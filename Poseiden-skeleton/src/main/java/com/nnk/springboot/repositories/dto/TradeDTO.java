package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class TradeDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer tradeId;
	@NotEmpty(message = "Account is mandatory")
	private String account;
	@NotEmpty(message = "Type is mandatory")
	private String type;
	@NotNull(message = "Buy Quantity is mandatory")
	@Positive(message = "Buy Quantity is positive number")
	private Double buyQuantity;
	
	
	
	public TradeDTO()
	{
		super();
	}


	public TradeDTO(Integer tradeId, String account, String type, Double buyQuantity)
	{
		super();
		this.tradeId = tradeId;
		this.account = account;
		this.type = type;
		this.buyQuantity = buyQuantity;
	}

	
	

	public Integer getTradeId()
	{
		return tradeId;
	}


	public void setTradeId(Integer tradeId)
	{
		this.tradeId = tradeId;
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


	public Double getBuyQuantity()
	{
		return buyQuantity;
	}


	public void setBuyQuantity(Double buyQuantity)
	{
		this.buyQuantity = buyQuantity;
	}

}
