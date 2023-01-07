# javaWeb

ctrl +  alt + t 快速代码生成  try/catch

ctrl +  alt  + shift 鼠标左键 多选

alt + insert 快速生成代码

ctrl + r		搜索，替换

数据库

```sql
MySQL

JDBC

Maven

MyBatis
```

前端

```sql
HTML + CSS

JavaScript

Ajax + Vue + ElementUI
```

web核心

```sql
Tomcat + HTTP + Servlet

Request + Response

JSP

Cookie + Session

Filter + Listener

综合案例
```

##  1. 数据库

结构化查询语言 structured query langage

### 1.为什么要配置环境变量

**①** **为什么需要配置环境变量？**

- 环境变量，代表系统的一个全局搜索路径。
- 当你没有配置环境变量的时候，你想要执行某个目录下的某个程序，就必须找到它的具体位置，才能够执行它。你仔细想一下，假如你在其它的文件路径下，想要执行另外一个目录下的某个程序，你觉得可以吗？
- 当不配置环境变量，想要执行某个程序可以吗？当然也是可以的，就拿启动mysql来说，你如果不配置环境变量，就必须在CMD黑窗口中，使用cd命令切换到mysql server下的bin目录下，才可以执行启动。你每次这样启动是不是觉得很麻烦，当你需要经常使用mysql，需要经常执行mysql启动。这就是为什么我们需要配置环境变量的原因。
- 当配置了某个环境变量，如果你想要执行某个程序，你可以在任何路径下，执行这个称序。首先，系统会在当前目录下，搜索是否存在想要执行的某个程序，假如没有，系统会再去系统环境变量中的目录进行一个个搜索，当搜索到了该程序，便会立即执行。

### 2. 进行初始化

首先需要一个my.ini文件

```sql
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8
[mysqld]
#设置3306端口
port = 3306
# 设置mysql的安装目录
basedir=C:\Program Files\MySQL\MySQL Server 5.7
# 设置mysql数据库的数据的存放目录
datadir=C:\Program Files\MySQL\MySQL Server 5.7\data
# 允许最大连接数
max_connections=200
# 服务端使用的字符集默认为8比特编码的latin1字符集
character-set-server=utf8
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
```

管理员模式下输入以下命令

```sql
mysqld install
安装
mysqld --initialize console或者mysqld --initialize --user=mysql --console
进行数据库的初始化，记住初始化密码
net start mysql
开始数据库
mysql -u root -p
登录，输入初始密码
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY '123456';
修改初始密码，用新密码登录
```

#### MySQL报错

 Can't create directory 'C:\Program Files\MySQL\MySQL Server 5.7\data\' (Errcode: 13 - Permission denied)

需要用管理员身份运行

启动服务失败

1.my.ini配置不对

2.data文件缺乏，最好不要手动创建

3.端口号被占用

```sql
输入
netstat -ano
查看，找到占用3306端口号的PID，去任务管理器里关闭即可
```

#### 查询所有用户

```sql
select user from mysql.user
```



### 3.数据库

.frm	表

.mvd	数据![1eb8d99a6ea6fc6a67f2edc97a97d94](C:\Users\boy\AppData\Local\Temp\WeChat Files\1eb8d99a6ea6fc6a67f2edc97a97d94.png)

一个MySQL可以创建多个数据库，数据库里面有多个表

### 4. SQL

结构化查询语言 structured query language

#### 1.SQL语句

1.单行或多行，以 ；结尾

2.不缺分大小写，关键字建议用大写

3.注释	单行#  --空格

​			多行 /* */

#### 2.分类

```sql
DDL(Data Definition Language)	结构化定义语言	定义数据库对象，数据库、表列
DML(Data Manipulation Language)	数据操作语言	 用来对数据库中表地数据crud
DQL(Data Query Language)		数据查询语言	 查询数据库中表的记录
DCL(Data Conrol Language)		数据控制语言	 定义数据库访问权限和安全级别，及创建用户
```

#### 3.DDL（表和库）

##### 1.创建库

```sql
create database name;
```

名字不能重复

```sql
create database if not exists name;
```

##### 2.删除库

```sql
drop database name;
drop database if exists name;
```

##### 3.查询库

```sql
show databases;
```

自带：

information_schema	 是视图

mysql								存储权限之类

porformance_schema	性能相关

sys									  系统相关

##### 4.使用数据库

```sql
use name;
```

查看当前使用的数据库

```sql
select database();
```

##### 5.查询表

```sql
show tables;
```

查询表的整体结构信息

description		描述

```sql
desc name;
```

##### 6.创建表

```sql
create table name(
	字段1	数据类型1,
	字段2	数据类型2,
	字段3	数据类型3
);
```

##### 7.数据类型

数值

日期

字符串

```sql
tinyint			1
smallint		2
int  integer	3
bigint			4
float			4
double			8		score double(总长度，保留位数)
```

```sql
date			3		birthday date
time			3
year			1
datetime		8
timestamp		4
```

```sql
char 			定长		name char(10)
varchar			变长
```

小练习

```sql
create table student(
    -> id int,
    -> name varchar(10),
    -> gender char(1),
    -> birthday date,
    -> score double(5,2),
    -> emial varchar(64),
    -> tel varchar(15),
    -> status tinyint
    -> );
```

##### 8.删除表

```sql
drop table name;
drop table if exits name;
```

##### 9.修改表

1.修改表名

```sql
alter table 表名 rename to 新表名;
```

2.添加一列

```sql
alter table 表名 add 新的列命
```

3.修改某一列数据类型

```sql
alter table 表名 modify 列名 新数据类型
```

4.修改列名和数据类型

```sql
alter table 表名 change 列名 新列名 新数据类型
```

5.删除列

```sql
alter table 表名 drop 列名
```

#### 4.DML（数据）

##### 1.指定列添加数据

```sql
insert into 表名(列名1，列名2) values(值1，值2)
```

##### 2.给全部列添加数据

```sql
insert into 表名 values(值1，值2)
```

##### 3.批量添加数据

```sql
insert into 表名(列名1，列名2) values (值1，值2),(值1，值2)
insert into 表名 values values(值1，值2),(值1，值2)
```

##### 4.修改表数据

```sql
update 表名 set 列名 = '女' where name = '张三'
```

不加where会修改所有记录

##### 5.删除

```sql
delete from 表名 where name = '张三'
```

不加where会修改所有记录

#### 5.DQL（查询）

```sql
基础查询
条件查询
分组查询
排序查询
分页查询
```

```sql
select
	字段列表
from
	表名列表
where
	条件列表
group by
	分组字段
having
	分组后条件
order by
	排序字段
limit
	分页限定
```

```sql
	( 1, '马云', 55, '男', '杭州', 66, 78, '1995-09-01' ),
	( 2, '马花疼', 45, '女', '深圳', 98, 87, '1998-09-01' ),
	( 3, '马斯克', 55, '男', '香港', 56, 77, '1998-09-02' ),
	( 4, '柳白', 20, '女', '湖南', 77, 65, '1997-09-05' ),
	( 5, '柳青', 20, '男', '湖南', 86, NULL, '1998-09-01' ),
	( 6, '刘德花', 57, '男', '香港', 99, 99, '1998-09-01' ),
	( 7, '张学右', 22, '女', '香港', 99, 99, '1998-09-01' ),
	( 8, '德玛西亚', 18, '男', '南京', 956, 65, '1994-09-02' );
```



##### 1.基础查询

查询 name age 两列

```sql
select name,age from stu;
```

查询所有列数据，不要用

```sql
select * from stu;
```

查询地址信息

```sql
select address from stu;
```

去除重复记录

```sql
select distinct address from stu;
```

起别名

```sql
select name ,english as 英语成绩, math as 数学成绩 from stu;
```

##### 2. 条件查询

```sql
select 字段列表 from 表名 where 条件列表;
```

```sql
-- 条件查询

-- 1.查询年龄大于20
select * from stu where age > 20;

-- 2.查询年龄大于20 且小于30
select * from stu where age>=20 and age<=30;
select * from stu where age>=20 && age<=30;
select * from stu where age between 20 and 30;

-- 3.查询入学日期
select * from stu where hire_date between '1998-09-01' and '1999-09-01';

-- 4. 查询年龄等于多少
select * from stu where age = 18;

-- 不等于
select * from stu where age != 18;

select * from stu where age <> 18;

-- 5.查询中或者
select * from stu where age = 18 or age = 20 or age = 22;

select * from stu where age in (18,20,22);

-- 6.查询信息为null
select * from stu where english is null;

select * from stu where english is not null;

```

模糊查询

```sql
/*
	通配符
	—— ：代表任意单个字
	%  ：任意个字符 
*/
-- 1.查询姓马
select * from stu where name like '马%';
-- 2.查询第二个字是花
select * from stu where name like '_花%';
-- 3.查询名字中含德
select * from stu where name like '%德%';
```

##### 3.排序查询

多个条件，只有第一个一样时才会用

```sql
select 字段列表 from 表名 order by 排序字段1[排序方式1]
asc	升序（默认）
desc 降序
```

**分组之后，查询的字段为聚合函数和分组字段，查询其他字段无意**义

```sql
-- 1.升序
select * from stu order by age;
-- 2.降序
select * from stu order by math desc;
-- 1.数学成绩降序，如果数学成绩一样就按照英语成绩
select * from stu order by math desc,english asc;
```

##### 4.分组查询

```sql
select 字段列表 from 表名 [where 分组条件限定] group by 分组字段名 [having 分组后条件过滤];
```

聚合函数

```
cout(列名)	统计数量	取值：主键
max(列名)
min(列名)
sum(列名)		求和
avg(列名)		平均
```

```sql
-- 1.统计多少学生
-- null 不会被统计
select count(id) from stu;
-- 2.查询数学最高分
select max(math) from stu;
-- 3.查询数学最低分
select min(math) from stu;
-- 4.查询数学总分
select sum(math) from stu;
-- 5.查询数学平均分
select avg(math) from stu;

-- 不统计null
select min(english) from stu;
```

查询

