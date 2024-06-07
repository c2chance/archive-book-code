package com.manage.platform.service.impl;

import java.util.List;
import java.util.Map;


import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.googlecode.ehcache.annotations.Cacheable;
import com.manage.platform.dao.IMANAGE_AREADao;
import com.manage.platform.entity.MANAGE_AREAEntity;
import com.manage.platform.service.IMANAGE_AREAService;

public class MANAGE_AREAServiceImpl implements IMANAGE_AREAService{

	private IMANAGE_AREADao MANAGE_AREAdao;
	
	public IMANAGE_AREADao getMANAGE_AREAdao() {
		return MANAGE_AREAdao;
	}

	public void setMANAGE_AREAdao(IMANAGE_AREADao fW_AREAdao) {
		MANAGE_AREAdao = fW_AREAdao;
	}

	public int insert(MANAGE_AREAEntity entity) {
		return MANAGE_AREAdao.insert(entity);
	}

	public int update(MANAGE_AREAEntity entity) {
		return MANAGE_AREAdao.update(entity);
	}

	public List<Map<String, Object>> findByCondition(String condition,int start, int count) {
		return MANAGE_AREAdao.findByCondition(condition, start, count);
	}
	
	// 缓存 @Cacheable(value = "users")
	@Override
	public List<Map<String, Object>> findGridByCondition(String condition) {
		return MANAGE_AREAdao.findGridByCondition(condition);
	}
	
	public List<Map<String, Object>> findTreeByCondition(String condition) {
		return MANAGE_AREAdao.findTreeByCondition(condition);
	}

	public int countByCondition(String condition) {
		return MANAGE_AREAdao.countByCondition(condition);
	}

	public int delete(String uuid) {
		return MANAGE_AREAdao.delete(uuid);
	}

	@Override
	public String testA() {
		return MANAGE_AREAdao.testA();
	}

}
