package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

/**
 * RuleName DATA TRANSFERT OBJECT class which is used to DTO Design Pattern
 * @author Silvio
 *
 */

public class RuleNameDTO implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message = "Name is mandatory")
	private String name;
	@NotEmpty(message = "Description is mandatory")
	private String description;
	@NotEmpty(message = "Json is mandatory")
	private String json;
	@NotEmpty(message = "Template is mandatory")
	private String template;
	@NotEmpty(message = "Sql STR is mandatory")
	private String sqlStr;
	@NotEmpty(message = "Sql Part is mandatory")
	private String sqlPart;
	
	
	public RuleNameDTO()
	{
		super();
	}


	public RuleNameDTO(Integer id, String name, String description, String json, String template, String sqlStr,
			String sqlPart)
	{
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.json = json;
		this.template = template;
		this.sqlStr = sqlStr;
		this.sqlPart = sqlPart;
	}
	
	
	
	
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getJson()
	{
		return json;
	}
	public void setJson(String json)
	{
		this.json = json;
	}
	public String getTemplate()
	{
		return template;
	}
	public void setTemplate(String template)
	{
		this.template = template;
	}
	public String getSqlStr()
	{
		return sqlStr;
	}
	public void setSqlStr(String sqlStr)
	{
		this.sqlStr = sqlStr;
	}
	public String getSqlPart()
	{
		return sqlPart;
	}
	public void setSqlPart(String sqlPart)
	{
		this.sqlPart = sqlPart;
	}
	
	

}
