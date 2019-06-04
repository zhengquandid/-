package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.ArticleCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:04
 * @description:
 */
@Repository
public interface ArticleCategoryRepository extends CrudRepository<ArticleCategory, Long> {

}
