package com.outhreeit.quickrbooks.entities;

import javax.persistence.Entity;

@Entity
public class Username extends BaseEntity{
	
	public Username(String name){
		this.setName(name);
	}
}
