package com.seclore.demo;

import org.springframework.stereotype.Component;

@Component("calc")
public class Calculator {

	public int add(int x, int y) {
		return x + y;
	}
}
