package com.ikcrm.api.config;

import com.ikcrm.api.utils.PropertiesUtils;

/**
 * 配合测试的信息(只是为了目前测试，后续应该是没用)
 * Created by likun(li.k@ikcrm.com) on 2017/8/1.
 */
public class Config {
    public static String USER_TOKEN = PropertiesUtils.getString("user_token");
    public static String VERSION_CODE = PropertiesUtils.getString("version_code");
    public static String DEVICE = PropertiesUtils.getString("device");
    public static String ENVIROMENTAL = PropertiesUtils.getString("environmental");
}
