package com.likzn.lisblog.controller;

import com.likzn.lisblog.dto.CommentDTO;
import com.likzn.lisblog.entity.ArticleCategory;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther: Li jx
 * @date: 2019/6/5 15:41
 * @description:
 */
@RestController
@RequestMapping("/api")
@Log4j2
public class ForeController extends BaseController {

    //添加留言
    @PostMapping(value = "/addComment",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addComment(@RequestBody CommentDTO commentDTO) {
        commentRepository.insertComment(commentDTO.getName(), commentDTO.getEmail(), commentDTO.getContent());
    }

    //列出分类标签
    @GetMapping("/listCategory")
    public List<ArticleCategory> listCategory() {
        List<ArticleCategory> list = new ArrayList();
        for (ArticleCategory category : articleCategoryRepository.findAll()) {
            list.add(category);
        }
        return list;
    }
}
