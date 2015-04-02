package com.wicky.demo;

import com.jfinal.aop.Interceptor;
import com.jfinal.core.ActionInvocation;

public class DemoInterceptor implements Interceptor {
	public void intercept(ActionInvocation ai) {
		System.out.println("Before action invoking");
		ai.invoke();
		System.out.println("After action invoking");
	}
}