package com.likzn.lisblog.controller;

import com.likzn.lisblog.dto.AdminSummaryDTO;
import com.likzn.lisblog.entity.Comment;
import com.likzn.lisblog.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        adminSummaryDTO.setBlogSum(articleInfoService.count());
        adminSummaryDTO.setBlogCommentSum(0L);
        adminSummaryDTO.setVisitSum(logService.count());
        adminSummaryDTO.setCommentSum(commentService.count());
        return adminSummaryDTO;
    }

    //后台留言统计
    @PostMapping("/comment")
    public List<Comment> listComment() {
        List<Comment> list = new ArrayList();
        for (Comment comment : commentService.findAll()) {
            list.add(comment);
        }
        return list;
    }
}
