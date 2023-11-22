package com.cg.trg.springMVC2Project.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
	Map<Integer,Employee> data=new HashMap<>();
	public EmployeeController() {
		data.put(100, new Employee(100,"suresh",LocalDate.of(1998, 10, 10), "Male", "manager"));
		data.put(110, new Employee(110,"suresh1",LocalDate.of(1999, 11, 11), "Male", "manager"));
		
	}
	
@GetMapping("/form")
public ModelAndView showForm() {
	ModelAndView mv=new ModelAndView("empdata");
	mv.addObject("employee",new Employee());
	mv.addObject("message","");
	return mv;
}

@PostMapping("/form")
public ModelAndView submitForms(@ModelAttribute("employee") Employee emp, @RequestParam("action") String action) {
	ModelAndView mv=new ModelAndView("empdata");
	
	if(data.containsKey(emp.getEmpId())) {
		mv.addObject("employee",new Employee());
		mv.addObject("message","employeev datsa already exist");
		
	}
	else {
		data.put(emp.getEmpId(), emp);
		mv.addObject("employee",new Employee());
		mv.addObject("message","Employee Data successfully saved");
		
	}

	if(action.equals("Find")) {
		Employee e=data.get(emp.getEmpId());
		if(e==null) {
			mv.addObject("employee",new Employee());
			mv.addObject("message","Employee data not found");
		}
		else {
			mv.addObject("employee",e);
			mv.addObject("message","");
			
		}
		
	}
	mv.addObject("empList",data.values());
	return mv;
	
}
  @ModelAttribute("roles")
  public String[] getRoles() {
   String[] roles= {"doctor","enginer","mechanics"};
    return roles;
}

}





