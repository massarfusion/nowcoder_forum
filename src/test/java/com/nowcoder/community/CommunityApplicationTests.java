package com.nowcoder.community;

import com.nowcoder.community.DAO.UserMapper;
import com.nowcoder.community.DAO.alphaDAO;
import com.nowcoder.community.DAO.alphaDAOHiberImpl;
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
class CommunityApplicationTests implements ApplicationContextAware {
    private  ApplicationContext context;

    @Autowired
    @Qualifier("alphaDAOHiberImpl")
    private alphaDAO testDao;

    @Autowired
    private AlphaService alphaService;

    @Test
    void contextLoads() {
        System.out.println(this.context);
        alphaDAO dataface = this.context.getBean(alphaDAO.class);
        System.out.println(dataface.select());

        alphaDAO face2 = this.context.getBean("alphaDAOHiberImpl", alphaDAO.class);
        System.out.println(face2.select());


        AlphaService as = this.context.getBean(AlphaService.class);
        AlphaService as2 = this.context.getBean(AlphaService.class);
        System.out.println(as);
        System.out.println(as2);
    }

    @Test
    void TestBeanConfig(){
        SimpleDateFormat simpleDateFormat = this.context.getBean(SimpleDateFormat.class);
        System.out.println( simpleDateFormat.format(new Date()) );;


    }
    @Test
    void TestDI(){
        System.out.println(this.testDao);
        System.out.println(this.alphaService);
        this.alphaService.printData();
    }

    @Autowired
    UserMapper  mapper;
    @Test
    void MapperTestation(){
        User user  = mapper.selectById(101);
        System.out.println(user);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }
}
