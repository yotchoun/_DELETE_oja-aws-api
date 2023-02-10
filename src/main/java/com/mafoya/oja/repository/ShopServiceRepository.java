package com.mafoya.oja.repository;

import com.mafoya.oja.model.ShopService;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ShopServiceRepository  extends CrudRepository<ShopService, String> {
}
