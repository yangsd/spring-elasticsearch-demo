package com.elasticsearch.demo;

import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author sdyang
 * @create 2018-03-03 14:45
 **/
@Service
public class ArticleService {

    @Autowired
    private ArticleDao articleDao;

    public void save(Article article){
        articleDao.save(article);
    }

    public List<Article> search(String keyword){
        List<Article> articleList = new ArrayList<Article>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(keyword);
        Iterable<Article> result = articleDao.search(builder);
        Iterator<Article> iterable = result.iterator();
        while (iterable.hasNext()){
            articleList.add(iterable.next());
        }
        return articleList;
    }

    public List<Article> findByTitle(String keyword){
        return articleDao.findBytitle(keyword);
    }

    public void init(){
        Article article1 = new Article();
        article1.setId(1L);
        article1.setTitle("B站正式递交赴美上市申请 计划融资4亿美元");
        article1.setAbstracts("上市，游戏");
        article1.setContent("美国东部时间3月2日，国内视频弹幕网站Bilibili（以下简称B站）正式向美国证券交易委员会（SEC）递交F-1招股书，计划通过IPO（首次公开募股）融资4亿美元");
        article1.setCreateTime(new Date());
        article1.setAuthor("崔鹏");

        this.save(article1);


        Article article2 = new Article();
        article2.setId(2L);
        article2.setTitle("李彦宏表态回归国内上市:只要政策允许，希望尽早回来");
        article2.setAbstracts("李彦宏");
        article2.setContent("全国人大代表，百度董事长兼首席执行官李彦宏接受采访时对百度回归国内上市表态。李彦宏称，一直希望百度能够整体在国内上市，因为主要的用户和市场都是在中国，如果主要股东也在中国就是最理想的情况。他指出，当年之所以去美国上市，是因为政策不允许，百度的VIE结构从中国的法律来看是一个外资公司。这一问题目前仍然存在着政策的障碍：”任何时候政策允许百度回来的话，我们肯定是希望能够尽早回到国内股市。”");
        article2.setCreateTime(new Date());
        article2.setAuthor("未知");

        this.save(article2);

        Article article3 = new Article();
        article3.setId(3L);
        article3.setTitle("京东2017业绩：年度净利润50亿元，全年GMV首破万亿");
        article3.setAbstracts("京东 财报");
        article3.setContent("京东今日发布了2017财年第四季度及全年财报。第四季度，京东净营收为人民币1102亿元，同比增长38.7%。净亏损人民币9.092亿元，与上年同期相比下降27.9%。基于非美国通用会计准则（Non-GAAP），净利润为人民币4.493亿元，而上年同期净收入人民币7.797亿元。");
        article3.setCreateTime(new Date());
        article3.setAuthor("未知");

        this.save(article3);
    }
}
