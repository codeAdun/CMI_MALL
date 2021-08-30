package com.sitech.cmi_mall.service.impl;


import com.sitech.cmi_mall.dao.CategoryMapper;
import com.sitech.cmi_mall.pojo.Category;
import com.sitech.cmi_mall.service.ICategoryService;
import com.sitech.cmi_mall.vo.CategoryVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.sitech.cmi_mall.consts.MallConst.ROOT_PARENT_ID;

@Service
public class CategoryServiceImpl implements ICategoryService {


    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryVo> selectAll() {

        //查找所有类目，返回的格式是一层层的类目关系，一级类目，二级类目等无限级，类目
      /*  逻辑：从上往下查，从下往上查
        1、先查出1级目录 -》 查其子目录，一直到查到的是null
             parentid=0 的代表一级目录，先将这些对应的id查出来，然后遍历这些id,直到查到的id为null

       2、查出所有目录 -》查父目录 ，一直查到到parent_id = 0;


     */
        List<CategoryVo> categoryVoList=new ArrayList<>();
        List<Category> categories=categoryMapper.selectAll();
        //遍历所有的类目
        for (Category categorie:categories){
            //判断当前类目的父id是否为0，如果为0，就将装到一个vo对象中
            if (categorie.getParentId().equals(ROOT_PARENT_ID)){
                CategoryVo categoryVo=new CategoryVo();
                categoryVo.setId(categorie.getId());
                //将category对象装到categoryvo对象中
                BeanUtils.copyProperties(categorie,categoryVo);
                //将vo对象添加到volist中
                categoryVoList.add(categoryVo);
            }
        }

        //方式二：采用lambda方式
        //获取par_id=0 的数据,也就是需要的数据；接着进行数据转换

//       categoryVoList=categories.stream().filter(e->e.getParentId().equals(ROOT_PARENT_ID))
//        .map( e-> category2CategoryVo(e))  //进行数据转换将caterory 转换为 cateroryvo,封装在一个方法中  .map(this::category2CategoryVo(e))
//        .collect(Collectors.toList()) ;  //直接返回一个list，无需提前定义，


        //查询子目录
        findSubCategory(categoryVoList, categories);

//        //查找子类目，根据查找出来的类目，继续向下查找子类目，直到查找的parent_id为null
//
//        for (CategoryVo categoryVo:categoryVoList){
//            List<CategoryVo> subCategoryVoList = new ArrayList<>();
//            //如果子类的父id等于，等于父类的id,那么就将子类放到一个vo对象中
//            //当前父节点的id,和整个目录的parent_id比较，如果查到内容，设置subCategory, 继续往下查
//            for(Category category:categories){
//                if(categoryVo.getId().equals(category.getParentId())){
//                    CategoryVo subCategoryVo=category2CategoryVo(category);
//                    //将这些子类插入到子类列表中
//                    subCategoryVoList.add(subCategoryVo);
//                }
//            }
//
//
//        }

        return categoryVoList;
    }

    private CategoryVo category2CategoryVo(Category category) {
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category, categoryVo);
        return categoryVo;
    }

    private void findSubCategory(List<CategoryVo> categoryVoList, List<Category> categories) {
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();

            for (Category category : categories) {
                //如果查到内容，设置subCategory, 继续往下查
                if (categoryVo.getId().equals(category.getParentId())) {
                    CategoryVo subCategoryVo = category2CategoryVo(category);
                    //将子目录添加到volist中
                    //list会一直叠加，当前父目录下的目录会放到一起
                    subCategoryVoList.add(subCategoryVo);
                }
               // subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                //设置属性值，将当前节点的子分支保存到父节点的属性值上
                categoryVo.setSubCategories(subCategoryVoList);

               findSubCategory(subCategoryVoList, categories); //入参是子目录
            }
        }
    }
}
