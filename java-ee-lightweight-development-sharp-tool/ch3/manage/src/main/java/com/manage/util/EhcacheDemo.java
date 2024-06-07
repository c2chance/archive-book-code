package com.manage.util;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class EhcacheDemo {
	public static void main(String[] args) throws Exception {
		CacheManager cacheManager = new CacheManager();
		Cache cache = cacheManager.getCache("users");
		String contentkey = "one";
		Element content = new Element(contentkey, "Hello Ehcache");
		cache.put(content);
		Element one = cache.get("one");
		System.out.println(cache.getSize());
		System.out.println(cache.getKeys());
		System.out.println(one.getObjectValue());
	}
}