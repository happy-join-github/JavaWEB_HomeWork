package com.itheima.service;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.PageBean;

import java.time.LocalDate;

public interface ClazzService {
    PageBean getAllClazz(String name, LocalDate begin, LocalDate end, Integer page, Integer pageSize);

    void addClazz(Clazz clazz);
}
