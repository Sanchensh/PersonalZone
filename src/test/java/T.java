import com.mrxu.personalzone.dao.UserMapper;
import com.mrxu.personalzone.entity.User;
import com.mrxu.personalzone.util.FileHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class T {

    @Test
    public void testFindUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        System.out.println(userMapper.findUser("徐江雷","123"));
    }
    @Test
    public void del(){
        FileHelper fileHelper = new FileHelper();
        System.out.println(fileHelper.deleteFile("img/UserPhoto/fe8349e043d64d0085f8c3c8b29cbff0.jpg"));
    }
    @Test
    public void insertUser(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        UserMapper userMapper = (UserMapper)ac.getBean("userMapper");
        User user = new User();
        user.setUserAccount("李晓");
        user.setUserPwd("123");
        user.setUserName("李晓");
        user.setUserMobil("1234455555");
        System.out.println(userMapper.insertUser(user));
    }
    @Test
    public void isHasAccount(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring-config.xml");
        UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
        System.out.println(userMapper.isHasAccount("管理员"));
    }

    @Autowired
    UserMapper userMapper;

    @Autowired
    SqlSession sqlSession;

    @Test
    public void t(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        for (int i = 0 ;i<50;i++)
            mapper.insertUser(new User("徐" + i,"123","江雷","img/UserPhoto/47b4c5987bf84f8e90d7b77f78496917.jpg","男","15927893520"));
    }
}