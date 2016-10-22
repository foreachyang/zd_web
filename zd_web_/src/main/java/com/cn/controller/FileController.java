package com.cn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.cn.component.RequestJsonParam;
import com.cn.pojo.Invoice_pojo;
import com.cn.service.InvoiceService;

import com.cn.service.Impl.Add_Invoice_is;
import com.cn.service.Impl.FileSize;
import com.cn.type.File_Image_Path;


@Controller()
@RequestMapping("file")
public class FileController {

      @Autowired  /*调用业务层bean*/
      InvoiceService invo;
      
      @Autowired(required=false)
      Add_Invoice_is add_invoice_is;
      
      @Autowired
      File_Image_Path filepath;
      
      @Autowired
      FileSize filesize;
      
      @RequestMapping("Invoice_view")
      public String test(){
    	  return "Invoice_view";
      }
      
      @RequestMapping(value="picture_list")
      public String picture(){
    	   return "picture-list";
      }
      
      @RequestMapping(value="fileUpload", produces="application/json")
      @ResponseBody
      public Map<String,Object> fileUpload2(@RequestJsonParam Invoice_pojo invo, HttpServletRequest request)throws AuthorizationException {
	 //  if(!SecurityUtils.getSubject().hasRole("admin"))  return "404";
	    System.out.println("发票数据-----------------------------------------------"+invo.toString());
	    SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");
		 String  date= simple.format(new Date());
			try {
				invo.setInvodate(simple.parse(date));
			} catch (ParseException e) {
				
				e.printStackTrace();
			}
		 
    	  Map<String,Object> map = new HashMap<String,Object>();
	  
		  this.invo.insertService(invo);
	      map.put("msg","成功");
	
	  return map; 
	  }
			      
	@RequestMapping(value = "upload")
	String fileupliad(HttpServletRequest request) {
		System.out.println("fapiao图片上传了。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				
				MultipartFile file = multiRequest.getFile(iter.next());

				if (file != null) {
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = filepath.FilePath + fileName;
					File localFile = new File(path);

					try {
						file.transferTo(localFile);
					} catch (IOException e) {
						System.out.println("FileUpload异常");
						e.printStackTrace();
					}
				}

			}
		}

		return "Invoice_view";
	}
	
	
	@RequestMapping(value = "productupload", method = RequestMethod.POST)
	String Porductupliad(HttpServletRequest request) {
		System.out.println("产品图片上传了。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());

		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

			Iterator<String> iter = multiRequest.getFileNames();

			while (iter.hasNext()) {
				
				MultipartFile file = multiRequest.getFile(iter.next());

				if (file != null) {
					String fileName = "demoUpload" + file.getOriginalFilename();
					String path = filepath.PorductPath+ fileName;
					File localFile = new File(path);

					try {
						file.transferTo(localFile);
					} catch (IOException e) {
						System.out.println("FileUpload异常");
						e.printStackTrace();
					}
				}

			}
		}

		return "Invoice_view";
	}
	
	
	
      
      @RequestMapping(value="filesize",produces="application/json",method=RequestMethod.GET)
      @ResponseBody
      public  Map  getsize() {
    	   Map<String, Long> map= new ConcurrentHashMap<String, Long>();
    	 Long t= filesize.getfilesize();
    	  map.put("daxiao", t);
    	  
    	  return map;
      }
     
    
      @RequestMapping(value = "/image/get")
      public void getImage(HttpServletRequest request,HttpServletResponse response) {
          FileInputStream fis = null;
          response.setContentType("image/gif");
          try {
              OutputStream out = response.getOutputStream();
              File file = new File("D:"+File.separator+"timg.jpg");
              fis = new FileInputStream(file);
              byte[] b = new byte[fis.available()];
              fis.read(b);
              out.write(b);
              out.flush();
          } catch (Exception e) {
               e.printStackTrace();
          } finally {
              if (fis != null) {
                  try {
                     fis.close();
                  } catch (IOException e) {
      	        e.printStackTrace();
      	    }   
                }
          }
      }
      
      
}