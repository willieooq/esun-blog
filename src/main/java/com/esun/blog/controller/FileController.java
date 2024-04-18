package com.esun.blog.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class FileController {
    private static final String UPLOAD_FOLDER = System.getProperty("user.dir") +
            "/src/main/resources/static/uploads/";

    @PostMapping("/upload")
    public String upload(String userName, MultipartFile photo, HttpServletRequest request) throws IOException {
        // 圖片名稱
        System.out.println(userName + ": " + photo.getOriginalFilename());
        // 文件類型
        System.out.println(photo.getContentType());
        // 路徑
        String path = request.getServletContext().getRealPath("/uploads/");
        System.out.println(path);
        saveFile(photo, path);
        return "上傳成功";
    }

    public void saveFile(MultipartFile photo, String path) throws IOException {
        File dir = new File(path);
        // 沒目錄 創建
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File file = new File(path, photo.getOriginalFilename());
        photo.transferTo(file);
    }
}
