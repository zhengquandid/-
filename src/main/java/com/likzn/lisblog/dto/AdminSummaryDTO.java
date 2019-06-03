package com.likzn.lisblog.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * @auther: Li jx
 * @date: 2019/6/3 18:58
 * @description:
 */
@Getter
@Setter
public class AdminSummaryDTO {
    private Integer blogSum;
    private Integer blogCommetSum;
    private Integer commentSum;
    private Integer visitSum;

}
