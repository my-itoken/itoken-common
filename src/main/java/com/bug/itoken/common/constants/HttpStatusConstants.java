package com.bug.itoken.common.constants;

public enum  HttpStatusConstants {
    BAD_GATEWAY("502","无法从上游服务器获取信息");

    private String status;
    private String content;

    HttpStatusConstants(String status,String content){
        this.status = status;
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public String getContent() {
        return content;
    }
}
