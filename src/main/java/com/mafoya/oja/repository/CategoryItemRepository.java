package com.mafoya.oja.repository;

import com.mafoya.oja.model.CategoryItem;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface CategoryItemRepository  extends CrudRepository<CategoryItem, String> {
    Set<CategoryItem> findByCategoryNavigationId(String id);
}
