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

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class CurvePointServiceTest
{
	@InjectMocks
	CurvePointServiceImpl service;
	
	@Mock
	CurvePointRepository repo;
	
	
	CurvePointDTO dTOTest = new CurvePointDTO(1, 1, 1.0, 1.0);
	CurvePoint test = new CurvePoint();
	
	
	@Test
	public void createTestMethod() throws Exception
	{

		test = service.create(dTOTest);
		assertTrue(dTOTest.getCurveId().equals(test.getCurveId()));
	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(repo.findById(1)).thenReturn(Optional.of(test));
		CurvePoint update = service.update(1, dTOTest);
		assertTrue(update.getTerm().equals(1.0));

	}
	
	@Test
	public void readTestMethod() throws Exception
	{
		test.setCurveId(1);
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Optional <CurvePointDTO> readOptional = service.read(1);
		
		assertEquals(test.getCurveId(), readOptional.get().getCurveId());
	}
	
	@Test
	public void readAllTestMethod() throws Exception
	{
		CurvePoint test2 = new CurvePoint(1, 1.0, 1.0);
		List<CurvePoint> list = new ArrayList<>();
		list.add(test);
		list.add(test2);
		
		when(repo.findAll()).thenReturn(list);
		
		List<CurvePointDTO> readList = service.readAll();
		
		assertEquals(test.getCurveId(), readList.get(0).getCurveId());
		

	}
	
	@Test
	public void deleteTestMethod() throws Exception
	{
		
		
	}

}
