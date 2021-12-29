package com.in28minutes.rest.webservices.springbootrestservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageResource;
	
	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	public String helloWorld(){
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/hello-world/path-variable/{name}")
	public String helloWorldBeanPathVariable(@PathVariable String name){
		return String.format("Hello %s", name); 
	}
	
	@RequestMapping(method = RequestMethod.GET, path="/good-morning-internationalized")
	public String goodMorningInternationalized(
			//@RequestHeader(name="Accept-Language", required=false) Locale locale
			){
		return messageResource.getMessage("good.morning.message", 
				null, "Default Message", LocaleContextHolder.getLocale());
	}

}
