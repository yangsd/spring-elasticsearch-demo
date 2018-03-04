package com;

import com.elasticsearch.demo.Article;
import com.elasticsearch.demo.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

/**
 * @author sdyang
 * @create 2018-03-04 15:29
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ElasticsearchTest {

    @Autowired
    private ArticleService articleService;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public void init(){
        articleService.init();
    }

    @Test
    public void test1(){
        List<Article> articleList = new ArrayList<Article>();

        articleList = articleService.search("百度");

        for(Article article:articleList){
            System.out.println(article.getTitle());
        }
    }

    @Test
    public void test2(){
        List<Article> articleList = new ArrayList<Article>();

        SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(queryStringQuery("京东")).build();
        articleList = elasticsearchTemplate.queryForList(searchQuery, Article.class);

        for(Article article:articleList){
            System.out.println(article.getTitle());
        }
    }


}
