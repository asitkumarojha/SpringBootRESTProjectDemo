package com.csmtech.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor 

public class Employees implements Serializable {

	private Long employeeId;
	
	private String lastName;
	
	private Double salary;
}
