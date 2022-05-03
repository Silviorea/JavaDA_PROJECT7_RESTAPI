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
import com.nnk.springboot.domain.Trade;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.TradeRepository;
import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.repositories.dto.TradeDTO;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;
import com.nnk.springboot.services.impl.TradeServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TradeServiceTest
{
	@InjectMocks
	TradeServiceImpl service;
	
	@Mock
	TradeRepository repo;
	
	TradeDTO dTOTest = new TradeDTO(1, "Account", "Type", 1.0);
	Trade test = new Trade();
	
	
	@Test
	public void createTestMethod() throws Exception
	{

		test = service.create(dTOTest);
		assertTrue(dTOTest.getAccount().equals(test.getAccount()));
	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Trade update = service.update(1, "AccountUPDATE", "Type", 1.0);
		assertTrue(update.getAccount().equals("AccountUPDATE"));

	}
	
	@Test
	public void readTestMethod() throws Exception
	{
		test.setAccount("AccountTest");
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Optional <TradeDTO> readOptional = service.read(1);
		
		assertEquals(test.getAccount(), readOptional.get().getAccount());
	}
	
	@Test
	public void readAllTestMethod() throws Exception
	{
		Trade test2 = new Trade("Account", "Type", 1.0);
		List<Trade> list = new ArrayList<>();
		list.add(test);
		list.add(test2);
		
		when(repo.findAll()).thenReturn(list);
		
		List<TradeDTO> readList = service.readAll();
		
		assertEquals(test.getAccount(), readList.get(0).getAccount());

	}
	
	@Test
	public void deleteTestMethod() throws Exception
	{
		
		
	}

}
