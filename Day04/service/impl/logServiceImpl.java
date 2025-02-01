package com.itheima.service.impl;

import com.itheima.pojo.Log;
import com.itheima.service.logService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itheima.dao.logDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class logServiceImpl implements logService{
    @Autowired
    private logDao logDao;
    @Override
    public List<Log> list() {
        ArrayList<String> lines= logDao.list();
        //2. 对原始数据进行处理 , 组装日志数据
        List<Log> logList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            return new Log(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], parts[6]);
        }).collect(Collectors.toList());
        return logList;
    }
}
