package com.cn.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cn.Redisdao.RedisDao;
import com.cn.component.RequestJsonParam;
import com.cn.pojo.Product_pojo;
import com.cn.service.Impl.Product_list_service_Impl;
import com.cn.service.Impl.SequenceGenerator;

import net.sf.json.JSONObject;
/**
 * 
 * @author 周杰
 * <p>  对前端请求做处理
 */
@Controller
@RequestMapping(value="product_list")
public class ProductController {

	 private long id=48;
	 
	 @Autowired(required=false)
	 private RedisDao redis;
	
	 @Autowired(required=false)
	  Product_list_service_Impl product;
	 
	 @Autowired(required=false)
	 SequenceGenerator seq;
	 
	@RequestMapping()
	public String product_list(){
		return "product-list";
	}
	
	@RequestMapping(value="product_sid",produces="application/json")
	@ResponseBody()
	public JSONObject product_sid(){
		  Product_pojo product_id =redis.getProduct(id);
			 
		  if(product_id==null){
			   product_id = product.select_pid(id); //数据库拿
			   
			   if(product_id !=null){
				    String result=redis.putProduct(product_id); 
				    System.out.println(result);
				    
				    product_id=redis.getProduct(id);
				    System.out.println("正在处理get 请求----------------");
				    System.out.println(product_id);
			   }
	
	}
			return null;
	}
	
	@RequestMapping(value="product_add")
	public String product_add(){
		System.out.println("product--------------------------------------------------------------------");
		return "product-add";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(value="product_value", produces={"text/html;charset=UTF-8;","application/json;"}, method=RequestMethod.POST)  
	@ResponseBody
	public Map<String,Object> product_value(@Valid @RequestJsonParam(value="model",required=true) Product_pojo product 
		,	BindingResult resulterror){
		 

		
		product.setId(seq.nextproduct_seq());
        product.setDatr("待审核");
		System.out.println(product.toString());
		Map<String,Object> result= new HashMap<String,Object>();
	/*
		 if(resulterror.hasErrors()){
			 List<ObjectError> errors= resulterror.getAllErrors();
		 result.put("msg","不合法");
		 
		 for(int i=0; i<errors.size(); i++)
			
		 result.put("msg","不合法");
		 return result;
		 } else{
		 */
			System.out.println("插入");     
	    this.product.insert_Product(product);
	    result.put("msg",null);
	  return  result;
	 
	
	}
	
	@RequestMapping(value="delete",produces="application/json",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> delete(String product_name){
		
		System.out.println("进入删除产品了---------------------------"+product_name);
		 Map<String,Object> map = new HashMap<String,Object>();
		 
		 this.product.delete_product(product_name);
		 
		  map.put("msg","删除成功");
		  
		  return map;
	}
	
	
	@RequestMapping(value="select_product", produces={"application/json;"}) 
	@ResponseBody
	
	public Map<String,Object> select_product(@RequestJsonParam(value="model")Product_pojo product){
		System.out.println("查询-----产品   select product");
                      Map<String,Object> map =  new HashMap<String,Object>();
                       List<Product_pojo> list = new ArrayList<Product_pojo>();
                      list=this.product.select_Product(); 
                       map.put("data", list);
                       
                       return map;
	}
}
