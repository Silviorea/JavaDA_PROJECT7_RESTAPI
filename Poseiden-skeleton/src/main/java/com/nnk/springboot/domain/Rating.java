package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import java.sql.Timestamp;

@Entity
@Table(name = "rating")
public class Rating {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	
	
	
	public Rating(String moodysRating, String sandPRating, String fitchRating, Integer orderNumber)
	{
		super();
		this.moodysRating = moodysRating;
		this.sandPRating = sandPRating;
		this.fitchRating = fitchRating;
		this.orderNumber = orderNumber;
		
		
	}



	public Rating()
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