```sql
-- 1.查询男女各自平均分
select sex , avg(math) from stu group by sex;

-- 2.查询男女各自平均分,及各自人数
select sex ,count(*),avg(math) from stu group by sex;

-- 3.查询男女各自平均分,及各自人数,分数低于70不参与
select sex ,count(*),avg(math) from stu where math > 70 group by sex;

-- 4.查询男女各自平均分,及各自人数,分数低于70不参与,分组之后人数大于两个
select sex ,count(*),avg(math) from stu where math > 70 group by sex having count(*) > 2;
```

where和having区别

1.执行时机不一样，where时分组之前进行限定，不满足where条件，不参与分组，而having是对分组之后的结果进行过滤

2.可判断的条件不一样，where不能对聚合函数进行判断，having可以，原因是执行顺序

执行顺序：where > 聚合函数 > having

##### 5.分页查询

```sql
select 字段列表 from 表名 limit 起始索引 , 查询条数;
```

```sql
-- 1.从零开始查询三条
select * from stu limit 0,3;

-- 2.每一页显示三条，查询第一页
select * from stu limit 0,3;

-- 3.每一页显示三条，查询第二页
select * from stu limit 3,3;

-- 4.每一页显示三条，查询第三页
select * from stu limit 6,3;

-- 起始索引
/*
	（当前页码 - 1） * 每页显示的条数
*/

```

##### 小结 

```sql
select
	字段列表
from
	表名列表
where
	条件列表
group by
	分组字段
having
	分组后条件
order by
	排序字段
limit
	分页限定
```

### 5. 约束

##### 分类

```
非空约束		not null
唯一约束		unique
主键约束		primary key
检查约束		check
默认约束		default
外键约束		foreign key
```

```sql
create table emp(
	id int primary key,
	ename varchar(50) not null unique,
	joindate date not null,
	salary double(7,2) not null,
	bonus double(7,2) default 0
);
```

auto_increment		自动增长

##### 外键约束

```sql
建表时添加
constraint [外键名称](关联外键的名称) foreign key(外键名称) references 主表(主表列名)

建完表后添加
alter table 表名 add constraint 外键名称 foreign key (外键字段名称) references 主表名称(主键字段)
```

创建表时关联

emp表的dep_id主键关联dept表的id

```sql
create table emp(
	id int primary key,
	ename varchar(50) not null unique,
	joindate date not null,
	salary double(7,2) not null,
	bonus double(7,2) default 0,
	-- 添加外键 dep_id 关联dept 表的id主键
    constraint fk_emp_dept foreign key(dep_id) references dept(id)
);

删除外键
alter table emp drop foreign key fk_emp_dept;
建完表后添加外键
alter table emp add constraint fk_emp_dept foreign key (dep_id) references dept(id);
```

### 6.数据库设计

需求分析 -> 设计->编码 ->测试 -> 安装部署

#### 表关系

一对一

 人和身份证

用户表和用户详情

分表提升查询性能



一对多

如：部门与员工



多对多

商品和订单

#### 一对多

实现：在多的一方建立外键，指向一的一方的主键

#### 多对多

实现：建立第三张中间表，中间表至少含两个外键，关联两张表的主键

```sql
-- 订单表
create table tb_order(
	id int primary key auto_increment,
	payment double(10,2),
	payment_type tinyint,
	status tinyint
);

-- 商品表
create table tb_goods(
	id int primary key auto_increment,
	title varchar(100),
	price double(10,2)
);

-- 订单商品中间表
create table tb_order_goods(
	id int primary key auto_increment,
	order_id int,
	goods_id int,
	count int
);


-- 添加外键
alter table tb_order_goods add constraint fk_order_id foreign key (order_id) references tb_order(id);
alter table tb_order_goods add constraint fk_goods_id foreign key (goods_id) references tb_goods(id);
```

### 7.多表查询

##### 内连接

```sql
-- 隐式内连接
select 字段列表 from 表1, 表2 where 条件;
-- 显示内连接
select * from emp inner join stu on emp.id = stu.id;
```

起别名

```sql
select t1.ename ,t1.bonus , t2.address,t2.english  from emp t1 ,stu t2 where t1.id = t2.id;
```

##### 外连接

左外连接：查询左表所有数据和交集部分数据 A B 中查 A 和 A∩B

```sql
-- 左外连接
select * from emp left join stu on emp.id = stu.id;
-- 右外连接
select * from emp right join stu on emp.id = stu.id;
```

##### 子查询

单行单列

​	作为条件值

```sql
select * from stu where math > (select math from stu where name = '柳白');
```

单行多列

​	作为条件值

```sql
select * from stu where id in (select id from stu where address = '湖南' or address ='香港' );
```

多行多列

​	建立虚拟表，先按照条件创建新表

```sql
select * from (select * from stu where hire_date > '1996-09-08') t1 , emp t2 where t1.id = t2.id;
```

##### 案例

```sql
drop table if exists emp;
drop table if exists dept;
drop table if exists job;
drop table if exists salarygrade;

-- 部门表
create table dept(
	id int primary key , -- 部门id
	dname varchar(50),   -- 部门名称
	loc varchar(50)      -- 部门所在地
);

-- 服务表，职务表 职务描述
create table job(
	id int primary key,
	jname varchar(20),
	description varchar(50)
);


-- 员工表
create table emp(
	id int primary key, -- 员工id
	ename varchar(50),  -- 员工姓名
	job_id int,         -- 职务id
	mgr int ,           -- 上级领导
	joindate date ,     -- 入职日期
	salary double(7,2), -- 工资
	bonus double(7,2),  -- 奖金
	dept_id int,        -- 所在部门编号
	constraint emp_jobid_ref_job_id_fk foreign key (job_id) references job(id), -- 添加外键到job表中的id
	constraint emp_deptid_ref_dept_id_fk foreign key (dept_id) references dept(id)-- 添加外键到dept表中的id
);

-- 工资等级表
create table salarygrade (
	grade int primary key , -- 级别
	losalary int,           -- 最低工资
	hisalary int            -- 最高工资
);


-- 添加4个部门
insert into dept (id,dname, loc) values
(10,'教研部','北京'),
(20,'学工部','上海'),
(30,'销售部','广州'),
(40,'财务部','深圳');


-- 添加4个职务
insert into job (id,jname ,description ) values
(1,'董事长','管理整个公司,接单'),
(2,'经理','管理部门员工'),
(3,'销售员','向客人推销产品'),
(4,'文员','使用办公软件');


-- 添加员工 
insert into emp(id , ename,job_id,mgr,joindate,salary,bonus,dept_id) values
(1001,'孙悟空',4,1004,'2000-12-17','8000.00',NULL,20),
(1002,'卢俊义',3,1006,'2001-02-20','16000.00','3000.00',30),
(1003,'林冲',3,1006,'2001-02-22','12500.00','5000.00',30),
(1004,'唐僧',2,1009,'2001-04-02','29750.00',NULL,20),
(1005,'李逵',4,1006,'2001-09-28','12500.00','14000.00',30),
(1006,'宋江',2,1009,'2001-05-01','28500.00',NULL,30),
(1007,'刘备',2,1009,'2001-09-01','24500.00',NULL,10),
(1008,'猪八戒',4,1004,'2007-04-19','30000.00',NULL,20),
(1009,'罗贯中',1,NULL,'2001-11-17','50000.00',NULL,10),
(1010,'吴用',3,1006,'2001-09-08','15000.00','0.00',30),
(1011,'沙僧',4,1004,'2007-05-23','11000.00',NULL,20),
(1012,'李逵',4,1006,'2001-12-03','9500.00',NULL,30),
(1013,'小白龙',4,1004,'2001-12-03','30000.00',NULL,20),
(1014,'关羽',4,1007,'2002-01-23','13000.00',NULL,10);

-- 添加5个工资等级
insert into salarygrade (grade,losalary,hisalary) values
(1,7000,12000),
(2,12010,14000),
(3,14010,20000),
(4,20010,30000),
(5,30010,99990);

-- 1.查询所有员工信息，包括员工编号，员工姓名，工资，职务名称，职务描述
/*
	1.员工编号，姓名，工资信息在emp表中
	2.职务名称，描述，信息在job职务表中
	3.job 职务表 和 emp 员工表是一对多关系
*/
-- 隐式内连接
select 
	emp.id ,
	emp.ename,
	emp.salary ,
	job.jname,
	job.description 
from 
	emp ,
	job  
where 
	emp.job_id = job.id 
order by 
	emp.id;
	
-- 显式内连接
select 
	emp.id ,
	emp.ename,
	emp.salary ,
	job.jname,
	job.description 
from 
	emp 
inner join job on emp.job_id = job.id 
order by 
	emp.id;

-- 2.查询员工编号，员工姓名，工资，职务名称，职位描述，部分名称，部门位置
-- 隐式
select 
	emp.id ,
	emp.ename ,
	emp.salary,
	job.jname,
	job.description,
	dept.dname,
	dept.loc 
from 
	emp,
	job ,
	dept 
where 
	emp.job_id = job.id 
	and emp.dept_id = dept.id 
order by 
	emp.id;

-- 显式
select 
	emp.id ,
	emp.ename ,
	emp.salary,
	job.jname,
	job.description,
	dept.dname,
	dept.loc 
from 
emp 
inner join job on emp.job_id = job.id 
inner join dept on  emp.dept_id = dept.id 
order by 
	emp.id;

-- 3.查询员工姓名，工资，工资等级
/*
  1.员工信息emp表
	2.工资信息salarygrade表
	3. emp.salary >= salarygrade.losalary and emp.salary <= salarygrade.hisalary
*/
select 
	emp.ename,
	emp.salary,
	t2.grade 
from 
	emp ,
	salarygrade t2 
where 
	emp.salary >= t2.losalary
	and emp.salary <= t2.hisalary 
order by 
	emp.salary;

-- 4.查询员工姓名，工资，职务名称，职务描述，部门名称，部门位置，工资等级
/*
  1.员工信息emp表
	2.工资信息salarygrade表
	3. emp.salary >= salarygrade.losalary and emp.salary <= salarygrade.hisalary
*/
-- 隐式
select 
	emp.id ,
	emp.ename ,
	emp.salary,
	job.jname,
	job.description,
	dept.dname,
	dept.loc,
	t2.grade
from 
	emp,
	job ,
	dept,
	salarygrade t2 
where 
	emp.job_id = job.id 
	and emp.dept_id = dept.id  
	and emp.salary >= t2.losalary
	and emp.salary <= t2.hisalary  
order by 
	emp.id
;

-- 显式
select 
	emp.id,
	emp.ename,
	emp.salary,
	job.jname,
	job.description,
	dept.dname,
	dept.loc,
	t2.grade 
from 
	emp 
inner join job on emp.job_id = job.id 
inner join dept on  emp.dept_id = dept.id 
inner join salarygrade t2 on emp.salary between t2.losalary and t2.hisalary 
order by 
	emp.id
;


-- 5.查询出部门编号，部门名称，部门位置，部门人数
/*
	按照dept_id分组，count(*)统计
*/
-- 先分组
select 
	dept_id,
	count(*)
from 
	emp
group by
	dept_id
;


select 
	dept.id,
	dept.dname,
	dept.loc,
	t.count      -- 起的别名
from
	dept,
	(select dept_id,count(*) count from emp group by dept_id) t
where 
	dept.id = t.dept_id		
;       
	
```

