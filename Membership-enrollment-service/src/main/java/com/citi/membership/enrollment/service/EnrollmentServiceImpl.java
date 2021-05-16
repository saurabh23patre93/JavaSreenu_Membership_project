/**@Copyright 2021. All rights are reserved,you should disclose the infromation,  
 * otherwise terms and conditions will apply.
 * 
 */
package com.citi.membership.enrollment.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.citi.membership.enrollment.dao.EnrollmentDao;
import com.citi.membership.enrollment.dao.EnrollmentDaoImpl;
import com.citi.membership.enrollment.exception.BusinessException;
import com.citi.membership.enrollment.exception.SystemException;
import com.citi.membership.enrollment.model.CardDetails;
import com.citi.membership.enrollment.model.CardDetailsResponse;
import com.citi.membership.enrollment.model.EnrollmentDaoRequest;
import com.citi.membership.enrollment.model.EnrollmentDaoResponse;
import com.citi.membership.enrollment.model.EnrollmentRequest;
import com.citi.membership.enrollment.model.EnrollmentResponse;
import com.citi.membership.enrollment.model.StatusBlock;
import com.citi.membership.enrollment.svcclient.CardsServiceClient;
import com.citi.membership.enrollment.svcclient.CardsServiceClientImpl;

/**
 * @author    ::asus
 * @Date      ::Apr 29, 2021
 * Description::
 */
public class EnrollmentServiceImpl  implements EnrollmentService {

	private Logger logger=Logger.getLogger(EnrollmentServiceImpl.class);
	public EnrollmentResponse createEnrollment(EnrollmentRequest enrollmentRequest) throws SystemException, BusinessException {
		logger.debug("Enter into service--start");
		//1.Get the enrollment Request from controller.

		//2.Prepare the request for service client

		//3.Call the service client
		CardsServiceClient cardsServiceClient=new CardsServiceClientImpl();
		
		CardDetailsResponse cardDetailsResponse=cardsServiceClient.getCardDetails(enrollmentRequest.getCustomerInfo().getCardNum());
		if(cardDetailsResponse!=null) {
			//List<CardDetails> cardDetailsList=cardDetailsResponse.getC
		}
		
		//TODO ::Once will get the response from card details the we need to write the bellow bussiness logic
		//once Cardproducts,status,primary card etc
		//if all the checks are success then only it will call to EnrollmentDAO else it will thow Exception from here
		/*		CardDetailsResponse cardDetailsResponce=cardsServiceClient.getCardDetails(enrollmentRequest.getCustomerInfo().getCardNum());

		if(cardDetailsResponce!=null) {
			List<CardDetails> cardDetailsList=cardDetailsResponce.getCardDetails();

			for(CardDetails cardDetails:cardDetailsList) {
				String card13digit=cardDetails.getCardNum().substring(13,15);

				if(!"pa".equals(cardDetails.getProductType())||!"active".equals(cardDetails.getStatus())||!cardDetails.isPrimary()){
					//TODO::Handle user defined exception-You are not eligble for this
					//enrollments
				}
			}
		}
		 */		
		//4.Prepare the request for dao with the help of controller request
		EnrollmentDaoRequest daoRequest=new EnrollmentDaoRequest();
		daoRequest.setFirstName(enrollmentRequest.getCustomerInfo().getFirstName());
		daoRequest.setLastName(enrollmentRequest.getCustomerInfo().getLastName());
		daoRequest.setCardNum(enrollmentRequest.getCustomerInfo().getCardNum());
		daoRequest.setCvv(enrollmentRequest.getCustomerInfo().getCvv());
		daoRequest.setDob(enrollmentRequest.getCustomerInfo().getDob());
		daoRequest.setEmailId(enrollmentRequest.getCustomerInfo().getEmailId());
		daoRequest.setEnrollmentDate(enrollmentRequest.getCustomerInfo().getEnrollmentDate());
		daoRequest.setExpDate(enrollmentRequest.getCustomerInfo().getExpDate());
		daoRequest.setMobNum(enrollmentRequest.getCustomerInfo().getMobNum());
		daoRequest.setNameOnCard(enrollmentRequest.getCustomerInfo().getNameOnCard());
		daoRequest.setClientId(enrollmentRequest.getCustomerInfo().getClientId());
		daoRequest.setMsgts(enrollmentRequest.getCustomerInfo().getMsgts());

		//5.call dao and get the dao response
		EnrollmentDao enrollmentDao=new EnrollmentDaoImpl();
		enrollmentDao.createEnrollment(daoRequest);

		EnrollmentDaoResponse daoResponse=enrollmentDao.createEnrollment(daoRequest);

		//6.Prepare the service response with the help of dao.
		EnrollmentResponse enrollmentResponse=new EnrollmentResponse(); 
		StatusBlock statusBlock=new StatusBlock();
		statusBlock.setResponseCode(daoResponse.getResponseCode());
		statusBlock.setResponseMsg(daoResponse.getResponseMsg());
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setStatusBlock(statusBlock);
		enrollmentResponse.setEnrollmentStatus(daoResponse.getEnrollmentStatus());
		enrollmentResponse.setAckNum(daoResponse.getAckNum());
		enrollmentResponse.setDescription(daoResponse.getDiscription());

		logger.info("Exit from service--end "+enrollmentResponse);
		return enrollmentResponse;
	} 

}
