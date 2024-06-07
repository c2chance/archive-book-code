package com.springcss.account;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="springcss.points")
public class SpringCssConfig {
 
    private Map<String, Integer> points = new HashMap<>();

	public Map<String, Integer> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Integer> points) {
		this.points = points;
	}

	
}