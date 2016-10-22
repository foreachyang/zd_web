package com.cn.Utils;
 
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager; 
import net.sf.ehcache.Element; 
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy; 

/**
 * 
 * @author  周杰
 * <p> date: 2019/9/6   对登录的用户做缓存  缓存采用Ehcache
 *
 */
public final class EhcacheUtil {

	private static final CacheManager cacheManager = CacheManager.getInstance(); 
	 
	  private static Cache cache = new Cache(new CacheConfiguration("systemCache", 5000).memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.FIFO).timeoutMillis(300).timeToLiveSeconds( 60 * 60)); 
	    static { 
	        cacheManager.addCache(cache); 
	    } 
	    public static void putItem(String key, Object item) { 
	    	 System.out.println("EhcacheUtil put");
	        if (cache.get(key) != null) { 
	            cache.remove(key); 
	        } 
	        Element element = new Element(key, item); 
	        cache.put(element); 
	    } 
	    public static void removeItem(String key) { 
	        cache.remove(key); 
	    } 
	    public static void updateItem(String key, Object value) { 
	        putItem(key, value); 
	    } 
	    public static Object getItem(String key) { 
	        Element element=  cache.get(key); 
	        if(null!=element) 
	        { 
	            return element.getObjectValue(); 
	        } 
	        return null; 
	    } 
}
