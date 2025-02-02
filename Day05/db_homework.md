```SQL
-- 1. 往emp表中插入一条测试数据， 全部的字段都需要插入值 。

insert into emp value(31,'root','123456','管理员',1,'18200000001',4,8000,'1.jpg',now(),now(),now());
-- 2. 批量往emp表中插入两条测试数据， 全部的字段都需要插入值 。
insert into emp
values
    (32,'emp32','123456','员工32',1,'18200000002',2,5000,'2.jpg',now(),now(),now()),
    (33,'emp33','123456','员工33',1,'18200000003',2,5500,'3.jpg',now(),now(),now());

-- 3. 为id为2,4,6,8,9这个几个员工，涨100块钱工资 （在当前薪资的基础上 + 100）。
update emp set salary=salary+100 where id in (2,4,6,8,9);

-- 4. 删除id为30,31的员工信息
delete from emp where id in (30,31);

-- 5. 将id为6，7，9，12这个几个员工的 入职日期修改为 '2018-09-10' , 密码修改为 '1234567'
update emp set entry_date = '2018-09-10',password='1234567' where id in (6,7,9,12);
```

```SQL
-- 1. 查询指定字段 name,entry_date 并设置别名为 姓名、入职日期 并返回

select name as '姓名',entry_date as '入职日期' from emp;
-- 2. 查询返回所有字段 （两种写法哦）

select id, username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time from emp;
select * from emp;
-- 3. 查询性别为女 且 有职位的员工，要求查询出 name,entry_date 并起别名 (姓名、入职日期)

select name as '姓名',entry_date as '入职日期' from emp where gender=2 and job is not null;
-- 4. 查询已有的员工关联了 哪几种 职位(不要重复)

select job from emp where job is not null group by job;
-- 5. 查询 姓名 为 '童威' 或 入职时间在 '2000-01-01' 到 '2010-01-01' 的员工

select * from emp where name='童威' or entry_date between '2000-01-01' and '2010-01-01';
-- 6. 查询在 薪资小于等于5000 的员工信息

select * from emp where salary<=5000;
-- 7. 查询 没有分配职位 的员工信息

select * from emp where job is null;
-- 8. 查询 有职位 的员工信息

select * from emp where job is not null;
-- 9. 查询 密码不等于 '123456' 或 没有职位的员工信息

select * from emp where password != '123456' or job is null;
-- 10. 查询入职日期 在 '2000-01-01' (包含) 到 '2015-01-01'(包含) 之间的员工信息

select * from emp where '2000-01-01'<= entry_date<= '2015-01-01';
-- 11. 查询 入职时间 在 '2000-01-01' (包含) 到 '2015-01-01'(包含) 之间 且 性别为女 的员工信息

select * from emp where '2000-01-01'<= entry_date<= '2015-01-01' and gender=2;
-- 12. 查询 职位是 2 (讲师) 或 3 (学工主管) 或 4 (教研主管) 的员工信息（两种写法实现）

select * from emp where job in (2,3,4);
select * from emp where job=2 or job = 3 or job = 4;
-- 13. 查询姓名为两个字 且 性别为男 且 薪资高于5000 的员工信息

SELECT * FROM emp WHERE CHAR_LENGTH(name) = 2 AND gender = 1 AND salary > 5000;
-- 14. 查询姓名中包含 '小' 的员工信息  且  入职时间在 '2008-01-01' 之后入职的员工

SELECT * FROM emp WHERE name like '%小%' and entry_date>'2008-01-01';
-- 15. 查询出 性别为 男 , 或 入职时间在 '2010-01-01' 之后入职的员工

select * from emp where gender=1 or entry_date > '2010-01-01';
-- 16. 查询有职位的， 且 姓名为两个字 的员工信息 

SELECT * FROM emp WHERE CHAR_LENGTH(name) = 2 and job is not null;
-- 17. 查询所有的性别为男(gender 为 1)的 讲师 (job 为 2) 的员工信息

SELECT * FROM emp WHERE gender=1 and job=2;
-- 18. 查询薪资小于 8000 或 入职时间在 2010-10-09 之后入职的员工信息

SELECT * FROM emp WHERE salary < 8000 or entry_date > '2010-10-09';
-- 19. 根据性别分组 , 统计男性和女性员工的数量 

select gender,count(*) as '总数' from emp group by gender;
-- 22. 先查询入职时间在 '2015-01-01' (包含) 以前的员工 , 并对结果根据职位分组 , 获取员工数量大于等于2的职位
select job from emp where entry_date<='2015-01-01' group by job having count(*)>=2;
```

```sql
create table dept(
    id int primary key auto_increment comment 'ID 主键',
    dept_name varchar(10) not null unique comment  '部门名称',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间'
)comment '部门表';

create table clazz(
    id int unsigned primary key auto_increment comment '主键,ID,自增长',
    class_name varchar(30) unique not null comment '班级名称',
    classroom varchar(20) comment '班级教室',
    begin_time date not null comment '开课时间',
    end_time date not null comment '结课时间',
    subject int unsigned not null comment '1-Java;2-前端;3-大数据;4-pyhton;5-go;6-嵌入式',
    status int unsigned comment '0-未开班;1-在读',
    create_time datetime comment '创建时间',
    update_time datetime comment '更新时间'
);
```

