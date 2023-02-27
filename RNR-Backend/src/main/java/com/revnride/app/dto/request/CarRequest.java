package com.revnride.app.dto.request;

import com.revnride.app.dto.response.LocalizationResponse;

import lombok.Data;

@Data
public class CarRequest {

	private int idcar;
	/** mark */
	private String mark;
	/** model */
	private String model;
	/** type */
	private String type;
	/** yearProduction */
	private int yearProduction;
	/** color */
	private String color;
	/** engineCapacity */
	private int engineCapacity;
	/** money */
	private float money;
	/** image */
	private String image;
	/** localization */
	private LocalizationResponse localization;

}
