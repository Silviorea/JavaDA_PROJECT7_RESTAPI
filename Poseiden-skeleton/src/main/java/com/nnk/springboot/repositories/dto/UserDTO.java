package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class UserDTO implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		private Integer id;
	    private String username;
	    private String password;
	    private String fullname;
	    private String role;
	    
	    
	    
	    
	    
		public UserDTO()
		{
			super();
		}





		public UserDTO(Integer id, String username, String password, String fullname, String role)
		{
			super();
			this.id = id;
			this.username = username;
			this.password = password;
			this.fullname = fullname;
			this.role = role;
		}





	





		public Integer getId()
		{
			return id;
		}





		public void setId(Integer id)
		{
			this.id = id;
		}





		public String getUsername()
		{
			return username;
		}





		public void setUsername(String username)
		{
			this.username = username;
		}





		public String getPassword()
		{
			return password;
		}





		public void setPassword(String password)
		{
			this.password = password;
		}





		public String getFullname()
		{
			return fullname;
		}





		public void setFullname(String fullname)
		{
			this.fullname = fullname;
		}





		public String getRole()
		{
			return role;
		}





		public void setRole(String role)
		{
			this.role = role;
		}
		
		
		
	    
	    
	
}
