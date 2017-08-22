package com.mrxu.personalzone.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class FileHelper {
    /**
     * 将文件写入指定的文件夹
     * 物理地址一份文件，tomcat中也有一份文件
     * 防止tomcat重启时删除所有的文件
     * @param file
     * @param relativePath
     * @return 返回文件的相对路径（带文件名）
     */
    public String upload(String relativePath ,MultipartFile file){
        String newName = fileName(file);//得到文件名
        //获取物理地址的前半部分
        String absolutePath = "C:\\Users\\xjl19\\IdeaProjects\\PersonalZone\\src\\main\\webapp\\";
        //获取绝对地址
        String path = absolutePath + relativePath + "/";
        //创建一个新的文件
        File newFile = new File(path,newName);
        try {
            //向文件中写入数据
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //将文件复制到tomcat容器中
        String webPath = "C:\\My Apps\\apache-tomcat-9.0.0.M22\\webapps\\ROOT\\";
        String webRealPath = webPath + relativePath + "/";
        try {
            FileInputStream fis = new FileInputStream(path + newName);
            FileOutputStream fos = new FileOutputStream(webRealPath + newName);
            byte[] bytes = new byte[1024];
            int point = 0;
            while ((point = fis.read(bytes)) != -1){
                fos.write(bytes,0,point);
            }
            fos.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //如果文件成功的写入，则返回true
        if(new File(path+newName).exists())
            return relativePath + "/" + newName;
        else
            return "";
    }

    /**
     * 获取并重新命名文件
     * @param file
     * @return 返回文件的新名字
     */
    public String fileName(MultipartFile file){
        //得到原始文件名
        String origName = file.getOriginalFilename();
        //新名字
        String newName = UUID.randomUUID().toString().replaceAll("-","") + origName.substring(origName.lastIndexOf("."));
        return newName;
    }

    /**
     * 删除文件，同时删除服务器中的文件
     * @param  relativePath
     * @return 成功刪除文件返回true
     */
    public boolean deleteFile(String relativePath){
        //获取物理地址的前半部分
        String absolutePath = "C:\\Users\\xjl19\\IdeaProjects\\PersonalZone\\src\\main\\webapp\\";
        //获取绝对地址
        String path = absolutePath + relativePath;
        File file = new File(path);

        String webPath = "C:\\My Apps\\apache-tomcat-9.0.0.M22\\webapps\\ROOT\\";
        String webRealPath = webPath + relativePath;
        File webFile = new File(webRealPath);

        if (file.exists() && webFile.exists())
            return file.delete() && webFile.delete();
        else
            return false;
    }
}
