package com.wicky.demo;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;

import com.jfinal.core.Controller;

public class IndexController extends Controller {
    
    public void index() throws HttpException, IOException {
        renderJsp("/index.jsp");
    }
    
    public void notfound() throws HttpException, IOException {
    	renderJsp("/404.html");
    }
    
}
