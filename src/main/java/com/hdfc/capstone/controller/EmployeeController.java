package com.hdfc.capstone.controller;

import java.io.PrintWriter;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.hdfc.capstone.vo.EmployeeVO;
import java.util.*;



@RestController
public class EmployeeController {
	
	@GetMapping("/get/{employeeId}")
	public ArrayList<Object> getEmployee(@PathVariable long employeeId)
	{
		
		ArrayList<Object> ae=new ArrayList<>();

		EmployeeVO obj2=new EmployeeVO().getEmployeeById(employeeId);
		System.out.println(employeeId);
		System.out.println(obj2.getEmployeeName());
		System.out.println(obj2.getDateOfBirth());
		ae.add(employeeId);
		ae.add(obj2.getEmployeeName());
		ae.add(obj2.getDateOfBirth());
		
		return ae;
		
		
		
	}
	


}
