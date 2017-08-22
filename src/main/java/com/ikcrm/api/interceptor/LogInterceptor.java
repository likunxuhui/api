package com.ikcrm.api.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.Map;


public class LogInterceptor implements HandlerInterceptor{

	private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
	private long st=0;

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object arg2, Exception arg3)
					throws Exception {
		String path = request.getContextPath();//当前工程名
		String info=	" 请求处理完成--> 请求URL："+request.getRequestURI().substring(path.length()+1)+" 耗时:"+(System.currentTimeMillis()-st+" ms");
		logger.info(arg2.getClass()+(info));

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		/*arg1.addHeader("Access-Control-Allow-Origin", "*");
		arg1.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
		arg1.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
		arg1.addHeader("Access-Control-Max-Age", "1728000");*/
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse arg1,
			Object handler) throws Exception {
		st=System.currentTimeMillis();
		String path = request.getContextPath();//当前工程名
		StringBuilder sb=new StringBuilder();
		sb.append("***********参数:");
		Map<String, String[]> params = request.getParameterMap();
		for(String key : params.keySet()) {
			Object value = params.get(key);
			if(value instanceof String[]){
				String[] o=(String[])value;
				for(int i=0;i<o.length;i++){
					sb.append(key+"-->"+URLDecoder.decode(o[i],"utf-8")+" , ");
				}
			}
		}
		logger.info(handler.getClass()+(" 请求处理开始-->"+"请求方式："+request.getMethod()+" 请求URL："+request.getRequestURI().substring(path.length()+1)+" "+sb.toString()));
		return true;  
	}

}
