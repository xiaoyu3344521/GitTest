package com.ysd.redis;


import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

@Component("redis")
public class RedisTrans {

	@Resource
	private StringRedisTemplate stringRedisTemplate;

	 /**
	   * д�뻺��
	   *
	   * @param key
	   * @param object
	   * @return
	   */
	  public boolean set(final String key, String object) {
	    boolean result = false;
	    try {
	      // ͨ��set�������ô洢������(key,value,ʱ�䣬ʱ��ĵ�λ)
	      stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
	      stringRedisTemplate.opsForValue().set(key, object, 6000, TimeUnit.SECONDS);

	      result = true;
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return result;
	  }

	  /**
	   * �õ�����
	   *
	   * @param key
	   * @param value
	   * @return
	   */
	  public String get(final String key) {
	    String value = null;
	    try {
	      // ͨ��get������ȡ�洢������(key)
	      value = stringRedisTemplate.opsForValue().get(key);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    return value;
	  }
	  public void delete(final String key) {
		  stringRedisTemplate.delete(key);
	  }
}
