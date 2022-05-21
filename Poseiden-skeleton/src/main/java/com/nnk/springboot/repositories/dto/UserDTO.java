package com.nnk.springboot.repositories.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * User DATA TRANSFERT OBJECT class which is used to DTO Design Pattern
 * @author Silvio
 *
 */

public class UserDTO implements Serializable
{

	private static final long serialVersionUID = 1L;
		
		private Integer id;
		@NotBlank(message = "Username is mandatory")
	    private String username;
		
		@NotNull(message = "Password is mandatory")
		
		@Pattern(regexp = "(?=.*[0-9]).+", message = "Password must contain one digit.")
		@Pattern(regexp = "(?=.*[a-z]).+", message = "Password must contain one lowercase letter.")
		@Pattern(regexp = "(?=.*[A-Z]).+", message = "Password must contain one uppercase letter.")
		@Pattern(regexp = "(?=.*[!@#$%^&*+=?-_()/\"\\.,<>~`;:]).+", message ="Password must contain one special character.")
		@Pattern(regexp = "(?=\\S+$).+", message = "Password must contain no whitespace.")
	
	    private String password;
		
		@NotBlank(message = "FullName is mandatory")
	    private String fullname;
		
		@NotBlank(message = "Role is mandatory")
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
