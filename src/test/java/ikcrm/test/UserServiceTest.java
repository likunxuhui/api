package ikcrm.test;

import com.ikcrm.lib.common.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class UserServiceTest {
    @Resource
    UserService userService;

    @Test
    public void test(){
        System.out.println(userService.getUserById(1));
    }

    @Test
    public void test1(){
        System.out.println(userService.getOperateUserIds(0,1));
    }
}
