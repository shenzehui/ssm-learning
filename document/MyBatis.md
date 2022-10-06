## ⼀、MyBatis简介

### 1.1 框架概念

> 框架，就是软件的半成品，完成了软件开发过程中的通用操作，程序员只需很少或者不用进行加工就能够实 现特定的功能，从而简化开发人员在软件开发中的步骤，提高开发效率。


### 1.2 常用框架

- 
MVC框架：简化了Servlet的开发步骤

   - Struts
   - Struts2
   - `SpringMVC`
- 
持久层框架：完成数据库操作的框架

   - apache DBUtils
   - Hibernate
   - Spring JPA
   - `MyBatis`
   - EJB3.0
- 
胶水框架：`Spring`

- 
SSM Spring SpringMVC MyBatis

- 
SSH Spring Struts2 Hibernate


### 1.3 MyBatis介绍

> MyBatis是⼀个`半自动`的`ORM`框架

> ORM（Object Relational Mapping）对象关系映射，将Java中的⼀个对象与数据表中一行记录⼀⼀对应。

> ORM框架提供了实体类与数据表的映射关系，通过映射文件的配置，实现对象的持久化。


- MyBatis的前身是iBatis，iBatis是Apache软件基金会提供的⼀个开源项目
- 2010年iBatis迁移到Google code，正式更名为MyBatis
- 2013年迁移到Github托管
- MyBatis特点：

   - 支持自定义SQL、存储过程
   - 对原有的JDBC进行了封装，几乎消除了所有JDBC代码，让开发者只需关注SQL本身
   - 支持XML和注解配置方式自定完成ORM操作，实现结果映射

## ⼆、MyBatis框架部署

> 框架部署，就是将框架引入到我们的项目中


### 2.1 创建Maven项目

- 
Java工程

- 
Web工程


### 2.2 在项目中添加MyBatis依赖

- 
在pom.xml中添加依赖

   - 
mybatis

   - 
mysql driver


```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>5.1.47</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.mybatis/mybatis -->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.4.6</version>
</dependency>
```

### 2.3 创建MyBatis配置文件

- 创建自定义模板：选择resources----右键New----Edit File Templates

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011047.png#alt=image-20220726142425405)

- 
在resources中创建名为`mybatis-config.xml` 的文件

- 
在 `mybatis-config.xml`文件配置数据库连接信息


```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
 "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <!-- 在environments配置数据库连接信息 -->
    <!-- 在environments标签中可以定义多个environment标签，每个environment标签可以定义⼀套连接配置 -->
    <!-- default属性，⽤来指定使⽤哪个environment标签 -->
    <environments default="mysql">
        <environment id="mysql">
            <!--transactionManager标签⽤于配置数据库管理⽅式-->
            <transactionManager type="JDBC"></transactionManager>
            <!--dataSource标签就是⽤来配置数据库连接信息 -->
            <dataSource type="POOLED">
                <property name="driver" value="com.mysql.jdbc.Driver"/>
                <property name="url" value="jdbc:mysql://localhost:3306/db_2010_fmwy?
                                            characterEncoding=utf-8"/>
                <property name="username" value="root"/>
                <property name="password" value="admin123"/>
            </dataSource>
        </environment>
    </environments>
</configuration>
```

## 三、Mybatis框架使用

> 案例：学生信息的数据库操作


### 3.1 创建数据表
| tb_students |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011588.png#alt=image-20220726143755227) |


### 3.2 创建实体类
| Student.java |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011589.png#alt=image-20220726144139635) |


### 3.3 创建DAO接口，定义操作方法
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011590.png#alt=image-20220726145323338) |
| --- |
|  |


### 3.4 创建DAO接口的映射文件