### 8.事务

事务：一种机制，一种操作机制，包含一组数据库的操作命令

事务将所有命令作为一个整体向系统提交或撤销操作请求，即这一组数据库命令要么同时成功，要么同时失败

事务是一个不可分割的逻辑单元

```sql
-- 开启事务
start transaction
或者  begin

-- 提交事务
conmit

-- 回滚事务
rollback
```

事务四大特征

acid

```sql
原子性(atomicity):事务是不可分割的最小操作单位，同时成功，同时失败
一致性(consistency):事务完成后，必须使所有的数据都保持一致性
隔离性(isolation):多个事务之间，操作的可见性
持久性(durability):事务一旦提交或回滚，它对数据库中的数据的改变就是永久的
```

查询自动提交

select @@autocommit     1为自动提交

##  2. JDBC

#### 快速入门

java database connectivity 		java数据库连接技术

下载mysql架包，有了架包的支持，java可以通过jdbc访问mysql数据库

```java
package boy.learning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/*
* JDBC快速入门
* */
public class JDBCdemo {
    public static void main(String [] args) throws Exception{
        //1. 注册驱动
        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接
        String url = "jdbc:mysql://localhost:3306/db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = 		                                  DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql = "update stu set age = 100 where id = 1";

        //4.获取执行的对象 Statement
        Statement stmt = conn.createStatement();

        //5.执行sql
        int count = stmt.executeUpdate(sql);//受影响函数的返回值

        //6.处理结果
        System.out.println(count);

        //7.释放资源
        stmt.close();
        conn.close();
    }
}

//注册驱动 mysql 6 以上
com.mysql.cj.jdbc.Driver
```

#### DriverManager

驱动管理类

​	1.注册驱动

​	2.获取数据库连接

```java
DriverManager.getConnection(url,username,password);

String url = "jdbc:mysql://ip地址:3306/数据库名称?useSSL=false";//本地连接
```

连接本机

```java
jdbc:mysql:///数据库名称?useSSL=false
userSSL= false 禁用安全连接方式
```

#### Connection

数据库连接对象

​	1.获取执行的SQL对象

​	2.事务管理

```java
//普通执行sql对象
Statement    createStatement();
//预编译SQL对象，防止SQL注入
PrepareStatement   prepareStatement();

//JDBC事务管理
setAutoCommit(boolean autoCommit) //true自动提交
commit()		//提交
rollback()		//回滚
```

```java
try {
            //开启事务
            conn.setAutoCommit(false);
            
            //4.获取执行的对象 Statement
            Statement stmt = conn.createStatement();
            
            //5.执行sql
            int count1 = stmt.executeUpdate(sql1);//受影响函数的返回值
            int count2 = stmt.executeUpdate(sql2);
    
            //6.处理结果
            System.out.println(count1+" "+count2);
    
        } catch (Exception e) {
                //回滚事务
                conn.rollback();
                throw new RuntimeException(e);
        }
```



#### Statement

执行SQL语句

```java
int executeUpdate(sql);//执行DML DDL 语句，返回影响行数

Result excuteQuery(sql);//执行DQL 语句,ResultSet结果集对象
```

#### ResultSet

结果集对象：封装了DQL查询对象的结果

```java
ResultSet  stmt.excuteaQuery(sql);

boolean next() //将光标从当前位置向前移动一行，判断当前是否为有效行

xxx getxxx(参数)   //获取数据
int getInt(参数)
    
Stirng getString(参数)
    int 列编号，从1开始
    String  列名称
使用：
    while(rs.next()){
		rs.getxxx(参数)
    }
```

```java
//1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接 如果连接本机 并且端口吗默认3306
        String url = "jdbc:mysql:///db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql = "select * from stu";

        //4.获取对象
        Statement stat = conn.createStatement();

        //5.执行
        ResultSet rs = stat.executeQuery(sql);

        //6.处理完，遍历数据
        while(rs.next()){
//            int id = rs.getInt(1);
//            String name = rs.getString(2);
//            int age = rs.getInt(3);
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            System.out.println(id);
            System.out.println(name);
            System.out.println(age);

            System.out.println("----------------");
        }

        //7.释放资源
        stat.close();
        conn.close();
```

将数据放入集合中，新建pojo(plain ordinary java object)包，专门存放数据

```java
//1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接 如果连接本机 并且端口吗默认3306
        String url = "jdbc:mysql:///db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = DriverManager.getConnection(url,username,password);

        //定义sql语句
        String sql = "select * from stu";

        //4.获取对象
        Statement stat = conn.createStatement();

        //5.执行
        ResultSet rs = stat.executeQuery(sql);

        //创建集合
        ArrayList<Account> list = new ArrayList<Account>();

        //6.处理完，遍历数据
        while(rs.next()){
            Account account = new Account();

            int id = rs.getInt("id");
            String name = rs.getString("name");
            int age = rs.getInt("age");

            account.setId(id);
            account.setName(name);
            account.setAge(age);

            list.add(account);
        }

        System.out.println(list);

        //7.释放资源
        stat.close();
        conn.close();
    }
```

Account对象

```java
public class Account {
    private int id;
    private String name;
    private int age;
}
```

#### PreparedStatement

预编译并执行sql语句

sql注入

```java
String name = "asfjasklfjaslf";
String pwd = "' or '1'='1";

String sql = "select * from tb_user where username = '"+name+"'and password = '"+pwd+"'";

//输出字符串
select * from tb_user where username = 'asfjasklfjaslf'and password = '' or '1'='1'
//转义
select * from tb_user where username = 'asfjasklfjaslf'and password = '\'or\'1\'=\'1'
```

方法：

```java
1.获取PreStatement 对象
String sql = "select * from stu where name = ? and password = ?";
PreparedStatement pstmt = conn.prepareStatement(sql);
2.设置参数值
PreparedStatement 对象： setxxx(参数1，参数2); 给?赋值
3.执行sql
executeUpdate();
executeQuery(); //不需要传递参数
```

示例

```java
//1. 注册驱动
//        Class.forName("com.mysql.jdbc.Driver");

        //2. 获取连接 如果连接本机 并且端口吗默认3306
        String url = "jdbc:mysql:///db1?useSSL=false";//本地连接
        String username = "root";
        String password = "123456";
        Connection conn  = DriverManager.getConnection(url,username,password);

        int id = 1;
        int age = 100;

        //定义sql
        String newsql = "select * from stu where id =? and age=?";
        //获取PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(newsql);
        //设置?内容
        pstmt.setInt(1,id);
        pstmt.setInt(2,age);
        //查询
        ResultSet rs =  pstmt.executeQuery();
        while(rs.next()){
            System.out.println(rs.getInt("id"));
            System.out.println(rs.getInt("age"));
        }
    }
```

开启预编译

userServerPrepStmts = true

原理：获取PrepareStatement对象时，将sql语句发给sql服务器进行编译，检查

#### 数据库连接池 Druid

标准接口：DataSource

连接数据库之前需要启动数据库服务

```java
//1.导入jar包

        //2.定义配置文件

        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection connection = dataSource.getConnection();

        System.out.println(connection);

//       System.out.println(System.getProperty("user.dir"));
```



#### 例子

```java
//1.获取连接对象
            //1.导入jar包
            //2.定义配置文件
            //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

            //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

            //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "select * from tb_brand";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行语句
        ResultSet rs = pstmt.executeQuery();

        //6.存放结果
        List<Brand> brands = new ArrayList<Brand>();
        Brand brand = null;
        while(rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name") ;
            int ordered = rs.getInt("ordered") ;
            String description = rs.getString("description") ;
            Integer status = rs.getInt("status") ;
            //封装对象
            brand = new Brand(id,brandName,companyName,ordered,description,status);

            brands.add(brand);
        }

        System.out.println(brands);

        //7.关闭
        rs.close();
        pstmt.close();
        conn.close();
```

查询所有

```java
/**
     * 查询所有
     */
    public static void testSelectAll() throws Exception {
        //1.获取连接对象
            //1.导入jar包
            //2.定义配置文件
            //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

            //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

            //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "select * from tb_brand";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数

        //5.执行语句
        ResultSet rs = pstmt.executeQuery();

        //6.存放结果
        List<Brand> brands = new ArrayList<Brand>();
        Brand brand = null;
        while(rs.next()){
            //获取数据
            int id = rs.getInt("id");
            String brandName = rs.getString("brand_name");
            String companyName = rs.getString("company_name") ;
            int ordered = rs.getInt("ordered") ;
            String description = rs.getString("description") ;
            Integer status = rs.getInt("status") ;
            //封装对象
            brand = new Brand(id,brandName,companyName,ordered,description,status);

            brands.add(brand);
        }

        System.out.println(brands);

        //7.关闭
        rs.close();
        pstmt.close();
        conn.close();
    }
```

添加

```java
 /**
     * 添加
     */
    public static void testAdd() throws Exception {
        //接受数据
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered =  50;
        String description = "描述";
        int status = 0;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "insert into tb_brand(brand_name,company_name,ordered,description,status) value (?,?,?,?,?)";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }
```

修改

