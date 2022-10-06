package com.szh.ioc.bean;

import java.util.List;

/**
 * @Author szh
 * @Date 2022/7/28 21:37
 * @PackageName:com.szh.ioc.bean
 * @ClassName: Book
 * @Description: TODO
 * @Version 1.0
 */
public class Book {
    private int bookId;
    private String bookName;

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                '}';
    }

    public void init(){
        //初始化方法：在创建当期类对象时调用的方法
        System.out.println("-------init");
        this.bookId = 1;
        this.bookName = "初始值";
    }


    public void destroy(){
        //销毁方法：在Spring容器销毁对象时调用此方法，进行一些资源回收性的操作
        System.out.println("-----destroy");
    }
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
}
