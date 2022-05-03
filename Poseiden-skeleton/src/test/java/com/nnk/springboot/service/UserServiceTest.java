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
import org.springframework.security.core.userdetails.UserDetails;

import com.nnk.springboot.domain.CurvePoint;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.CurvePointRepository;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.repositories.dto.CurvePointDTO;
import com.nnk.springboot.repositories.dto.UserDTO;
import com.nnk.springboot.services.impl.CurvePointServiceImpl;
import com.nnk.springboot.services.impl.UserServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class UserServiceTest
{
	@InjectMocks
	UserServiceImpl service;

	@Mock
	UserRepository repo;

	UserDTO dTOTest = new UserDTO(1, "UserName", "Password", "FullName", "Admin");
	User test = new User();

	@Test
	public void createTestMethod() throws Exception
	{
		test = service.create(dTOTest);
		assertTrue(dTOTest.getFullname().equals(test.getFullname()));
	}

	@Test
	public void updateTestMethod() throws Exception
	{
		when(repo.findById(1)).thenReturn(Optional.of(test));
		User update = service.update(1, "UserNameUPDATE", "Password", "FullName", "Admin");
		assertTrue(update.getUsername().equals("UserNameUPDATE"));
	}

	@Test
	public void readTestMethod() throws Exception
	{
		test.setFullname("MyNewFullName");
		when(repo.findById(1)).thenReturn(Optional.of(test));
		Optional<UserDTO> readOptional = service.read(1);

		assertEquals(test.getFullname(), readOptional.get().getFullname());
	}

	@Test
	public void readAllTestMethod() throws Exception
	{
		User test2 = new User("UserName", "Password", "FullName", "Admin");
		List<User> list = new ArrayList<>();
		list.add(test);
		list.add(test2);

		when(repo.findAll()).thenReturn(list);

		List<UserDTO> readList = service.readAll();

		assertEquals(test.getFullname(), readList.get(0).getFullname());

	}

//	public void loadUserByUsernameTest()
//	{
//		test.setUsername("UserName");
//		test.setPassword("password");
//		
//		when(repo.findByUsername("UserName")).thenReturn(test);
//
//		UserDetails userDetails = service.loadUserByUsername("UserName");
//
//		assertTrue(userDetails.getUsername().equals(test.getUsername()));
//		assertTrue(userDetails.getPassword().equals(test.getPassword()));
//	}

	@Test
	public void deleteTestMethod() throws Exception
	{

	}

}
