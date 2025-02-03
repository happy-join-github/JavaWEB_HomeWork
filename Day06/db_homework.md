```SQL
-- 1. 查询所有的性别为男(gender 为 1)的 讲师 (job 为 2) , 并根据入职时间, 对员工进行升序排序

select * from emp where gender=1 and job=2 order by entry_date;
-- 2. 根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序

select * from emp order by entry_date, id desc;
-- 3. 查询性别为男(gender 为 1) 且 薪资大于 6000 的员工, 并根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序

select * from emp where gender=1 and salary>6000 order by entry_date,id desc;
-- 4. 查询性别为男(gender 为 1)的员工 且 在 '2005-10-01' 至 '2018-10-01' 之间入职的员工, 并根据 入职时间 对公司的员工进行 升序排序 ， 入职时间相同 , 再按照 ID 进行降序排序

select * from emp where gender=1 and entry_date between '2005-10-01' and '2018-10-01' order by entry_date,id desc;
-- 5. 查询姓 '阮' 且 在 '2010-10-01' 之后入职的员工, 并根据入职时间进行升序排序, 并对结果分页操作, 展示第1页员工数据, 每页展示5条记录
select * from emp where name like '阮%' and entry_date > '2010-10-01' order by entry_date limit 0,5;
```

```java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateUserExample {

    // JDBC URL, 用户名和密码（这些需要根据你的实际情况进行修改）
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user"; // 修改为你的数据库URL
    private static final String JDBC_USER = "root"; // 修改为你的用户名
    private static final String JDBC_PASSWORD = "000000"; // 修改为你的密码

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            // 1. 获取数据库连接
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 2. 准备预编译SQL语句
            String sql = "update user set password = ? , name = ?, age = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            // 3. 设置预编译参数
            preparedStatement.setString(1, "666888");
            preparedStatement.setString(2, "关羽");
            preparedStatement.setInt(3, 32);
            preparedStatement.setInt(4, 4);

            // 4. 执行更新操作
            int affectedRows = preparedStatement.executeUpdate();

            // 5. 输出受影响的行数
            System.out.println("Affected Rows: " + affectedRows);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. 关闭资源
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```



```java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QueryUserExample {

    // JDBC URL, 用户名和密码（这些需要根据你的实际情况进行修改）
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user"; // 修改为你的数据库URL
    private static final String JDBC_USER = "root"; // 修改为你的用户名
    private static final String JDBC_PASSWORD = "000000"; // 修改为你的密码

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // 1. 获取数据库连接
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // 2. 准备预编译SQL语句
            String sql = "select id,username,password,name,age from user where age >= ? and id <= ?";
            preparedStatement = connection.prepareStatement(sql);

            // 3. 设置预编译参数
            preparedStatement.setInt(1, 20); // 设置age
            preparedStatement.setInt(2, 4); // 设置id

            // 4. 执行查询操作
            resultSet = preparedStatement.executeQuery();

            // 5. 封装查询结果到User对象列表
            List<User> userList = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                userList.add(user);
            }

            // 6. 输出用户信息到控制台
            for (User user : userList) {
                System.out.println(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 7. 关闭资源
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
```