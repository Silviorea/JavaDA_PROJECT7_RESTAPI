package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

public class BidListDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer BidListId;
	private String account;
	private String type;
	private Double bidQuantity;
	
	
	
	



	public BidListDTO(Integer bidListId, String account, String type, Double bidQuantity)
	{
		super();
		BidListId = bidListId;
		this.account = account;
		this.type = type;
		this.bidQuantity = bidQuantity;
	}



	public Integer getBidListId()
	{
		return BidListId;
	}



	public void setBidListId(Integer bidListId)
	{
		BidListId = bidListId;
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
