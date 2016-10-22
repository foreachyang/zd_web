package com.cn.Redisdao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cn.pojo.Product_pojo;
import com.cn.service.Impl.Product_list_service_Impl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-for-mybatis.xml"})
public class RedisDaoTest{
 private long id=48;
 
 @Autowired
 private RedisDao redis;
 
 @Autowired
 private Product_list_service_Impl product;
 
 
 @Test
 public void testProduct(){
	  Product_pojo product_id =redis.getProduct(id);
	 
	  if(product_id==null){
		   product_id = (Product_pojo) product.select_pid(id);
		   
		   if(product_id !=null){
			    String result=redis.putProduct(product_id);
			    System.out.println(result);
			    product_id=redis.getProduct(id);
			    System.out.println(product_id.toString());
		   }
	  }
 }
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRedisDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetProduct() {
		fail("Not yet implemented");
	}

	@Test
	public void testPutProduct() {
		fail("Not yet implemented");
	}

}
