package com.wicky.demo;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;

public class UrlSkipHandler extends Handler {
	public void handle(String target, HttpServletRequest request,
			HttpServletResponse response, boolean[] isHandled) {

		System.out.println("Handle URL: " + target);
		
		// skip direct jsp requests
        if (target.toLowerCase().lastIndexOf(".jsp") != -1){
        	try {
				response.sendRedirect("/notfound");
			} catch (final IOException e) {
				// ignore
			}
        	return;
        }
        
        // skip direct html requests
        if (target.toLowerCase().lastIndexOf(".html") != -1){
        	try {
        		response.sendRedirect("/notfound");
        	} catch (final IOException e) {
        		// ignore
        	}
        	return;
        }
        
        // loop handlers
		nextHandler.handle(target, request, response, isHandled);
	}
}