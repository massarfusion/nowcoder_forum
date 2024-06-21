package com.nowcoder.community.entity;
/*
* 封装分页控制
*
* */
public class Page {
    //页码
    int current = 1;
    // 条数上限
    int limit = 10;

    // 数据总数（总页数）
    int rows;

    // 查询路径; 复用分页的链接
    String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        current = current>=1?current:1;
        this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit>=1 || limit<=100){
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows>=0){
            this.rows = rows;
        }
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getOffset(){
        // current * limie - limit
        return (current-1) * limit;
    }

    // 页数总数
    public  int getTotal(){
        // rows / limit
        if (rows%limit==0){
            return rows / limit;
        }
        else {
            return rows/limit+1;
        }
    }
    // 最终页码
    public int getTo(){
        int to = current+2;
        int total = getTotal();
        return to>total?total:to;
    }
    // 起始页码
    public int getFrom(){
        return (current-2)>=1?current-2:1;
    }
}
