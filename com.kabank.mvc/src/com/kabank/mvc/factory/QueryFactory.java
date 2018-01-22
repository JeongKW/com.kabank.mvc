package com.kabank.mvc.factory;

import com.kabank.mvc.command.InitCommand;

public class QueryFactory {
	public static String queryCreate(String s, String table, String[] arr) {
		StringBuffer res = null;
		switch(s) {
		//select ? from $ WHERE id=?
		//123456789012345
		case "select":
			res = new StringBuffer("SELECT * FROM  WHERE id=?");
			res.insert(14, table);
			break;
		//insert into $(#, #, ...) values(?, ?, ...
		//12345678901234
		case "insert":
			res = new StringBuffer("INSERT INTO () VALUES(");
			
			String questionValues = "";
			String columns = "";
			for(int i = 0; i < arr.length; i++) {
				if(i == arr.length - 1) {
					questionValues += "?)";
					columns += arr[i];
				} else {
					questionValues += "?, ";
					columns += arr[i] + ", ";
				}
			}
			res.insert(13, columns);
			res.insert(12, table);
			res.append(questionValues);
			break;
		//update $ set #=?, #=?, ... where #=?a
		case "update":
			res = new StringBuffer("UPDATE  SET  WHERE ");
			break;
		//delete from $ where #=?
		case "delete":
			res = new StringBuffer("DELETE FROM  WHERE id=?");
			res.insert(12, table);
			break;
		}
		return res.toString();
	}
}
