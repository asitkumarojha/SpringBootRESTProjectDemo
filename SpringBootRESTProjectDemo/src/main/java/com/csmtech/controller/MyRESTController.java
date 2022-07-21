package com.csmtech.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.csmtech.model.Departments;
import com.csmtech.model.Employees;
import com.csmtech.repository.DepartmentRepository;
@RestController
@RequestMapping("/emp")
public class MyRESTController {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	List<Employees> empList;
	
	@GetMapping(produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public Employees getAEmp(){
		
		 return new Employees(101l,"Amit",2509.00);
	}
	

	@GetMapping(value="/getAllEmps",produces= {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
	public List< Employees> getAllEmps(){
		
		empList=new ArrayList<Employees>();
		
		empList.add( new Employees(100l,"Ajit",2529.00));
		empList.add(new Employees(101l,"Amit",2509.00));
		empList.add(new Employees(102l,"Asit",2509.00));
		empList.add(new Employees(103l,"Abhi",2509.00));
		
		 return empList;
	}
	
	
	@GetMapping(value="/getEmpById")
	public Employees getEmpById(@RequestParam("eId") Long eId){
		
		Employees e=null;
		
		for(Employees x:empList) {
			if(x.getEmployeeId().longValue()==eId.longValue())
				e=x;
		}
		
		
	
		
		 return e;
	}
	
	@GetMapping(value="/getDepts")
	public List<Departments> getAllDepartmentById() {
		
		return departmentRepository.findAll() ;
	}
	
	@GetMapping(value="/getIdByDepts")
	public Departments getIdByDepts(@RequestParam("dId") Integer dId) {
		
		return departmentRepository.findById(dId).get();
	}
	
	
    //for pagination
	@GetMapping(value="/getDeptByPagination")
	public Page<Departments> getDeptByPagination(@RequestParam("pageNo") Integer pageNo,@RequestParam("pageSize") Integer pageSize) {
		
		return departmentRepository.findAll(PageRequest.of(pageNo, pageSize));
	}
	
	
}
