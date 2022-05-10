package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class BidListDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer bidListId;

	@NotEmpty(message = "Account is mandatory")
	private String account;

	@NotEmpty(message = "Type is mandatory")
	private String type;

	@NotNull(message = "Bid Quantity is mandatory")
	@PositiveOrZero(message = "Bid Quantity is positive number")
	private Double bidQuantity;

	public BidListDTO(Integer bidListId, String account, String type, Double bidQuantity)
	{
		super();
		this.bidListId = bidListId;
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}

	public Integer getBidListId()
	{
		return bidListId;
	}

	public void setBidListId(Integer bidListId)
	{
		this.bidListId = bidListId;
	}

	public String getAccount()
	{
		return account;
	}

	public void setAccount(String account)
	{
		this.account = account;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Double getBidQuantity()
	{
		return bidQuantity;
	}

	public void setBidQuantity(Double bidQuantity)
	{
		this.bidQuantity = bidQuantity;
	}

}
