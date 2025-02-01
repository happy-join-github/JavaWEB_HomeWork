# 使用方法

直接将下面的文件放在给出的文件文件里面。

具体位置为springboot-ioc-homework\src\main\java\com\itheima下即可。





# 分层解耦

1. Controller
   接受请求，调用service层，返回结果
2. Service
   处理业务逻辑，调用dao层，返回结果
3. dao
   查询数据，返回结果。