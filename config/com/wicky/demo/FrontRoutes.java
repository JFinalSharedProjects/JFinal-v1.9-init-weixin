package com.wicky.demo;

import com.jfinal.config.Routes;
import com.wicky.demo.IndexController;

public class FrontRoutes extends Routes {

    @Override
    public void config() {
        add("/", IndexController.class);
    }

}
