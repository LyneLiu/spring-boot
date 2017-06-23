package com.lyne.bo;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by nn_liu on 2017/5/18.
 */

@Component
public class PrdBean {

    private String name;
    private String addr;

    @PostConstruct
    public void init(){
        this.name = "test_name";
        this.addr = "test_addr";
    }

    @PreDestroy
    public void destroy(){
        System.out.println("destroy the prdbean");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }
}
