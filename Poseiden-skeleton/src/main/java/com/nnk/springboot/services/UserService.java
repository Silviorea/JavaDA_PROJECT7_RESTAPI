package com.nnk.springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.dto.UserDTO;

public interface UserService extends UserDetailsService
{
	public User create (UserDTO userDTO);
	public Optional<UserDTO> read(Integer id);
	public User update(Integer userID, String userName, String fullName, String password, String role);
	public void delete (Integer userID);
	public List<UserDTO> readAll();
	
	
}
