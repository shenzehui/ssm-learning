## ⼀、SpringMVC概述

> Spring MVC 是由Spring官方提供的基于MVC设计理念的web框架。

> SpringMVC是基于Servlet封装的用于实现MVC控制的框架，实现前端和服务端的交互。


### 1.1 SpringMVC优势

- 
严格遵守了MVC分层思想

- 
采用了松耦合、插件式结构；相比较于我们封装的BaseServlet以及其他的⼀些MVC框架来说更灵活、更具扩展性

- 
SpringMVC是基于Spring的扩展、提供了⼀套完善的MVC注解

- 
SpringMVC在数据绑定、视图解析都提供了多种处理方式，可灵活配置

- 
SpringMVC对RESTful URL设计方法提供了良好的支持


### 1.2 SpringMVC本质工作

- 
接收并解析请求

- 
处理请求

- 
数据渲染、响应请求


## ⼆、SpringMVC框架部署

### 2.1 基于Maven创建⼀个web工程

- SpringMVC是⼀个web框架，应用在web工程中

### 2.2 添加SpringMVC依赖

- spring-context
- spring-aspects
- spring-jdbc
- spring-web
- spring-webmvc
- spring-junit

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.qfedu</groupId>
    <artifactId>springmvc-demo2</artifactId>
    <version>1.0-SNAPSHOT</version>

    <properties>
        <maven.compiler.source>8</maven.compiler.source>
        <maven.compiler.target>8</maven.compiler.target>
        <spring.version>5.2.13.RELEASE</spring.version>
    </properties>

    <packaging>war</packaging>
    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aspects</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-web</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>${spring.version}</version>
        </dependency>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-test</artifactId>
            <version>${spring.version}</version>
        </dependency>
    </dependencies>

</project>
```

### 2.3 创建SpringMVC配置⽂件

- 
在resources目录下创建名为spring-servlet.xml 的文件

- 
添加MVC命名空间


```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">
    <context:annotation-config/>
    <context:component-scan base-package="com.qfedu"/>

    <!--声明mvc使用注解驱动-->
    <mvc:annotation-driven/>
</beans>
```

### 2.4 在web.xml中配置SpringMVC的前端控制器

> SpringMVC提供了一个名为DispatcherServlet的类（SpringMVC中央处理器，也叫作前端控制器），用于拦截用户请求交由SpringMVC处理


```xml
<servlet>
    <servlet-name>dispatcherServlet</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath:spring-servlet.xml</param-value>
    </init-param>
    <load-on-startup>1</load-on-startup>
</servlet>
<servlet-mapping>
    <servlet-name>dispatcherServlet</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```

## 三、SpringMVC框架使用

> 在SpringMVC中，我们把接收用户请求、处理用户请求的类称之为Controlelr（控制器）


### 3.1 创建控制器

##### 3.1.1 创建控制器类

- 
创建一个名为`com.qfedu.controller`的包（包需要在Spring注解扫描的范围内）

- 
创建一个类（无需做任何的继承和实现）

- 
在类上添加 `@Controller`注解声明此类为SpringMVC的控制器

- 
在类上添加 `@RequestMapping("url")`声明此控制器类的请求url（可以省略）


```java
@Controller
@RequestMapping("/book")
public class BookController {

}
```

##### 3.1.2 在控制器类中定义处理请求的方法

- 
在一个控制器类中可以定于多个方法处理不同的请求

- 
在每个方法上添加 `@RequestMapping("url")` 用于声明当前方法请求的url


```java
@Controller
@RequestMapping("/book")
public class BookController {
    @RequestMapping("/add")
    public void addBook(){
        System.out.println("---book akdd");
    }
    @RequestMapping("/list")
    public void listBooks(){
        System.out.println("---book list");
    }
}
```

##### 3.1.3 访问

- 
[http://localhost:8080/springmvc_demo2/book/add](http://localhost:8080/springmvc_demo2/book/add)

- 
[http://localhost:8080/springmvc_demo2/book/list](http://localhost:8080/springmvc_demo2/book/list)


### 3.2 静态资源配置

> 静态资源：就是项目中的HTML、css、js、图片、字体等


##### 3.2.1 /* 和 / 的区别

- 
/* 拦截所有HTTP请求，包括.jsp的请求，都作为控制器类的请求路径来处理

- 
/ 拦截所有HTTP请求，但不包括.jsp的请求，不会放行静态资源的请求（html/css/js/图片）


##### 3.2.2 静态资源放行配置

```xml
<!--配置静态资源放行-->
<mvc:resources mapping="/css/**" location="/css/"/>
<mvc:resources mapping="/js/**" location="/js/"/>
<mvc:resources mapping="/imgs/**" location="/imgs/"/>
<mvc:resources mapping="/pages/**" location="/pages/"/>
```

### 3.3 前端提交数据到控制器

##### 3.3.1 表单提交

- 
表单提交：输入框需要提供name属性，SpringMVC控制器是通过name属性取值的
```jsp
<body>
    <h3>添加图书</h3>
    <form action="book/add" method="post">
        <p>图书名称：<input type="text"></p>
        <p>图书作者：<input type="text"></p>
        <p>图书价格：<input type="text"></p>
        <p><input type="submit" value="提交"></p>
    </form>
