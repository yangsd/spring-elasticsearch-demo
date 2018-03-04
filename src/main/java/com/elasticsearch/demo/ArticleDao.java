package com.elasticsearch.demo;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author sdyang
 * @create 2018-03-03 14:44
 **/
public interface ArticleDao extends ElasticsearchRepository<Article,Long>{

    List<Article> findBytitle(String title);
}
