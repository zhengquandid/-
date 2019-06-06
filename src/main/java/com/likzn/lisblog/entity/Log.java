package com.likzn.lisblog.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:11
 * @description:
 */
@Entity
@Table(name = "blog_log")
@Setter
@Getter
@Component
public class Log extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ip;

    private String operateBy;


}