</body>
```



##### 3.3.2 URL提交

- 
URL提交：
```html
<a href="book/add?bookName=Java">URL提交</a>
```



##### 3.3.3 AJAX提交

- AJAX提交：请求行、请求头、请求体都可以用来传值

```html
<h3>AJAX提交</h3>
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<input type="button" value="ajax提交" id="btn1"/>
<script type="text/javascript">
    $('#btn1').onclick(function () {
        var obj = {};
        obj.bookName="java";
        obj.bookAuthor="张三";
        obj.bookPrice=3.33;
        $.ajax({
            url:"book/add",
            type:"post",
            headers:{

            },
            data:obj,
            contentType:"application/json",
            success:function (res) {
                console.log(res);
            }
        })
    })
</script>
```

### 3.4 控制器接收前端提交的数据

##### 3.4.1 [@RequestParam ](/RequestParam ) 接收请求行传值 

- 表单提交
- URL提交
- $.ajax()请求的url传值
- ![](https://g.yuque.com/gr/latex?.post()%2F#card=math&code=.post%28%29%2F).get()中的{}传值

`@RequestParam` 注解用于接收请求行传递的数据

- 前端提交数据

```jsp
<form action="${pageContext.request.contextPath}/book/add" method="post">
    <p>图书名称：<input type="text" name="bookName"></p>
    <p>图书作者：<input type="text" name="bookAuthor"></p>
    <p>图书价格：<input type="number" name="bookPrice"></p>
    <p><input type="submit" value="提交"></p>
</form>
```

- 控制器接收数据

```java
@RequestMapping(value = "/add",method = RequestMethod.POST)
public void addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b,@RequestParam("bookPrice")  double c){
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
}
```

**`注意` 如果控制器方法中接收数据的参数名与请求行传值的key一致，则@RequestParam注解可省略**

```java
@RequestMapping("/add")
public void addBook(String bookName,String bookAuthor, double bookPrice){
    System.out.println("---book add");
    System.out.println(bookName);
    System.out.println(bookAuthor);
    System.out.println(bookPrice);
}
```

##### 3.4.2 @RequestHeader接收请求头传值

- ajax封装请求头数据

```javascript
$.ajax({
    ...,
    headers:{

	},
  	 ...
})
```

**`@RequestHeader`注解用于接收请求行头传递的数据**

- 前端

```html
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<input type="button" value="ajax提交" id="btn1"/>
<script type="text/javascript">
    $('#btn1').click(function () {
        $.ajax({
            url:"${pageContext.request.contextPath}/book/list",
            type:"post",
            headers:{
                token:"wahahahahha"
            },
            success:function (res) {
                console.log(res);
            }
        })
    })
