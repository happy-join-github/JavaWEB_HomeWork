package com.itheima.service;
import com.itheima.pojo.Log;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface logService{
    List<Log> list();
}
