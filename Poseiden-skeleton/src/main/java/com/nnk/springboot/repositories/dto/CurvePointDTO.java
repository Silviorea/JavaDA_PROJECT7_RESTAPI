package com.nnk.springboot.repositories.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

/**
 * CurvePoint DATA TRANSFERT OBJECT class which is used to DTO Design Pattern
 * @author Silvio
 *
 */

public class CurvePointDTO implements Serializable
{


	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotNull(message = "Id is mandatory")
	@Positive(message = "Id is positive number")
	private Integer curveId;
	
	private Timestamp asOfDate;
	
	@NotNull(message = "Term is mandatory")
	@Positive(message = "Term is positive number")
	private Double term;
	
	@NotNull(message = "Value is mandatory")
	@Positive(message = "Value is positive number")
	private Double value;
	
	private Timestamp creationDate;
	
	
	
	
	

	public CurvePointDTO(Integer id, Integer curveId, Double term, Double value)
	{
		super();
		this.id = id;
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}





	public CurvePointDTO()
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


	public Integer getCurveId()
	{
		return curveId;
	}


	public void setCurveId(Integer curveId)
	{
		this.curveId = curveId;
	}


	public Timestamp getAsOfDate()
	{
		return asOfDate;
	}


	public void setAsOfDate(Timestamp asOfDate)
	{
		this.asOfDate = asOfDate;
	}


	public Double getTerm()
	{
		return term;
	}


	public void setTerm(Double term)
	{
		this.term = term;
	}


	public Double getValue()
	{
		return value;
	}


	public void setValue(Double value)
	{
		this.value = value;
	}


	public Timestamp getCreationDate()
	{
		return creationDate;
	}


	public void setCreationDate(Timestamp creationDate)
	{
		this.creationDate = creationDate;
	}
	
	
	
	
	
}
