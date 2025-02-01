package com.itheima.dao;

import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;


@Repository
public class logDao {

    public ArrayList<String> list() {
        //1. 加载log.txt文件数据
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("log.txt");
        ArrayList<String> lines = IoUtil.readUtf8Lines(inputStream, new ArrayList<String>());
        return lines;
    }
}
