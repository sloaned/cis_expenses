package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="usr")
public class User extends BaseEntity {
	
	public User(String name){
		this.setName(name);
	}
	
	public User(){}
}
