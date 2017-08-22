package ikcrm.test;

import com.alibaba.fastjson.JSONObject;
import com.ikcrm.lib.common.service.FieldService;
import com.ikcrm.lib.common.utils.YamlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class FieldServiceTest {
    @Resource
    FieldService fieldService;

    @Test
    public void test(){
        ;
        //System.out.println(fieldService.getFieldValueListByFieldMapId(1));

        System.out.println(fieldService.getFieldMapByOrganizationIdAndKlassNameAndfieldName(1,"Lead","source"));

    }
}
