package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.ArticleCategory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:04
 * @description:
 */
@Repository
public interface ArticleCategoryRepository extends CrudRepository<ArticleCategory, Long> {


    @Transactional
    @Modifying
    @Query(value = "insert into blog_article_category (category_name) values (:name)", nativeQuery = true)
    int insertCategory(@Param("name") String name);

    @Transactional
    @Modifying
    @Query(value = "UPDATE  blog_article_category set category_name=:name where id = :id", nativeQuery = true)
    int updateCategoryById(@Param("name") String name,@Param("id") Long id);

}
