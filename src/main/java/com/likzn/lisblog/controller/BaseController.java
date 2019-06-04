package com.likzn.lisblog.controller;

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
}
