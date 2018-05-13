package com.dongx.initialization.controller;

import com.dongx.initialization.entity.Demo2;
import com.dongx.initialization.service.Demo2Service;
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
public class HelloController {
	
	@Resource
	private Demo2Service demo2Service;
	
	@RequestMapping("/")
	public String index(ModelMap map) {
		// 加入一个属性 用于在模板中读取
		map.addAttribute("host", "Dongx");
		return "index";
	}

	@RequestMapping("/hello")
	public Integer insert(ModelMap map) {
		Demo2 demo2 = new Demo2();
		demo2.setName("111");
		demo2.setAge(111);
		return demo2Service.insert(demo2);
	}
}
