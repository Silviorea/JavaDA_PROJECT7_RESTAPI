package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


/**
 * User ENTITY
 * @author Silvio
 *
 */

@Entity
@Table(name = "users")
public class User {
	
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    
    @Column(unique=true)
    private String username;
    
    private String password;
    
    private String fullname;
   
    private String role;

    
   
	public User(String username, String password, String fullname, String role)
	{
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.role = role;
	}




	public User()
	{
		super();
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
