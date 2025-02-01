package com.itheima.service.impl;

import com.itheima.dao.DeptDao;
import com.itheima.service.DeptSeivice;
import com.itheima.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptSeivice{
    @Autowired
    private DeptDao deptMapper;
    @Override
    public List<Dept> list() {
        //1. 查询部门原始数据
        List<String> lines = deptMapper.list();

        //2. 对原始数据进行处理 , 组装部门数据
        List<Dept> deptList = lines.stream().map(line -> {
            String[] parts = line.split(",");
            Integer id = Integer.parseInt(parts[0]);
            String name = parts[1];
            LocalDateTime updateTime = LocalDateTime.parse(parts[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new Dept(id, name, updateTime);
        }).toList();

        return deptList;
    }
}
