package com.mrxu.personalzone.controller;

import com.mrxu.personalzone.util.FileHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

    @RequestMapping("/upload")
    public String file(Model model,@RequestParam("file")MultipartFile multipartFile){
        //设置文件存储路径
        String relativePath = "img/UserPhoto";
        //得到fileHelper对象
        FileHelper fileHelper = new FileHelper();
        String realPath = fileHelper.upload(relativePath,multipartFile);
        System.out.println(realPath);
        if(realPath != ""){
            model.addAttribute("realPath",realPath);
            return "success";
        }
        else
            return "error";
    }
}
