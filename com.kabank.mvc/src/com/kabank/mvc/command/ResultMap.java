package com.kabank.mvc.command;

import java.util.List;

import com.kabank.mvc.domain.AccountBean;
import com.kabank.mvc.domain.AttendBean;
import com.kabank.mvc.domain.FoodBean;
import com.kabank.mvc.domain.LottoBean;
import com.kabank.mvc.domain.MemberBean;
import com.kabank.mvc.domain.PhoneBean;

import lombok.Data;

@Data
public class ResultMap {
	protected MemberBean member;
	protected AccountBean account;
	protected FoodBean food;
	protected LottoBean lotto;
	protected AttendBean attend;
	protected PhoneBean phone;
	protected List<MemberBean> members;
	protected List<AccountBean> accounts;
	protected List<FoodBean> foods;
	protected List<LottoBean> lottos;
	protected List<AttendBean> attends;
	protected List<PhoneBean> phones;
}
