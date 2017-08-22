package com.ikcrm.api.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ikcrm.api.common.AuthorizationException;
import com.ikcrm.api.common.ErrorsEnum;
import com.ikcrm.api.common.Result;
import com.ikcrm.api.utils.ResultUtils;
import com.ikcrm.lib.common.model.dto.ApiKey;
import com.ikcrm.lib.common.model.dto.Permission;
import com.ikcrm.lib.common.model.dto.User;
import com.ikcrm.lib.common.service.ApikeyService;
import com.ikcrm.lib.common.service.PermissionService;
import com.ikcrm.lib.common.service.UserService;
import com.ikcrm.lib.common.utils.DateUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/7/3.
 */
public class BaseController {
    private static Logger logger = LoggerFactory.getLogger(BaseController.class);

    @Resource
    ApikeyService apikeyService;

    @Resource
    UserService userService;

    @Resource
    PermissionService permissionService;

    public final static String AUTHORIZATION = "Authorization";
    public final static String LOGIN_USER_ID = "user_id";
    public final static String LOGIN_ORGANIZATION_ID = "organization_id";

    protected Result successDefault(){
        return ResultUtils.successDefault();
    }

    protected Result successObject(Object data){
        return ResultUtils.successObject(data);
    }

    protected Result errorDefault(){
        return ResultUtils.errorDefault();
    }

    protected Result erroe(ErrorsEnum errorsEnum){
        return ResultUtils.erroe(errorsEnum);
    }

    protected Result error(int code,String message){
        return ResultUtils.errorMsg(code,message);
    }

    /**
     * 判断用户是否登陆
     * @return
     */
    private boolean isAuthenticated(HttpServletRequest request,StringBuffer userId) {
        return checkAuthenticatedByHeader(request,userId) || checkAuthenticatedByParam(request,userId);
    }

    private boolean checkAuthenticatedByHeader(HttpServletRequest request,StringBuffer userId) {
        String authorization = request.getHeader(AUTHORIZATION);
        if(StringUtils.isNotEmpty(authorization)){
            //去掉头尾空格
            authorization = authorization.trim();
            //todo  拿到请求头参数进行校验
            String headerArr[] = authorization.split(" ");
            if(headerArr.length ==2 && "Token".equals(headerArr[0])){
                logger.info("Authorization:"+authorization);
                String str = headerArr[1];
                String jsonStr = "{\""+headerArr[1].replace("=","\":").replace(",",",\"")+"}";
                logger.info(jsonStr);
                JSONObject jsonObj = JSON.parseObject(jsonStr);
                Object device = jsonObj.get("device");
                Object version_code = jsonObj.get("version_code");
                Object token = jsonObj.get("token");
                //todo  对设备效验
                if(null == device || !checkDevice((String)device)){
                    throw new AuthorizationException(ErrorsEnum.DEVICE_NOT_AVAILABLE);
                }
                //todo  对token效验
                if(null == token || !checkToken((String)token,userId)){
                    throw new AuthorizationException(ErrorsEnum.LOGIN_EXPIRED);
                }
                return true;
            }
        }
        return false;
    }

    private boolean checkAuthenticatedByParam(HttpServletRequest request,StringBuffer userId) {
        String user_token = request.getParameter("user_token");
        String version_code = request.getParameter("version_code");
        String device = request.getParameter("device");
        //todo 对device进行有效性效验
        if(null == device || !checkDevice(device)){
            throw new AuthorizationException(ErrorsEnum.DEVICE_NOT_AVAILABLE);
        }
        //todo  对参数进行有效性效验
        if(null == user_token || !checkToken(user_token,userId)){
            throw new AuthorizationException(ErrorsEnum.LOGIN_EXPIRED);
        }
        return true;
    }

    /**
     * device有效，返回true
     * @param device
     * @return
     */
    private boolean checkDevice(String device){
        return ( "ios".equals(device) || "android".equals(device) || "dingtalk".equals(device) );
    }

