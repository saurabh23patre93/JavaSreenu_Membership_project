/**@Copyright 2021. All rights are reserved,you should disclose the infromation,otherwise terms and conditions will apply.  
 * 
 * 
 */
package com.citi.membership.enrollment.model;

import lombok.Data;

/**
 * @author    ::asus
 * @Date      ::May 14, 2021
 * Description::
 */
@Data
public class CardDetails {
	private String cardNum;
	private boolean primary;
	private String productType;
	private String status;
	private String fname;
	private String lname;
	private String pastDue;
}
