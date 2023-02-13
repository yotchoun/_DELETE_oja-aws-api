package com.mafoya.oja.repository;

import com.mafoya.oja.model.Shop;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface ShopRepository  extends CrudRepository<Shop, String> {

    Set<Shop> findByUserId(String id);

    Set<Shop> findBySocialLinkId(String id);
}
