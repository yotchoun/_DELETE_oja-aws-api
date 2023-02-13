package com.mafoya.oja.repository;

import com.mafoya.oja.model.Category;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface CategoryRepository  extends CrudRepository<Category, String> {

    Set<Category> findByForId(String id);

    Set<Category> findByProductId(String id);
}
