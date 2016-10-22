package com.cn.service;

import java.util.List;

import com.cn.pojo.Product_pojo;

public interface ProductService {
	
	public Product_pojo select_pid(long id);
	
	/**
	 * 
	 * @param  周杰
	 *   <p> 插入药品
	 * @return
	 */
            public int insert_Product(Product_pojo product_pojo);
            
            /**
             *   导出所有产品
             * @return  product
             */
            
            public List<Product_pojo> select_Product();  
            
            public int delete_product(String product);
}