```java
/**
     * 修改
     */
    public static void testUpdate() throws Exception {
        //接受数据
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered =  1000;
        String description = "绕地球一圈";
        int status = 0;
        int id = 4;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "update tb_brand set brand_name = ?, company_name=?, ordered=?,description=?,status=? where id=?";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setString(1,brandName);
        pstmt.setString(2,companyName);
        pstmt.setInt(3,ordered);
        pstmt.setString(4,description);
        pstmt.setInt(5,status);
        pstmt.setInt(6,id);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }
```

删除

```java
/**
     * 删除
     */
    public static void testDelete() throws Exception {
        //接受数据

        int id = 4;


        //1.获取连接对象
        //1.导入jar包
        //2.定义配置文件
        //3.加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("jdbc-demo/src/druid.properties"));

        //4.获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);

        //5.获取数据库连接
        Connection conn = dataSource.getConnection();
        //2.sql语句
        String sql = "delete from tb_brand where id = ?";

        //3.PrepareStatement对象
        PreparedStatement pstmt = conn.prepareStatement(sql);

        //4.设置参数
        pstmt.setInt(1,id);



        //5.执行语句
        int count = pstmt.executeUpdate();

        //6.存放结果
        System.out.println(count > 0);


        //7.关闭
        pstmt.close();
        conn.close();
    }
```

## 3. Maven

1.标准化项目结构

2.标准化构建流程(编译，测试，打包，发布)

3.提供一套依赖管理机制

```
maven-project
	src(源代码和测试代码)
		main(源代码目录)
			java(源代码目录java文件目录)
			resources(源代码配置文件)
			webapp(web项目核心目录)
		test(测试代码目录)
			java
			resources
	pom.xml(核心配置文件)
```

#### 1.常用命令

```
compile:编译
clean: 清理
test:测试
package:打包
install:安装
```

compile -> test -> package -> install

执行后面的命令前面的命令自动执行

#### 2.配置maven环境

修改idea maven配置

#### 3.maven坐标

```
groudid：	定义当前项目组织名称
artifactid： maven项目名称
version： 当前项目版本号
```

#### 4.导入maven项目

导入pom.xml文档

#### 5.依赖管理

1.dependencies标签

2.dependency标签引入坐标

3.坐标信息 groudid artifactId version

4.刷新

直接搜

依赖范围：编译环境、测试环境、运行环境

```java
<scope>test</scope>
1.compile   默认，都有效
2.test     	只有测试有效
3.provided	编译 测试可以用，运行无效
4.runtime	测试和运行有效  jdbc
5.system	运行无效
```

## 4. MyBatis

优秀的持久层框架，简化JDBC开发

引入mybatis依赖，写xml文档

pom.xml

```xml

    <dependencies>
    <!--MyBatis依赖-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.5</version>
        </dependency>
<!--        mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>5.1.46</version>
        </dependency>
<!--        junt单元测试-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.2</version>
            <scope>test</scope>
        </dependency>

    </dependencies>
```

mybatis.xml

数据库连接信息去官网

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <environments default="development">
        <environment id="development">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
<!--                数据库连接信息-->
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql:///db1?useSSL=false"/>
                <property name="username" value="root"/>
                <property name="password" value="123456"/>
            </dataSource>
        </environment>
    </environments>
    <mappers>
<!--        映射文件-->
<!--        <mapper resource="boy/learning/mapper/UserMapper.xml"/>-->
<!--        Mapper代理方式，用包扫描方式-->
        <package name="boy.learning.mapper"/>
    </mappers>
</configuration>
```

mysql反射文件

UserMapper.xml

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace : 名称空间-->
<mapper namespace="test">
    <select id="selectAll" resultType="boy.learning.pojo.User">
        select * from stu
    </select>
</mapper>
```

#### 1.快速入门

1.定义pojo类

2.加载核心配置文件，获取SqlSessionFactory对象

3.获取SqlSession对象，执行sql

4.释放资源

```java
package boy.learning;


import boy.learning.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {
    public static void main(String[] args) throws IOException {
//        1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取SqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3.执行sql
        List<User>list =  sqlSession.selectList("test.selectAll");

        System.out.println(list);

        sqlSession.close();
    }
}

```

#### 2.idea 连接数据库

database->mysql

可以在idea写sql语句

#### 3.MyBatis代理开发

1.定理Mapper接口，跟mysql文件放在同一目录下，名称相同(放在同名的文件夹下，编译后会在一起)

2.设置sql映射文件的namespace名为mapper接口全限定名

3.在接口中定义方法，方法名为sql映射文件中sql语句的id，参数类型和方法名一致

4.编码

​				通过SqlSession的getMapper方法获取Mapper接口的代理对象

​				调用对应方法完成sql执行

代理开发

D:\download\java-2022-06\JavaData\MyBatis-demo

```java
package boy.learning;


import boy.learning.mapper.UserMapper;
import boy.learning.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;


/**
 * MyBatis 代理开发
 */
public class MyBatisDemo2 {

    public static void main(String[] args) throws IOException {
//        1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取SqlSession对象，用来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3.执行sql
        //List<User>list =  sqlSession.selectList("test.selectAll");

        //3.1获取UserMapper接口的代理对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User>user = userMapper.selectAll();


        System.out.println(user);

        sqlSession.close();
    }
}

```

#### 4.MyBatis核心配置文件

environments配置数据库连接环境，可以配置多个环境，通过default切换不同的数据库

别名:给pojo下的所有实体类起别名，默认为类名，部分大小写

```xml
<!--    别名-->
    <typeAliases>
        <package name="boy.learning.pojo"/>
    </typeAliases>
简化配置
resultType="boy.learning.pojo.User"
resultType="user"
```

#### 5.案例

mybatisx插件，alt+enter自动生成mapper中包含select语句的文件

BrandMapper

```java
package boy.learning.mapper;

import boy.learning.pojo.Brand;
import boy.learning.pojo.User;

import java.util.List;

public interface BrandMapper {

    //查询所有
    List<Brand> selectAll();


}

```

BrandMapper.xml

##### 主键映射解决字段不一致

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<!--namespace : 名称空间-->
<mapper namespace="boy.learning.mapper.BrandMapper">

<!--数据库表的名称和实体类的名称不一样，会出现问题
    *起别名，对不一样的列名起别名，每次都要定义别名
    *resultMap
        1.定义resultMap标签
        2.在select标签中用resultMap代替resutType
-->


    <!--    id唯一标识，type映射类型，
            id完成主键映射，result一般键的映射
                column列名
                property属性名
    -->
    <resultMap id="brandResultMap" type="brand">
        <!--      列名                  属性名-->
        <result column="brand_name" property="brandName"></result>
        <result column="company_name" property="companyName"></result>
    </resultMap>

    <select id="selectAll" resultMap="brandResultMap">
        select *
        from tb_brand
    </select>

<!--    引用     sql片段-->
<!--    <sql id="brand_column">-->
<!--        id, brand_name brandName,company_name companyName,ordered,description,status-->
<!--    </sql>-->

<!--    <select id="selectAll" resultType="boy.learning.pojo.Brand">-->
<!--        select <include refid="brand_column"/>-->
<!--        from tb_brand-->
<!--    </select>-->


</mapper>
```

test	 查询所有

```java
package boy.learning.test;


import boy.learning.mapper.BrandMapper;
import boy.learning.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisDemo {

    @Test
    public void testSelectAll() throws IOException {
        //1.加载MyBatis核心配置文件，获取SqlSessionFactory对象
        String resource = "mybatis-config.xml";
//        传入字符串，返回字节输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2.获取sqlsession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3.获取mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4.执行对应接口方法
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5.释放资源
        sqlSession.close();

    }

}

```

当实体类名称和数据库字段名称不同时，查询失败（详情看BrandMap.xml文档）

#### 6.多条件查询

```xml
* 条件查询
*  1.散装参数  @Param("")
*  2.对象参数  参数名和实体类属性名一致
*  3.map集合参数 参数名和map集合的键的值对应即可
```

BrandMapper接口

```java
List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName,@Param("brandName")String brandName);

    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);
```

BrandMapper.xml

```xml
<!--    条件查询-->
    <select id="selectByCondition" resultMap="brandResultMap">
        select *
        from tb_brand
        where status = #{status}
            and company_name like #{companyName}
            and brand_name like #{brandName}
    </select>
```

测试用例关键代码

```java
		int status = 1;
        String companyName = "华为";
        String brandName = "华为";
        companyName = "%"+companyName+"%";
        brandName = "%"+brandName+"%";

        //对象
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        //集合
        Map map = new HashMap();
        map.put("status",status);
        map.put("companyName",companyName);
        map.put("brandName",brandName);

      //4.执行对应接口方法

//        List<Brand> brands = brandMapper.selectByCondition(status,companyName,brandName);
//        List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
```

#### 7.动态sql 条件查询

where标签，防止第一个条件不存在

```xml
<!--    动态条件查询-->
    <select id="selectByCondition" resultMap="brandResultMap">
        select *
        from tb_brand
        where 1=1
        <if test="status != null">and status = #{status}</if>
        <if test="companyName != null and companyName != '' ">and company_name like #{companyName}</if>
        <if test="brandName != null and brandName != '' ">and brand_name like #{brandName}</if>
    </select>

```

#### 8.单条件动态查询

```xml
    <select id="selectByConditionSingle" resultMap="brandResultMap">
        select *
        from tb_brand
        <where>
            <choose>
                <when test="status!=null">status = #{status}</when>
                <when test="companyName!=null and company!=''">companyName like #{companyName}</when>
                <when test="brandName!=null and brandName!=''">brandName like #{brandName}</when>
            </choose>
        </where>
    </select>
