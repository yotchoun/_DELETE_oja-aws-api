package com.mafoya.oja.repository;

import com.mafoya.oja.model.CategoryParent;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface CategoryParentRepository  extends CrudRepository<CategoryParent, String> {

    Set<CategoryParent> findByCategoryId(String id);
}
