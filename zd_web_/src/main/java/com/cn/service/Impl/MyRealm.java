package com.cn.service.Impl;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.pojo.User;
import com.cn.service.UserService;
/**
 * 
 * @author 周杰。   
 *<p>用户登录Realm 交给Spring-for-mybatis 中的凭证匹配器验证
 */
@Service
public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserService userService;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals)  {
		System.out.println("进入AuthorizationInfo方法");
	String userName=(String)principals.getPrimaryPrincipal();
	System.out.println("当前用户"+userName);
	SimpleAuthorizationInfo authorizationInfo= new SimpleAuthorizationInfo();
	System.out.println("当前角色"+userService.getRoles(userName));
	System.out.println("当前权限"+userService.getPermissions(userName));
	authorizationInfo.setRoles(userService.getRoles(userName));
	authorizationInfo.setStringPermissions(userService.getPermissions(userName));
		return authorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException{
		System.out.println("进入   doGetAuthenticationInfo password------------------------------");
		UsernamePasswordToken  usernamePasswordToken =(UsernamePasswordToken) token;
		
		String username= String.valueOf(usernamePasswordToken.getUsername());
		 User user=userService.getByUserName(username);
		 
		 if(user==null)
			  throw new UnknownAccountException();
		 
		  Integer sync=user.getSync();
		  
		  if(sync.equals(1))
			  throw new LockedAccountException(); 
		 
		System.out.println("doGetAuthenticationInfo password"+user.toString());
		
		  
		
SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(  
            user.getUserName(), //用户名  
            user.getPassword(), //密码  
            ByteSource.Util.bytes(user.getCredentialsSalt()),//salt=username+salt  
            getName()  //realm name  
    );
   
   return authenticationInfo; 
} 
	
	
	 @Override
	    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthorizationInfo(principals);
	    }

	    @Override
	    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
	        super.clearCachedAuthenticationInfo(principals);
	    }

	    @Override
	    public void clearCache(PrincipalCollection principals) {
	        super.clearCache(principals);
	    }

	    public void clearAllCachedAuthorizationInfo() {
	        getAuthorizationCache().clear();
	    }

	    public void clearAllCachedAuthenticationInfo() {
	        getAuthenticationCache().clear();
	    }

	    public void clearAllCache() {
	        clearAllCachedAuthenticationInfo();
	        clearAllCachedAuthorizationInfo();
	    }
	    
	    public Object test(){
	    	int i=1;
	    	return i;
	    }

}
		

	
	
	