</script>
```

- 控制器

```java
//接收请求头数据
@RequestMapping("/list")
public void listBook(@RequestHeader String token){
    System.out.println(token);
}
```

##### 3.4.3 `@RequestBody`接收请求体传值

- ajax封装请求体数据

```javascript
$.ajax({
    ...,
    contentType:"application/json",
    data:obj,
    ...
})
```

**`@RequestBody`注解用于接收请求行头传递的数据**

- 前端

```html
<script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
<input type="button" value="ajax提交" id="btn1"/>
<script type="text/javascript">
    $('#btn1').click(function () {
        var obj = {};
        obj.bookName = "java";
        obj.bookAuthor = "张三";
        obj.bookPrice = 3.33;

        var s = JSON.stringify(obj); //将对象转成json格式
        $.ajax({
            url: "book/update",
            type: "post",
            data: s,
            contentType: "application/json", ////如果data的值为json格式字符串，contentType必须设置为"application/json"
            success: function (res) {
                console.log(res);
            }
        })
    })
</script>
```

> [@RequestBody ](/RequestBody ) 将前端请求体提交的 `JSON格式数据转换成Java对象`，依赖jackson包


- 导⼊jackson的依赖

```xml
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.1</version>
</dependency>
```

- 控制器

```java
@RequestMapping(value = "/update",method = RequestMethod.POST)
public void update(@RequestBody Book book){
    System.out.println(book);
    System.out.println("----book update");
}
```

### 3.5 控制器响应前端请求

> 同步请求：form、超链接

> 处理同步请求的方法的返回类型定义为`String`或者`ModelAndView`，以实现页面的跳转


- 
返回类型为String

**转发**
```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
public String addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b, @RequestParam("bookPrice") double c) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    return "/tip.jsp";
}
```


**重定向**
```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
public String addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b, @RequestParam("bookPrice") double c) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    return "redirect:/tip.jsp";
}
```


- 
返回类型为ModelAndView

**转发**
```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ModelAndView addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b, @RequestParam("bookPrice") double c, ModelAndView modelAndView) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    modelAndView.setViewName("/tip.jsp");
    return modelAndView;
}
```


**重定向**
```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ModelAndView addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b, @RequestParam("bookPrice") double c, ModelAndView modelAndView) {
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    modelAndView.setViewName("redirect:/tip.jsp");
    return modelAndView;
}
```



##### 3.5.2 控制器响应异步请求

> 异步请求：ajax请求


**使用response中的输出流进行响应**

- 
控制器方法的返回类型为 `void`

- 
控制器方法添加 `HttpServletResponse response` 参数

- 
在方法中通过response获取输出流，使用流响应ajax请求


```java
@RequestMapping(value = "/update")
/* @RequestBody 将前端请求体提交的JSON格式数据转换成Java对象，依赖jackson包*/
public void update(@RequestBody Book book, HttpServletResponse response) throws IOException {
    System.out.println(book);
    System.out.println("----book update");
    //使用response流的形式响应ajax请求
    response.setContentType("application/json;charset=utf-8");
    PrintWriter out = response.getWriter();
    String s = new ObjectMapper().writeValueAsString(book);
    out.println(s);
    //也可以 out.write(s);
    out.flush();
    out.close();
}
```

**直接在控制器方法返回响应的对象**

- 控制器方法的返回类型设置为响应给ajax请求的对象类型
- 在控制器方法前添加 `@ResponseBody` 注解，将返回的对象转换成JSON响应给ajax请求
- 如果⼀个控制器类中的所有方法都是响应ajax请求，则可以直接在控制器类前添加 `@ResponseBody` 注解

```java
@RequestMapping("/update")
@ResponseBody
public List<Book> update() {
    System.out.println("---book update");
    List<Book> books = new ArrayList<Book>();
    books.add(new Book(1,"Java","⽼张",2.22));
    books.add(new Book(2,"C++","⽼李",3.22));
    return books;
}
```

##### 3.5.3 控制器响应同步请求的数据传递

> 对于同步请求的转发响应，我们可以传递参数到转发的页面


- 返回类型为String:

```java
//1.在控制器⽅法中定义一个Model类型的参数
//2.在return页面之前，向model中添加键值对，添加的键值对就会被传递到转发的页面
@RequestMapping("/add")
public String addBook(String name, String author, double price,Model model){
    model.addAttribute("key1","value1");
    model.addAttribute("book",new Book(1,"Java","⽼张",2.22));
    return "/tips.jsp";
}
//除了使用Model对象传值外，还可以直接使用HttpServletRequest对象
@RequestMapping("/add")
public String addBook(String name, String author, double price,HttpServletRequest request){
    request.setAttribute("key1","value1");
    request.setAttribute("book",new Book(1,"Java","⽼张",2.22));
    return "/tips.jsp";
}
```

- 返回类型ModelAndView:

```java
@RequestMapping(value = "/add", method = RequestMethod.POST)
public ModelAndView addBook(@RequestParam("bookName") String a, @RequestParam("bookAuthor") String b, @RequestParam("bookPrice") double c) {
    ModelAndView modelAndView = new ModelAndView("/tip.jsp");
    modelAndView.addObject("book", new Book(1, a, b, c));
    modelAndView.addObject("key1", "value1");
    return modelAndView;
}
```

- 前端

```html
<body>
  <h3>成功！！！！${key1} and ${book}</h3>
