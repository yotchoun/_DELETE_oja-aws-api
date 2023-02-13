package com.mafoya.oja.repository;

import com.mafoya.oja.model.Article;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@EnableScan
@Repository
public interface ArticleRepository  extends CrudRepository<Article, String> {

    Set<Article> findByUserId(String id);
}
