package com.nowcoder.community.DAO;


import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {


    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);
    // 将来个人主页，某人的id的帖子可以用这个接口

    int selectDiscussPostRows(@Param("userId") int userId);
}
