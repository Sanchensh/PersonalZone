package com.mrxu.personalzone.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mrxu.personalzone.entity.User;
import com.mrxu.personalzone.service.UserDAO;
import com.mrxu.personalzone.util.FileHelper;
import static com.mrxu.personalzone.util.Character.$;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDAO userDAO;

    /**
     * 实现登录功能
     * @param userAccount
     * @param userPwd
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value = "userAccount") String userAccount,
                        @RequestParam(value = "userPwd") String userPwd,
                        Model model) {
        //查看是否有该用户
        boolean bool = userDAO.login($(userAccount),$(userPwd));
        if(bool) {
            //一开始就展示分页给用户看，已经实现分页
            page(1,model);
            return "success";
        }
        else {
            model.addAttribute("mes","用户不存在！");
            return "error";
        }
    }

    /**
     * 分页的实现，并且可以刷新页面
     * @param start
     * @param model
     * @return
     */
    @RequestMapping("/page")
    public String getAllUsers(@RequestParam(value = "start",defaultValue = "1")Integer start,Model model){
        page(start,model);
        return "success";
    }

    /**
     * 注册功能的实现
     * @param user
     * @param multipartFile
     * @param model
     * @return
     */
    @RequestMapping("/reg")
    public String reg(User user, MultipartFile multipartFile, Model model) {
        //判断该用户账号是否已经存在，存在就返回错误页面
        if(userDAO.isHasAccount($(user.getUserAccount()))) {
            model.addAttribute("mes","账户已经存在，不能重新注册！");
            return "error";
        }
        //如果文件存在
        if(!multipartFile.isEmpty()) {
            //设置文件存储路径
            String relativePath = "img/UserPhoto";
            //得到fileHelper对象
            FileHelper fileHelper = new FileHelper();
            //保存图片
            String realPath = fileHelper.upload(relativePath,multipartFile);
            //设置图片路径
             if(realPath != "")
                user.setUserPhoto(realPath);
             else
                 System.out.println("图片插入失败！");
        }
        else
            System.out.println("图片不存在或没插入成功！");
        //向数据库中添加该用户，提前设置编码
        user.setUserAccount($(user.getUserAccount()));
        user.setUserName($(user.getUserName()));
        user.setUserSex($(user.getUserSex()));
        //不存在该用户则直接注册
        if(userDAO.regUser(user))
            //重定向到登录页面
            return "redirect:/index.jsp";
        return "error";
    }

    /**
     * 删除用户
     * @param userID
     * @param start
     * @param model
     * @return
     */
    @RequestMapping("/delete")
    public String deleteUser(@RequestParam("userID")String userID,
                             @RequestParam(value = "start",defaultValue = "1")Integer start,
                             Model model){
        boolean bool = userDAO.deleteUser(userID);
        if(bool){
            page(start,model);
            return "success";
        }
        else {
            model.addAttribute("mes","删除用户失败！");
            return "error";
        }
    }

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String updateUser(User user,Model model){
        boolean bool = userDAO.updateUser(user);
        if(bool){
            return "success";
        }
        else {
            model.addAttribute("mes","修改用户失败！");
            return "error";
        }
    }

    /**
     * 模糊查询
     * @param userName
     * @param start
     * @param model
     * @return
     */
    @RequestMapping("/find")
    public String find(@RequestParam("userName")String userName,
                       @RequestParam(value = "start",defaultValue = "1")Integer start,
                       Model model){
        PageHelper.startPage(start,5);
        List<User> list = userDAO.find($(userName),"");
        PageInfo<User> pageInfo = new PageInfo<User>(list,5);
        model.addAttribute("pageInfo", pageInfo);
        return "success";
    }
    /**
     * 实现分页的方法
     * @param start
     * @param model
     */
    public void page(Integer start, Model model){
        PageHelper.startPage(start,5);
        List<User> list = userDAO.getAllUser();
        PageInfo<User> pageInfo = new PageInfo<User>(list,5);
        model.addAttribute("pageInfo", pageInfo);
    }
}
