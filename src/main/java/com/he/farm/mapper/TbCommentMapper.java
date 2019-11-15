package com.he.farm.mapper;

import com.he.farm.domain.TbComment;

import java.util.Date;
import java.util.List;

import com.he.farm.domain.vo.Comment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface TbCommentMapper extends Mapper<TbComment> {
    int getAllCommentCount();

    int getTodayCommentCount(@Param("startdate") String startdate, @Param("enddate") String enddate);

    List<Comment> getAllComment();

    List<Comment> getTodayComment(@Param("startdate") String startdate, @Param("enddate") String enddate);
}