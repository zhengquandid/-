package com.likzn.lisblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @auther: Li jx
 * @date: 2019/6/3 16:34
 * @description:
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    public Timestamp createTime;

    public Timestamp updateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getCreateTime() {
        return createTime;
    }
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Timestamp getUpdateTime() {
        return updateTime;
    }
}
