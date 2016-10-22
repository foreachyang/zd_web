package com.cn.dao;

import java.util.List;

import com.cn.pojo.User;

/**
 * 
 * @author 周杰    dao  给管理员页面提供所有公司员工和管理员数据
 *
 */
public interface Admin_role_listdao {
    public List<User> selectuser();
    public List<String> select_sumadmin();
}
