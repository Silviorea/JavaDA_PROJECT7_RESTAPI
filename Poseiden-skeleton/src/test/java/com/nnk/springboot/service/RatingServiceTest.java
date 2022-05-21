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
import com.nnk.springboot.domain.Rating;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.RatingRepository;
import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.repositories.dto.RatingDTO;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;
import com.nnk.springboot.services.impl.RatingServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class RatingServiceTest
{
	@InjectMocks
	RatingServiceImpl service;
	
	@Mock
	RatingRepository repo;
	
	
	RatingDTO dTOTest = new RatingDTO(1, "ModdyTest", "SandTest", "FitchTest", 1);
	Rating test = new Rating();
	
	
	@Test
	public void createTestMethod() throws Exception
	{

		test = service.create(dTOTest);
		assertTrue(dTOTest.getMoodysRating().equals(test.getMoodysRating()));
	}
		
	
	@Test
	public void updateTestMethod() throws Exception
	{
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Rating update = service.update(1, dTOTest);
		assertTrue(update.getMoodysRating().equals("ModdyTest"));

	}
	
	@Test
	public void readTestMethod() throws Exception
	{
		test.setMoodysRating("ModdyTest");
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Optional <RatingDTO> readOptional = service.read(1);
		
		assertEquals(test.getMoodysRating(), readOptional.get().getMoodysRating());
	}
	
	@Test
	public void readAllTestMethod() throws Exception
	{
		Rating test2 = new Rating("ModdyTest", "SandTest", "FitchTest", 1);
		List<Rating> list = new ArrayList<>();
		list.add(test);
		list.add(test2);
		
		when(repo.findAll()).thenReturn(list);
		
		List<RatingDTO> readList = service.readAll();
		
		assertEquals(test.getMoodysRating(), readList.get(0).getMoodysRating());
		

	}
	
	@Test
	public void deleteTestMethod() throws Exception
	{
		
		
	}


}
