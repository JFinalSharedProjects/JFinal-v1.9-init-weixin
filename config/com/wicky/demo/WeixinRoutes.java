package com.wicky.demo;

import com.jfinal.config.Routes;

public class WeixinRoutes extends Routes {

    @Override
    public void config() {
        add("/msg", WMsgController.class);
        add("/api", WApiController.class);
    }

}
