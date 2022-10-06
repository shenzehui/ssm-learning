package com.szh.controller;

import com.szh.bean.Book;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author szh
 * @Date 2022/8/1 13:33
 * @PackageName:com.szh.controller
 * @ClassName: BookController
 * @Description: TODO
 * @Version 1.0
 */
@Controller
@RequestMapping("/book")
public class BookController {

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addBook(Book book, MultipartFile imgFile, HttpServletRequest request) throws IOException {
        String oldFileName = imgFile.getOriginalFilename();
        String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.indexOf(".")); //.jpg
        String realPath = request.getServletContext().getRealPath("imgs");
        File file = new File(realPath + "/" + newFileName);
        if (!file.exists()) {
            file.mkdirs();
        }
        imgFile.transferTo(file);
        book.setImgUrl("imgs/" + newFileName);
        System.out.println("---------");
        return "/tips.jsp";
    }

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

    @RequestMapping("/download")
    public void downloadImg(String fileName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String realPath = request.getServletContext().getRealPath("imgs");
        String filePath = realPath + "/" + fileName;
        InputStream inputStream = new FileInputStream(filePath);
        response.setContentType("application/exe");
        response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @RequestMapping("/query")
    public String query(String id){
        int i = Integer.parseInt(id);
        return "/tips.jsp";
    }
}
