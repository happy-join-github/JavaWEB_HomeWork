package com.itheima.controller;

import com.itheima.service.DeptSeivice;
import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    private DeptSeivice deptSeivice;
    @RequestMapping("/depts")
    public Result list2(){
        List<Dept> deptList = deptSeivice.list();
        //2. 响应数据
        return Result.success(deptList);
    }

}
