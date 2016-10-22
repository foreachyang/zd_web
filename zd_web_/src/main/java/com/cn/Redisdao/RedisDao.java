package com.cn.Redisdao;

import com.cn.pojo.Product_pojo;
import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {
  
	 private final JedisPool jedisPool;
	 private RuntimeSchema<Product_pojo> schema=RuntimeSchema.createFrom(Product_pojo.class);
	 
	 public RedisDao(String ip, int port){
		 jedisPool = new JedisPool(ip,port);
	 }
	 
	 public Product_pojo getProduct(long id){
		 System.out.println("redisdao  get...........................");
		 try{
			  Jedis jedis=jedisPool.getResource();
	
			  try{
				  String key = "Product_pojo"+id;
				  jedis.get(key.getBytes());
				   
				   
				 byte[] bytes=jedis.get(key.getBytes()); 
				  //缓存获取到
				   if(bytes !=null){
					   Product_pojo  product_pojo =schema.newMessage();
					    ProtostuffIOUtil.mergeFrom(bytes, product_pojo , schema);
					    
					    return product_pojo;
				   }
			  }finally{
				
			  }
			 
		 }catch(Exception e){
			
		 }
		 return null;
	 }
	 
	 
	 public String putProduct(Product_pojo product_pojo){
		 System.out.println("redisdao  put...........................");
		 try {
			Jedis jedis=jedisPool.getResource();
			
			String key ="Product_pojo"+product_pojo.getId();
			byte[] bytes=ProtostuffIOUtil.toByteArray(product_pojo, schema, 
					LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
			int timeout=60*60;
			
		 String result=jedis.setex(key.getBytes(), timeout, bytes);
			  
		 return result;
		} catch (Exception e) {
			System.out.println("jedis --------------");
		}
		 
		 return null;
	 }
	 
}
