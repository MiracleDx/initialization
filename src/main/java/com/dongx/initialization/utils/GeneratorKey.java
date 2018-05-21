package com.dongx.initialization.utils;

import java.security.SecureRandom;
import java.util.UUID;

/**
 * GeneratorKey
 *
 * @author: dongx
 * Description: 随机主键生成器
 * Created in: 2018-05-21 20:19
 * Modified by:
 */
public class GeneratorKey {
	
	public static String getKey() {
		SecureRandom random = new SecureRandom();
		
		// 当前时间戳
		Long current = System.currentTimeMillis() + random.nextInt(999999999);
		String currentResult = current.toString();
		
		// 取uuid的前8位
		String uuid = UUID.randomUUID().toString();
		String uuidResult = uuid.substring(0, uuid.indexOf("-"));
		
		// 取随机数
		String randomResult = String.valueOf(random.nextInt(Math.abs(Integer.parseInt(currentResult.substring(0, 10)) + 1000)));
		
		char[] chars = {'y', 'a', 'n', 'g', 'x', 'i', 'a', 'o', 'l', 'i', 'm', 'w', 'o', 'x', 'i', 'h', 'u', 'a', 'n', 'n', 'i', 'a'};
		char charResult = chars[random.nextInt(chars.length)];
		
		// 拼接随机数
		StringBuilder sb = new StringBuilder();
		sb.append(currentResult).append(uuidResult).append(randomResult);
		
		String result = "";
		
		// 拼接随机数的长度
		int temp = sb.length();
		// 最终生成随机数的长度
		int resultTemp = 32;
		// 差值
		int num = resultTemp - temp;
		
		// 使随机数为32位
		if (num == 0) {
			result = sb.toString();
		} else {
			for (int i = 0; i < num -1; i++) {
				sb.append(String.valueOf(random.nextInt(5)));
			}
			sb.append(String.valueOf(charResult));
			result = sb.toString();
		}
		
		return result;
	}
	
	// TODO 改为单例模式
	public static void main(String[] args) {
		System.out.println(getKey() + ", length = " + getKey().length());
	}
}
