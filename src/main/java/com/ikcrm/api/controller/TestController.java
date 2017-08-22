package com.ikcrm.api.controller;

import com.alibaba.fastjson.JSONObject;
import com.ikcrm.api.common.ErrorsEnum;
import com.ikcrm.api.common.AuthorizationException;
import com.ikcrm.api.common.ServiceEnv;
import com.ikcrm.api.utils.PropertiesUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/29.
 */
@Controller
@RequestMapping(value="/test")
public class TestController extends BaseController{

    @Resource
    ServiceEnv serviceEnv;

    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping("resource")
    public Object version(HttpServletRequest request){
        return successObject(serviceEnv);

    }

    @ResponseBody
    @RequestMapping("add")
    public Object add(HttpServletRequest request){
        try{
            Map paramMap = getRequestParamters(request);
            paramMap.put(LOGIN_USER_ID,getUserId(request));
            logger.info("params:"+paramMap);
            int loginUserId = getUserId(request);
            logger.info("login_user_id:"+loginUserId);
            return successDefault();
        }catch (AuthorizationException e){
            logger.error(e.getMessage());
            return error(e.getCode(),e.getMessage());
        }catch (Exception e){
            logger.error(e.getMessage());
            return errorDefault();
        }
    }

    @ResponseBody
    @RequestMapping(value = "success")
    public Object success(){
        return "哈哈哈";
    }
    @ResponseBody
    @RequestMapping("success1")
    public Object success1(){
        List<Map> list = new ArrayList<Map>();
        Map map1 = new HashMap();
        map1.put("name",20);
        map1.put(20,"奶奶来年");
        Map map2 = new HashMap();
        map2.put("name",20);
        map2.put(20,"age");
        list.add(map1);
        list.add(map2);
        return successObject(list);
    }

    @ResponseBody
    @RequestMapping("error")
    public Object error(){
        return errorDefault();
    }

    @ResponseBody
    @RequestMapping("error1")
    public Object error1(){
        return erroe(ErrorsEnum.REQUEST_SERVICE_ERROR);
    }

    @ResponseBody
    @RequestMapping("error2")
    public Object error2(){
        return error(401,"权限不足");
    }

    @ResponseBody
    @RequestMapping(value = "test",produces = "application/json;charset=UTF-8")
    public Object test(){
        return "{\"contact\":{\"customer_id\":\"89046\",\"name\":\"联系人1\",\"text_asset_33ec0d5e\":\"sel_e0f0\",\"gender\":\"male\",\"department\":\"销售部\",\"job\":\"小组长\",\"address\":{\"tel\":\"13122563232\",\"phone\":\"13122563235\",\"wechat\":\"11111111\",\"qq\":\"22222222\",\"wangwang\":\"33333333\",\"email\":\"te@qq.com\",\"url\":\"http://www.baidu.com\",\"province_id\":9,\"city_id\":73,\"tag\":\"-\",\"city_display_data\":\"上海-上海市-浦东新区\",\"district_id\":732,\"province\":{\"id\":9,\"name\":\"上海\",\"country_id\":4,\"sub\":[{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]}]},\"city\":{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]},\"district\":{\"id\":732,\"name\":\"浦东新区\"},\"detail_address\":\"浦东软件园Y1座515室\",\"lng\":121.60262346267703,\"lat\":31.198880713554242,\"zip\":\"432566\"},\"text_asset_426ca268\":\"13122563333\",\"numeric_asset_f9c46c79\":450,\"numeric_asset_0dfed558\":12.5,\"numeric_asset_ce10d8\":280,\"text_asset_9d118775\":\"嘿嘿\",\"text_asset_0a285956\":\"text@qq.com\",\"birth_date\":\"2017-07-11\",\"note\":\"这是备注\",\"datetime_asset_96f594e2\":\"2017-07-12 16:54\",\"address_attributes\":{\"tel\":\"13122563232\",\"phone\":\"13122563235\",\"wechat\":\"11111111\",\"qq\":\"22222222\",\"wangwang\":\"33333333\",\"email\":\"te@qq.com\",\"url\":\"http://www.baidu.com\",\"province_id\":9,\"city_id\":73,\"tag\":\"-\",\"city_display_data\":\"上海-上海市-浦东新区\",\"district_id\":732,\"province\":{\"id\":9,\"name\":\"上海\",\"country_id\":4,\"sub\":[{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]}]},\"city\":{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]},\"district\":{\"id\":732,\"name\":\"浦东新区\"},\"detail_address\":\"浦东软件园Y1座515室\",\"lng\":121.60262346267703,\"lat\":31.198880713554242,\"zip\":\"432566\"}}}";
    }

