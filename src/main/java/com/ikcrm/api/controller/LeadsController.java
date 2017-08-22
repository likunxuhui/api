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
 * 线索相关
 * Created by Administrator on 2017/6/29.
 */
@Controller
@RequestMapping(value="/api/v2/leads")
public class LeadsController extends BaseController{
    private static Logger logger = LoggerFactory.getLogger(LeadsController.class);
    private static final String SUBJECT = ConstantStatic.PERMISSION_SUBJECT_LEAD;

    @Resource
    ServiceEnv serviceEnv;

    @ResponseBody
    @RequestMapping("/test")
    public Object test(){
        System.out.println("in leads test method...");
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
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put("userId",String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_QUERY;
            String result =  HttpUtils.doGetWithMap(url,paramMap);
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
     * 线索tab页数量
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/util_counts",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object utilCounts(HttpServletRequest request,@PathVariable String id){


        return "add";
    }

    /**
     * 线索列表by_name
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/by_name",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object queryByName(HttpServletRequest request){


        return "add";
    }

    /**
     * 筛选条件
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/filter_sort_group",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object filterSortGroup(HttpServletRequest request){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_FILTER_SORT_GROUP;
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
     * 筛选条件选项
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{field_name}/filter_options",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object filterOptions(HttpServletRequest request,@PathVariable String field_name){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("field_name",field_name);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_FILTER_OPTIONS;
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
     * 线索详情
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object single(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_SHOW);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_DETAIL;
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
     * 线索转客户
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/turn_to_customer",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object turnToCustomer(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_TURN_TO_CUSTOMER);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_TURN_TO_CUSTOMER;
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
     * 创建线索
     * @return
     */
    @ResponseBody
    @RequestMapping(value="",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public Object add(HttpServletRequest request, @RequestBody String data){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_CREATE);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_CREATE;
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
     * 更新线索
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = {RequestMethod.PATCH,RequestMethod.PUT},produces = "application/json;charset=UTF-8")
    public Object update(HttpServletRequest request,@PathVariable String id,@RequestBody String data){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_EDIT);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_EDIT;
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
     * 线索转他人
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/update_user",method = RequestMethod.PUT,produces = "application/json;charset=UTF-8")
    public Object updateUser(HttpServletRequest request,@PathVariable String id,@RequestBody String data){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_TRANSFER);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_UPDATE_USER;
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
     * 删除线索
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}",method = RequestMethod.DELETE,produces = "application/json;charset=UTF-8")
    public Object delete(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            //效验权限
            checkAccess(userId, SUBJECT,ConstantStatic.PERMISSION_ACTION_DESTROY);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_DESTROY;
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
     * 线索动态
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/sales_activities",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object salesActivities(HttpServletRequest request,@PathVariable String id){
        try{
            Map paramMap = getRequestParamters(request);
            int userId = getUserId(request);
            int organization_id = getUserOrganizationIdByUserId(userId);
            paramMap.put(LOGIN_USER_ID,String.valueOf(userId));
            paramMap.put(LOGIN_ORGANIZATION_ID,String.valueOf(organization_id));
            paramMap.put("lead_id",id);
            String url =serviceEnv.getLead_base_url()+ URLConfig.LEADS_SALES_ACTIVITIES;
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
     * 全景
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/panorama",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object panorama(HttpServletRequest request,@PathVariable String id){
        return "add";
    }

    /**
     * 销售团队
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/{id}/sales_team",method = RequestMethod.GET,produces = "application/json;charset=UTF-8")
    public Object salesTeam(HttpServletRequest request,@PathVariable String id){
        return "add";
    }

}
