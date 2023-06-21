package com.SpringMVC.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.UUID;

//复合注解，意为给类添加@Controller，为类下的每个方法添加@ResponseBody
//@RestController
@Controller
@RequestMapping("/download")
public class DownloadController {

    @RequestMapping("/index")
    public String index(){
        return "downloadIndex";
    }

    @RequestMapping("/img")
    public ResponseEntity<byte[]> getImg(HttpServletRequest request, HttpSession session) throws Exception{
        String filename = request.getParameter("filename");
        //获取ServletContext对象
        ServletContext context = session.getServletContext();
        //获取文件在服务器中的真实路径
        String realPath = context.getRealPath("/static/img/" + filename);
        //创建输入流
        InputStream is = new FileInputStream(realPath);
        //创建字节数组，用当前文件所有字节数创建数组
        byte[] bytes = new byte[is.available()];
        //将流读到字节数组中
        is.read(bytes);
        //创建HttpHeaders对象设置响应头信息
        MultiValueMap<String,String> headers = new HttpHeaders();
        //设置下载方式以及下载文件名
        headers.add("Content-Disposition","attachment;filename=" + filename);
        //设置响应状态码
        HttpStatus statusCode = HttpStatus.OK;
        //创建ResponseEntity对象
        ResponseEntity<byte[]> responseEntity = new ResponseEntity<byte[]>(bytes,headers,statusCode);
        is.close();
        return responseEntity;
    }

    @RequestMapping("/upload")
    public String upload(MultipartFile photo,HttpSession session) throws Exception{
        //获取上传文件的文件名
        String filename = photo.getOriginalFilename();
        //解决文件上传重名导致文件内容被覆盖的问题
        //获取上传的文件的后缀名
        String suffix = filename.substring(filename.lastIndexOf("."));
        //将UUID作为文件名
        String uuid = UUID.randomUUID().toString();
        //获取上传路径
        ServletContext context = session.getServletContext();
        String photoPath = context.getRealPath("photo");
        File file = new File(photoPath);
        if(!file.exists()){
            //若不存在则创建目录
            file.mkdir();
        }
        //File.separator 获取当前系统的文件路径分隔符
        String finalPath = photoPath + File.separator + uuid + suffix;
        photo.transferTo(new File(finalPath));
        return "success";
    }

}
