package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexController {

	@GetMapping("/givenunits") //localhost:8080/givenunits
	public ModelAndView display()
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home.jsp");
		return mav;
	}
	
	@GetMapping("/Calculate_amt")
	public ModelAndView Calculate(Ebbill ebamt)
	{
		ModelAndView mav = new ModelAndView();
		int units = ebamt.getUnits();
		double amount = 0;
		
		if (units <= 500) {
            if (units <= 100) {
                amount = units * 0;
            } else if (units <= 200) {
                amount = 100 * 0 + (units - 100) * 2.25;
            } else if (units <= 400) {
                amount = 100 * 0 + 100 * 2.25 + (units - 200) * 4.50;
            } else if (units <= 500) {
                amount = 100 * 0 + 100 * 2.25 + 200 * 4.50 + (units - 400) * 6.00;
            }
        } else { // units > 500
            if (units <= 600) {
                amount = 100 * 0 + 100 * 2.25 + 200 * 4.50 + 100 * 6.00 + (units - 500) * 8.00;
            } else if (units <= 800) {
                amount = 100 * 0 + 100 * 2.25 + 200 * 4.50 + 100 * 6.00 + 100 * 8.00 + (units - 600) * 9.00;
            } else if (units <= 1000) {
                amount = 100 * 0 + 100 * 2.25 + 200 * 4.50 + 100 * 6.00 + 100 * 8.00 + 200 * 9.00 + (units - 800) * 10.00;
            } else {
                amount = 100 * 0 + 100 * 2.25 + 200 * 4.50 + 100 * 6.00 + 100 * 8.00 + 200 * 9.00 + 200 * 10.00 + (units - 1000) * 11.00;
            }
            
        }
		
    	mav.addObject("charge", amount);
 		mav.setViewName("output.jsp");
		return mav;
	}
}
