package com.diversite.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.io.IOException;

class WebVisitFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession();
		UserDetails userDetails = (UserDetails) session.getAttribute("user");

		String uri = new String(req.getRequestURI());

		// 放行所有靜態檔案
		if(uri.contains("/css") || uri.contains("/images") || uri.contains("/js")) {
			chain.doFilter(request, response);
			return;
		}

		// 已登入
		if(userDetails != null) {
			System.err.println("Been Login");
			if(uri.contains("/api/users/login") || uri.contains("/api/users/signup")) {
				res.sendRedirect("/");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		// 未登入
		else {
			if(uri.contains("/api/users/login")) {
				chain.doFilter(request, response);
			}
			else {
				res.sendRedirect("/login");
			}
		}
	}

	@Override
	public void destroy() {
	}
}



@Configuration
public class WebVisitFilterConfig {
	@Bean
	public FilterRegistrationBean<Filter> webVisitFilterConfigRegistration() {
		//匹配拦截 URL
		String urlPatterns = "/api/*,/system/*";
		FilterRegistrationBean<Filter> registration = new FilterRegistrationBean<Filter>();
		registration.setDispatcherTypes(DispatcherType.REQUEST);
		registration.setFilter(new WebVisitFilter());
		registration.addUrlPatterns(StringUtils.split(urlPatterns, ","));
		//设置名称
		registration.setName("webVisitFilter");
		//设置过滤器链执行顺序
		registration.setOrder(3);
		//启动标识
		registration.setEnabled(true);
		//添加初始化参数
		registration.addInitParameter("enabel", "true");
		return registration;
	}
}

