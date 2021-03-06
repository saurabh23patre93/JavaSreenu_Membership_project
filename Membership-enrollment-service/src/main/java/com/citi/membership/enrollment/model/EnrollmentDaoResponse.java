/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
@Data
@JsonInclude(value = Include.NON_NULL)
public class EnrollmentDaoResponse {
	
	private String responseCode;
	private String responseMsg;
	private String enrollmentStatus;
	private String ackNum;
	private String discription;
}
