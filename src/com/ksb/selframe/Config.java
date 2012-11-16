package com.ksb.selframe;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class Config {

	private HashMap<String, String> map;
	private static Config instance = null;
	private Logger log = Logger.getLogger("report");

	private Config() {

		map = new HashMap<String, String>();
	}

	public Logger getLogger() {
		return log;
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
			return instance;
		}
		return instance;
	}

	public void set(String key, String value) {
		map.put(key, value);

	}

	public String get(String key) {
		return get(key, null);
	}

	public String get(String key, String defaultValue) {
		if (map.get(key) == null)
			return defaultValue;
		return map.get(key);
	}

}
