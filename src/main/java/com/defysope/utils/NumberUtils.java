package com.defysope.utils;

import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;


public class NumberUtils extends org.apache.commons.lang.math.NumberUtils {

	public static int toIntegerDefaultIfNull(Integer value, int defaultValue) {
		return value == null ? defaultValue : value.intValue();
	}

	public static double toDoubleDefaultIfNull(Double value, double defaultValue) {
		return value == null ? defaultValue : value.doubleValue();
	}

	public static float toFloatDefaultIfNull(Float value, float defaultValue) {
		return value == null ? defaultValue : value.floatValue();
	}

	public static Float toFloatDefaultIfNull(Double value, Float defaultValue) {
		return value == null ? defaultValue : value.floatValue();
	}

	public static double roundPrecision(Double value, int precision) {
		double precisionFactor = Math.pow(10, precision);
		long v1 = Math.round(toDoubleDefaultIfNull(value, 0) * precisionFactor);
		return v1 / precisionFactor;
	}

	public static float roundPrecision(Float value, int precision) {
		return (float) roundPrecision((Double) (value == null ? null : value
				.doubleValue()), precision);
	}

	public static double diff(Double value1, Double value2, int precision) {
		double precisionFactor = Math.pow(10, precision);
		long v1 = Math
				.round(toDoubleDefaultIfNull(value1, 0) * precisionFactor);
		long v2 = Math
				.round(toDoubleDefaultIfNull(value2, 0) * precisionFactor);
		return (v1 - v2) / precisionFactor;
	}

	public static double add(Double value1, Double value2, int precision) {
		double precisionFactor = Math.pow(10, precision);
		long v1 = Math
				.round(toDoubleDefaultIfNull(value1, 0) * precisionFactor);
		long v2 = Math
				.round(toDoubleDefaultIfNull(value2, 0) * precisionFactor);
		return (v1 + v2) / precisionFactor;
	}

	public static float add(Float value1, Double value2, int precision) {
		return (float) add((Double) (value1 == null ? null : value1
				.doubleValue()), value2, precision);
	}

	public static float add(Float value1, Float value2, int precision) {
		Double v1 = value1 == null ? null : value1.doubleValue();
		Double v2 = value2 == null ? null : value2.doubleValue();
		return (float) add((Double) v1, (Double) v2, precision);
	}

	/**
	 * @deprecated
	 * */
	public static String formatNumber(float f, String format) {
		return formatNumber(String.valueOf(f), format);
	}
	
	public static String formatNumber(String value, String format) {
		DecimalFormat df = null;
		if (format != null) {
			df = new DecimalFormat(format);
		} else {
			df = new DecimalFormat("");
		}
		return df.format(NumberUtils.toDouble(value));
	}
	
	
}
