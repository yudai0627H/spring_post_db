package com.example.demo.domain.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.domain.entity.Inquiry;

@Service
public class InquiryDaoImpl implements InquiryDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public InquiryDaoImpl(JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	

	@Override
	public void create(Inquiry inquiry) {
		
		 jdbcTemplate.update("INSERT INTO inquiry (name, email, contents) VALUES (?, ?, ?)",
			        inquiry.getName(), inquiry.getEmail(), inquiry.getContents()); 
	}

}
