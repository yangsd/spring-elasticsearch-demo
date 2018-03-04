package com.elasticsearch.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.Date;

/**
 * indexName            索引库名称
 * type                 类型
 * shards               默认分区数
 * replicas             每个分区默认的备份数
 * refreshInterval      刷新间隔
 * indexStoreType       索引文件存储类型
 * @author sdyang
 * @create 2018-03-03 14:31
 **/
@Document(indexName = "myelastic",type = "article",refreshInterval = "-1")
public class Article implements Serializable{

    /**
     * 主键
     */
    @Id
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 摘要
     */
    private String abstracts;

    /**
     * 内容
     */
    @Field(type = FieldType.text,fielddata = true, searchAnalyzer = "ik_smart", analyzer = "ik_smart")
    private String content;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 作者
     */
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAbstracts() {
        return abstracts;
    }

    public void setAbstracts(String abstracts) {
        this.abstracts = abstracts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
