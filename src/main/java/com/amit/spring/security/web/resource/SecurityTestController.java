package com.amit.spring.security.web.resource;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;

@RestController
public class SecurityTestController {

	@GetMapping("/unsecured")
	public ExampleClass getUnsecuredResponse() {
		return new ExampleClass("Summer of 69", "Hotel California");
	}
	
	@GetMapping("/secured")
	public ExampleClass getSecuredResponse() {
		return new ExampleClass("Summer of 69 Secured", "Hotel California secured");
		
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ExampleClass getAdminRes() {
		return new ExampleClass("ADMIN", "YYYY");
		
	}
}

@Data
class ExampleClass {
	private String field1;
	private String field2;
	public ExampleClass(String field1, String field2) {
		super();
		this.field1 = field1;
		this.field2 = field2;
	}
	
}