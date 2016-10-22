package com.cn.service;

import com.cn.pojo.Role_pojo;

public interface RoleService {
   public Role_pojo createRole(Role_pojo role);
   public void deleteRole(Long roleid);
   

   /**
    * 添加角色-权限之间关系
    * @param roleId
    * @param permissionIds
    */
   public void correlationPermissions(Long roleId, Long... permissionIds);

   /**
    * 移除角色-权限之间关系
    * @param roleId
    * @param permissionIds
    */
public void uncorrelationPermissions(Long roleId, Long... permissionIds);

}
