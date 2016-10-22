package com.cn.dao;

import java.util.List;

import com.cn.pojo.Member_pojo;
import com.cn.pojo.User;

/**
 * 
 * @author 周杰
 *
 *  客户代表 dao
 */
public interface Memberdao {
    public  int insert_member(Member_pojo member);
    public List<User> select_usersync(String user);
    public List<Member_pojo> selectmember();
}