```

#### 9.添加

添加成功后返回主键 useGenerateKeys  = true     keyProperty = id

```xml
    <insert id="add" useGeneratedKeys="true" keyProperty="id">
        insert into tb_brand(company_name,brand_name,ordered,description,status)
        values (#{companyName},#{brandName},#{ordered},#{description},#{status})
    </insert>
```

#### 10.修改

```xml
  
int update(Brand brand);

	<update id="update" >
        update tb_brand
        set company_name = #{companyName},
            brand_name = #{brandName},
            ordered = #{ordered},
            description = #{description},
            status = #{status}
        where id = #{id}
    </update>
```

#### 11.动态修改

set标签

```xml
    <update id="update" >
        update tb_brand
        <set>
            <if test="companyName!=null and companyName !=''">company_name = #{companyName},</if>
            <if test="brandName!=null and brandName !=''">brand_name = #{brandName},</if>
            <if test="ordered!=null">ordered = #{ordered},</if>
            <if test="description!=null and description !=''">description = #{description},</if>
            <if test="status!=null">status = #{status}</if>
        </set>
        where id = #{id}
    </update>
```

#### 12.删除

删除一个

```xml
   void deleteById(id);

	<delete id="deleteById">
        delete from tb_brand where id = #{id}
    </delete>
```

删除多个

```xml
    <delete id="deleteByIds">
        delete from tb_brand where id
             in
                 <foreach collection="array" item="id" separator="," open="(" close=")">
                        #{id}
                 </foreach>
                 ;
    </delete>
```

#### 13.参数传递

mybatis提供ParamNameResolve类进行参数封装

加上注解后，一个值有多个键

```java
单个参数
	pojo类型：直接使用，属性名和参数占位符名称一致
	map：直接使用，键名和参数占位符名称一致
	collection：封装为map集合
			("arg0",list集合)
			("collection",list集合)
	list
			("arg0",list集合)
			("collection",list集合)							("list",list集合)
	array
			("arg0",list集合)
			("array",list集合)
	其他
多个参数：封装为map集合，使用@param注解，替换map集合中默认的arg键名
	map.put("arg0",参数值1)
	map.put("param1",参数值1)
	map.put("arg1",参数值2)
	map.put("param2",参数值2)
```

都用注解来修改map集合中默认的键名

#### 14.注解完成增删改查

```sql
查询
@Select
添加
@Insert
修改
@Update
删除
@Delete
```

```sql
    @Select("select * from stu where id = #{id}")
    User selectbyId(int id);
```

## 5.HTTP

超文本传输协议

1.基于tcp协议，面向连接，安全

2.基于请求-响应模型，一次请求对应一次响应

3.是无状态协议，对于事务处理没有记忆能力，每次请求响应都是独立的

速度快，但不能共享数据

```
请求数据
1.请求行：请求数据第一行。GET表示请求方式 /请求资源路径 HTTP/1.1协议版本
2.请求头：第二行开始，key：value形式
3.请求体（POST特有）：POST请求的最后一部分，存放请求参数
```

get和post区别

1.get请求请求参数在请求行中，没有请求体，post有请求体

2.get请求限制大小

```
响应数据
1.响应行：HTTP/1.1协议版本  200 响应状态码  OK状态码描述
2.响应头：第二行开始，key：value
3.响应体：最后一部分，存放相应数据
```

## 6. Apache Tomcat

阿帕奇汤姆猫 

1.web服务器作用？

​	封装http协议操作，简化开发

​	将web项目部署到服务器中，对外提供网上浏览服务

2.Tomcat是一个轻量级的web服务器，支持servlet/jsp少量javaee规范，也称web服务器，servlet容器



启动后乱码：将java.util.logging.ConsoleHander.encoding改成JBK



关闭：直接× 强制关闭

​			bin/shutdown 正常关闭

​			按CTRL+ c  正常关闭



启动时问题：端口号冲突，关闭端口号

​						闪退，%JAVA_HOME%



部署项目：直接将项目放到webapps目录下

项目目录：

```
webapp
	img
	html
	WEB-INF
		web.xml
```

使用骨架创建...

#### 1. ide集成本地tomcat

右上角锤子右边 edit configuration添加tomcat

#### 2.tomcat的maven插件

1.pom.xml引入Tomcat插件

2.用maven中tomcat:run启动

```xml
  <build>
    <finalName>Tomcat-demo</finalName>
    <plugins>
<!--      tomcat插件-->
      <plugin>
        <groupId>org.apache.tomcat.maven</groupId>
        <artifactId>tomcat7-maven-plugin</artifactId>
        <version>2.2</version>
        <configuration>
          <port>8080</port>
          <path>/</path>
        </configuration>
      </plugin>
    </plugins>
  </build>
```

## 7.servlet

servlet是java提供的一门动态web资源开发技术

servlet是javaee的规范之一，是一个接口，自己实现，部署在web服务器

#### 1.快速入门

1.创建web项目，导入servlet依赖坐标

```xml
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>3.1.0</version>
      <scope>provided</scope>
    </dependency>

  </dependencies>
```

2.创建：定义一个类，实现servlet接口，并重写所有方法，并在service方法中输入一句话

3.配置：在类上使用@WebServlet注解，配置servlet的访问路径

4.访问：启动Tomcat，浏览器输入url访问该servlet

```java
@WebServlet("/demo1")
public class ServletDemo1 implements Servlet{

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
```

#### 2.访问流程

http://localhost:8080/web-demo/demo1

web-demo:web项目

demo1：写的那个类

servlet对象由Tomcat创建并执行service()方法

#### 3.生命周期

1.加载和实例化：第一次被访问时，由容器创建servlet对象

2.初始化：实例化之后，容器调用init()方法初始化对象

3.请求处理：每次请求时，都会调用service()方法对请求进行处理

4.服务终止：需要释放内存或容器关闭，调用destory()方法

```java
package boy.learning.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2",loadOnStartup = 1)
public class ServletDemo2 implements Servlet{

    /**
     * 初始化方法
     *  1.调用方法：默认情况下，第一次访问时，自动调用
     *      loadOnStartup:设置init调用时间,0正整数，启动时创建
     *  2.调用次数：只调用一次
     * @param servletConfig
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }


    /**
     * 提供服务
     * 1.调用：每次servlet被访问时，都会调用
     * 2.次数：多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("servlet hello world!");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁
     * 1.调用时机：被销毁时，
     *      内存释放或服务器关闭时调用
     * 2.调用次数：1次
     */
    @Override
    public void destroy() {
        System.out.println("destory...");
    }
}
```

#### 4.方法介绍

```java
getServletInfo()
返回一些信息
getServletConfig()
获取servletConfig对象
```

#### 5.体系结构(架构)

HttpServlet

```java
@Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //通过请求方式的不同，惊醒分别处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1.获取请求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            //get方式的处理逻辑
        }else if("POST".equals(method)){
            //post方式的处理逻辑
        }
    }
```

HttpServlet原理:

```java
public class MyServlet implements Servlet{
        @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //通过请求方式的不同，惊醒分别处理

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        //1.获取亲求方式
        String method = request.getMethod();
        //2.判断
        if("GET".equals(method)){
            //get方式的处理逻辑
            doGet(servletRequest,servletResponse);
        }else if("POST".equals(method)){
            //post方式的处理逻辑
            doPost(servletRequest,servletResponse);
        }
    }
        protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
    }

    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
    }
}

//直接继承自MyServlet
@WebServlet("/demo4")
public class ServletDemo4 extends MyServlet{
    @Override
    protected void doGet(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("get...");
    }

    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        System.out.println("post...");
    }
}
```

1.HttpServlet使用步骤

​		1.继承HttpServlet

​		2.重写doGet和doPost方法

2.HttpServlet原理

​		获取请求方式，并根据不同分请求方式，调用不同的doXXX方法

#### 6. urlPattern配置

servlet要想被访问，必须配置访问路径

配置规则

1.精确匹配：@WebServlet(urlPattern="/user/select")

2.目录匹配：@WebServlet(urlPattern="/user/*")

3.扩展名匹配：@WebServlet(urlPattern="*.do")   不加 /

4.任意匹配：@WebServlet(urlPattern="/*") 或 /

#### 7. xml配置servlet

web.xml

```xml
<!--  1.servlet全类名-->
<servlet>
  <servlet-name>demo5</servlet-name>
  <servlet-class>boy.learning.web.ServletDemo5</servlet-class>
</servlet>
<!--  2.servlet访问路径-->
<servlet-mapping>
  <servlet-name>demo5</servlet-name>
  <url-pattern>/demo5</url-pattern>
</servlet-mapping>
```

## 8.Request(请求)  Response(响应)

Request：获取请求数据

Response：设置响应数据

#### 1. Request继承体系

```java
ServletRequest   	--->   java提供的请求对象根接口
    ↑
HttpServletRequest	--->  java提供的对Http协议封装的请求对象接口
    ↑
RequestFacade  		--->  Tomcat定义的实现类
```

Tomcat需要解析请求数据，封装为request对象，并且创建request对象传递到service方法中

#### 2. Request获取请求数据

1.请求行

GET /request-demo/req1?username=zhangsan HTTP/1.1

```java
String getMethod()			获取请求方式：GET
String getContextPath()		获取虚拟目录(项目访问路径)：/request-demo
StringBuffer getRequestURL()获取URL(统一资源定位符)：http://localhost:8080/request-demo/req1
String getRequestURI()		获取URI(统一资源标识符)：/request-demo/req1
String getQueryString()		获取请求参数(GET方式)：username=zhangsan&password=123
```

测试：

```java
	//获取请求方式
        String method = req.getMethod();
        System.out.println(method);
        //获取项目访问路径
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        //获取url
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        //获取uri
        String uri = req.getRequestURI();
        System.out.println(uri);
        //获取请求参数
        String queryString = req.getQueryString();
        System.out.println(queryString);

执行结果：
GET
/Tomcat-demo
http://localhost:8080/Tomcat-demo/demo5
/Tomcat-demo/demo5
null
```

2.请求头

User-Agent:Mozilla/5.0Chrome/91.0.4472.106

```java
String getHeader(String name)：根据请求头名称，获取值
```

测试：

```java
       //获取请求头
        //获取浏览器版本
        String agent = req.getHeader("user-agent");
        System.out.println(agent);


Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/108.0.0.0 Safari/537.36 Edg/108.0.1462.54

```

3.请求体

username=zhangsan&password=123

```java
ServletInpoutStream getInputStream()	获取字节输入流
Buffered Reader getReader() 		获取字符输入流
```

测试：

通过表单提交到此目录下，然后通过post获取

```java
		//获取请求体
        //1.获取字符输入流
        BufferedReader br = req.getReader();
        String line = br.readLine();
        System.out.println(line);

username=zhangsan&password=123
```

#### 3. Request通用请求方式获取请求参数

Map		Map<String,String[]>

username	zhangsan

hobby			1，2

```java
Map<Strign,String[]> getParameterMap();	获取所有参数map集合
String[] getParameterValues(String name);	根据名称获取参数值（数组）
String getParameter(String name);	根据名称获取参数值（单个值）如果有多个，只获取一个
```

例子，获取参数的map集合

```java
 //get请求逻辑
        System.out.println("get...");

