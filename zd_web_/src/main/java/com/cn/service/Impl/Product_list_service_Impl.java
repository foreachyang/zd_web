package com.cn.service.Impl;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.util.DefaultPrettyPrinter.FixedSpaceIndenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cn.dao.Porductdao;
import com.cn.pojo.Product_pojo;
import com.cn.service.ProductService;
/**
 * 
 * @author 周杰
 * <p> 对药品数据进行效验
 */
@Service
@Configuration
public class Product_list_service_Impl implements ProductService  {
    /**
     * 
     * @param product  Controller传过来的 product 实体
     * <p> 利用反射检查get set 是否为空
     * @return
     * @throws IllegalAccessException 
     * @throws IllegalArgumentException 
     */
	
	  @Autowired
	  Porductdao product;
	   public boolean examine_get_set(final Product_pojo product) throws IllegalArgumentException, IllegalAccessException{
		   
		    for(Field field : product.getClass().getDeclaredFields()){
		    	field.setAccessible(true);
		    	if(field.get(product)==null)
		    		return false;
		    }
		    return true;
	   }

	public int insert_Product(Product_pojo product_pojo) {
		
		
			 product.insert_Product(product_pojo);
	
		return 0;
	}
	/**
	 * 根据产品id 查询产品
	 */
	public Product_pojo select_pid(long id){
		 Product_pojo product = new Product_pojo();
		 
		 product=this.product.select_pid(id);
		
			System.out.println("根据id查询产品....................."+product.toString());
		
		 return product;
	}

	public List<Product_pojo> select_Product() {
		List<Product_pojo> list = new ArrayList<Product_pojo>();
		
		list=product.select_Product();
		return list;
	}

	public int delete_product(String product) {
		 System.out.println("删除 产品了---------------------------------------------------------");
		  this.product.delete_product(product);
		return 0;
	}
}
