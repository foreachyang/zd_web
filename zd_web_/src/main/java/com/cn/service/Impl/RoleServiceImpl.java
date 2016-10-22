package com.cn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.dao.Roledao;
import com.cn.pojo.Role_pojo;
import com.cn.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	 Roledao roledao;
	
	public Role_pojo createRole(Role_pojo role) {
		
		return roledao.createRole(role);
	}

	public void deleteRole(Long roleid) {
		 roledao.deleteRole(roleid);
	}
/**
 *  添加角色-权限
 *  @param roleId 
 *  @param permissionIds
 */
	public void correlationPermissions(Long roleId, Long... permissionIds) {
		
		roledao.correlationPermissions(roleId, permissionIds);
	}

	/**
	 *  移除角色-权限
	 */
	public void uncorrelationPermissions(Long roleId, Long... permissionIds) {
	   roledao.uncorrelationPermissions(roleId, permissionIds);
		
	}

}
