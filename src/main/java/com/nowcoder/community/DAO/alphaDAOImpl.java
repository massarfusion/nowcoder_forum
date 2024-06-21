package com.nowcoder.community.DAO;


import org.springframework.stereotype.Repository;

@Repository
public class alphaDAOImpl implements  alphaDAO {

    @Override
    public String select() {
        return "Liu Zhongjing";
    }
}
