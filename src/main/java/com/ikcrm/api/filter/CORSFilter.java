package com.ikcrm.api.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by likun(li.k@ikcrm.com) on 2017/8/8.
 */
public class CORSFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(CORSFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String path = req.getContextPath();//当前工程名
        logger.info("******进入CORSFilter拦截器处理跨域访问问题*****");
        logger.info("请求路径：{},请求方式：{}",req.getRequestURI().substring(path.length()+1),req.getMethod());
        HttpServletResponse res = (HttpServletResponse) response;
        //res.setContentType("application/json;charset=UTF-8");
        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT");
        res.setHeader("Access-Control-Max-Age", "0");
        res.setHeader("Access-Control-Allow-Headers", "X-OPERATE-AUTH-CODE, Authorization, Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        res.setHeader("Access-Control-Allow-Credentials", "true");
        res.setHeader("XDomainRequestAllowed","1");
        chain.doFilter(request, response);
        logger.info("******CORSFilter拦截器处理完成*****");
        logger.info("------------------------------************************------------------------");
    }
    @Override
    public void init(FilterConfig filterConfig) {}
    @Override
    public void destroy() {}
}
