package com.wicky.demo;

import java.io.File;
import java.util.Properties;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.plugin.ehcache.EhCachePlugin;
import com.jfinal.render.ViewType;
import com.jfinal.weixin.sdk.api.ApiConfigKit;

public class Config extends JFinalConfig {

	public Properties loadProp(String pro, String dev) {
		try {
			return loadPropertyFile(pro);
		} catch (Exception e) {
			try {
				return loadPropertyFile(new File(pro));
			} catch (Exception e2) {
				return loadPropertyFile(dev);
			}
		}
	}
	
    public void configConstant(Constants me) {
    	loadProp(System.getProperty("user.dir") + "/a_little_config_pro.txt", "a_little_config.txt");
        me.setViewType(ViewType.JSP);
        me.setDevMode(true);
        ApiConfigKit.setDevMode(me.getDevMode());
    }

    public void configRoute(Routes me) {
        me.add(new FrontRoutes());
        me.add(new AdminRoutes());
        me.add(new WeixinRoutes());
    }

    public void configPlugin(Plugins me) {
		// C3p0Plugin c3p0Plugin = new C3p0Plugin(getProperty("jdbcUrl"), getProperty("user"), getProperty("password").trim());
		// me.add(c3p0Plugin);
		
		EhCachePlugin ecp = new EhCachePlugin();
		me.add(ecp);
    }

    public void configInterceptor(Interceptors me) {
    	me.add(new DemoInterceptor());
    }

    public void configHandler(Handlers me) {
    	me.add(new UrlSkipHandler());
    }
}
