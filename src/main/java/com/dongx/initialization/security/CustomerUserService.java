package com.dongx.initialization.security;

import com.dongx.initialization.dto.UserDTO;
import com.dongx.initialization.entity.Permission;
import com.dongx.initialization.entity.Role;
import com.dongx.initialization.entity.User;
import com.dongx.initialization.mapper.PermissionMapper;
import com.dongx.initialization.mapper.UserMapper;
import com.dongx.initialization.resposity.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * CustomerUserService
 *
 * @author: dongx
 * Description: 重写UserdetailService
 * Created in: 2018-05-26 19:40
 * Modified by:
 */
@Component
public class CustomerUserService implements UserDetailsService {
	
	@Resource
	private UserMapper userMapper;
	
	@Resource
	private PermissionMapper permissionMapper;
	
	@Resource
	private PasswordEncoder passwordEncoder;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// 通过用户名查询用户
		UserDTO user = userMapper.findByUsername(username);

		if (user != null) {
			List<Permission> permissionList = permissionMapper.findByUserid(user.getId());

			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
			for (Permission permission : permissionList) {
				if (permission != null && !StringUtils.isEmpty(permission.getName())) {
					GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getName());
					// 将权限信息添加到GrantedAuthority中， 进行全权限验证会用到
					grantedAuthorities.add(grantedAuthority);
				}
			}
			String password = passwordEncoder.encode(user.getPassword());
			return new org.springframework.security.core.userdetails.User(user.getUsername(), password, grantedAuthorities);
		} else {
			throw new UsernameNotFoundException("admin: " + username + " do not exist!");
		}
		
	}
}
