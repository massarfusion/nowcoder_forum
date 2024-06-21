package com.nowcoder.community.DAO;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
public class alphaDAOHiberImpl implements  alphaDAO{
    @Override
    public String select() {
        return "This is retrieved from Hiber";
    }
}
