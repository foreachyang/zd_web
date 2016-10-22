package com.cn.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cn.dao.Staffdao;
import com.cn.pojo.Staff_pojo;
import com.cn.service.StaffService;

@Service
public class StaffService_Impl implements StaffService {

	@Autowired
    @Qualifier("staffdao")
	Staffdao  staff;
	
	public List<Staff_pojo> select_staff(String username) {
	     List<Staff_pojo> list = new ArrayList<Staff_pojo>();
	     
	     list=staff.select_staff(username);
	     
	     for (Staff_pojo staff_pojo : list) {
			 System.out.println("staff 服务层--------"+staff_pojo.toString());
		}
		
		return list;
	}

	public int insert_staff(Staff_pojo staff) {
		 this.staff.insert_staff(staff);
		return 0;
	}

	

}
