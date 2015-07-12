package com.defysope.utils;

import java.util.UUID;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	public String getRandomString() {
		synchronized (this) {
			return UUID.randomUUID().toString();
		}
	}
}
