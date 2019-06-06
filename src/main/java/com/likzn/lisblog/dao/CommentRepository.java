package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.Comment;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:05
 * @description:
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
     Iterable<Comment> findAllByOrderByCreateTimeDesc();


    @Transactional
    @Modifying
    @Query(value = "insert into blog_comment (name,content,email) values (:name,:content,:email)", nativeQuery = true)
    int insertComment(@Param("name") String name, @Param("email") String email,@Param("content")String content);
}
