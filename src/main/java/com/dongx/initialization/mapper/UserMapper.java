package com.dongx.initialization.mapper;

import com.dongx.initialization.dto.UserDTO;
import com.dongx.initialization.entity.User;
import org.springframework.data.repository.query.Param;

public interface UserMapper {
    int deleteByPrimaryKey(String id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    UserDTO findByUsername(@Param("username") String username);
}