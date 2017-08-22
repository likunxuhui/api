package ikcrm.test;

import com.alibaba.fastjson.JSONObject;
import com.ikcrm.lib.common.common.ConstantStatic;
import com.ikcrm.lib.common.service.PermissionService;
import com.ikcrm.lib.common.utils.YamlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class PermissionServiceTest {
    @Resource
    PermissionService permissionService;

    @Test
    public void test(){
        System.out.println(permissionService.isAccess(21619, ConstantStatic.PERMISSION_SUBJECT_CONTACT,ConstantStatic.PERMISSION_ACTION_EDIT));
    }

    @Test
    public void test2(){
        System.out.println(permissionService.getPermissionBySubjectAndAction( ConstantStatic.PERMISSION_SUBJECT_CONTACT,ConstantStatic.PERMISSION_ACTION_EDIT));
    }
}
