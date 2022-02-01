package com.example.SpringBootExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository userRepository;
	
	@GetMapping("/elogin")
    
    public ModelAndView login() {
    	ModelAndView mav = new ModelAndView("DashBoard");
        mav.addObject("user", new Employee());
        return mav;
    }

	@PostMapping("/add")
    public String addStudent(@Validated Employee employ, BindingResult result, Model model) {
       
        userRepository.save(employ);
        return "redirect:/employee/view";
    }
	
	@GetMapping("/view")
	public String showUserList(Model model) {
	    model.addAttribute("employs", userRepository.findAll());
	    return "Eview";

}

}
