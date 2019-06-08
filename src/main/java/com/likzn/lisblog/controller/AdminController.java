package com.likzn.lisblog.controller;

import com.likzn.lisblog.dto.AdminSummaryDTO;
import com.likzn.lisblog.dto.ArticleDTO;
import com.likzn.lisblog.dto.CategoryDTO;
import com.likzn.lisblog.entity.*;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li jx
 * @date: 2019/6/3 17:49
 * @description:
 */
@RestController
@RequestMapping("/admin")
@Log4j2
public class AdminController extends BaseController{

    private static String adminUsername = "123456";
    private static String adminPassword = "123456";

    //验证登陆
    @PostMapping("/login")
    public String login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/admin/main.html");
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        return null;
    }

    //获取后台信息总览
    @GetMapping("/summary")
    public AdminSummaryDTO listSummary() {
        adminSummaryDTO.setBlogSum(articleInfoRepository.count());
        adminSummaryDTO.setBlogCommentSum(0L);
        adminSummaryDTO.setVisitSum(logRepository.count());
        adminSummaryDTO.setCommentSum(commentRepository.count());
        return adminSummaryDTO;
    }

    //后台留言统计
    @PostMapping("/listComment")
    public List<Comment> listComment() {
        List<Comment> list = new ArrayList();
        for (Comment comment : commentRepository.findAllByOrderByCreateTimeDesc()) {
            list.add(comment);
        }
        return list;
    }

    @DeleteMapping("/comment/{id}")
    public void deleteComment(@PathVariable Long id) {
        commentRepository.deleteById(id);
        log.info("接口/admin/comment/{} ", id);
    }
    //删除分类
    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        articleCategoryRepository.deleteById(id);
        log.info("接口/admin/category/{} ", id);
    }

    //后台日志统计
    @PostMapping("/listLog")
    public List<Log> listLog() {
        List<Log> list = new ArrayList();
        for (Log log : logRepository.findAllByOrderByIdDesc()) {
            list.add(log);
        }
        return list;
    }

    //后台管理分类
    @PostMapping("/listCategory")
    public List<ArticleCategory> listCategory() {
        List<ArticleCategory> list = new ArrayList();
        for (ArticleCategory category : articleCategoryRepository.findAll()) {
            list.add(category);
        }
        return list;
    }

    //增加分类
    @PostMapping("/addCategory/{name}")
    public void addCategory(@PathVariable String name) {
        articleCategoryRepository.insertCategory(name);

    }

    //修改分类
    @PostMapping("/updateCategory")
    public void updateCategory(@RequestBody CategoryDTO categoryDTO) {
        articleCategoryRepository.updateCategoryById(categoryDTO.getCategoryName(), categoryDTO.getId());
    }

    //增加一片文章
    @PostMapping("/addArticle")
    public void addArticle(@RequestBody ArticleDTO articleDTO) {
        articleInfoService.addArticle(articleDTO);

    }
    //更新一片文章
    @PostMapping("/updateArticle")
    public void updateArticle(@RequestBody ArticleInfo articleInfo) {
        articleInfoService.updateArticle(articleInfo);
    }

    //列出文章总览
    @PostMapping("/listArticle")
    public List<ArticleInfo> listArticle() {
        List<ArticleInfo> list = new ArrayList();
        for (ArticleInfo articleInfo : articleInfoRepository.findAll()) {
            list.add(articleInfo);
        }
        return list;
    }

    //列出指定标签文章
    @PostMapping("/listArticle/{id}")
    public List<ArticleInfo> listArticleByCategoryId(@PathVariable Long id) {
        List<ArticleInfo> list = new ArrayList();
        for (ArticleInfo articleInfo : articleInfoRepository.findAllByCategoryId(id)) {

            list.add(articleInfo);
        }
        return list;
    }

    //删除指定文章
    @DeleteMapping("/deleteArticle/{id}")
    public void deleteArticle(@PathVariable Long id) {
        log.info("接口/admin/deleteArticle/{} ", id);
        articleCategoryRepository.reduceNumber(articleInfoRepository.findById(id).get().getCategoryId());
        articleInfoRepository.deleteById(id);
    }

    //列出指定文章
    @PostMapping("/article/{id}")
    public ArticleInfo articleById(@PathVariable Long id) {
        return articleInfoRepository.findById(id).get();
    }
}