//1.获取所有参数的map集合
        Map<String,String[]> map = req.getParameterMap();
        for (String key : map.keySet()) {

            //username:zhangsan lisi
            System.out.print(key+":");

            //获取值
            String[] values = map.get(key);
            for (String value : values) {
                System.out.print(value+" ");
            }
            System.out.println();
        }
//2.获取参数值，数组
        String[] hobbies = req.getParameterValues("hobby");

        for (String hobby : hobbies) {
            System.out.print(hobby+" ");
        }
        System.out.println();

//3.根据key获取单个参数值
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
```

结果

```
get...
username:zhangsan 
password:123 

hobby:1 2 

1 2
zhangsan
123
```

#### 4. post乱码

post是以流的方式读入，

```java
POST.getReader();
req.setCharacterEncoding("UTF-8");
```

#### 5. get乱码

浏览器  汉字URL编码------>Tomcat   URL解码

原因：Tomcat默认解码用的iso-8859-1,   8以上变为utf-8

get获取参数的方式

```java
getQueryString();
```

Tomcat做法

```java
        //url编码
        String username = "张三";
        String encode = URLEncoder.encode(username, "utf-8");
        System.out.println(encode);

        //url解码
        String decode = URLDecoder.decode(username);
        System.out.println(decode);
        //Tomcat解码
        String decodeTomcat = URLDecoder.decode(encode, "ISO-8859-1");
        System.out.println(decodeTomcat);

%E5%BC%A0%E4%B8%89
张三
å¼ ä¸
```

解决：

```java
//url编码
String username = "张三";
String encode = URLEncoder.encode(username, "utf-8");
//Tomcat解码
String decodeTomcat = URLDecoder.decode(encode, "ISO-8859-1");
//3.转换为字节数组,编码
byte[] bytes = decodeTomcat.getBytes("ISO-8859-1");
//4.将字节数组转化为字符串，解码
String s = new String(bytes, "utf-8");
```

get解决

```java
//将获取到的中文先编码后解码为utf-8
username = new String(username.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
```

#### 6. Request请求转发

一种在服务器内部的资源跳转方式

```java
req.getRequestDispather("资源B路径").forward(req,resp);
```

从demo6跳转到demo7

```java
//请求转发
req.getRequestDispatcher("/demo7").forward(req,resp);
```

请求转发资源间共享数据

```java
void setAttribute(String name,Object o);	存储数据到request中
Object getAttribute(String name);	根据key，互殴去值
void removeAttribute(String name);	根据key，删除资源
```

```java
demo6
System.out.println("demo6...");
req.setAttribute("msg","hello");
//请求转发
req.getRequestDispatcher("/demo7").forward(req,resp);


demo7
System.out.println("demo7...");
System.out.println(req.getAttribute("msg"));


访问demo6之后输出
demo6...
demo7...
hello
```

特点：

浏览器地址栏的地址不发生变化

只能转发到当前服务器的内部资源

一次请求，可以在转发的资源见使用request共享数据

#### 1. Response

1.响应行：HTTP/1.1 200 OK

2.响应头：Content-Type：text/html

设置响应头键值对     

```java
void setHeader(String name,String value);
```

3.响应体：<html></html>

```java
PrintWriter getWriter();		获取字符输出流

ServletOutputStream getOutputStream();	获取字节输出流
```

#### 2. 重定向

一种资源跳转方式

```java
resp.setStatus(302);
resp.setHeaader("location","资源B的路径");

resp.sendRedirect("资源路径");
```

```java
 //重定向
//1.设置响应状态码
response.setStatus(302);
//2.设置响应头
response.setHeader("location","/Tomcat-demo/resp2");
//简化方式
response.sendRedirect("/Tomcat-demo/resp2");
```

特点：

1.浏览器地址发生变化

2.可以重定向到任意位置的资源（服务器内部、外部都可）

3.两次请求，不能在多个资源间使用request共享数据

#### 3. 路径问题

明确路径谁使用？

浏览器使用：需要加虚拟目录（项目访问路径）

服务器使用：不需要加虚拟目录

```java
//动态获取虚拟目录
String contextPath = request.getContextPath();
response.sendRedirect(contextPath+"/resp2");
```

#### 4. Response 响应字符数据

使用：

```java
1.通过Response对象获取字符输出流
PrintWriter writer = response.getWriter();
2.写数据
writer.write("你好");
3.中文乱码
//设置响应字符格式及字符集
response.setContentType("text/html;charset=utf-8");
```

测试：

```java
//设置响应字符格式及字符集
response.setContentType("text/html;charset=utf-8");
//获取字符输出流
PrintWriter writer = response.getWriter();

//content-Type
//response.setHeader("content-type","text/html");
    
writer.write("你好");
writer.write("<h1>世界</h1>");

//流不需要关闭
```

#### 5. Response响应字节数据

使用：

```java
1.通过Response对象获取字符输出流
ServletOutputStream outputStream = response.getOutputStream();
2.写数据
outputStream.write(字节数据);
```

测试：

```java

//1.读取文件
FileInputStream fis = new FileInputStream("F:\\photo\\genshin\\bg.jpg");

//2.通过Response对象获取字符输出流
ServletOutputStream os = response.getOutputStream();
//2.写数据,完成流的copy
byte[] buff = new byte[1024];
int len = 0;
while((len = fis.read(buff))!=-1){
   os.write(buff,0,len);
}

fis.close();
```

工具类

IOUtils

```xml
导入坐标
    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>2.6</version>
    </dependency>

使用
	IOUtils.copy(输入流，输出流)
```

## 案例 

Maven + MyBatis + Servlet + Request + Response

#### 1.登录

#### 2.注册

#### 3.问题

1.服务器如何识别前端页面传入的数据？

表单中的name属性，username=zhangsan

2.关于服务器报错500之类

首先是配置问题，先查看路径配置，

mybatis中对于mapper的映射文件中的路径配置

其次，找不到某个名称之类，先去数据库查看名称是否正确，或者加注解来解决

#### 4.SqlSessionFactory工具类抽取

```java
private static SqlSessionFactory sqlSessionFactory;

    static {
        //2.1获取SqlSessionFactory对象
        try {
            String  resorce = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resorce);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }
```

使用时直接用

```java
SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();
```

## 9. JSP

java server pages		 java服务端页面

一种动态的网页技术，既可以定义html cssjs灯静态，加可以定义java的动态内容

JSP = java + HTML

JSP本质上是一个servlet

JSP在被访问时，由JSP容器（Tomcat）将其转化为java文件（Servlet），在由JSP容器（Tomcat）将其编译，最终对外提供服务的其实就是这个字节码文件

1.导入JSP坐标

```xml
<!--JSP-->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.2</version>
      <scope>provided</scope>
    </dependency>
```

2.创建JSP文件

3.编写HTML标签和java代码

#### 2.JSP脚本

1.<%...%>：内容会直接放到_JjspService()方法中

2.<%=...%>：内容会放到out.print()中，作为out.print()的参数

3.<%!...%>：内容会放到_jspService()方法中，被类直接包含

缺点：

书写麻烦

阅读麻烦

复杂度高，依赖于各种环境

占内存和磁盘

调试困难

不利于团队协作

不淘汰你淘汰谁？？？

#### 3. EL表达式

Expression Language表达式语言

功能：获取数据

语法：${expression} 获取域中存储的key为expression的数据

request请求转发，request.setAttribute("brands",brands);

jsp中调用：${brands}



javaWeb四大域对象

1. page：当前页面

2. request：当前请求

3. session：当前会话

4. application：当前应用

   

#### 4. JSTL标签

jsp标准标签库 （JSP Standarded Tag library）使用标签取代代码

1.导入坐标

```xml
    <!--    jstl-->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
<!--standard-->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
```

2.引入这玩意在jsp文件中

```jsp
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```

3.测试

if标签

```jsp
<%--   c:if 逻辑判断 --%>
    <c:if test="true">
        <h1>true</h1>
    </c:if>
```

<c:forEach>标签

items：被遍历的容器

var：遍历产生的临时变量

varStatus：遍历状态的对象，status.count从1开始，因为id可能不连续

begin：开始数

end：结束数

step：步长

${brands.id}  将id变为Id，加get，变为getId()函数，是不是直接访问成员

```jsp
<c:forEach items="${brands}" var="brand" varStatue="status">
    ${status.count}
    ${brands.id}
</c:forEach>
```

## 10. MVC模式和三层架构

MVC是一种分层开发的模式

M：model，业务模块，处理业务

V：view，视图，界面显示

C：controller，控制器，处理请求，调用模型和视图

三层架构

表现层 web/controller		springMVC

业务逻辑层 service 			 spring

数据访问层 dao/mapper	MyBatis



数据访问层：对数据库的CRUD基本操作



业务逻辑层：对业务逻辑进行封装，组合数据访问层中基本功能。形成复杂的业务逻辑功能



表现层：接受请求，封装数据，调用业务逻辑层，响应数据

#### 案例

1.创建项目，创建新的模块

2.创建三层架构的结构，web文件夹，setting -> factes -> + ->web -> ok

3.实体类

4.数据库表 tb_brand

5.mybatis配置环境

​	config.xml

​	mapper接口

​	mapper.xml



查询：

![eda89cebde2e9788f61b2e43190fca5](javaWeb.assets/eda89cebde2e9788f61b2e43190fca5.png)

添加：

![c1bc65030a07d6616e649963c1788a2](javaWeb.assets/c1bc65030a07d6616e649963c1788a2.png)

修改-回显数据：

![2bc8182fe9c146baeb4dcc2bf8a58db](javaWeb.assets/2bc8182fe9c146baeb4dcc2bf8a58db.png)

修改-修改数据

![33becd37507bbdcfee21f9926396ba5](javaWeb.assets/33becd37507bbdcfee21f9926396ba5.png)





数据库中字段和实体类字段不一致导致不能查询出结果？

#### 主键映射

```xml
<resultMap id="brandResultMap" type="brand">
        <result column="brand_name" property="brandName"></result>
        <result column="company_name" property="companyName"></result>
    </resultMap>
```

```java
注解使用
@Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();
mapper.xml使用
<select id="selectAll" resultMap="brandResultMap">
        select *
        from tb_brand
</select>
```

#### 页面404：

路径不对，大小写出错

#### 乱码：

post请求设置utf-8	  request.setCharacterEncodeing("utf-8")

#### #{}和${}区别

**#{}** 是预编译处理，像传进来的数据会加个" "（#将传入的数据都当成一个字符串，会对自动传入的数据加一个双引号）

**${}** 就是字符串替换。直接替换掉占位符。$方式一般用于传入数据库对象，例如传入表名.

## 11. 会话跟踪技术

会话：用户打开浏览器，访问服务器资源，会话建立，知道有一方断开，会话结束，一次会话中包涵多次请求和响应。

会话跟踪：一种维护浏览器状态的方法，服务器需要识别多次请求是否来自同一浏览器，以便在同一次会话的多次请求间共享数据。

HTTP协议是无状态的，每次向服务器请求时，服务器都会将该请求视为新的请求，因此需要会话跟踪技术来实现会话内数据共享。

实现方式：

1.客户端会话跟踪技术：cookie

2.服务端会话跟踪技术：session

#### 1. Cookie基本使用

发送cookie：

1.创建Cookie对象，设置数组

```java
Cookie cookie = new Cookie("key","value");
```

2.发送Cookie到客户端，使用response对象

```java
response.addCookie(cookie);
```

获取cookie：

3.获取客户端的所有Cookie，使用request对象

```java
Cookie[] cookies = request.getCookies();
```

4.遍历数组，获取每一个Cookie对象：for

5.使用Cookie对象方法获取数据

```java
cookies.getName();
cookies.getValue();
```

筛选想要的数据

```java
Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if("username".equals(cookie.getName())){
                String value = cookie.getValue();

                System.out.println("username"+value);
                break;
            }
        }
