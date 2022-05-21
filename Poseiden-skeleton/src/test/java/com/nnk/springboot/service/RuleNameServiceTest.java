package com.nnk.springboot.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.RuleName;
import com.nnk.springboot.repositories.RuleNameRepository;
import com.nnk.springboot.repositories.dto.RuleNameDTO;
import com.nnk.springboot.services.impl.RuleNameServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RuleNameServiceTest
{

	@InjectMocks
	RuleNameServiceImpl service;
	
	@Mock
	RuleNameRepository repo;
	
	
	RuleNameDTO dTOTest = new RuleNameDTO(1, "name", "description", "Json", "Template", "SqlStr", "SqlPart");
	RuleName test = new RuleName();
	
	
	@Test
	public void createTestMethod() throws Exception
	{

		test = service.create(dTOTest);
		assertTrue(dTOTest.getDescription().equals(test.getDescription()));
	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(repo.findById(1)).thenReturn(Optional.of(test));
		RuleName update = service.update(1, dTOTest);
		assertTrue(update.getName().equals("name"));

	}
	
	@Test
	public void readTestMethod() throws Exception
	{
		test.setJson("JsonTest");
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Optional <RuleNameDTO> readOptional = service.read(1);
		
		assertEquals(test.getJson(), readOptional.get().getJson());
	}
	
	@Test
	public void readAllTestMethod() throws Exception
	{
		RuleName test2 = new RuleName("name", "description", "Json", "Template", "SqlStr", "SqlPart");
		List<RuleName> list = new ArrayList<>();
		list.add(test);
		list.add(test2);
		
		when(repo.findAll()).thenReturn(list);
		
		List<RuleNameDTO> readList = service.readAll();
		
		assertEquals(test.getName(), readList.get(0).getName());
		

	}
	
	@Test
	public void deleteTestMethod() throws Exception
	{
		
		
	}

}
