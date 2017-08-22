package ikcrm.test;

import com.ikcrm.lib.common.service.CustomFieldService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/8/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class CustomFieldServiceTest {
    @Resource
    CustomFieldService customrFieldService;

    @Test
    public void test(){
        System.out.println(customrFieldService.getCustomFieldListBymodelKlassAndOrganizationId("Lead",10357).size());
    }


    @Test
    public void test1(){
        System.out.println(customrFieldService.getFixedFieldListBymodelKlassAndOrganizationId("Lead",10357).size());
    }

    @Test
    public void test2(){
        System.out.println(customrFieldService.getFieldListBymodelKlassAndOrganizationId("Lead",10357).size());
    }


}
