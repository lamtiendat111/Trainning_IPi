package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Entity.ProductTest2;
@Repository
public interface ProductRepository extends JpaRepository<ProductTest2, Object> {
	@Query(nativeQuery = true,value = "select a.* from product a where a.name = :name LIMIT 1")
	public ProductTest2 findByName(@Param(value = "name") String name);
}
