package com.mafoya.oja.repository;

import com.mafoya.oja.model.UserAddress;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface UserAddressRepository  extends CrudRepository<UserAddress, String> {

    Set<UserAddress> findByUserId(String id);
}
