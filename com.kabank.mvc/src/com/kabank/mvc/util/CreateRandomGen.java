package com.kabank.mvc.util;

public class CreateRandomGen {
	public static String createAccountNum() {
		String resAccountNum = "";
		for(int i = 0; i < 3; i++) {
			int num = (int)(Math.random() * 9000) + 1000;
			resAccountNum += num;
			if(i != 2) {
				resAccountNum += "-";
			}
		}
		return resAccountNum;
	}
	
	public static String createPhoneNumber() {
		String resPhoneNumber = "010-";
		resPhoneNumber += ((int)(Math.random() * 9000) + 1000) + "-";
		resPhoneNumber += (((int)(Math.random() * 9999) + 1) > 1000) ? ((int)(Math.random() * 9999) + 1) : "0" + ((int)(Math.random() * 9999) + 1);
		return resPhoneNumber;
	}
}
