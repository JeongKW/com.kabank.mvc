package com.kabank.mvc.enums;

public enum Action {
	MOVE, ADD, LOGIN, JOIN, CHANGE, DELETE, TEST,
	CREATE, MYPAGE, LOGOUT,
	VIEW{
		@Override
		public String toString() {
			return "/WEB-INF/view/";
		}
	},
	EXTENSION{
		@Override
		public String toString() {
			return ".jsp";
		}
	},
	SEPARATOR{
		@Override
		public String toString() {
			return "/";
		}
	}
}
