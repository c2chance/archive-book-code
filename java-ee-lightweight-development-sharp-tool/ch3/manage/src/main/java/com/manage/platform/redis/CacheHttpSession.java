/*package com.manage.platform.redis;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.servlet.http.HttpSession;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

public class CacheHttpSession extends HttpSessionWrapper {

	private String sid;
	private RedisTemplate redisTemplate;
	private StringRedisSerializer stringSerializer = new StringRedisSerializer();
	public CacheHttpSession(HttpSession session,String sid,RedisTemplate redisTemplate) {
		super(session);
		this.sid = sid;
		this.redisTemplate = redisTemplate;
	}

	@SuppressWarnings("unchecked")
	public Enumeration<String> getAttributeNames() {
		final byte[] key = stringSerializer.serialize(sid);
		Object result = redisTemplate.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				Set<byte[]> set = connection.keys(key);
				return set;
			}
		});
		if(result != null) {
			Set<byte[]> s = (Set<byte[]>)result;
			Set<String> ss = new HashSet<String>();
			for(byte[] b : s) {
				ss.add(stringSerializer.deserialize(b));
			}
			Enumeration<String> en = new Vector(ss).elements();
			return en;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void setAttribute(String name, Object value) {
		final byte[] key = stringSerializer.serialize(name);
		final byte[] v = stringSerializer.serialize((String)value);
		redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				connection.set(key, v);
				return null;
			}
		});
	}

	@Override
	public Object getAttribute(String name) {
		final byte[] key = stringSerializer.serialize(name);
		@SuppressWarnings("unchecked")
		Object value = redisTemplate.execute(new RedisCallback<Object>() {
			@Override
			public Object doInRedis(RedisConnection connection)
					throws DataAccessException {
				return connection.get(key);
			}
		});
		return value;
	}

	@Override
	public String getId() {
		return sid;
	}
}*/