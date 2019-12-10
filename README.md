## 贪吃蛇功能
#### 1.管理类————>很多类————>类的功能不同

根据类的功能不同，将相同功能的类放到同一个包中

窗体类————>com.jt.frame包

面板类————>com.jt.panel包

对数据库表操作类————>com.jt.dao包

实体类————>com.jt.po包

工具类(数据库工具类...)————>com.jt.util包

#### 2.创建数据库snakegame

用户表user

排行表rank   主键id(自增)、分数、时间、用户id

#### 3.创建登录界面

创建登录界面的窗体类LoginFrame(com.jt.frame)

设置图标————>Image————>ImageIcon————>getImage()

创建用于获取图片的工具类ImageUtil(com.jt.util)

创建登录界面的面板类LoginPanel(com.jt.panel)

根据用户名及密码对user表查询jdbc

对user表的操作————>UserDao

对rank表的操作————>RankDao
