package com.itheima;

import com.itheima.mapper.StudentMapper;
import com.itheima.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class SpringBootMybatisApplicationTests {
    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void getAllInfo(){
        // 调用mapper接口进行查询全部学生信息
        List<Student> students = studentMapper.findAll();
        // 输出查询信息
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }

    @Test
    public void getStudentById(){
        // 调用mapper接口进行查询指定id的学生信息
        Student student = studentMapper.findById(1);
        System.out.println(student.toString());
    }
    @Test
    public void insertStudent(){
        // 创建一个Student对象
        Student student = new Student(null, "小明", "20190011", 1, "12345678901", "123456789012345678", 1, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        // 调用mapper接口进行插入学生信息
        studentMapper.insertStudent(student);
    }

    @Test
    public void updateStudent(){
        // 创建一个Student对象
        Student student = new Student(11, "小明", "201900011", 1, "12345678901", "123456789087654321", 1, LocalDate.now(), LocalDateTime.now(), LocalDateTime.now());
        // 调用mapper接口进行更新学生信息
        studentMapper.updateStudent(student);
    }

    @Test
    public void deleteStudent(){
        // 调用mapper接口进行删除学生信息
        studentMapper.deleteById(2);
    }
}
