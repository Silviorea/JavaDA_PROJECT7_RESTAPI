package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.repositories.dto.RuleNameDTO;
import com.nnk.springboot.services.RuleNameService;

@Service
public class RuleNameServiceImpl implements RuleNameService	
{
	
	@Autowired
	RuleNameRepository ruleNameRepo;
	

	@Override
	public RuleName create(RuleNameDTO ruleNameDTO)
	{
		RuleName newRuleName = new RuleName(
				ruleNameDTO.getName(),
				ruleNameDTO.getDescription(),
				ruleNameDTO.getJson(),
				ruleNameDTO.getTemplate(),
				ruleNameDTO.getSqlStr(),
				ruleNameDTO.getSqlPart());
		
		ruleNameRepo.save(newRuleName);
		
		return newRuleName;
	}
	
	

	@Override
	public Optional<RuleNameDTO> read(Integer id)
	{
		RuleName ruleName = ruleNameRepo.findById(id).get();
		
		RuleNameDTO ruleNameDTO = new RuleNameDTO(
				ruleName.getId(),
				ruleName.getName(),
				ruleName.getDescription(),
				ruleName.getJson(),
				ruleName.getTemplate(),
				ruleName.getSqlStr(),
				ruleName.getSqlPart());
		
		return Optional.of(ruleNameDTO);
	}
	
	

	@Override
	public List<RuleNameDTO> readAll()
	{
		List<RuleName> list = ruleNameRepo.findAll();
		List<RuleNameDTO> listDTO = new ArrayList<>();
		
		for (RuleName ruleName : list)
		{
			listDTO.add( new RuleNameDTO(
					ruleName.getId(),
					ruleName.getName(),
					ruleName.getDescription(),
					ruleName.getJson(),
					ruleName.getTemplate(),
					ruleName.getSqlStr(),
					ruleName.getSqlPart()));
		}
		
		return listDTO;
	}
	
	

	@Override
	public RuleName update(Integer id, String name, String description, 
			String json, String template, String sqlStr,String sqlPart)
	{
		
		RuleName ruleName = ruleNameRepo.findById(id).get();
		ruleName.setName(name);
		ruleName.setDescription(description);
		ruleName.setJson(json);
		ruleName.setTemplate(template);
		ruleName.setSqlStr(sqlStr);
		ruleName.setSqlPart(sqlPart);
		
		ruleNameRepo.save(ruleName);
		
		return ruleName;
	}
	
	

	@Override
	public void delete(Integer id)
	{
		ruleNameRepo.deleteById(id);
		
	}

}
