package com.nowcoder.community.service;

import com.nowcoder.community.DAO.DiscussPostMapper;
import com.nowcoder.community.DAO.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    DiscussPostMapper discussPostMapper;


    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        return this.discussPostMapper.selectDiscussPosts(userId, offset, limit);
    }

    public int findDiscussPostsRows(int userId){
        return this.discussPostMapper.selectDiscussPostRows(userId);
    }


}
