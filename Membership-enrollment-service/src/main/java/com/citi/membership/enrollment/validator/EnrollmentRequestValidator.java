/**@Copyright 2021. All rights are reserved,you should disclose the infromation,

 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.validator;

import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.util.EnrollmentConstant;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
public class EnrollmentRequestValidator {

	/**
	 * @param enrollmentRequest
	 */
	public void validate(EnrollmentRequest enrollmentRequest) throws EnrollmentRequestValidationException{
		
		//TODO:: Validate the request.If any one of the element is invalid then send exception
		//Need to handle user defined exception.
		
		if(enrollmentRequest==null || enrollmentRequest.getClientInfo()==null ||enrollmentRequest.getCustomerInfo()==null) {
			
			throw new EnrollmentRequestValidationException("ENS001","Invalid requst ");
		}
		
		ClientInfo clientInfo=enrollmentRequest.getClientInfo();
		
		//client id null or empty scenarios
		if(clientInfo.getClientId()==null || "".equals(clientInfo.getClientId())) {
			throw new EnrollmentRequestValidationException("ENS002","Invalid client id");
			
		}
		
		//Channel id empty scenarios
		if(clientInfo.getChannelId()==null ||"".equals(clientInfo.getChannelId())) {
			throw new EnrollmentRequestValidationException("ENS003","Invalid channel id");
		}
		
		CustomerInfo customerInfo=enrollmentRequest.getCustomerInfo();
		
		//Card no null or empty scenarios
		if(customerInfo.getCardNum()==null || "".equals(customerInfo.getCardNum())) {
			throw new EnrollmentRequestValidationException("ENS004","Invalid  card No");
		}
	}

}
