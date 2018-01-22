package com.kabank.mvc.domain;

import lombok.Data;

@Data
public class MemberBean {
	private String id, pw, name, ssn, email, profile, addr;
	private AccountBean account;
	private PhoneBean phone;
	private FoodBean food;
	private AttendBean attend;
	private LottoBean lotto;
	
	@Override
	public String toString() {
		return "회원정보 [ID: " + id + ", PW: " + pw + ", 이름: " + name + ", 주민번호(생년원일-첫째번호): " + ssn + ", 이메일: " + email
				+ ", 전화번호: " + phone + ", 프로필사진: " + profile + ", 주소: " + addr + ", Account: " + account + "]";
	}

}
