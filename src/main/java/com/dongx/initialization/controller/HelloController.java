package com.dongx.initialization.controller;

import com.dongx.initialization.service.Demo2Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


/**
 * HelloController
 * 
 * @author dongx
 * Description:
 * Created in: 2018-05-13 9:40
 * Modified by:
 */
@Controller
@Slf4j
public class HelloController {
	
	@Resource
	private Demo2Service demo2Service;
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		// 加入一个属性 用于在模板中读取
		map.addAttribute("host", "别让你的梦想，没了梦只剩下想");
		log.debug("我是debug");
		log.info("我是info");
		return "index";
	}

	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