```

#### 2.Cookie原理

Cookie的实现是基于Http协议

响应头：set-cookie

请求头：cookie

#### 3.Cookie使用细节

Cookie存活时间：

1.默认情况下，Cookie存储在浏览器内存中，当浏览器关闭后，内存释放，cookie被销毁。

2.设置存活时间

```java
setMaxAge(int seconds);  设置cookie存活时间
正数：写入浏览器所在的电脑硬盘，持久化存储，时间到自动删除
负数：默认值，cookie在当前浏览器内存中，浏览器关闭，cookie销毁
零：删除对应cookie
```

Cookie存储中文

不能直接存储中文

转码

```java
//存储中文
        String value = "张三";
        value = URLEncoder.encode(value,"utf-8");

        System.out.println("username="+value);

        
        //1.创建Cookie对象
        Cookie cookie = new Cookie("username",value);
```

解码

```java
//获取cookie

        Cookie[] cookies = req.getCookies();

        for (Cookie cookie : cookies) {
            if("username".equals(cookie.getName())){
                String value = cookie.getValue();
                value = URLDecoder.decode(value);
                
                System.out.println("username"+value);
                break;
            }
        }
```

#### 4.Session基本原理

服务端会话跟踪技术：将数据保存到服务端

javaEE提供HttpSession接口，来实现一次会话的多次请求间的数据共享功能

使用：

1.获取session对象

```java
HttpSession session = new requst.getSession();
```

2.session对象的功能

```java
void setAttrubute(String name,Object o);存储数据到session中
Object getAttribute(String name);  根据key，获取值
void removeAttribute(String name);  根据key，删除键值对
```

#### 5.Session原理&使用细节

session是基于cookie实现的

![6afbc138bf6368af9a3ed7e28bb75a6](javaWeb.assets/6afbc138bf6368af9a3ed7e28bb75a6.png)

使用细节：

1.session钝化、活化:
服务器重启，session中的数据是否存在？

钝化：服务器关闭后，Tomcat会自动将Session数据写入硬盘中

活化：再次重启服务器后，Tomcat会自动将文件中的数据加载到Session中

2.Sesson销毁：

默认情况下，无操作30分钟销毁

web.xml中配置，Tomcat中默认配置是30，分钟为单位

```xml
 <session-config>
    <session-timeout>30</session-timeout>
  </session-config>
```

调用Session对象的invalidate()方法来销毁

#### 6.小结

Cookie和Session都是来完成一次会话内多次请求间数据共享的

区别：
存储位置：Cookie将数据存在客户端，Session将数据存储在服务器

安全性：Cookie安全，Session不安全

数据大小：Cookie最大3KB，Session无大小限制

存储时间：Cookie可以长期存储，Session默认30分钟

服务器性能：Cookie不占服务器资源，Session占服务器资源

#### 案例

##### 用户登录

![ff18e753bb89c77c893768ee99c35c2](javaWeb.assets/ff18e753bb89c77c893768ee99c35c2.png)

##### 记住用户

![2ce16dd0e0755ed8b20ac44cf413200](javaWeb.assets/2ce16dd0e0755ed8b20ac44cf413200.png)

${cookie.key.value}   获取存储在cookie中key键的值

##### 用户注册

![8389748b80a542a62e0d260fe4ae6cc](javaWeb.assets/8389748b80a542a62e0d260fe4ae6cc.png)

##### 验证码

#### 1.页面中出现${}

加上  isELIgnored="false"

#### 2.not find class brand

未起别名，导致不认识该类

不认识该brand

```xml
BrandMapper.xml
    <resultMap id="brandResultMap" type="brand">
        <result column="brand_name" property="brandName"></result>
        <result column="company_name" property="companyName"></result>
    </resultMap>
```

解决方法：

```xml
1.在mybatis-config中起别名
    <typeAliases>
        <package name="boy.learning.pojo"/>
    </typeAliases>
原理：使用包扫描，将pojo包下的所有实体类都赋予一个首字母小写（小驼峰命名法）的别名，使用时直接调用别名即可。
2.写全，boy.learning.pojo.Brand
```

## 12. Filter

概念：Filter表示过滤器，javaweb三大组件之一

拦截请求资源

可以完成通用操作：权限控制，统一编码处理，敏感字符等

#### 1. 快速入门

1.定义类。实现Filter接口，重写所有方法

```java
package boy.learning.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {}

    @Override
    public void destroy() {}
}

```

2.配置Filter拦截资源的路径，类上定义WebFileter注释

```java
@WebFilter("/*")
```

3.doFilter方法中输出一句话，放行

```java
System.out.println("FilterDemo...");

        //放行

        filterChain.doFilter(servletRequest,servletResponse);
