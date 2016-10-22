package com.cn.service.Impl;


import org.apache.shiro.crypto.RandomNumberGenerator;  
import org.apache.shiro.crypto.SecureRandomNumberGenerator;  
import org.apache.shiro.crypto.hash.SimpleHash;  
import org.apache.shiro.util.ByteSource;  
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import com.cn.pojo.User;  
/**
 * 
 * @author 周杰
 * <p> 实现PsdToken接口，  对当前的登录的用户进行md5加密  解密委托给Shiro
 *
 */

@Service
@Configuration
public class PasswordHelper{

	
	  
	 private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
	    private String algorithmName = "md5";
	    private int hashIterations = 2;

	    public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
	        this.randomNumberGenerator = randomNumberGenerator;
	    }

	    public void setAlgorithmName(String algorithmName) {
	        this.algorithmName = algorithmName;
	    }

	    public void setHashIterations(int hashIterations) {
	        this.hashIterations = hashIterations;
	    }

	    public void encryptPassword(User user) {

	        user.setSalt(randomNumberGenerator.nextBytes().toHex());

	        String newPassword = new SimpleHash(
	                algorithmName,
	                user.getPassword(),
	                ByteSource.Util.bytes(user.getCredentialsSalt()),
	                hashIterations).toHex();  //十六进制
  System.out.println("加密后的password------------"+newPassword);
  System.out.println("盐值为--------------"+user.getSalt());
	        user.setPassword(newPassword);
	}
	    

	    
}

