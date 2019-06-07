package com.likzn.lisblog.service;

import com.likzn.lisblog.dao.ArticleCategoryRepository;
import com.likzn.lisblog.dao.ArticleInfoRepository;
import com.likzn.lisblog.dao.CommentRepository;
import com.likzn.lisblog.dao.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther: Li jx
 * @date: 2019/6/4 14:53
 * @description:
 */
public class BaseService {
    @Autowired
    ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    ArticleInfoRepository articleInfoRepository;
    @Autowired
    LogRepository logRepository;
    @Autowired
    CommentRepository commentRepository;


}
