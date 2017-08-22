package com.ikcrm.api.controller;

import com.ikcrm.api.common.AuthorizationException;
import com.ikcrm.api.common.ErrorsEnum;
import com.ikcrm.api.common.ServiceEnv;
import com.ikcrm.api.config.URLConfig;
import com.ikcrm.lib.common.common.ConstantStatic;
import com.ikcrm.lib.common.utils.HttpUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 联系人相关
 * Created by likun(li.k@ikcrm.com) on 2017/7/4.
 */
@Controller
@RequestMapping(value="/api/v2/contacts")
public class ContactsController extends BaseController {

    @Resource
    ServiceEnv serviceEnv;

    private static Logger logger = LoggerFactory.getLogger(ContactsController.class);
    private static final String SUBJECT = ConstantStatic.PERMISSION_SUBJECT_CONTACT;
    private static final String CUSTOMER_SUBJECT = ConstantStatic.PERMISSION_SUBJECT_CUSTOMER;

    @ResponseBody
    @RequestMapping("/test")
    public Object test(){
        System.out.println("in contacts test method...");
        return successDefault();
    }

    /**
     * 全部列表页
     * @return
     */
    @ResponseBody
    @RequestMapping(value="",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object queryAll(HttpServletRequest request){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            checkAccess(userId, CUSTOMER_SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_QUERY;
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

    /**
     * simplest联系人列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/simplest",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object simplest(HttpServletRequest request){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_SIMPLEST;
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

    /**
     * 返回具有有效电话号码的联系人列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/valid_mobile_contacts",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object validMobileContacts(HttpServletRequest request){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_VALID_MOBILE_CONTACTS;
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

    /**
     * 新建联系人
     * @return
     */
    @ResponseBody
    @RequestMapping(value="",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Object add(HttpServletRequest request, @RequestBody String data){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_CREATE);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_CREATE;
            String result = HttpUtils.doPostWithMapAndContext(url,paramMap,data);
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

    /**
     * 更新联系人
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = {RequestMethod.PATCH,RequestMethod.PUT},produces = "application/json;charset=UTF-8")
    public Object update(HttpServletRequest request, @PathVariable String id, @RequestBody String data){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_EDIT);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("contact_id",id);
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_EDIT;
            String result = HttpUtils.doPostWithMapAndContext(url,paramMap,data);
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

    /**
     * 联系人详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object single(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            checkAccess(userId, CUSTOMER_SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("contact_id",id);
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_DETAIL;
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

    /**
     * 推送来电通知
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/miss_call_notify",method = {RequestMethod.PUT},produces = "application/json;charset=UTF-8")
    public Object missCallNotify(HttpServletRequest request,@PathVariable String id){


        return "add";
    }

    /**
     * 删除单条数据
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    public Object delete(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_DESTROY);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("contact_id",id);
            String url =serviceEnv.getContact_base_url()+ URLConfig.CONTACTS_DESTROY;
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
