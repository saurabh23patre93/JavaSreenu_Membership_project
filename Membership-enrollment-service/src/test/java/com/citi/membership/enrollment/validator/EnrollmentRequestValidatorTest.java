/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.validator;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.citi.membership.enrollment.exception.EnrollmentRequestValidationException;
import com.citi.membership.enrollment.model.ClientInfo;
import com.citi.membership.enrollment.model.CustomerInfo;
import com.citi.membership.enrollment.model.EnrollmentRequest;

import lombok.val;

/**
 * @author    ::asus
 * @Date      ::May 3, 2021
 * Description::
 */
public class EnrollmentRequestValidatorTest {

	EnrollmentRequestValidator validaor=null;
	EnrollmentRequest enrollmentRequest=null;


	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		validaor=new EnrollmentRequestValidator();
		enrollmentRequest=buildEnrollmentRequest();
	}


	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_RequestObj_Null_Scenario() {
		try {
			validaor.validate(null);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS001",e.getResponseCode());
		}

	}
	
	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_ClientInfo_Null_Scenario() {
		try {
			enrollmentRequest.setClientInfo(null);
			
			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS001",e.getResponseCode());
		}

	}
	
	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_CustomerInfo_Null_Scenario() {
		try {
			enrollmentRequest.setCustomerInfo(null);
			
			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS001",e.getResponseCode());
		}

	}

	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_ClientId_Null_Scenario() {
		try {

			enrollmentRequest.getClientInfo().setClientId(null);

			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS002",e.getResponseCode());
		}

	}


	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_ClientId_Empty_Scenario() {
		try {

			enrollmentRequest.getClientInfo().setClientId("");

			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS002",e.getResponseCode());
		}

	}
	
	
	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_ChannelId_Null_Scenario() {
		try {
			enrollmentRequest.getClientInfo().setChannelId(null);

			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS003",e.getResponseCode());
		}

	}

	/**
	 * Test method for {@link com.citi.membership.enrollment.validator.EnrollmentRequestValidator#validate(com.citi.membership.enrollment.model.EnrollmentRequest)}.
	 */
	@Test
	public void testValidate_CardNum_Null_Scenario() {
		try {
			enrollmentRequest.getCustomerInfo().setCardNum(null);

			validaor.validate(enrollmentRequest);
		} catch (EnrollmentRequestValidationException e) {
			assertEquals("ENS004",e.getResponseCode());
		}

	}	

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		validaor=null;
		enrollmentRequest=null;
	}

	/**
	 * @return
	 */
	private EnrollmentRequest buildEnrollmentRequest() {
		EnrollmentRequest enrollmentRequest=new EnrollmentRequest();


		ClientInfo clientInfo=new ClientInfo();
		clientInfo.setRequestId("web");
		clientInfo.setChannelId("online");
		clientInfo.setClientId("safhalfaf");
		clientInfo.setMessageTs("27-4-21");


		CustomerInfo customerInfo =new CustomerInfo();
		customerInfo.setCardNum("54542455224");
		customerInfo.setClientId("456");
		customerInfo.setCvv("55");
		customerInfo.setDob("23/2/21");
		customerInfo.setEmailId("saurabh23patre@gmail.com");
		customerInfo.setEnrollmentDate("12/5/20");
		customerInfo.setExpDate("22/5/21");
		customerInfo.setFirstName("saurabh");
		customerInfo.setLastName("patre");
		customerInfo.setMobNum("9527766635");
		customerInfo.setMsgts("safa");;
		customerInfo.setNameOnCard("safafa");

		enrollmentRequest.setClientInfo(clientInfo);
		enrollmentRequest.setCustomerInfo(customerInfo );
		return enrollmentRequest;
	}

}
