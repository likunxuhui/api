package ikcrm.test;

import com.ikcrm.lib.common.service.AddressService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class AddressServiceTest {
    @Resource
    AddressService addressService;

    @Test
    public void test(){
        System.out.println(addressService.getCountryById(4));
    }

    @Test
    public void test2(){
        System.out.println(addressService.getProvincesByCountryId(4));
    }
}
