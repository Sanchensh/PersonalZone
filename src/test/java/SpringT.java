import com.github.pagehelper.PageInfo;
import com.mrxu.personalzone.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring-config.xml","classpath:spring-mvc-config.xml"})
public class SpringT {
    @Autowired
    WebApplicationContext context;
    MockMvc mockMvc;
    @Before
    public void initMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //        模拟请求,拿到返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/page").param("start","1")).andReturn();
        //    请求成功后，请求域中有pageInfo，我们可以取出pageinfo进行验证
        MockHttpServletRequest request = result.getRequest();
        PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+pageInfo.getPageNum());
        System.out.println("总页码"+pageInfo.getPages());
        System.out.println("总记录数"+pageInfo.getTotal());
        System.out.println("在页面需要连续显示的页码");
        int[] nums=pageInfo.getNavigatepageNums();
        for (int i: nums) {
            System.out.println(" "+i);
        }
        //获取员工数据
        List<User> list = pageInfo.getList();
        for (User user: list) {
            System.out.println("ID   " + user.getUserID()+"    name    " +user.getUserName());
        }
    }
}