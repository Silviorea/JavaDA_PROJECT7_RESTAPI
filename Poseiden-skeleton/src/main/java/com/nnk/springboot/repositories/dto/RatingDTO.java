package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class RatingDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Moodys Rating is mandatory")
	private String moodysRating;
	
	@NotEmpty(message = "Sand Rating is mandatory")
	private String sandPRating;
	
	@NotEmpty(message = "Fitch Rating is mandatory")
	private String fitchRating;
	
	@NotNull(message = "Bid Quantity is mandatory")
	@Positive(message = "Bid Quantity is positive number")
	private Integer orderNumber;
	
	
	
	public RatingDTO(Integer id, String moodysRating, String sandPRating, String fitchRating, Integer orderNumber)
	{
		super();
		this.id = id;
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
	}



	public RatingDTO()
	{
		super();
	}



	public Integer getId()
	{
		return id;
	}



	public void setId(Integer id)
	{
		this.id = id;
	}



	public String getMoodysRating()
	{
		return moodysRating;
	}



	public void setMoodysRating(String moodysRating)
	{
		this.moodysRating = moodysRating;
	}



	public String getSandPRating()
	{
		return sandPRating;
	}



	public void setSandPRating(String sandPRating)
	{
		this.sandPRating = sandPRating;
	}



	public String getFitchRating()
	{
		return fitchRating;
	}



	public void setFitchRating(String fitchRating)
	{
		this.fitchRating = fitchRating;
	}



	public Integer getOrderNumber()
	{
		return orderNumber;
	}



	public void setOrderNumber(Integer orderNumber)
	{
		this.orderNumber = orderNumber;
	}
	
	
	
	

}
