package com.likzn.lisblog.dao;

import com.likzn.lisblog.entity.Log;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther: Li jx
 * @date: 2019/6/3 19:05
 * @description:
 */
public interface LogRepository extends CrudRepository<Log, Long> {
    Iterable<Log> findAllByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query(value = "insert into blog_log (ip,operate_by) values (:ip,:operateBy)", nativeQuery = true)
    int insertLog(@Param("ip") String ip, @Param("operateBy") String operateBy);
}
