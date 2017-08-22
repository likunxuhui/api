package com.ikcrm.api.controller;

import com.ikcrm.api.common.AuthorizationException;
import com.ikcrm.api.common.ErrorsEnum;
import com.ikcrm.api.common.ServiceEnv;
import com.ikcrm.api.config.Config;
import com.ikcrm.api.config.URLConfig;
import com.ikcrm.lib.common.common.ConstantStatic;
import com.ikcrm.lib.common.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 客户相关
 * Created by Administrator on 2017/6/29.
 */
@Controller
@RequestMapping(value="/api/v2/customers")
public class CustomersController extends BaseController{

    @Resource
    ServiceEnv serviceEnv;

    private static Logger logger = LoggerFactory.getLogger(CustomersController.class);
    private static final String SUBJECT = ConstantStatic.PERMISSION_SUBJECT_CUSTOMER;
    @ResponseBody
    @RequestMapping("/test")
    public Object test(){
        System.out.println("in customers test method...");
        return successDefault();
    }

    @ResponseBody
    @RequestMapping(value="/{id}/contacts",method = {RequestMethod.GET},produces = "application/json;charset=UTF-8")
    public Object getCustomerAssociatedContact(HttpServletRequest request, @PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //这个接口看的是是否有查看联系人的权限
            checkAccess(userId, ConstantStatic.PERMISSION_SUBJECT_CUSTOMER,ConstantStatic.PERMISSION_ACTION_SHOW);
            checkAccess(userId, ConstantStatic.PERMISSION_SUBJECT_CONTACT,ConstantStatic.PERMISSION_ACTION_SHOW);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("customer_id",id);
            String url =serviceEnv.getCustomer_base_url()+ URLConfig.CUSTOMERS_ASSOCIATE_CONTACT;
            String result = HttpUtils.doGetWithMap(url,paramMap);
            if(StringUtils.isNotEmpty(result)){
                return result;
            }else{
                throw new AuthorizationException(ErrorsEnum.REQUEST_SERVICE_ERROR);
            }
        }catch (AuthorizationException e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return error(e.getCode(),e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.getMessage());
            return errorDefault();
        }
    }
}
