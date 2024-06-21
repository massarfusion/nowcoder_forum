package com.nowcoder.community.DAO;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class alphaDAOMybatisImpl implements  alphaDAO{
    @Override
    public String select() {
        return "This is retrieved from Mybatis";
    }
}
