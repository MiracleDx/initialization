package com.dongx.initialization.mapper;

import com.dongx.initialization.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * UserMapperTest
 *
 * @author: dongx
 * Description:
 * Created in: 2018-05-27 18:27
 * Modified by:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
	
	@Resource
	private UserMapper userMapper;

	@Test
	public void findUserByUsername() {
		UserDTO userDTO = userMapper.findByUsername("admin");
		System.out.println(userDTO.toString());
	}
	
	@Test
	public void selectByPrimaryKey () {
		userMapper.selectByPrimaryKey("123213");
	}
}