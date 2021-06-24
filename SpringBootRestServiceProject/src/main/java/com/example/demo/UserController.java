package com.example.demo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

//	//example- http://localhost:8080/user
//	@GetMapping
//	public String getUsers() {
//		return "http get request was sent";
//	} }

	//example- http://localhost:8080/users?page=5&limit=2
	@GetMapping
	public String getUsers(@RequestParam(value="page") int pageNo, @RequestParam(value="limit") int limitNo) {
		return "http get request was sent using query paramenter and value of page is  :"+pageNo+"   and limit no is :  "+limitNo;
	}
	
	//example- http://localhost:8080/user/55
	@GetMapping(path = "/{userID}") // path parameter
	public String getUser(@PathVariable String userID) {

		return "http get request was sent for user ID   :	" + userID;
	}

	@PostMapping
	public String createUser() {

		return "http POST request was sent";
	}

	@PutMapping
	public String updateUser() {

		return "http put request was sent";
	}

	@DeleteMapping
	public String deleteUser() {

		return "http delete request was sent";
	}

}

