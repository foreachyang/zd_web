package com.cn.service.Impl;

import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;  
import org.apache.shiro.authc.ExcessiveAttemptsException;  
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;  
import org.apache.shiro.cache.Cache;  
import org.apache.shiro.cache.CacheManager;  
  
import java.util.concurrent.atomic.AtomicInteger;
 

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordRetryCache;

    public RetryLimitHashedCredentialsMatcher(CacheManager cacheManager) {
        passwordRetryCache = cacheManager.getCache("passwordRetryCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username = (String)token.getPrincipal();
        
        System.out.println("进入hash 缓存-----打印username"+username);
        //retry count + 1
        AtomicInteger retryCount = passwordRetryCache.get(username);
        if(retryCount == null) {
            retryCount = new AtomicInteger(0);
            passwordRetryCache.put(username, retryCount);
        }
        if(retryCount.incrementAndGet() > 5) {
            //如果账号名连续错误5次 抛出异常
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token, info);
        if(matches) {
            //否则清楚
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
