package com.example.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数，获取下载文件名称
        String filename = req.getParameter("filename");
        //获取文件的真实路径
        ServletContext sc = this.getServletContext();
        String realPath = sc.getRealPath("/img/" + filename);
        //设置response响应头
        //设置响应头类型
        String mimeType = sc.getMimeType(filename);
        resp.setContentType(mimeType);
        resp.setHeader("content-disposition","attachment;filename=" + filename);

        //使用自己节流将文件读入内存，并用放入输出流
        FileInputStream fis = new FileInputStream(realPath);
        BufferedInputStream bis = new BufferedInputStream(fis);
        ServletOutputStream sos = resp.getOutputStream();
        byte[] c = new byte[1024];
        int len = 0;
        while ((len = bis.read(c)) != -1) {
            sos.write(c, 0, len);
        }
    }
}
