package org.aman.uiapp.services;

import org.springframework.stereotype.Service;

@Service
public class AdditionService {

	
	public Integer performAddition(Integer num1, Integer num2) {
		return num1+num2;
	}

}
