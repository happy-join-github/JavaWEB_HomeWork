package com.itheima.mapper;

import com.itheima.pojo.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//1. 开发Mapper接口方法，查询全部学生信息，并编写对应的单元测试。 【基于注解方式配置SQL】 。
//2. 开发Mapper接口方法，往学生表中插入一条数据，并编写对应的单元测试。 【基于注解方式配置SQL】 。
//3. 开发Mapper接口方法，根据ID更新学生的学号、手机号、身份证号，并编写对应的单元测试。 【基于注解方式配置SQL】 。
//4. 开发Mapper接口方法，根据ID查询学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。
//5. 开发Mapper接口方法，根据ID删除学生信息，并编写对应的单元测试。 【基于XML方式配置SQL】 。

@Mapper
public interface StudentMapper {
    // 查询所有学生
    @Select("select * from student")
    public List<Student> findAll();


    // 插入学生
    @Insert("insert into student (name, no, gender, phone, id_card, degree, graduation_date, create_time, update_time) " +
            "values (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{degree}, #{graduationDate}, #{createTime}, #{updateTime})")
    public void insertStudent(Student student);

    // 更新学生
    @Update("update student set no=#{no},phone=#{phone},id_card=#{idCard} where id=#{id}")
    public void updateStudent(Student student);

    // 根据ID查询学生
//    @Select("select * from student where id=#{id}")
    public Student findById(Integer id);

    // 根据ID删除学生
//    @Delete("delete from student where id=#{id}")
    public void deleteById(Integer id);
}