</body>
```

### 3.6 解决中文乱码问题

##### 3.6.1 前端编码

- 
JSP页面：
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
```


- 
HTML页面
```html
<meta charset="UTF-8">
```



##### 3.6.2 服务器编码

- 
tomcat/conf/server.xml
```xml
<Connector port="8080" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" 
			   URIEncoding="UTF-8"/>
```



##### 3.6.3 设置SpringMVC的编码方式

- 
在web.xml中配置SpringMVC编码过滤器的编码方法
```xml
<filter>
    <filter-name>characterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceRequestEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
    <init-param>
        <param-name>forceResponseEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>characterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```



## 四、SpringMVC的请求处理流程

### 4.1 请求处理流程

> SpringMVC通过前端控制器（DispatcherServlet）拦截并处理用户请求的


![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051022215.png#alt=%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio%20%2874%29)

> **①前端发送请求被前端控制器DispatcherServlet拦截

②前端控制器调用处理器映射HandlerMapping对请求URL进行解析，解析之后返回`调用链`给前端控制器

③前端控制器调用处理器适配器，基于反射通过适配器设计模式完成处理器（控制器）的调用处理用户请求

④处理器适配器将控制器返回的视图和数据信息封装成ModelAndView响应给前端控制器

⑤前端控制器调用视图解析器对ModelAndView进行解析，将解析结果（视图资源和数据）响应给前端控制器

⑥前端控制器调用视图View组件，将数据进行渲染，将渲染结果（静态视图）响应给前端控制器

⑦前端控制器响应用户请求**


### 4.2 SpringMVC的核心组件

- `DispatcherServlet` 前端控制器、总控制器

   - 由SpringMVC提供，无需工程师开发
   - 作用：接收请求，协同各组件工作、响应请求
- `HandlerMapping` 处理器映射

   - 也是由SpringMVC提供
   - 作用：负责根据用户请求的URL找到对应的Handler（控制器）
   - **可配置** SpringMVC提供多个处理器映射的实现，可以根据需要进行配置
- `HandlerAdapter` 处理器适配器

   - 作用：按照处理器映射器解析的用户请求的调用链，通过适配器模式完成Handler的调用
- `Handler` 处理器/控制器

   - 由工程师根据业务的需求进行开发
   - 作用：处理请求
- `ModelAndView` 视图模型

   - 作用：用于封装处理器返回的数据以及响应的视图
   - ModelAndView = Model + View
- `ViewResolver` 视图解析器

   - 作用：对ModelAndView进行解析
   - **可配置** SpringMVC提供多个视图解析器的实现，可以根据需要进行配置
- `View` 视图

   - 作用：完成数据渲染

### 4.3 处理器映射器

> 不同的处理器映射器对URL处理的方式也不相同，使用对应的处理器映射器之后我们的前端请求规则也需要发生相应的变化

> SpringMVC提供的处理器映射器：

> - 
`BeanNameUrlHandlerMapping` 根据控制器的ID（Spring容器中的ID）访问控制器

> - 
`SimpleUrlHandlerMapping` 根据控制器配置的URL访问（默认）



配置处理器映射器：

- 
在SpringMVC的配置文件中通过bean标签声明处理器映射器

- 
配置`BeanNameUrlHandlerMapping`
```xml
<bean class="org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping"></bean>
```


- 
配置`SimpleUrlHandlerMapping`
```xml
<!--Spring默认HandlerMapping-->
<bean class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping">
    <property name="mappings">
        <props>
            <!--请求/aaa 映射到bookController  相当于@RequestMapping("/aaa")-->
            <prop key="/aaa">bookController</prop>
            <prop key="/bbb">studentController</prop>
        </props>
    </property>
</bean>
```



### 4.4 视图解析器

> Spring提供了多个视图解析器：

> - `UrlBasedViewResolver`
> - `InternalResourceView`（推荐使用）


- 
`UrlBasedViewResolver` 需要依赖jstl

   - 添加jstl的依赖
```xml
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

   - 配置视图解析器
```xml
<!--配置视图解析器 这里id必须是viewResolver-->
<bean id="viewResolver" class="org.springframework.web.servlet.view.UrlBasedViewResolver">
    <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>  <!--这里需要依赖jstl依赖-->
    <property name="prefix" value="/"/>
    <property name="suffix" value=".jsp"/>
</bean>
```

- 
`InternalResourceView`
```xml
<bean id="viewResolver" class="org.springframework.web.servlet.view.InternalResourceViewResolver">
    <property name="prefix" value="/"/>
    <property name="suffix" value=".jsp"/>
</bean>
```



## 五、日期格式处理

> 如果前端需要输入日期数据，在控制器中转化成Date对象，SpringMVC要求前端输入的日期格式必须为`yyyy/MM/dd`

> 如果甲方要求日期格式必须为指定的格式，而这个指定格式SpringMVC不接受，该如何处理呢？

> - 自定义日期转换器


##### 5.2.1 创建自定义日期转换器

```java
/**
 * 1.创建一个类实现Converter接口，泛型指定从什么类型转化成什么类型
 * 2.实现convert转化方法
  */
public class MyDateConverter implements Converter<String, Date> {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");

    /**
     * @param s 前端传过来的值
     * @return
     */
    @Override
    public Date convert(String s) {
        Date date = null;
        try {
            //解析字符串
            date = sdf.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
```

##### 5.2.2 配置自定义转化器

```xml
<!--声明mvc使用注解驱动 将转化器工厂配置给SpringMVC -->
<mvc:annotation-driven conversion-service="converterFactory"/>

<!--将自定义日期转换器配置给Spring转化器工厂-->
<bean id="converterFactory" class="org.springframework.context.support.ConversionServiceFactoryBean">
    <property name="converters">
        <set>
            <bean class="com.qfedu.utils.MyDateConverter"/>
        </set>
    </property>
</bean>
```
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051022216.png#alt=image-20220801003024650) |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051022217.png#alt=image-20220801003101974) |


## 六、文件上传下载

### 6.1 SpringMVC框架部署

- 基于Maven创建web工程
- 添加SpringMVC所需的依赖

   - Spring：context aspects jdbc test web webmvc jackson
- 创建SpringMVC配置文件
- 在web.xml中配置SpringMVC的前端控制器
- 在web.xml中配置SpringMVC的编码过滤器

### 6.2 文件上传

> 案例：添加图书，同时提交图书的封面图片


##### 6.2.1 前端提交文件

- 表单提交方式必须为post
- 表单enctype属性设置为 `multipart/form-data`

```html
<h4>添加图书信息</h4>
<form action="" enctype="multipart/form-data">
    <p>图书名称：<input type="text" name="bookName"></p>
    <p>图书作者：<input type="text" name="bookAuthor"></p>
    <p>图书价格：<input type="text" name="bookPrice"></p>
    <p>图书封面：<input type="file" name="imgFile"></p>
    <p><input type="submit" value="提交"></p>
</form>
```

##### 6.2.2 控制器接收数据和文件

> SpringMVC处理上传⽂件需要借助于CommonsMultipartResolver文件解析器


- 添加依赖：commons-io commons-fileupload

```xml
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.11.0</version>
</dependency>
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.4</version>
</dependency>
```

- 在spring-servlet.xml中配置文件解析器

```xml
<bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
    <property name="maxUploadSize" value="10240000"/>
    <property name="maxInMemorySize" value="102400"/>
    <property name="defaultEncoding" value="utf-8"/>
</bean>
```

- 控制器接收文件

   - 在处理⽂件上传的方法法中定义⼀个MultiPartFile类型的对象，就可以接受图片了

```java
@RequestMapping(value = "/add",method = RequestMethod.POST)
public String addBook(Book book, MultipartFile imgFile, HttpServletRequest request) throws IOException {
    String oldFileName = imgFile.getOriginalFilename();
    String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.indexOf(".")); //.jpg
    String realPath = request.getServletContext().getRealPath("imgs");
    File file = new File(realPath + "/" + newFileName);
    if(!file.exists()){
        file.mkdirs();
    }
    imgFile.transferTo(file);
    book.setImgUrl("imgs/" + newFileName);
    System.out.println("---------");
    return "/tips.jsp";
}
```

**`注意`：MultipartFile参数名必须与前端表单中的name保持一致，且不能与Book中的属性名冲突**

### 6.3 文件下载

##### 6.3.1 显示文件列表

- list.jsp

```html
<html>
    <head>
        <title>Title</title>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    </head>
    <body>
        <div id="container"></div>
        <script type="text/javascript">
            $.ajax({
                url: 'book/listImgs',
                method: 'get',
                dataType: 'json',
                success: function (res) {
                    console.log(res);
                    for (let i = 0; i < res.length; i++) {
                        var htmlStr = "<div class='card' style='width: 18rem;'><img src='" + "imgs/" + res[i] + "' class='card-img-top'><div class='card-body'><a href='book/download?fileName=" + res[i] + "'>下载</a></div></div>";
                        $("#container").append(htmlStr);
                    }
                }
            })
        </script>
    </body>
    <style>
        div{
            display: flex ;
            justify-content: space-between;
        }
        img{
            width: 200px;
            height: 200px;
        }
    </style>
</html>
```

- BookController

```java
@RequestMapping(value = "/listImgs", method = RequestMethod.GET)
@ResponseBody
public List<String> listImgs(HttpServletRequest request) {
    List<String> imgUrlList = new ArrayList<>();
    String realPath = request.getServletContext().getRealPath("imgs");
    File file = new File(realPath);
    String[] list = file.list();
    for (int i = 0; i < list.length; i++) {
        imgUrlList.add(list[i]);
    }
    return imgUrlList;
}
```

##### 6.3.2 实现文件下载

- BookController

```java
@RequestMapping("/download")
public void downloadImg(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
    String realPath = request.getServletContext().getRealPath("imgs");
    String filePath = realPath + "/" + fileName;
    InputStream inputStream = new FileInputStream(filePath);
    response.setContentType("application/exe");
    response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
    IOUtils.copy(inputStream, response.getOutputStream());
}
```

## 七、统一异常处理

> 在我们的应用系统运行过程中，可能由于运行环境，用户操作，资源不足等各方面的原因导致系统出现异常（HTTP状态异常，Exception）；如果系统出现了异常，这些异常将会通过浏览器呈现给用户，这种异常的显示是没有必要，因此我们可以在服务器进行特定的处理——当系统出现异常之后，能够呈现给用户统一的、可读的异常提示页面。


### 7.1 HTTP异常状态统一处理

> **HTTP Status 404**


- 创建⼀个用于进行异常提示的页面：404.jsp
- 在web.xml中进行配置

```xml
<error-page>
    <error-code>404</error-code>
    <location>/404.jsp</location>
</error-page>
```

### 7.2 Java代码异常的统一处理

##### 7.2.1 基于Servlet-api的处理

- 
创建一个用于进行异常提示的页面：404.jsp

- 
在web.xml中进行配置
```xml
<error-page>
    <exception-type>java.lang.NumberFormatException</exception-type>
    <location>/err.jsp</location>
</error-page>
```



##### 7.2.2 SpringMVC处理

- 
使用异常处理类进行统⼀处理
```java
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String nullHandler(Throwable t){
        return t.getMessage();
    }
}
```



## 八、拦截器

### 8.1 拦截器介绍

> SpringMVC提供的拦截器就类似于Servlet-api中的过滤器，可以对控制器的请求进行拦截实现相关的预处理和 后处理。


过滤器

- 是Servlet规范的⼀部分，所有的web项目都可以使用
- 过滤器在web.xml配置（可以使用注解），能够拦截所有web请求

拦截器

- 是SpringMVC框架的实现，只有在SpringMVC框架中才能使用
- 拦截器在SpringMVC配置文件进行配置，不会拦截SpringMVC放行的资源（jsp/html/css..）

### 8.2 自定义拦截器

##### 8.2.1 创建拦截器

```java
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("--------预处理");
        /*必须传参  id*/
        Enumeration<String> keys = request.getParameterNames();
        while (keys.hasMoreElements()){
            String key = keys.nextElement();
            if(key.equals("id")){
                return true;
            }
        }
        response.setStatus(400);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("tips","这是通过拦截器的后处理添加的数据");
        System.out.println("---------后处理");
    }
}
```

##### 8.2.2 配置拦截器

```xml
<mvc:interceptors>
    <mvc:interceptor>
        <mvc:mapping path="/book/query"/>
        <mvc:mapping path="/book/add"/>
        <mvc:mapping path="/student/**"/>
        <mvc:exclude-mapping path="/student/add"/>
        <bean class="com.qfedu.interceptor.MyInterceptor"/>
    </mvc:interceptor>
