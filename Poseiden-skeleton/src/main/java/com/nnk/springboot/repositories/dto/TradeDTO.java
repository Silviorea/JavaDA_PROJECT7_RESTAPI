package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

public class TradeDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer tradeId;
	private String account;
	private String type;
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
