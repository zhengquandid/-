package com.likzn.lisblog.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @auther: Li jx
 * @date: 2019/6/3 18:58
 * @description:
 */
@Getter
@Setter
@Component
public class AdminSummaryDTO {
    private Long blogSum;
    private Long blogCommentSum;
    private Long commentSum;
    private Long visitSum;

}
