package com.nnk.springboot.services.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		
		User newUser = new User(
				userDTO.getUsername(),
				passwordEncoder.encode(userDTO.getPassword()),
				userDTO.getFullname(),
				userDTO.getRole());
		
		
		userRepository.save(newUser);
		
		return newUser;
	}

	@Override
	public Optional<UserDTO> read(Integer id)
	{
		User user = userRepository.findById(id).get();
		
		UserDTO userDTO = new UserDTO(
				user.getId(),
				user.getUsername(),
				user.getPassword(),
				user.getFullname(),
				user.getRole());
		
		return Optional.of(userDTO);
	}
	


	@Override
	public User update(Integer id, String userName, String fullName, String password, String role)
	{
		User user = userRepository.findById(id).get();
		user.setUsername(userName);
		user.setFullname(fullName);
		user.setPassword(password);
		user.setRole(role);
		
		userRepository.save(user);
		
		return user;
	}

	@Override
	public void delete(Integer id)
	{
		userRepository.deleteById(id);
		
	}

	@Override
	public List<UserDTO> readAll()
	{
		List<User> list = userRepository.findAll();
		List<UserDTO> listDTO = new ArrayList<>();
		
		for (User userList : list)
		{
			listDTO.add( new UserDTO(
					userList.getId(),
					userList.getUsername(),
					userList.getPassword(),
					userList.getFullname(),
					userList.getRole()));
		}
		
		return listDTO;
	}

	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		
		User user = userRepository.findByUsername(username);
		
		if (user == null)
		{
			throw new UsernameNotFoundException("Invalid username or invalid Password");
		} 
		return new org.springframework.security.core.userdetails.User
				(user.getUsername(), user.getPassword(), mapRolesToAuthorities(user.getRole()));
		
		
	}
	
	
	private Collection <? extends GrantedAuthority> mapRolesToAuthorities (String role)
	{
		
//		roles.stream()
//		.map( role -> new SimpleGrantedAuthority(roles))
//		.collect(Collectors.toList());
		
		
		List<SimpleGrantedAuthority> authorithies = new ArrayList<>();
	    authorithies.add(new SimpleGrantedAuthority(role));
		return authorithies;
		
		
	}

}
