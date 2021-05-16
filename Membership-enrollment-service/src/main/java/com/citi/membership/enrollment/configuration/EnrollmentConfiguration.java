/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author    ::asus
 * @Date      ::Apr 30, 2021
 * Description::
 */

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.citi.membership.enrollment.controller")
public class EnrollmentConfiguration {

}
