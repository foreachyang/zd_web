package com.cn.service;

import java.util.List;

import com.cn.pojo.Staff_pojo;

/**
 * 
 * @author 
 *员工登录后显示的信息
 */
public interface StaffService {
    public List<Staff_pojo> select_staff(String username);
    public int insert_staff(Staff_pojo staff);
}
