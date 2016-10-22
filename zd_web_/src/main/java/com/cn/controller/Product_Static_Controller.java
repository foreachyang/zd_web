package com.cn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author  周杰
 *  产品静态页面
 */
@Controller
public class Product_Static_Controller {
	
	/**
	 *  苏肽生
	 * @return
	 */
	 @RequestMapping(value="chanpin1")
	 public String chanpin1(){return "chanpin1";}
	 
	 /**
		 * 还少丹
		 * @return
		 */
	 @RequestMapping(value="chanpin2")
	 public String chanpin2(){return "chanpin2";}
	 
	 /**
		 *  龟鹿补肾丸
		 * @return
		 */
	 @RequestMapping(value="chanpin3")
	 public String chanpin3(){return "chanpin3";}
	 
	 /**
	  *  70尾珍珠丸
	  * @return
	  */
	 @RequestMapping(value="chanpin4")
	 public String chanpin4(){return "chanpin4";}
	 
	 /**
	  *  脑得生片 
	  * @return
	  */
	 @RequestMapping(value="chanpin5")
	 public String chanpin5(){return "chanpin5";}
	 
	 @RequestMapping(value="chanpin6")
	 public String chanpin6(){return "chanpin6";}
	 
	 
	 

}
