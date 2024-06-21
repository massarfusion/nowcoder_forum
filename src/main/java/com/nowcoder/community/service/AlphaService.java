package com.nowcoder.community.service;

import com.nowcoder.community.DAO.alphaDAO;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlphaService {

    @Autowired
    private alphaDAO DAO;

    public AlphaService() {
        System.out.println("正在构造AlphaService");
    }

    @PostConstruct
    void afterConstruct(){
        System.out.println("出现在构造后");
    }

    @PreDestroy
    void beforeWeDie(){
        System.out.println("正在收尾...");
    }

    public  void printData(){
        System.out.println(this.DAO.select());
    }
}
