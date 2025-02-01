package com.itheima.dao;

import cn.hutool.core.io.IoUtil;
import org.springframework.stereotype.Repository;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Repository
public class DeptDao {
    public List<String> list() {
        //1. 加载文件 ,  获取原始数据
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("dept.txt");
        List<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<String>());
        return lines;

    }

}
