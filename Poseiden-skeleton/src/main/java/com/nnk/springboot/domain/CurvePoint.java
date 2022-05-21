package com.nnk.springboot.domain;


import javax.persistence.*;

import java.sql.Timestamp;

/**
 * CurvePoint ENTITY
 * @author Silvio
 *
 */

@Entity
@Table(name = "curvepoint")
public class CurvePoint {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer curveId;

	private Timestamp asOfDate;
	
	private Double term;
	
	private Double value;
	
	private Timestamp creationDate;
	
	
	
	public CurvePoint(Integer curveId, Timestamp asOfDate, Double term, Double value,
			Timestamp creationDate)
	{
		super();
		this.curveId = curveId;
		this.asOfDate = asOfDate;
		this.term = term;
		this.value = value;
		this.creationDate = creationDate;
	}
	
	



	public CurvePoint(Integer curveId, Double term, Double value)
	{
		super();
		this.curveId = curveId;
		this.term = term;
		this.value = value;
	}





	public CurvePoint()
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
