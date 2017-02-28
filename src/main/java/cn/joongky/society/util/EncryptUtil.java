package cn.joongky.society.util;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Random;

public class EncryptUtil {
	
	private static final Random RANDOM = new SecureRandom();
	
	/** * 把inputString加密 */
	public static String generatePassword(String password, String salt) {
		return encodeByMD5(password + salt);
	}

	/**
	 * 验证输入的密码是否正确
	 * 
	 * @param password
	 *            加密后的密码
	 * @param inputString
	 *            输入的字符串
	 * @return 验证结果，TRUE:正确 FALSE:错误
	 */
	public static boolean validatePassword(String password, String inputString) {
		if (password.equals(encodeByMD5(inputString))) {
			return true;
		} else {
			return false;
		}
	}

	/** 对字符串进行MD5加密 */
	public static String encodeByMD5(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes("UTF-8"));
				// 将得到的字节数组变成字符串返回
				StringBuffer sb = new StringBuffer();
				for (byte b : results) {
					sb.append(String.format("%02x", b));
				}
				String resultString = sb.toString();
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 对originString进行sha1的加密
	 * @param originString
	 * @return
	 */
	public static String sha1(String originString) {
		if (originString != null) {
			try {
				// 创建具有指定算法名称的信息摘要
				MessageDigest md = MessageDigest.getInstance("sha1");
				// 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
				byte[] results = md.digest(originString.getBytes("UTF-8"));
				// 将得到的字节数组变成字符串返回
				StringBuffer sb = new StringBuffer();
				for (byte b : results) {
					sb.append(String.format("%02x", b));
				}
				String resultString = sb.toString();
				return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static byte[] getNextSalt() {
		byte[] salt = new byte[16];
		RANDOM.nextBytes(salt);
		return salt;
	}
	
}
