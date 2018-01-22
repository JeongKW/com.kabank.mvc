package com.kabank.mvc.util;

import com.kabank.mvc.factory.QueryFactory;

public class MainTest {
	public static void main(String[] args) {
		String test = "cmd_151";
		String test2 = "cmaqe";
		Object a = "1";
		System.out.println(a);
		System.out.println(test.substring(0, (test.indexOf("_") == -1) ? test.length() : test.indexOf("_")));
		System.out.println(test2.substring(0, (test2.indexOf("_") == -1) ? test2.length() : test2.indexOf("_")));
		
		String[] arr = {"id", "pw", "name"};
		System.out.println(QueryFactory.queryCreate("insert", "Member", arr));
	}
}
