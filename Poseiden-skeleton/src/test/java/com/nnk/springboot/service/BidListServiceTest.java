package com.nnk.springboot.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.anything;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.junit.jupiter.api.Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.repositories.BidListRepository;
import com.nnk.springboot.repositories.dto.BidListDTO;
import com.nnk.springboot.services.impl.BidListServiceImpl;



//@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class BidListServiceTest
{

	@InjectMocks
	BidListServiceImpl bdService;
	
	@Mock
	BidListRepository bdRepo;
	
	
	BidListDTO bdDTOTest = new BidListDTO(1, "AccountTest", "TypeTest", 1.0);
	//BidList bdTest = new BidList(bdDTOTest.getAccount(),bdDTOTest.getType(), bdDTOTest.getBidQuantity());
	BidList bdTest = new BidList();
	
	
	@Test
	public void createTestMethod() throws Exception
	{
		bdTest = bdService.create(bdDTOTest);
		assertEquals("AccountTest", bdTest.getAccount());
	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(bdRepo.findById(1)).thenReturn(Optional.of(bdTest));
		BidList bidListUpdate = bdService.update(1, "AccountUPDATETest", "TypeUPDATETest", 7.7);
		assertEquals("AccountUPDATETest", bidListUpdate.getAccount());

	}
	
	@Test
	public void readTestMethod() throws Exception
	{
		bdTest.setAccount("Account");
		when(bdRepo.findById(1)).thenReturn(Optional.of(bdTest));
		Optional <BidListDTO> readOptional = bdService.read(1);
		
		assertEquals(bdTest.getAccount(), readOptional.get().getAccount());
	}
	
	@Test
	public void readAllTestMethod() throws Exception
	{
		BidList bdTest2 = new BidList("AccountTest2", "TypeTest2", 1.0);
		List<BidList> bdList = new ArrayList<>();
		bdList.add(bdTest);
		bdList.add(bdTest2);
		
		when(bdRepo.findAll()).thenReturn(bdList);
		
		List<BidListDTO> readList = bdService.readAll();
		
		assertEquals(bdTest2.getAccount(), readList.get(1).getAccount());
		

	}
	
	@Test
	public void deleteTestMethod() throws Exception
	{
		
		
	}
	
}
