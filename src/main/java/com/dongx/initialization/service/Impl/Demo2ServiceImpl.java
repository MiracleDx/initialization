package com.dongx.initialization.service.Impl;

import com.dongx.initialization.entity.Demo2;
import com.dongx.initialization.mapper.Demo2Mapper;
import com.dongx.initialization.service.Demo2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Demo2ServiceImpl
 *
 * @author: dongx
 * Description:
 * Created in: 2018-05-13 19:32
 * Modified by:
 */
@Service
public class Demo2ServiceImpl implements Demo2Service {

	@Autowired
	private Demo2Mapper demo2Mapper;
	
	@Override
	public Integer insert(Demo2 demo2) {
		return demo2Mapper.insert(demo2);
	}
}
