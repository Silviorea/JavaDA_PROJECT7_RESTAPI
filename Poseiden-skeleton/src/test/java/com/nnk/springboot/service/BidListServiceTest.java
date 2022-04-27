package com.nnk.springboot.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
	BidList bdTest = new BidList(bdDTOTest.getAccount(),bdDTOTest.getType(), bdDTOTest.getBidQuantity());
	
	
	
	@Test
	public void createTestMethod() throws Exception
	{
		
		
		bdTest = bdService.create(bdDTOTest);
		
		assertEquals("AccountTest", bdTest.getAccount());

	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(bdRepo.findById(1).get()).thenReturn(bdTest);
		
		BidList bidListUpdate = bdService.update(1, "AccountUPDATETest", "TypeUPDATETest", 7.7);
		
		assertEquals("AccountUPDATETest", bidListUpdate.getAccount());

	}
	
}
