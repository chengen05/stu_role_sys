package edu.znzz.cg.tools;


import org.apache.shiro.crypto.hash.Md5Hash;

public class PasswordTool {
	public static String encryptPassword(String pwd, String salt) {
		return new Md5Hash(pwd+salt).toHex().toString();
	}
	
	public static void main(String[] args) {
		
		System.out.println(encryptPassword("cg0511","789456"));
		System.out.println(getRandomSalt());
	}
	/**
	 * Éú³ÉËæ»úÑÎ
	 * @return String
	 */
	public static String getRandomSalt() {
		String model = "abcdefghijklmnopqrstuvwxyz1234567890";
		StringBuffer salt = new StringBuffer();
		char[] m = model.toCharArray();
		for (int i = 0; i < 6; i++) {
			char c = m[(int) (Math.random() * 36)];
			salt = salt.append(c);
		}
		return salt.toString();
	}
		
}
