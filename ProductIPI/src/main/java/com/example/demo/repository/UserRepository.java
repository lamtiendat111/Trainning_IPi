package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.UserTest;
@Repository
public interface UserRepository extends JpaRepository<UserTest, Object> {
	@Query(nativeQuery = true,value = "select a.* from user a where a.name = :name LIMIT 1")
	public UserTest findByName(@Param(value = "name") String name);
}
