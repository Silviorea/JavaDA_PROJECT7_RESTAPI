package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.dto.RuleNameDTO;

public interface RuleNameService
{
	public RuleName create (RuleNameDTO ruleNameDTO);
	public Optional<RuleNameDTO> read (Integer id);
	public List<RuleNameDTO> readAll();
	public RuleName update (Integer id, String name, String description, String json,
			String template, String sqlStr, String sqlPart);
	public void delete(Integer id);
	

}