    /**
     * token有效，返回true
     * @param token
     * @return
     */
    private boolean checkToken(String token,StringBuffer userId){
        //todo  对参数进行有效性效验
        ApiKey apikey = apikeyService.getApiKeyByToken(token);
        if(null != apikey){
            userId.append(apikey.getUser_id());
            return true;
        }
//        String url = String.format(URLConfig.AUTH_CHECK_USER_TOKEN, token);
//        String result = HttpUtils.doGet(url);
//        JSONObject json = JSONObject.parseObject(result);
//        if(0 == json.getInteger("code")){
//            if(json.getJSONObject("data").getBoolean(USER_TOKEN_VALID)){
//                userId.append(json.getJSONObject("data").getString(LOGIN_USER_ID));
//                return true;
//            }
//        }
        return false;
    }

    /**
     * 根据user_token 获取用户的userId
     * @param
     * @return
     */
    protected int getUserId(HttpServletRequest request){
        StringBuffer userId = new StringBuffer();
        if(isAuthenticated(request,userId)){
            return Integer.valueOf(userId.toString());
        }else{
            throw new AuthorizationException(ErrorsEnum.USER_NOT_LOGGED_IN);
        }
    }

    /**
     * 根据user_token 获取用户的userId
     * @param
     * @return
     */
    protected int getUserOrganizationIdByUserId(int userId){
        User user = userService.getUserById(userId);
        if(null == user){
            throw new AuthorizationException(ErrorsEnum.USER_NOT_EXIST);
        }else{
            logger.info("用户id:{},用户姓名:{}，用户组织id:{}",new Object[]{userId,user.getName(),user.getOrganization_id()});
            return user.getOrganization_id();
        }
    }

    public Map<String,String> getRequestParamters(HttpServletRequest request) {
        // 获取所有的请求参数
        Map properties = request.getParameterMap();
        // 返回值Map
        Map<String,String> returnMap = new HashMap<String,String>();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        //读取map中的值
        while (entries.hasNext()) {

            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            //全局参数不用传递到服务
            if("user_token".equals(name) || "version_code".equals(name) || "device".equals(name)){
                continue;
            }
            logger.info("name:"+name);
            Object valueObj = entry.getValue();
            if (null == valueObj) {
                value = " ";
            } else if (valueObj instanceof String[]) {
                String[] values = (String[]) valueObj;
                for (int i = 0; i < values.length; i++) {
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length() - 1);
            } else {
                value = valueObj.toString();
            }
            logger.info("value:"+value);
            //将读取到的值存入map中
            returnMap.put(name, value);
            //移除map中为空的参数
            if ("".equals(value)) {
                returnMap.remove(name);
            }
        }

		/*String  userJson = userApi.getUserByLoginName(loginName);
		User user = null;
		Result result = null;
		result = (Result) JSONObject.parse(userJson);
		user = (User) result.getValue();
		returnMap.put("updateby", user.getUserId());
		returnMap.put("createby", user.getUserId());
		returnMap.put("createTime", new Date());
		returnMap.put("updateTime", new Date());
		returnMap.put("companyId", user.getCompanyId());
		returnMap.put("locationId", user.getLocationId());*/
		String requestNumber = DateUtils.formatDate(new Date(),"yyyyMMddHHmmss")+"-"+UUID.randomUUID().toString();
        returnMap.put("requestNumber",requestNumber);
        logger.info("请求外部服务流水号:{}",requestNumber);
		logger.info("params:"+returnMap);
        return returnMap;

    }

    protected void checkAccess(int userId,String subject,String action){
        if(!permissionService.isAccess(userId,subject,action)){
            Permission permission = permissionService.getPermissionBySubjectAndAction(subject,action);
            ErrorsEnum errorsEnum = ErrorsEnum.NO_OPERATION_AUTHORITY;
            errorsEnum.setMessage(String.format(errorsEnum.getMessage(),permission.getName()));
            throw new AuthorizationException(errorsEnum);
        }
    }
}
