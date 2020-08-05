package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.entity.Inquiry;
import com.example.demo.domain.service.InquiryService;

@Controller
@RequestMapping("/") // rootにアクセス
public class InquiryController {
	
	@Autowired
	private InquiryService service;
	
	@GetMapping
	public String form() {
		return "index";
	}
	
	@PostMapping("/confirm")
	public String confirm(@Validated InquiryForm inquiryForm, BindingResult result) {
		
		if (result.hasErrors()) {
			System.out.println("六本木");
			return "index";
		}
		
		return "confirm";
	}
	
	@PostMapping("/save")
	  public String save(@Validated InquiryForm inquiryForm, BindingResult result) {
	    if (result.hasErrors()) {
	      //TODO Exception
	    	System.out.println("よよよｙ");
	    }
	    Inquiry inquiry = new Inquiry(inquiryForm.getName(), inquiryForm.getEmail(), inquiryForm.getContents());
	    service.save(inquiry);
	    return "complete";
	}
}
