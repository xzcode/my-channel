package com.xzcode.product.common.util;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

@Service
public class ThAmounts {
	
	public static final BigDecimal MULTIPLE = new BigDecimal("100");
	
	public static final BigDecimal WAN_MULTIPLE = new BigDecimal("1000000");

	public static long toFen(Object amount) {
		BigDecimal decimal = null;
		if (amount == null || "".equals(amount)) {
			amount = 0;
		}
		if (amount instanceof Double) {
			decimal = new BigDecimal((double)amount);
		}else if (amount instanceof Float) {
			decimal = new BigDecimal((float)amount);
		}else {
			decimal = new BigDecimal(String.valueOf(amount));
		}
		decimal = decimal.multiply(MULTIPLE);
		return decimal.longValue();
	}

	public static BigDecimal toYuan(Object amount) {
		if (amount == null || "".equals(amount)) {
			amount = 0;
		}
		BigDecimal decimal = null;
		if (amount instanceof Double) {
			decimal = new BigDecimal((double)amount);
		}else if (amount instanceof Float) {
			decimal = new BigDecimal((float)amount);
		}else {
			decimal = new BigDecimal(String.valueOf(amount));
		}
		
		decimal = decimal.divide(MULTIPLE);
		return decimal;
	}
	
	public static String toYuanString(Object amount) {
		return toYuan(amount).setScale(2, BigDecimal.ROUND_DOWN).toString();
	}
	
	
	public static long wanToFen(Object amount) {
		BigDecimal decimal = null;
		if (amount == null || "".equals(amount)) {
			amount = 0;
		}
		if (amount instanceof Double) {
			decimal = new BigDecimal((double)amount);
		}else if (amount instanceof Float) {
			decimal = new BigDecimal((float)amount);
		}else {
			decimal = new BigDecimal(String.valueOf(amount));
		}
		decimal = decimal.multiply(WAN_MULTIPLE);
		return decimal.longValue();
	}
	
	
	public static BigDecimal toWanYuan(Object amount) {
		if (amount == null || "".equals(amount)) {
			amount = 0;
		}
		BigDecimal decimal = null;
		if (amount instanceof Double) {
			decimal = new BigDecimal((double)amount);
		}else if (amount instanceof Float) {
			decimal = new BigDecimal((float)amount);
		}else {
			decimal = new BigDecimal(String.valueOf(amount));
		}
		
		decimal = decimal.divide(WAN_MULTIPLE);
		return decimal;
	}
	
	public static String toWanYuanString(Object amount) {
		return toWanYuan(amount).setScale(2, BigDecimal.ROUND_DOWN).toString();
	}

}
