package com.likzn.lisblog.controller;

import com.likzn.lisblog.dto.CommentDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
