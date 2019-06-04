package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.ArticleInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:05
 * @description:
 */
@Repository
public interface ArticleInfoRepository extends CrudRepository<ArticleInfo, Long> {


}