    @ResponseBody
    @RequestMapping(value = "test1" ,produces = "application/json;charset=UTF-8")
    public Object test1(){
        String s =  "{\"contact\":{\"customer_id\":\"89046\",\"name\":\"联系人1\",\"text_asset_33ec0d5e\":\"sel_e0f0\",\"gender\":\"male\",\"department\":\"销售部\",\"job\":\"小组长\",\"address\":{\"tel\":\"13122563232\",\"phone\":\"13122563235\",\"wechat\":\"11111111\",\"qq\":\"22222222\",\"wangwang\":\"33333333\",\"email\":\"te@qq.com\",\"url\":\"http://www.baidu.com\",\"province_id\":9,\"city_id\":73,\"tag\":\"-\",\"city_display_data\":\"上海-上海市-浦东新区\",\"district_id\":732,\"province\":{\"id\":9,\"name\":\"上海\",\"country_id\":4,\"sub\":[{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]}]},\"city\":{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]},\"district\":{\"id\":732,\"name\":\"浦东新区\"},\"detail_address\":\"浦东软件园Y1座515室\",\"lng\":121.60262346267703,\"lat\":31.198880713554242,\"zip\":\"432566\"},\"text_asset_426ca268\":\"13122563333\",\"numeric_asset_f9c46c79\":450,\"numeric_asset_0dfed558\":12.5,\"numeric_asset_ce10d8\":280,\"text_asset_9d118775\":\"嘿嘿\",\"text_asset_0a285956\":\"text@qq.com\",\"birth_date\":\"2017-07-11\",\"note\":\"这是备注\",\"datetime_asset_96f594e2\":\"2017-07-12 16:54\",\"address_attributes\":{\"tel\":\"13122563232\",\"phone\":\"13122563235\",\"wechat\":\"11111111\",\"qq\":\"22222222\",\"wangwang\":\"33333333\",\"email\":\"te@qq.com\",\"url\":\"http://www.baidu.com\",\"province_id\":9,\"city_id\":73,\"tag\":\"-\",\"city_display_data\":\"上海-上海市-浦东新区\",\"district_id\":732,\"province\":{\"id\":9,\"name\":\"上海\",\"country_id\":4,\"sub\":[{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]}]},\"city\":{\"id\":73,\"name\":\"上海市\",\"sub\":[{\"id\":720,\"name\":\"黄浦区\"},{\"id\":721,\"name\":\"卢湾区\"},{\"id\":722,\"name\":\"徐汇区\"},{\"id\":723,\"name\":\"长宁区\"},{\"id\":724,\"name\":\"静安区\"},{\"id\":725,\"name\":\"普陀区\"},{\"id\":726,\"name\":\"闸北区\"},{\"id\":727,\"name\":\"虹口区\"},{\"id\":728,\"name\":\"杨浦区\"},{\"id\":729,\"name\":\"宝山区\"},{\"id\":730,\"name\":\"闵行区\"},{\"id\":731,\"name\":\"嘉定区\"},{\"id\":732,\"name\":\"浦东新区\"},{\"id\":733,\"name\":\"金山区\"},{\"id\":734,\"name\":\"松江区\"},{\"id\":735,\"name\":\"青浦区\"},{\"id\":736,\"name\":\"南汇区\"},{\"id\":737,\"name\":\"奉贤区\"},{\"id\":738,\"name\":\"崇明县\"}]},\"district\":{\"id\":732,\"name\":\"浦东新区\"},\"detail_address\":\"浦东软件园Y1座515室\",\"lng\":121.60262346267703,\"lat\":31.198880713554242,\"zip\":\"432566\"}}}";
        return JSONObject.parse(s);
    }
}