</mvc:interceptors>
```

### 8.3 拦截器链

> 将多个拦截器按照一定的顺序构成一个执行链


![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051022218.png#alt=%E6%9C%AA%E5%91%BD%E5%90%8D%E7%BB%98%E5%9B%BE.drawio%20%2875%29)

## 九、SSM整合

### 9.1 创建web项目

- 创建Maven项目
- 修改pom文件

```xml
<packaging>war</packaging>
```

- 完成maven工程web项目结构
- 添加web依赖

```xml
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

- 配置服务器运行环境

### 9.2 部署MyBatis

- 添加MyBatis依赖

```xml
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis</artifactId>
    <version>3.5.6</version>
</dependency>
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version>
</dependency>
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.22</version>
</dependency>
```

- 创建MyBatis配置文件`mybatis-config`

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
            PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
            "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>


</configuration>
```

### 9.3 部署Spring、SpringMVC

##### 9.3.1 添加依赖

```xml
<!--spring-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-context</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<!--aop相关依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aspects</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<!--提供spring事务支持相关依赖-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-jdbc</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<!--spring测试-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-test</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<!--springmvc-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-web</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.2.13.RELEASE</version>
</dependency>
<!--支持@RequestBody @ResponseBody String转对象依赖-->
<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.9.9</version>
</dependency>
```

##### 9.3.2 创建Spring配置

- 
多配置文件分开配置

   - spring-context.xml  只配置注解声明，以及类的管理
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <context:annotation-config/>

    <context:component-scan base-package="com.qfedu"/>
</beans>
```

   - spring-mvc.xml  进行mvc相关配置，例如静态资源配置，拦截器配置等
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/mvc https://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!--声明mvc使用注解配置-->
    <mvc:annotation-driven/>
