package com.likzn.lisblog.controller;

import com.likzn.lisblog.dao.ArticleCategoryRepository;
import com.likzn.lisblog.dao.ArticleInfoRepository;
import com.likzn.lisblog.dao.CommentRepository;
import com.likzn.lisblog.dao.LogRepository;
import com.likzn.lisblog.dto.AdminSummaryDTO;
import com.likzn.lisblog.service.ArticleCategoryService;
import com.likzn.lisblog.service.ArticleInfoService;
import com.likzn.lisblog.service.CommentService;
import com.likzn.lisblog.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:04
 * @description:
 */
public class BaseController {
    @Autowired
    ArticleCategoryService articleCategoryService;
    @Autowired
    ArticleInfoService articleInfoService;
    @Autowired
    CommentService commentService;
    @Autowired
    LogService logService;
    @Autowired
    AdminSummaryDTO adminSummaryDTO;
    @Autowired
    ArticleCategoryRepository articleCategoryRepository;
    @Autowired
    ArticleInfoRepository articleInfoRepository;
    @Autowired
    LogRepository logRepository;
    @Autowired
    CommentRepository commentRepository;
}
