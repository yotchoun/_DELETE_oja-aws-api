package com.mafoya.oja.repository;

import com.mafoya.oja.model.Review;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ReviewRepository  extends CrudRepository<Review, String> {
}
