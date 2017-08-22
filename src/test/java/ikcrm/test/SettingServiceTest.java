package ikcrm.test;

import com.alibaba.fastjson.JSONObject;
import com.ikcrm.lib.common.service.SettingService;
import com.ikcrm.lib.common.utils.YamlUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class SettingServiceTest {
    @Resource
    SettingService settingService;

    @Test
    public void test(){
        JSONObject json = YamlUtils.convertToJson(settingService.getSettingByVarAndTargetIdAndTargetType("contact_duplicate_field_config",10357,"Organization").getValue());
        System.out.println(json);
    }
}