</beans>
```

   - spring-mybatis.xml  进行spring与MyBatis整合相关的配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

</beans>
```

##### 9.3.3 配置SpringMVC前端控制器

- 在web.xml进行配置

```xml
<?xml version="1.0" encoding="UTF-8"?>

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
          http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
    <servlet>
        <servlet-name>dispatcherServlet</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-*.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcherServlet</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
        <init-param>
            <param-name>forceRequestEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
        <init-param>
            <param-name>forceResponseEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>characterEncodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
    
</web-app>
```

### 9.4 整合配置

##### 9.4.1 导入mybatis-spring依赖

```xml
<!--spring整合mybatis-->
<dependency>
    <groupId>org.mybatis</groupId>
    <artifactId>mybatis-spring</artifactId>
    <version>2.0.5</version>
</dependency>
```

##### 9.4.2 配置druid连接池

```xml
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid</artifactId>
    <version>1.2.11</version>
</dependency>
```

- 创建druid.properties,并配置：

```properties
druid.driver=com.mysql.cj.jdbc.Driver
druid.url=jdbc:mysql://localhost:3306/db_2010_mybatis?characterEncoding=utf-8&useUnicode=true
druid.username=root
druid.password=240518.a

## 连接池参数
druid.pool.init=1
druid.pool.minIdle=3
druid.pool.maxActive=20
druid.pool.timeout=30000
```

