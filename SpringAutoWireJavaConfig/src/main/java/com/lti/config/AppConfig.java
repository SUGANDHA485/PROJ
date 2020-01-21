package com.lti.config;


import javax.print.attribute.standard.RequestingUserName;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.lti.model.Address;


@Configuration
@ComponentScan(basePackages="com.lti.model")

public class AppConfig {
   @Bean(name="address1")
	public Address getAddress()
	{
	Address address=new Address();
	address.setCity("Navi Mumbai");
	return address;
}
}