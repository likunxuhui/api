package com.ikcrm.api.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/8/10.
 */
@Component
public class ServiceEnv {
    @Value("${contact_base_url}")
    public String contact_base_url;
    @Value("${customer_base_url}")
    public String customer_base_url;
    @Value("${lead_base_url}")
    public String lead_base_url;

    public String getContact_base_url() {
        return contact_base_url;
    }

    public void setContact_base_url(String contact_base_url) {
        this.contact_base_url = contact_base_url;
    }

    public String getCustomer_base_url() {
        return customer_base_url;
    }

    public void setCustomer_base_url(String customer_base_url) {
        this.customer_base_url = customer_base_url;
    }

    public String getLead_base_url() {
        return lead_base_url;
    }

    public void setLead_base_url(String lead_base_url) {
        this.lead_base_url = lead_base_url;
    }
}
