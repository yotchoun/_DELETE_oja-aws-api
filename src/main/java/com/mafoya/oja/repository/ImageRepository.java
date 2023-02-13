package com.mafoya.oja.repository;

import com.mafoya.oja.model.Image;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface ImageRepository  extends CrudRepository<Image, String> {

    Set<Image> findByProductId(String id);
}
