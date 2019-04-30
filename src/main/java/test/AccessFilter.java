package test;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class AccessFilter extends ZuulFilter{

	private final Logger logger  = Logger.getLogger(getClass());
	
	public Object run() {
		RequestContext ctx= RequestContext.getCurrentContext();
		HttpServletRequest rq= ctx.getRequest();
		logger.info("进来过滤器了");
		String name = rq.getParameter("name");
		if (StringUtils.isEmpty(name)) {
			logger.info("name为空拦截请求");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		logger.info("OK --- name:"+name);
		return null;
	}

	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

}
