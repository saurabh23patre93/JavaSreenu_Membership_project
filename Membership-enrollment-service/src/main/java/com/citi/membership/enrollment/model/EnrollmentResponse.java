package com.citi.membership.enrollment.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class EnrollmentResponse {
	
	private StatusBlock statusBlock;
	private String enrollmentStatus;
	private String description;
	private String ackNum;
}
