package org.cloudfoundry.identity.uaa.servicebroker.config;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class WebXml extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}

//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        super.onStartup(servletContext);
//
//        registerProxyFilter(servletContext, "springSecurityFilterChain");
//        registerProxyFilter(servletContext, "oauth2ClientContextFilter");
//    }
//
//    private void registerProxyFilter(ServletContext servletContext, String name) {
//        DelegatingFilterProxy filter = new DelegatingFilterProxy(name);
//        filter.setContextAttribute("org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher");
//        servletContext.addFilter(name, filter).addMappingForUrlPatterns(null, false, "/*");
//    }
}