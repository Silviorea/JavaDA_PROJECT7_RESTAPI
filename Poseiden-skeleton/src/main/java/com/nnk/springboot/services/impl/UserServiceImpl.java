package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.UserRepository;
import com.nnk.springboot.repositories.dto.UserDTO;
import com.nnk.springboot.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	UserRepository userRepository;

	@Override
	public User create(UserDTO userDTO)
	{
		User newUser = new User(
				userDTO.getUsername(),
				userDTO.getPassword(),
				userDTO.getFullname(),
				userDTO.getRole());
		return newUser;
	}

	@Override
	public Optional<UserDTO> read(Integer id)
	{
		User user = userRepository.findById(id).get();
		
		UserDTO userDTO = new UserDTO(
				user.getUsername(),
				user.getPassword(),
				user.getFullname(),
				user.getRole());
		
		return Optional.of(userDTO);
	}
	


	@Override
	public User update(Integer userID, String userName, String fullName, String password, String role)
	{
		User user = userRepository.findById(userID).get();
		user.setUsername(userName);
		user.setFullname(fullName);
		user.setPassword(password);
		user.setRole(role);
		
		return user;
	}

	@Override
	public void delete(Integer userID)
	{
		userRepository.deleteById(userID);
		
	}
	

}
