package com.ikcrm.api.config;

import com.ikcrm.api.utils.PropertiesUtils;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/6/30.
 */
public class URLConfig {
    //接口权限相关
    public static String AUTH_CHECK_USER_TOKEN = PropertiesUtils.getString("auth.checkUserToken");
    //线索相关
    public static String LEADS_QUERY = PropertiesUtils.getString("leads.query");
    public static String LEADS_CREATE = PropertiesUtils.getString("leads.create");
    public static String LEADS_DESTROY = PropertiesUtils.getString("leads.destroy");
    public static String LEADS_EDIT = PropertiesUtils.getString("leads.edit");
    public static String LEADS_DETAIL = PropertiesUtils.getString("leads.detail");
    public static String LEADS_FILTER_SORT_GROUP = PropertiesUtils.getString("leads.filterSortGroup");
    public static String LEADS_FILTER_OPTIONS = PropertiesUtils.getString("leads.filterOptions");
    public static String LEADS_TURN_TO_CUSTOMER = PropertiesUtils.getString("leads.turnToCustomer");
    public static String LEADS_UPDATE_USER = PropertiesUtils.getString("leads.updateUser");
    public static String LEADS_SALES_ACTIVITIES = PropertiesUtils.getString("leads.salesActivities");
    //联系人相关
    public static String CONTACTS_QUERY = PropertiesUtils.getString("contacts.query");
    public static String CONTACTS_CREATE = PropertiesUtils.getString("contacts.create");
    public static String CONTACTS_DESTROY = PropertiesUtils.getString("contacts.destroy");
    public static String CONTACTS_EDIT = PropertiesUtils.getString("contacts.edit");
    public static String CONTACTS_DETAIL = PropertiesUtils.getString("contacts.detail");
    public static String CONTACTS_VALID_MOBILE_CONTACTS = PropertiesUtils.getString("contacts.validMobileContacts");
    public static String CONTACTS_SIMPLEST = PropertiesUtils.getString("contacts.simplest");
    public static String CONTACTS_MISS_CALL_NOTIFY = PropertiesUtils.getString("contacts.missCallNotify");

    //客户相关
    public static String CUSTOMERS_ASSOCIATE_CONTACT = PropertiesUtils.getString("customers.associatedContact");

}