- 在spring-mybatis.xml配置数据源

```xml
<context:property-placeholder location="classpath:druid.properties"/>

<bean id="dataSource" class="com.alibaba.druid.pool.DruidDataSource">
    <property name="url" value="${druid.url}"/>
    <property name="driverClassName" value="${druid.driver}"/>
    <property name="username" value="${druid.username}"/>
    <property name="password" value="${druid.password}"/>
    <property name="initialSize" value="${druid.pool.init}"/>
    <property name="maxActive" value="${druid.pool.maxActive}"/>
    <property name="minIdle" value="${druid.pool.minIdle}"/>
    <property name="maxWait" value="${druid.pool.timeout}"/>
</bean>
```

##### 9.4.3 配置SqlSessionFactory

- 在spring-mybatis.xml配置

```xml
<bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
    <property name="dataSource" ref="dataSource"/>
    <property name="mapperLocations" value="classpath:mappers/*.xml"/>
    <property name="typeAliasesPackage" value="com.qfedu.bean"/>
    <property name="configLocation" value="classpath:mybatis-config.xml"/>
</bean>
```

##### 9.4.4 配置MapperScannerConfigurer

- 在spring-mybatis.xml配置

```xml
<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
    <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    <property name="basePackage" value="com.qfedu.dao"/>
</bean>
```

