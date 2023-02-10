package com.mafoya.oja.repository;

import com.mafoya.oja.model.DealHot;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface DealHotRepository  extends CrudRepository<DealHot, String> {
}
