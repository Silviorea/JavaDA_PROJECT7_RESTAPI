package com.nnk.springboot.services;

import java.util.Optional;

import com.nnk.springboot.domain.BidList;
import com.nnk.springboot.domain.User;
import com.nnk.springboot.repositories.dto.BidListDTO;
import com.nnk.springboot.repositories.dto.UserDTO;

public interface UserService
{
	public User create (UserDTO userDTO);
	public Optional<UserDTO> read(Integer id);
	public User update(Integer userID, String userName, String fullName, String password, String role);
	public void delete (Integer userID);
	
	
}
