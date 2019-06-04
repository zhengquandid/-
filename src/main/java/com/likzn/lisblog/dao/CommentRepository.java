package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.Comment;
import org.springframework.data.repository.CrudRepository;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:05
 * @description:
 */
public interface CommentRepository extends CrudRepository<Comment, Long> {
}