### 9.5 整合配置（AOP）

> 使用Spring提供的事务管理完成DAO操作的事务管理

> 基于注解的事务管理配置：


- 将Spring提供的事务管理切面类配置到Spring容器

```xml
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
    <property name="dataSource" ref="dataSource"/>
</bean>

<tx:annotation-driven transaction-manager="transactionManager"/>
```

### 9.6 整合测试

##### 9.6.1 完成User的查询操作

- 创建实体类

```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer userId;
    private String userName;
    private String userPwd;
    private String userRealname;
    private String userImg;
}
```

- 在DAO包中创建接⼝

```java
public interface UserDAO {

    List<User> queryAllUsers();
}
```

- 在mappers 目录下创建映射文件

```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.qfedu.dao.UserDAO">

    <resultMap id="UserMap" type="user">
        <id column="user_id" property="userId"/>
        <result column="user_name" property="userName"/>
        <result column="user_pwd" property="userPwd"/>
        <result column="user_realname" property="userRealname"/>
        <result column="user_img" property="userImg"/>
    </resultMap>

    <select id="queryAllUsers" resultMap="UserMap">
        select user_id,user_name,user_pwd,user_realname,user_img from users;
    </select>
</mapper>
```

##### 9.6.2 对DAO单元测试

- 添加junit、spring-test依赖

```xml
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.12</version>
    <scope>test</scope>
</dependency>
```

- 创建测试类

```java
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-context.xml", "classpath:spring-mvc.xml", "classpath:spring-mybatis.xml"})
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    public void queryAllUsers() {
        List<User> users = userDAO.queryAllUsers();
        System.out.println(users);
    }
}
```

##### 9.6.3 新建service接口及其实现类

- 接口

```java
public interface UserService {
    List<User> listUser();
}
```

- 实现类

```java
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> listUser() {
        return userDAO.queryAllUsers();
    }
}
```

##### 9.6.4 新建controller

```java
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    @ResponseBody
    public List<User> list(){
        return userService.listUser();
    }
}
```
| **运行代码进行测试** |
| --- |
| ![](https://gitee.com/shenzehui/image-repo/raw/master/img/202210051022219.png#alt=image-20220802012520912) |

