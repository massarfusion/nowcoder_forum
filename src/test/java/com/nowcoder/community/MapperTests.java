package com.nowcoder.community;

import com.nowcoder.community.DAO.DiscussPostMapper;
import com.nowcoder.community.DAO.UserMapper;
import com.nowcoder.community.DAO.alphaDAO;
import com.nowcoder.community.entity.User;
import com.nowcoder.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class MapperTests implements ApplicationContextAware {
    private  ApplicationContext context;





    @Autowired
    UserMapper  mapper;

    @Autowired
    DiscussPostMapper discussPostMapper;

    @Test
    void MapperTestation(){
        User user  = mapper.selectById(101);
        System.out.println(user);

        user  = mapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);


        user  = mapper.selectByName("liubei");
        System.out.println(user);
    }

    @Test
    void testInsert(){
        User user = new User();
        user.setUsername("Rito");
        user.setEmail("222@qq.com");
        user.setPassword("114514");
        user.setSalt("1919");
        user.setHeaderUrl("www.yjsp.com/101.jpg");
        user.setCreateTime(new Date());

//        mapper.insertUser(user);
        System.out.println(mapper.selectByName("Rito"));
        mapper.updateHeader(152, "ftp://mysa.com/123.png");
        mapper.updateStatus(152, 2);
        mapper.updatePassword(152, "cqccloap");
        System.out.println(mapper.selectByName("Rito"));

    }

    @Test
    void testPosts(){
        System.out.println(discussPostMapper.selectDiscussPosts(0, 0,8));
        System.out.println(discussPostMapper.selectDiscussPostRows(0));
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
