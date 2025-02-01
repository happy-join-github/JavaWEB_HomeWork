package com.itheima.controller;

import cn.hutool.core.io.IoUtil;
import com.itheima.pojo.Log;
import com.itheima.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.itheima.service.logService;
@RestController
public class LogController {
    @Autowired
    private logService logService;

    @RequestMapping("/logs")
    private Result list(){
        List<Log> logList = logService.list();
        //3. 响应结果
        return Result.success(logList);
    }

}
