package com.cn.dao;

import java.util.List;

import com.cn.pojo.Product_pojo;

/**
 * 
 * @author  周杰
 * 
 * <p> 产品的dao接口  对应 mapper 文件 Porduct_mapper.xml
 *
 */
public interface Porductdao {
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	       public Product_pojo select_pid(long id);
	
	/**
	 *   <p> 插入药品
	 *
	 */
            public int insert_Product(Product_pojo product_pojo);
       
     /**
      *  导出所有产品
      *
      */       
         public List<Product_pojo> select_Product();   
         
         
         public int delete_product(String product);
}
