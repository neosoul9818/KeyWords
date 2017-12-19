package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.atguigu.bean.T_MALL_USER_ACCOUNT;

@Controller
public class LoginController {

	@RequestMapping(value="login",produces="text/html; charset=UTF-8")
	@ResponseBody
	public String login(T_MALL_USER_ACCOUNT user, int shjh) {
		return "中文";
	}

}