```

#### 2.流程：

放行前（对request进行处理） ->  访问资源 -> 放行后（对response进行处理）

访问完资源之后response才有数据

#### 3.Filter细节

拦截路径：

```
拦截具体资源：/index.jsp
目录拦截： /user/*
后缀名拦截：*.jsp
拦截所欲： /*
```

过滤器链：多个过滤器相连

执行顺序：xml未配置，根据类名决定先后顺序

#### 案例-登录验证

![](javaWeb.assets/a05f47a8f79ab572cf99eae7e19f604.png)

放行注册、登录页面，防止出现  “你让我注册呀！“   ”你不登陆怎么注册？“

```java
合理会员制
//判断访问路径是否和登录注册相关
        String[] urls = {"/login.jsp","/css/","/image/","/loginServlet","register.jsp","/registerServlet","/checkCodeServlet"};
        //获取当前访问路径
        String url = req.getRequestURI().toString();
//循环判断
        for (String u : urls) {
            if(url.contains(u)){
                //找到啦，放行
                chain.doFilter(request, response);
                //break;
                return;
            }
        }

要直接return
```

##### 如果return了，访问资源还会执行放行后的语句吗》

## 13.Listener

三大组件之一

监听器：监听application，session，request三个对象创建、销毁或修改删除

监听器分类：（八个）

####  使用：

1.定义类，实现ServletContextListener接口

2.加上webListener注释

## 14. AJAX

ajax（Asynchronous Javascript and  xml）：异步的javascript和xml

作用：

1.与服务器进行数据交换：通过ajax可以给服务器发送请求，并获取服务器响应的数据，使用ajax和服务请进行通信，就可以使用html+ajax替换jsp页面。

2.异步交互：可以在不重新加载整个页面的情况下，与服务器交互并更新部分网页的技术，如：联想搜索，用户名校验

#### 同步和异步

![039bce2bc1df6e35e07e7449ad0cda2](javaWeb.assets/039bce2bc1df6e35e07e7449ad0cda2.png)

异步，客户端不用等待服务端的处理

#### 1.快速入门

编写AjaxServlet，并使用response，输出字符

```js
   //1.创建核心对象xmlHttpRequest,用于和服务请交互数据
      var xmlhttp;
      if (window.XMLHttpRequest)
      {
        //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
      }
      else
      {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
      }

    //2.发送请求
      xmlhttp.open("GET","http://localhost:8080/ajax-demo/ajaxServlet");
      xmlhttp.send();


    //3.获取服务器响应数据
    xmlhttp.onreadystatechange=function()
    {
      if (xmlhttp.readyState==4 && xmlhttp.status==200)
      {
        alert(this.responseText);
      }
    }
```

#### 2.案例

需求：在完成用户注册时，当用户名输入框失去焦点时，校验用户名是否在数据库存在

![f5506e161040a0402b497ec2fcaff7e](javaWeb.assets/f5506e161040a0402b497ec2fcaff7e.png)

##### 流程：

1.前端向后端通过ajax发送请求，携带数据username

```js
      //2.发送请求
      xmlhttp.open("GET","http://localhost:8080/ajax-demo/selectUserServlet?username="+username);
      xmlhttp.send();
```

2.服务器端通过request接收数据，通过response返回数据

```java
//1.接受用户名
        request.getParameter("username");

        //2.调用service查询
        boolean falg = true;

        //3.返回响应标记
        response.getWriter().write(""+ falg);
```

3.返回的数据是xmlHttp.responseText  == true 

```js
//3.获取服务器响应数据
      xmlhttp.onreadystatechange=function()
      {
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
          //得到true
           alert("xmlHttp.responseText");
        }
      }
```

#### 1. Axios异步框架

CDN引用

```
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>

```

对原生的ajax进行封装，简化书写

1.引入axios的js文件

```
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
```

2.使用axios发送请求，并获取响应结果

```js
//get请求方式
axios({
        method:"get",
        url:"http://localhost:8080/ajax-demo/axiosServlet?username=zhangsan",
    }).then(function (resp){
        //回调函数
        alert(resp.data);
    })
  
//post请求方式
    axios({
        method:"post",
        url:"http://localhost:8080/ajax-demo/axiosServlet",
        data:"username=zhangsan"
    }).then(function (resp){
        //回调函数
        alert(resp.data);
    })
```

####  2. Axios请求方式别名

为所有支持的请求方法提供了别名

更简单

```js
    //别名get请求方式
    axios.get("http://localhost:8080/ajax-demo/axiosServlet?username=zhangsan").then(function (resp) {
        alert(resp.data)
    })

    //别名post请求方式
    axios.post("http://localhost:8080/ajax-demo/axiosServlet","username=zhangsan").then(function (resp) {
        alert(resp.data)
    })
```

## 15. JSON

概念：JavaScript Object Notation  。 即 JavaScript对象表示法

语法简单，层次结构鲜明，多用于数据载体，在网络中进行数据传输

#### 1.基础语法

定义：

```json
var 变量名 = {
    "key1":value1,
    "key2":value2,
    ...
};
示例
    var json = {
    "name":"zhangsan",
    "age":23,
    "addr":["北京","上海","西安"]
};
```

获取数据：

```json
变量名.key
json.name
```

value的数据类型：

数字（整数或浮点数）

字符串（双引号）

逻辑值（true或false）

数组（方括号）

对象（花括号）

null

#### 2. json数据和java对象转换

请求数据：json字符串转换为java对象	JSON.toJSONString(user);

响应数据：java对象转换为json字符串	JSON.parseObject("jsonStr", User.class);

导入坐标：

```xml
<!--    fastjson-->
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>2.0.21.graal</version>
    </dependency>
```

例子：

```java
//1.将java对象转为json
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        String jsonString = JSON.toJSONString(user);
        System.out.println(jsonString);


        //2.将json字符串转为java对象
        User u = JSON.parseObject("{\"id\":1,\"password\":\"123\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(u);

输出：
    {"id":1,"password":"123","username":"zhangsan"}
User{id=1, username='zhangsan', password='123'}
```

#### 案例

查询所有：

![c5e219cdcfeee96a589125e33fadefd](javaWeb.assets/c5e219cdcfeee96a589125e33fadefd.png)

.innerHTML   不是.innerText		！！！！

通过拼接字符串来动态修改表格

新增品牌：![eeeac79e96268c8211cffdb8a778fa3](javaWeb.assets/eeeac79e96268c8211cffdb8a778fa3.png)

```java
request.getParameter()不能接受json数据
专门读取文本字符
解决：用bufferedReader读入json，然后转化为java对象
//获取请求体数据
        request.setCharacterEncoding("UTF-8");
        BufferedReader br = request.getReader();
        String params = br.readLine();

        //将js字符转换为java对像
        Brand brand = JSON.parseObject(params, Brand.class);
        System.out.println(brand);
```

出现乱码：设置request编码	request.setCharacterEncoding("UTF-8");

## 16. Vue

Vue是一套前端框架，免除原生js中的DOM操作，简化书写

基于MVVM（Model-View-ViewModel）思想，实现数据的双向绑定，将编程的关注重点放在数据上

MVC：只能实现模型到视图的单向展示

#### 1.快速入门

1.新建html页面，引入vue.js文件

cdn方式引入：

```js
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
```

2.在js代码区域，创建Vue核心对象，进行数据绑定

```js
//1.创建核心对象
  new Vue({
    el:"#app",
    data(){
      return {
        username:""
      }
    }
    /*上面是简写
    data:function () {
      return {
        username:""
      }
    }*/
  })
```

3.编写视图

```html
<div id="app">
  <input v-model="username" >
<!--  插值表达式-->
  {{username}}
</div>
```

#### 2. Vue常用指令

```
v-bind:	为heml标签绑定属性值，如设置href css等
v-model: 在表单元素上创建双向绑定
v-on:	为html标签绑定事件
v-if=	条件判断
v-else=
v-else-if=
v-else=
v-show=	条件满足就展示内容（渲染不一样，v-show是隐藏）
v-for=	循环

```

v-bind：

```js
<a v-bind:href="url">点我</a>
省略：
<a :href="url">点我</a>

  new Vue({
    el:"#app",
    data(){
      return {
          username:"",
          url:"https://www.baidu.com"
      }
    }
  })
```

v-on：

```js

<div id="app">
    <input type="button" value="一个按钮" v-on:click="show()">
    <input type="button" value="一个按钮" @click="show()">
</div>

  //1.创建核心对象
  new Vue({
    el:"#app",
    methods:{
        show(){
            alert("我被点了")
        }
    }
  });
```

v-if=

```js
    <div v-if="count==1">div1</div>
    <div v-else-if="count==2">div2</div>
    <div v-else>div3</div>

    <input v-model="count" >
      //1.创建核心对象
  new Vue({
    el:"#app",
      data() {
          return{
              count:3
          }
      },
      methods:{
        show(){
            alert("我被点了")
        }
    }

  });
```

v-for=

```
<div id="app">
    <div v-for="(addr,i) in addrs">
        {{i+1}}--{{addr}}<br>
    </div>
</div>

data() {
          return{
              count:3,
              addrs:["北京","深圳","上海"]
          }
      },
```



#### 3. Vue生命周期

生命周期的八个阶段：每触发一个生命周期时间，会自动执行一个生命周期方法（钩子）

```
beforeCreate	创建前
created			创建后
beforeMount		载入前
mounted			挂载完成
beforeUpdate	更新前
updated			更新后
beforeDestroy	销毁前
destroyed		销毁后
```

![93b1660ff11823a3db910fe737e63d5](javaWeb.assets/93b1660ff11823a3db910fe737e63d5.png)

mouned：挂载完成，Vue初始化成功，html页面渲染成功

->发送异步请求，加载数据

```js
      mounted() {
        alert("加载完成")
      }
```

#### 案例（new-brand-demo）

对查询所有的改进

![786c1c6f11df9ac773420bdf6f90c59](javaWeb.assets/786c1c6f11df9ac773420bdf6f90c59.png)

新增品牌的改进

![b8a682378d197eb6155a7a4ee96b52b](javaWeb.assets/b8a682378d197eb6155a7a4ee96b52b.png)

## 17. Element

Element:饿了吗公司前端开发团队提供的一套基于Vue的网站组件库，用于快速构建网页

#### 1. 快速入门

!!!!!!!!    vue需要放到element-ui的js文件上方

1.引入Element的css、js文件和Vue.js

cdn引入：

```html
<!-- 引入样式 -->
<link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
<!-- 若要直接在html中使用，需要挂载vue的js文件。-->
<script src="https://cdn.jsdelivr.net/npm/vue/dist/vue.js"></script>
<!-- 引入组件库 -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
```

下载文件引入

```html
vue
<scription src="js/vue.js"></scription>
<scription src="element-ui/lib/index.js"></scription>
<link rel="stylesheet" href="element-ui/lib/theme-chalk/index.css">
```

2.创建Vue核心对象

```js
  //1.创建核心对象
  new Vue({
      el:"#app"
  });
```

3.官网复制Element组件代码

直接去复制

#### 2. 布局

有两种布局方式

1.Layout布局：通过基础的24分栏，迅速简便的创建布局



2.Container布局：有导航栏

我是cv工程师，，，

#### 3. 表格

#### 案例

vue-demo中的brand.html

## 18. 综合案例(brand-case)

功能列表：

1.查询所有
2.新增品牌

3.修改品牌

4.删除品牌

5.批量删除

6.分页查询

7.条件查询

#### 问题：

##### 1.添加后显示乱码？

```
使用request：
request.setCharacterEncoding("UTF-8");
使用response：
response.setContentType("text/json;charset=utf-8");
```

##### 2.500错误？

可能数据库相关，看配置和登录

##### 3.element-ui中代码不执行？

vue的data数据访问必须要添加this，我服了，为什么出现问题也不报错，反而是去执行别的代码....

##### 4.数据不显示，或者只有数据库和实体类命名不同的不显示？

加上resultMap，不然数据库不认识

#### Servlet优化

利用反射的思想，创建BaseServlet根据路径名称进行分发

将所有servelt的方法放在一个继承BaseServlet的类中

```java
//1.获取请求路径
String uri = req.getRequestURI(); //   /brand-case/brand/selectAll

//2.获取最后一段路径方法名
int index = uri.lastIndexOf('/');
String methodName = uri.substring(index+1); //   selectAll

//3.获取对象
//1.获取BrandServlet对象的字节码对象Class
//谁调用我（this所在的方法） 我（this）代表谁  BrandServlet!
Class<? extends BaseServlet> cls = this.getClass();

//2.获得method方法
Method method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);

//3.执行方法
method.invoke(this,req,resp);
```

#### 分页查询

参数1 开始索引 			开始索引  = （当前页面 - 1） * 每页显示条数

参数2 查询的条目数  	查询的条目数 = 每页显示条数

select * from tb_brand limit 0 , 5

前端传入当前页和每页条数，后端返回当前页的数据和总数据条数，封装成一个对象

service层进行数据转换

#### 条件查询

三个条件关系 and

三个条件不需要全部填写

需要分页

![54603243e462b5fed32d2b586f3aa4f](javaWeb.assets/54603243e462b5fed32d2b586f3aa4f.png)

单条件和多条件动态查询的区别

条件查询 + 分页

#### 问题

##### 1.查询数据失败，Undeclared variable

sql语句中数据要加#{}

#### 2. 查询数据不加status条件，自动有该条件

狗篮子，Integer 和 int

#### 3. 数据库删除后id不连续

# END 放在最后

终于学完了，学的越多越感到自己的菜哈哈哈哈哈哈....

虽然是看完了，但是还有很多问题，就算让自己再写一次，还是写不出来（我好笨hhhhhh），还是要时常复习呀

```
最后的案例还有未实现的功能，交给你了

1.实现单个品牌的数据回显和修改，还有删除

2.搜索表单中状态添加所有选项
```

