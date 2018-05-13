package com.dongx.initialization.resposity;

import com.dongx.initialization.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * DemoRepository
 *
 * @author: dongx
 * Description: demo资源库-数据访问接口
 * Created in: 2018-05-13 11:23
 * Modified by:
 */
public interface DemoRepository extends JpaRepository<Demo, Long> {
	
	Demo findByName(String name);
	
	Demo findByNameAndAge(String name, Integer age);
	
	@Query(value = "select * from gu_demo u where u.name = :name", nativeQuery = true)
	Demo findDemo(@Param("name") String name);
}