- 在 `resources` 目录下，新建名为 `mappers` 文件夹
- 在 `mappers` 中新建名为 `StudentMapper.xml` 的映射文件（根据模板创建）
- 在映射文件中对DAO中定义的⽅法进行实现：

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.szh.dao.StudentDao">
    <!--使用insert,update,delete,select标签写sql-->
    <insert id="insertStudent" parameterType="student">
        insert into tb_students(stu_num, stu_name, stu_gender, stu_age)
        values (#{stuNum}, #{stuName}, #{stuGender}, #{stuAge})
    </insert>

    <delete id="deleteStudent">
        delete from tb_students where  stu_num = #{stuNum}
    </delete>
</mapper>
```

### 3.5 将映射文件添加到主配置文件
| mybatis-config.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011591.png#alt=image-20220726150732735) |


## 四、单元测试

### 4.1 添加单元测依赖

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
</dependency>
```

### 4.2 创建单元测试类
| 在被测试类名后alt+insert --- 选择Test |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011592.png#alt=image-20220726150914161) |


### 4.3 测试代码

```java
package com.szh.dao;

import com.szh.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @Author szh
 * @Date 2022/7/26 14:54
 * @PackageName:com.szh.dao
 * @ClassName: StudentDaoTest
 * @Description: TODO
 * @Version 1.0
 */
public class StudentDaoTest {

    @Test
    public void insertStudent() {
        InputStream inputStream = null;
        try {
            //加载mybatis配置文件
            inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            //会话工厂
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //会话（连接）
            SqlSession session = sqlSessionFactory.openSession();
            //通过会话回去Dao对象
            StudentDao studentDao = session.getMapper(StudentDao.class);
            //测试StudentDao中的方法
            int result = studentDao.insertStudent(new Student(null, "12", "撒贝宁", "男", 50));
            System.out.println("result = " + result);
            //手动提交
            session.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void deleteStudent() {
    }
}
```

## 五、MyBatis的CRUD操作

> 案例:学生信息的增删查改


### 5.1 添加操作

略

### 5.2 删除操作

> 根据学号删除⼀条学生信息


- 在StudentDAO中定义删除方法
| StudentDAO |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011593.png#alt=image-20220726151604214) |


- 在StudentMapper.xml中对接口方法进行"实现"
| StudentMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011594.png#alt=image-20220726151707667) |


- 测试：在StudentDAO的测试类中添加测试方法
| StudentDAOTest |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011595.png#alt=image-20220726184532691) |


### 5.3 修改操作

> 根据学生学号，修改其他字段信息


- 在StudentDAO接⼝中定义修改方法
| StudentDAO |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011596.png#alt=image-20220726185652489) |


- 在StudentMapper.xml中“实现”接口中定义的修改方法
| StudentMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011597.png#alt=image-20220726185739525) |


- 单元测试
| StudentDAOTest |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011599.png#alt=image-20220726185822603) |


### 5.4 查询操作-查询所有

- 在StudentDAO接口定义操作方法
| StudentDAO |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011600.png#alt=image-20220726190251726) |


- 在StudentMapper.xml中"实现"DAO中定义的方法
| StudentMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011601.png#alt=image-20220726190633428) |


- 单元测试
| StudentDAOTest |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011602.png#alt=image-20220726190802603) |


### 5.5 查询操作-查询一条记录

> 根据学号查询⼀个学生信息


- 在StudentDAO接口中定义方法
| StudentDAO |
| :--- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011603.png#alt=image-20220726191019557) |


- 在StudentDAOMapper.xml中配置StudentDAO接口的方法实现——SQL
| StudentDAOMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011604.png#alt=image-20220726191126600) |


- 单元测试
| StudentDAOTest |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011605.png#alt=image-20220726191155531) |


### 5.6 查询操作-多参数查询

> 分页查询（参数 start ， pageSize）


- 在StudentDAO中定义操作方法，如果方法有多个参数，使用`@Param` 注解声明参数的别名
| StudentDAO |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011606.png#alt=image-20220726192742479) |


- 在StudentMapper.xml配置sql时，使用 `#{别名}`获取到指定的参数
| StudentMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011607.png#alt=image-20220726192824844) |


`注意` 如果DAO操作⽅法没有通过@Param指定参数别名，在SQL中也可以通过 `arg0,arg1...`或者 `param1,param2,...`获取参数

### 5.7 查询操作-查询总记录数

- 在StudentDAO接口中定义操作方法
| StduentDao |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011608.png#alt=image-20220726191511757) |


- 在StudentMapper.xml配置sql，通过resultType指定当前操作的返回类型为int
| StudentDAOMapper.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011609.png#alt=image-20220726191555401) |


- 单元测试
| StudentDAOTest |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011610.png#alt=image-20220726191619412) |


### 5.8 添加操作回填生成的主键

- StudentMapper.xml的添加操作标签—— insert

```xml
<!--useGeneratedKeys设置添加操作是否需要回填生成的主键 keyProperty设置回填的主键值赋值到参数对象的哪个属性-->
<insert id="insertStudent" parameterType="student" useGeneratedKeys="true" keyProperty="stuId">
    insert into tb_students(stu_num, stu_name, stu_gender, stu_age)
    values (#{stuNum}, #{stuName}, #{stuGender}, #{stuAge})
</insert>
```

## 六、MyBatis工具类封装

- MyBatisUtil

```java
package com.szh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author szh
 * @Date 2022/7/26 19:36
 * @PackageName:com.szh.utils
 * @ClassName: MyBatisUtil
 * @Description: TODO
 * @Version 1.0
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static SqlSession getSqlSession() {
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession();
            local.set(sqlSession);
        }
        return sqlSession;
    }

    /*给无需commit的数据库操作提供*/
    public static <T extends Object>T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession();
        T dao = sqlSession.getMapper(c);
        return dao;
    }
}
```

## 七、事务管理

> SqlSession 对象

> - 
getMapper(DAO.class) : 获取Mapper（DAO接口的实例）

> - 
事务管理



### 7.1 手动提交事务

- `sqlSession.commit()`; 提交事务
- `sqlSession.rollback()`; 事务回滚

**测试类中进行事务管理**

```java
@Test
public void insertStudent() {
    SqlSession session = MyBatisUtil.getSqlSession();
    //1.当我们获取SqlSession对象时，就默认开启了事务
    try {
        //通过会话回去Dao对象
        StudentDao studentDao = session.getMapper(StudentDao.class);
        //测试StudentDao中的方法
        Student student = new Student(null, "122", "康辉", "男", 50);
        int result = studentDao.insertStudent(student);
        System.out.println("result = " + result);
        //主键回填
        System.out.println(student);
        //2.操作完成并成功后，需要手动提交
        session.commit();
    } catch (Exception e) {
        //3.当操作出现异常，调用rollback进行回滚
        session.rollback();
    }

}
```

**业务逻辑层手动事务管理**

```java
public class StudentServiceImpl implements StudentService {
    public boolean addStudent(Student student) {
        boolean b = false;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        try{
            StudentDAO studentDAO = sqlSession.getMapper(StudentDAO.class);
            int i = studentDAO.insertStudent(student);
            b = i>0;
            sqlSession.commit();
        }catch (Exception e){
            sqlSession.rollback();
        }
        return b;
    }
}
```

### 7.2 自动提交事务

> 通过SqlSessionFactory调用openSession方法获取SqlSession对象时，可以通过参数设置事务是否自动提交：

> - 
如果参数设置为true，表示自动提交事务： factory.openSession(true);

> - 
如果参数设置为false，或者不设置参数，表示手动提交：

factory.openSession();/factory.openSession(false);



**MyBatisUtil优化**

```java
package com.szh.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author szh
 * @Date 2022/7/26 19:36
 * @PackageName:com.szh.utils
 * @ClassName: MyBatisUtil
 * @Description: TODO
 * @Version 1.0
 */
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    /**
     * 
     * @param isAutoCommit 是否自动事务提交
     * @return
     */
    public static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession(isAutoCommit);  //设置事务是否自动提交
            local.set(sqlSession);
        }
        return sqlSession;
    }

    //手动事务管理
    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    //自动事务提交
    public static <T extends Object>T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        T dao = sqlSession.getMapper(c);
        return dao;
    }
}
```

**测试操作**

```java
@Test
public void testDeleteStudent() {
    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);
    int i = studentDao.deleteStudent("12");
    System.out.println(i);
}
```

**业务逻辑层自动事务管理**

```java
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO = MyBatisUtil.getMapper(StudentDAO.class);
    public boolean addStudent(Student student) {
        int i = studentDAO.insertStudent(student);
        boolean b = i>0;
        return b;
    }
}
```

## 八、MyBatis主配置文件

> mybatis-config.xml 是MyBatis框架的主配置文件，只要用于配置MyBatis数据源及属性信息


### 8.1 properties标签

> 用于设置键值对，或者加载属性文件


- 在resources目录下创建`jdbc.properties` 文件，配置键值对如下：

```properties
mysql_driver=com.mysql.cj.jdbc.Driver
mysql_url=jdbc:mysql://localhost:3306/jdbc?characterEncoding=utf-8&useUnicode=true
mysql_username=root
mysql_password=240518.a
```

- 在`mybatis-config.xml`中通过 properties 标签引用`jdbc.properties`文件;引入之后，在配置environment 时可以直接使用jdbc.properties的key获取对应的value
| mybatis-config.xml |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011611.png#alt=image-20220726205648600) |


### 8.2 settings标签

```xml
<!--设置mybatis的属性-->
<settings>
    <!-- 启动⼆级缓存-->
    <setting name="cacheEnabled" value="true"/>
    <!-- 启动延迟加载 -->
    <setting name="lazyLoadingEnabled" value="true"/>
</settings>
```

### 8.3 typeAliases标签

```xml
<!--typeAliases标签用于给实体类取别名，在映射文件中可以直接使用别名来替代实体类的全限定名-->
<typeAliases>
    <typeAlias type="com.szh.pojo.Student" alias="Student"></typeAlias>
    <typeAlias type="com.szh.pojo.Book" alias="Book"></typeAlias>
</typeAliases
```

### 8.4 plugins标签

```xml
<!--plugins标签，用于配置MyBatis插件（分页插件）-->
<plugins>
    <plugin interceptor=""></plugin>
</plugins>
```

### 8.5 environments标签

```xml
<!-- 在environments配置数据库连接信息 -->
<!-- 在environments标签中可以定义多个environment标签，每个environment标签可以定义⼀套连接配置 -->
<!-- default属性，用来指定使用哪个environment标签 -->
<environments default="mysql">
    <environment id="mysql">
        <!--transactionManager标签用于配置数据库管理方式
            type="JDBC" 可以进⾏事务的提交和回滚操作
            type="MANAGED" 依赖容器完成事务管理，本身不进行事务的提交和回滚操作 -->
        <transactionManager type="JDBC"/>
        <!--dataSource标签就是用来配置数据库连接信息  POOLED|UNPOOLED-->
        <dataSource type="POOLED">
            <property name="driver" value="${mysql_driver}"/>
            <property name="url" value="${mysql_url}"/>
            <property name="username" value="${mysql_username}"/>
            <property name="password" value="${mysql_password}"/>
        </dataSource>
    </environment>
</environments>
```

### 8.6 mappers标签

> 加载映射配置（映射文件、DAO注解）


```xml
<!--mappers标签用于载入映射文件-->
<mappers>
    <mapper resource="mappers/StudentDao.xml"/>
</mappers>
```

## 九、映射文件

### 9.1 MyBatis Mapper初始化

> XML文件解析：读取xml文件中的标签配置封装到Java对象中


![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011612.png#alt=%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio%20%2862%29)

### 9.2 mapper根标签

> mapper文件相当于DAO接口的'实现类'，namespace属性要指定实现 DAO接口的全限定名


### 9.3 insert标签

> 声明添加操作（sql: insert ...）

> **常用属性**

> id属性，绑定对应DAO接口中的方法

> parameterType属性，用以指定接口中对应方法的参数类型（可省略）

> useGeneratedKeys属性， 设置添加操作是否需要回填生成的主键

> keyProperty属性，指定回填的id设置到参数对象中的哪个属性

> timeout属性，设置此操作的超时时间，如果不设置则⼀直等待


**主键回填**

**方式一：**

```xml
<!--useGeneratedKeys设置添加操作是否需要回填生成的主键 keyProperty设置回填的主键值赋值到参数对象的哪个属性-->
<insert id="insertStudent" parameterType="student" useGeneratedKeys="true" keyProperty="stuId">
    insert into tb_students(stu_num, stu_name, stu_gender, stu_age)
    values (#{stuNum}, #{stuName}, #{stuGender}, #{stuAge})
</insert>
```

**方式二：**

```xml
<insert id="insertStudent" parameterType="student" useGeneratedKeys="true" keyProperty="stuId" timeout="3000">
    <selectKey keyProperty="stuId" resultType="java.lang.Integer">  resultType回填值的类型
        select last_insert_id()
    </selectKey>
    insert into tb_students(stu_num, stu_name, stu_gender, stu_age)
    values (#{stuNum}, #{stuName}, #{stuGender}, #{stuAge})
</insert>
```

### 9.4 delete标签

> 声明删除操作


### 9.5 update标签

> 声明修改操作


### 9.6 select标签

> 声明查询操作

> - 
id属性， 指定绑定方法的方法名

> - 
parameterType属性，设置参数类型

> - 
resultType属性，指定当前sql返回数据封装的对象类型（实体类）

> - 
resultMap属性，指定从数据表到实体类的字段和属性的对应关系

> - 
useCache属性，指定此查询操作是否需要缓存

> - 
timeout属性，设置超时时间



### 9.7 resultMap标签

```xml
<!-- resultMap标签用于定义实体类与数据表的映射关系（ORM） -->
<resultMap id="studentMap" type="Student">
    <id column="sid" property="stuId"/>
    <result column="stu_num" property="stuNum"/>
    <result column="stu_name" property="stuName"/>
    <result column="stu_gender" property="stuGender"/>
    <result column="stu_age" property="stuAge"/>
</resultMap>
```

### 9.8 cache标签

> 设置当前DAO进行数据库操作时的缓存属性设置


```xml
<cache type="" size="" readOnly="false"/>
```

### 9.9 sql和include

> SQL片段


```xml
<sql id="wanglaoji">sid , stu_num , stu_name , stu_gender , stu_age</sql>
<select id="listStudents" resultMap="studentMap">
    select <include refid="wanglaoji"/> from tb_students
</select>
```

## 十、分页插件

> 分页插件是⼀个独⽴于MyBatis框架之外的第三方插件;


### 10.1 添加分页插件的依赖

> PageHelper


```xml
<!--pagehelper分页插件-->
<dependency>
    <groupId>com.github.pagehelper</groupId>
    <artifactId>pagehelper</artifactId>
    <version>5.1.10</version>
</dependency>
```

### 10.2 配置插件

> 在mybatis的主配置文件 `mybatis-config.xml`中通过 `plugins` 标签进行配置


```xml
<!--plugins标签，用于配置MyBatis插件（分页插件）-->
<plugins>
    <plugin interceptor="com.github.pagehelper.PageInterceptor"></plugin>
</plugins>
```

### 10.3 分页实例

> 对学生信息进行分页查询


```java
@Test
public void listStudentByPagePro(){
    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);  //sqlSession
    PageHelper.startPage(2,1);     
    List<Student> students = studentDao.listStudent();
    PageInfo<Student> pageInfo = new PageInfo<Student>(students);
    //PageInfo中就包含了数据及分页信息
    List<Student> list = pageInfo.getList();
    for (Student student : list) {
        System.out.println(student);
    }
}
```

**带条件分页**

```java
@Test
public void listStudentByPagePro(){
    StudentDao studentDao = MyBatisUtil.getMapper(StudentDao.class);  //sqlSession
    PageHelper.startPage(1,1);
    List<Student> students = studentDao.listStudentByGender("女");
    PageInfo<Student> pageInfo = new PageInfo<Student>(students);
    //PageInfo中就包含了数据及分页信息
    List<Student> list = pageInfo.getList();
    for (Student student : list) {
        System.out.println(student);
    }
}
```

## 十一、关联映射

### 11.1 实体关系

> 实体——数据实体，实体关系指的就是数据与数据之间的关系

> 例如：用户和角色、房屋和楼栋、订单和商品


实体关系分为以下四种：

**⼀对⼀关联**

实例：人和身份证、学生和学生证、用户基本信息和详情

数据表关系：

- 主键关联（用户表主键 和详情主键相同时，表示是匹配的数据）

用户基本信息表（5个字段）   															用户详情表（20+）

`用户ID`，账号，密码，姓名，最后登录时间 					  	`详情ID`，......

1              zhangsan   shangsan 	张三  	2002:2:27                   1          	13838384388

2           	lisi            lisi      李四   ....														3				13738214633

3              wangwu	wangwu	王五 ..... 											  2             18257292958

用户登录：根据用户名查询用户信息，当用户表中数据量很大且字段很多时会严重影响查询的速度

- 唯一外键关联

用户基本信息表（5个字段）   															用户详情表（20+）

`用户ID`，账号，密码，姓名，最后登录时间 					  	 详情ID，...... 							 	`uid(外键)`

1              zhangsan   shangsan 	张三  	2002:2:27                   1          	13838384388			2

2           	lisi            lisi      李四   ....														3				13738214633			3

3              wangwu	wangwu	王五 ..... 											  2             18257292958			1

**一对多关联、多对一关联**

实例：

- 
一对多： 班级和学生 、 类别和商品、楼栋和房屋

- 
多对一：学生和班级 、 商品和类别


数据表关系：

- 在多的一端添加外键和⼀的⼀段进行关联

**多对多关联**

实例：用户和角色、角色和权限、房屋和业主、学生和社团、订单和商品

数据表关系：建立第三张关系表添加两个外键分别与两张表主键进行关联

用户(user_id) 		用户角色表(uid,rid)	 	角色(role_id)

### 11.2 创建项目，部署MyBatis框架

- 创建web项目（maven）

```xml
<!--添加web依赖-->
<dependency>
    <groupId>javax.servlet.jsp</groupId>
    <artifactId>jsp-api</artifactId>
    <version>2.2</version>
</dependency>
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.1.0</version>
</dependency>
```

- 部署MyBatis框架

   - 添加依赖

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.1</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>
```

- 
配置文件

- 
帮助类


```java
public class MyBatisUtil {

    private static SqlSessionFactory sqlSessionFactory;

    private static final ThreadLocal<SqlSession> local = new ThreadLocal<SqlSession>();
    
    static {
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    private static SqlSession getSqlSession(boolean isAutoCommit) {
        SqlSession sqlSession = local.get();
        if (sqlSession == null){
            sqlSession = sqlSessionFactory.openSession(isAutoCommit);  
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static SqlSession getSqlSession(){
        return getSqlSession(false);
    }

    public static <T extends Object>T getMapper(Class<T> c){
        SqlSession sqlSession = getSqlSession(true);
        T dao = sqlSession.getMapper(c);
        return dao;
    }
}
```

### 11.3 一对一关联

> 实例：用户---详情


##### 11.3.1 创建数据表

```sql
-- 用户信息表
create table users(
	user_id int primary key auto_increment,
    user_name varchar(20) not null unique,
    user_pwd varchar(20) not null,
    user_realname varchar(20) not null,
    user_img varchar(100) not null
);
-- 用户详情表
create table details(
	detail_id int primary key auto_increment,
    user_addr varchar(50) not null,
    user_tel char(11) not null,
    user_desc varchar(200),
    user_id int not null unique
    -- constraint FK_USER foreign key(uid) references users(user_id) 物理关联 
)
```

##### 11.3.2 创建实体类

**User**

```java
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;
}
```

**Detail**

```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Detail {
    private int detailId;
    private String userAddr;
    private String userTel;
    private String userDesc;
    private int userId;
}
```

##### 11.3.3 添加操作（事务）
| 测试代码 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011613.png#alt=image-20220727141913627) |


##### 11.3.4 一对一关联查询

> 在查询用户的同时关联查询出与之对应的详情


**实体**

| User | Detail |
| --- | --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011614.png#alt=) | ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011615.png#alt=image-20220727142040010) |


**映射文件**

| 连接查询 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011616.png#alt=image-20220727144148520) |

| 子查询 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011617.png#alt=image-20220727144221411) |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011618.png#alt=image-20220727144333107) |


### 11.4 一对多关联

> 案例：班级(1)—学生(n)


##### 11.4.1 创建数据表

```sql
-- 创建班级信息表
create table classes(
	cid int primary key auto_increment,
    cname varchar(30) not null unique,
    cdesc varchar(100)
);

-- 创建学生信息表
create table students(
	sid char(5) primary key,
    sname varchar(20) not null,
    sage int not null,
    scid int not null 
);
```

##### 11.4.2 创建实体类
| Clazz | Student |
| --- | --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011619.png#alt=image-20220727163742071) | ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011620.png#alt=image-20220727163802509) |


##### 11.4.3 关联查询

> 当查询⼀个班级的时候， 要关联查询出这个班级下的所有学生


**连接查询**

| 连接查询的映射配置 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011621.png#alt=image-20220727165612814) |


**子查询**

| 子查询的映射配置 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011622.png#alt=image-20220727170204906) |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011623.png#alt=image-20220727170152276) |


### 11.5 多对一关联

> 实例：学生(n)—班级(1)

> 当查询⼀个学生的时候，关联查询这个学生所在的班级信息


##### 11.5.1 创建实体类
| Student | Clazz |
| --- | --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011624.png#alt=image-20220727170410196) | ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011625.png#alt=image-20220727170429915) |


##### 11.5.2 关联查询

**连接查询**

| 连接查询映射配置 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011626.png#alt=image-20220727195419046) |


**子查询**

| 子查询映射配置 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011627.png#alt=image-20220727194949646) |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011628.png#alt=image-20220727195018721) |


### 11.6 多对多关联

> 案例：学生（m）—课程（n）


##### 11.6.1 创建数据表

```sql
-- 学生信息表（如上）
-- 课程信息
CREATE TABLE course(
	course_id int PRIMARY KEY auto_increment,
	course_name VARCHAR(50) not NULL
);
-- 选课信息表/成绩表（学号、课程号、成绩）
CREATE TABLE grades(
	sid char(5) not NULL,
	cid int not NULL,
	score int not NULL
);
```

##### 11.6.2 关联查询

> 查询学生时，同时查询学生选择的课程

| Student | Course |
| --- | --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011629.png#alt=image-20220727200447434) | ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011630.png#alt=image-20220727200503234) |


> 根据课程编号查询课程时，同时查询选择了这门课程的学生

| Student | Course |
| --- | --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011631.png#alt=image-20220727200629313) | ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011632.png#alt=image-20220727200613016) |

| 连接查询映射配置 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011633.png#alt=image-20220727202812324) |

| 子查询 |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011634.png#alt=image-20220727202832460) |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011635.png#alt=image-20220727202911084) |


## 十二、动态SQL

> 交友网：珍爱网、百合网 筛选心仪对象 性别 年龄 城市 身高

> 电商：淘宝、京东 筛选商品 羽毛球拍 品牌 价格


李四 		性别 	女		select * from members where gender='⼥'

王五 		性别 	女		年龄 18-23 		select * from members where gender='女' and age >=18 and age <=23

张三 		年龄 	城市 		select * from members where age >=18 and age <=23 and city=""

> 用户的筛选条件不同，我们完成筛选执行的SQL也不一样；我们可以通过穷举来一一的完成不同条件的筛 选，但是这种实现思路过于繁琐和复杂，MyBatis就提供了动态SQL的配置⽅式来实现多条件查询。


### 12.1 什么是动态SQL？

> 根据查询条件动态完成SQL的拼接


### 12.2 动态SQL使用案例

> 案例：心仪对象搜索


##### 12.2.1 创建数据表

```sql
create table memebers(
    member_id int primary key auto_increment,
    member_nick varchar(20) not null unique,
    member_gender char(2) not null,
    member_age int not null,
    member_city varchar(30) not null
);
```

##### 12.2.2 创建实体类

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member {
    private int memberId;
    private String memberNick;
    private String memberGender;
    private int memberAge;
    private String memberCity;
}
```

##### 12.2.3 创建DAO接口

> 在DAO接口中定义⼀个多条件查询的方法


```java
public interface MemberDao {

    //在多条件查询中，如果查询条件不确定，可以直接使用HashMap作为参数
    //优点：无需单独定义传递查询条件的类
    //缺点：当向Map中存放参数时，key必须与动态sql保持一致（）
	//List<Member> queryMemberBy(HashMap<String,Object> params);


    //也可以定义专门用于存放查询条件的实体类存放参数
    //优点：设置参数时无需关注属性名
    //缺点：需要单独定义一个类来封装参数
    List<Member> queryMemberBy(MemberSearchCondition params);
}
```

### 12.3 if

```xml
<resultMap id="MemberMap" type="member">
    <id column="member_id" property="memberId"/>
    <result column="member_nick" property="memberNick"/>
    <result column="member_gender" property="memberGender"/>
    <result column="member_age" property="memberAge"/>
    <result column="member_city" property="memberCity"/>
</resultMap>
<select id="queryMemberBy" resultMap="MemberMap">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    where 1=1
    <if test="gender != null"> <!--这里的gender  就是参数对象的属性或者Map的key-->
        and member_gender = #{gender}
    </if>
    <if test="minAge != null">
        and member_age &gt;= #{minAge} <!--&gt; -->
    </if>
    <if test="maxAge != null">
        and member_age &lt;= #{maxAge}
    </if>
    <if test="city != null">
        and member_city = #{city}
    </if>
</select>
```

**测试**

```java
public class MemberDaoTest {

    @Test
    public void queryMemberBy() {
        HashMap<String,Object> params = new HashMap<>();
        params.put("gender","女");
        params.put("minAge",18);
        params.put("maxAge",25);
        params.put("city","杭州");

        //---------------------------------------------------------------------------
        MemberSearchCondition params2 = new MemberSearchCondition();
        params2.setGender("女");
        params2.setMinAge(20);
//        params2.setMaxAge(25);
//        params2.setCity("杭州");

        //===========================================================================

        MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
        List<Member> members = memberDao.queryMemberBy(params2);
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
```

### 12.4 where

```xml
<resultMap id="MemberMap" type="member">
    <id column="member_id" property="memberId"/>
    <result column="member_nick" property="memberNick"/>
    <result column="member_gender" property="memberGender"/>
    <result column="member_age" property="memberAge"/>
    <result column="member_city" property="memberCity"/>
</resultMap>
<select id="queryMemberBy" resultMap="MemberMap">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    <where>
        <if test="gender != null"> <!--这里的gender  就是参数对象的属性或者Map的key-->
            and member_gender = #{gender}
        </if>
        <if test="minAge != null">
            and member_age &gt;= #{minAge} <!--&gt; -->
        </if>
        <if test="maxAge != null">
            and member_age &lt;= #{maxAge}
        </if>
        <if test="city != null">
            and member_city = #{city}
        </if>
    </where>
</select>
```

### 12.5 trim

```xml
<select id="queryMemberBy" resultMap="MemberMap">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    <trim prefix="where" prefixOverrides="and | or" suffix="order by member_age">			 <!--prefixOverrides="and | or" 语句开头若有and或者or 则会被去除  suffix后缀 prefix前缀 -->
        <if test="gender != null"> <!--这里的gender  就是参数对象的属性或者Map的key-->
            and member_gender = #{gender}
        </if>
        <if test="minAge != null">
            and member_age &gt;= #{minAge} <!--&gt; -->
        </if>
        <if test="maxAge != null">
            and member_age &lt;= #{maxAge}
        </if>
        <if test="city != null">
            and member_city = #{city}
        </if>
    </trim>
</select>
```

### 12.6 foreach

```java
public interface MemberDao {
    List<Member> queryMemberByCity(List<String> cities);
}
```

```xml
<select id="queryMemberByCity" resultMap="MemberMap">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    where member_city in
    <foreach collection="list" item="cityName" separator="," open="(" close=")">
        #{cityName}
    </foreach>
</select>
```

**测试**

```java
@Test
public void queryMemberByCity() {
    List<String> cities = new ArrayList<>();
    cities.add("杭州");
    cities.add("深圳");
    MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
    List<Member> members = memberDao.queryMemberByCity(cities);
    for (Member member : members) {
        System.out.println(member);
    }
}
```

## 十三、模糊查询

> 案例：根据昵称查询会员信息（模糊匹配 like）


### 13.1 模糊查询实现

##### 13.1.1 DAO

```java
public interface MemberDao {
    //根据昵称查询用户信息——模糊查询
    //默认查询需要使用${}取值，与sql进行拼接
    // 在使用${}时，即使只有一个参数也需要使用@Param注解声明参数的key(非String对象参数可以不用声明)
    List<Member> searchMemberByNick(@Param("keyWord") String keyWord);
}
```

##### 13.1.2 映射文件

```xml
<select id="searchMemberByNick" resultMap="MemberMap">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    where member_nick like '%${keyWord}%'
</select>
```

##### 13.1.3 测试

```java
@Test
public void testSearchMemberByNick(){
    MemberDao memberDao = MyBatisUtil.getMapper(MemberDao.class);
    List<Member> members = memberDao.searchMemberByNick("小");
    for (Member member : members) {
        System.out.println(member);
    }
}
```

### 13.2 #{}和${}的区别

- ${key}  表示获取参数，先获取参数的值`拼接`到SQL语句中，再编译执行SQL语句；可能引起SQL注入问题
- #{key}  表示获取参数，先完成SQL编译（`预编译`），预编译之后再将获取的参数设置到SQL语句中，可以避免SQL注入问题

## 十四、MyBatis日志配置

> MyBatis做为⼀个封装好的ORM框架，其运行过程我们没办法跟踪，为了让开发者了解MyBatis执行流程及每个执行步骤所完成的工作，MyBatis框架本身支持log4j日志框架，对运行的过程进行跟踪记录。我们只需对 MyBatis进行相关的日志配置，就可以看到MyBatis运行过程中的日志信息。


### 14.1 添加日志框架依赖

```xml
<dependency>
    <groupId>log4j</groupId>
    <artifactId>log4j</artifactId>
    <version>1.2.17</version>
</dependency>
```

### 14.2 添加日志配置文件

- 在resources目录下创建名为`log4j.properties`（文件名必须是这个名字）文件
- 在`log4j.properties`文件配置日志输出的方式

```properties
# 声明日志的输出级别及输出方式
log4j.rootLogger=DEBUG,stdout
# MyBatis logging configuration...
log4j.logger.org.mybatis.example.BlogMapper=TRACE
# Console output...
log4j.appender.stdout=org.apache.log4j.ConsoleAppender
log4j.appender.stdout.layout=org.apache.log4j.PatternLayout
# 定义日志的打印格式 %t 表示线程名称 %5p 日志级别 %msg日志信息
log4j.appender.stdout.layout.ConversionPattern=[%t] %5p - %msg \:%m%n
```

### 14.3 日志信息的级别

> 在使用日志框架输出日志信息的时候，会根据输出的日志信息的重要程度分为5个级别

| 级别 | 说明 |
| --- | --- |
| DEBUG | 输出调试信息 |
| INFO | 输出提示信息 |
| WARN | 输出警告信息 |
| ERROR | 一般性错误信息 |
| FATAL | 致命性错误 |


## 十五、配置数据库连接池-整合Druid

> MyBatis做为⼀个ORM框架，在数据库操作时是需要和数据库连接连接的，MyBatis⽀持基于数据库连接池的连接创建方式。 当我们配置MyBatis数据源时，只要配置了dataSource标签的type属性值为POOLED时，就可以使

> 用MyBatis内置的连接池管理连接。

> 如果我们想要使用第三方的数据库连接池，则需进行自定义配置。


### 15.1 常见的连接池

- 
DBCP

- 
C3P0

- 
Druid 性能也比较好，提供了比较便捷的监控系统

- 
Hikari 性能最好


### 15.2 添加Druid依赖

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.11</version>
</dependency>
```

### 15.3 创建Druid连接池工厂

```java
public class DruidDataSourceFactory extends PooledDataSourceFactory {

    public DruidDataSourceFactory() {
        this.dataSource = new DruidDataSource();
    }
}
```

### 15.4 将DruidDataSourceFactory配置给MyBatis数据源

```xml
<environments default="mysql">
    <environment id="mysql">
        <transactionManager type="JDBC"/>

        <!--POOLED 使用MyBatis内置的连接池实现  -->
        <!--mybatis需要一个连接池工厂，这个工厂可以产生数据库连接池  PooledDataSourceFactory-->
        <dataSource type="com.szh.utils.DruidDataSourceFactory">
            <property name="driverClass" value="${driver}"/>
            <property name="jdbcUrl" value="${url}"/>
            <property name="username" value="${username}"/>
            <property name="password" value="${password}"/>
        </dataSource>
    </environment>
</environments>
```

## 十六、MyBatis缓存

> MyBatis是基于JDBC的封装，使数据库操作更加便捷；MyBatis除了对JDBC操作步骤进⾏封装之外也对其性能 进行了优化：

> - 
在MyBatis引入缓存机制，用于提升MyBatis的检索效率

> - 
在MyBatis引入延迟加载机制，用于减少对数据库不必要的访问



### 16.1 缓存的工作原理

> 缓存，就是存储数据的内存


![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011636.png#alt=%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio%20%2863%29)

### 16.2 MyBatis缓存

> MyBatis缓存分为一级缓存和二级缓存


##### 16.2.1 一级缓存

> ⼀级缓存也叫做SqlSession级缓存，为每个SqlSession单独分配的缓存内存，无需手动开启可直接使用；多个SqlSession的缓存是不共享的。

> 特性：

> 1. 
如果多次查询使用的是同⼀个SqlSession对象，则第⼀次查询之后数据会存放到缓存，后续的查询则直接访问缓存中存储的数据；

> 2. 
如果第一次查询完成之后，对查询出的对象进行修改（此修改会影响到缓存），第二次查询会直接访问缓存，造成第二次查询的结果与数据库不一致；

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011637.png#alt=image-20220728002554901)

> 3. 
当我们进行在查询时想要跳过缓存直接查询数据库，则可以通过sqlSession.clearCache();来清除当前 SqlSession的缓存;

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011638.png#alt=image-20220728002859564)

> 4. 
如果第一次查询之后第二查询之前，使用当前的sqlsession执行了修改操作，此修改操作会使第一次查询并`缓存的数据失效`，因此第⼆次查询会再次访问数据库。(缓存失效场景)

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011639.png#alt=image-20220728003443730)



**测试代码**

```java
@Test
public void testQueryMemberById(){
    SqlSession sqlSession1 = MyBatisUtil.getSqlSessionFactory().openSession();
    SqlSession sqlSession2 = MyBatisUtil.getSqlSessionFactory().openSession();
    MemberDAO memberDAO1 = sqlSession1.getMapper(MemberDAO.class);
    Member member1 = memberDAO1.queryMemberById(1);
    System.out.println(member1);
    member1.setMemberAge(99);
    sqlSession1.clearCache();
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    MemberDAO memberDAO2 = sqlSession1.getMapper(MemberDAO.class);
    Member member2 =memberDAO2.queryMemberById(1);
    System.out.println(member2);
}
```

##### 16.2.2 两次查询与数据库数据不一致问题

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011640.png#alt=%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio%20%2865%29)

##### 16.2.3 二级缓存

> 二级缓存也称为SqlSessionFactory级缓存，通过同一个factory对象获取的Sqlsession可以共享二级缓存；在应 用服务器中SqlSessionFactory是单例的，因此我们二级缓存可以实现全局共享。

> 特性：

> 1. 
二级缓存默认没有开启，需要在mybatis-config.xml中的settings标签开启

> 2. 
二级缓存只能缓存实现序列化接口的对象



- 在mybatis-config.xml开启使用二级缓存

```xml
<settings>
    <!--开启二级缓存-->
    <setting name="cacheEnable" value="true"/>
</settings>
```

- 在需要使用二级缓存的Mapper文件中配置cache标签使用功能二级缓存

```xml
<!--
    eviction 表示缓存策略  FIFO 按对象先进先出移出   LRU 移出最长时间不被使用的对象 默认LRU
    flushInterval 刷新间隔  60s  默认不设置
    size 最多可以存储结果对象512个  默认 1024
    readOnly  返回对象被认为是只读,无法修改  默认是false
-->
<cache readOnly="true" size="521" flushInterval="60000" eviction="LRU"/>
```

- 被缓存的实体类实现序列化接口

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member implements Serializable {
    private Integer memberId;
    private String memberNick;
    private String memberGender;
    private Integer memberAge;
    private String memberCity;
}
```

- **测试**

```java
@Test
public void testQueryMemberById(){
    SqlSessionFactory sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
    /*多个SqlSession对象必须来自于同一个SqlSessionFactory*/
    SqlSession sqlSession1= sqlSessionFactory.openSession();
    SqlSession sqlSession2= sqlSessionFactory.openSession();

    MemberDao memberDao = sqlSession1.getMapper(MemberDao.class);
    Member member = memberDao.queryMemberById(1);
    System.out.println(member);
    
    sqlSession1.commit();//第一次查询之后，执行 sqlSession1.commit() 会将当前sqlSession的查询结果缓存到二级缓存
    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    MemberDao memberDao2 = sqlSession2.getMapper(MemberDao.class);
    Member member1 = memberDao2.queryMemberById(1);
    System.out.println(member1);
}
```

### 16.3 查询操作的缓存开关

```xml
<select id="queryMemberById" resultMap="MemberMap" useCache="true">
    select member_id,member_nick,member_gender,member_age,member_city
    from members
    where member_id = #{mid}
</select>
```

### 16.4 更新操作刷新缓存

```xml
<!--flushCache表示修改后会自动修改缓存-->
<update id="updateMember" flushCache="true">
    update members set member_age = #{age}
    where member_id = #{mid}
</update>
```

## 十七、延迟加载

> 延迟加载——如果在MyBatis开启了延迟加载，在执行了`子查询`（至少查询两次及以上）时，默认只执行第⼀ 次查询，当用到子查询的查询结果时，才会触发子查询的执行；如果无需使用子查询结果，则子查询不会执 行.


**开启延迟加载：**

```xml
<settings>
    <!--开启二级缓存-->
    <setting name="cacheEnabled" value="true"/>
    <!-- 启动延迟加载 -->
    <setting name="lazyLoadingEnabled" value="true"/>
</settings>
```

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011641.png#alt=image-20220728142716974)

**测试代码**

```java
/*延迟加载*/
@Test
public void queryClazzByCid() {
    ClazzDao clazzDao = MyBatisUtil.getMapper(ClazzDao.class);
    Clazz clazz = clazzDao.queryClazzByCid(1);
    System.out.println(clazz.getStus());
}
```

**运行日志：**

![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051011642.png#alt=image-20220728142938677)
