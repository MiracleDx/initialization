package com.dongx.initialization.service.Impl;

import com.dongx.initialization.resposity.UserRepository;
import com.dongx.initialization.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * UserSerivceImpl
 *
 * @author: dongx
 * Description: 用户接口实现类
 * Created in: 2018-05-26 19:35
 * Modified by:
 */
@Service
public class UserSerivceImpl implements UserService {
	
	@Resource
	UserRepository userRepository;
	
}
