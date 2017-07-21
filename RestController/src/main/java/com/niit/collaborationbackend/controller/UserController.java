package com.niit.collaborationbackend.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.niit.collaborationbackend.dao.UserDAO;
import com.niit.collaborationbackend.model.User;

@RestController
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@GetMapping("/users")
	public List<User> getUsers() {
		List<User> userList = userDAO.list();
		return userList;

	}

	@GetMapping("/userid/{userId}")
	public ResponseEntity<User> getUserByID(@PathVariable("userId") int id) {

		User user = userDAO.get(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@GetMapping("/username/{user_name}")
	public List<User> getUserByUsername(@PathVariable("user_name") String name) {
		List<User> user = userDAO.getbyUsername(name);
		if (user == null) {
			// return new ResponseEntity("No User found for Name " + name,
			// HttpStatus.NOT_FOUND);
		}
		return user;

	}

	@PostMapping("/user")
	public ResponseEntity save(@RequestBody User user) {
		userDAO.create(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@PutMapping("/user")
	public ResponseEntity update(@RequestBody User user) {
		userDAO.update(user);
		return new ResponseEntity(user, HttpStatus.OK);
	}

	@DeleteMapping("/user/{userId}")
	public ResponseEntity deleteUser(@PathVariable("userId") int id) {
		User user = userDAO.get(id);
		if (user == null) {
			return new ResponseEntity("No User found for ID " + id, HttpStatus.NOT_FOUND);
		}
		userDAO.delete(id);
		return new ResponseEntity("deleted for ID " + id, HttpStatus.OK);

	}
	
	@RequestMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User validUser = userDAO.login(user);
		if (validUser == null) {
			Error error = new Error("Invalid credentials.. please enter valid username and password");
			return new ResponseEntity<Error>(error, HttpStatus.UNAUTHORIZED);
		} else {
			session.setAttribute("loggedInUser", validUser);
			
			System.out.println(validUser.getEmail_id());
			System.out.println("hi");
			System.out.println(validUser.getUser_name());
			User user1 = (User) session.getAttribute("loggedInUser");
			System.out.println(user1.getRole());
			System.out.println(user1.getDob());
			return new ResponseEntity<User>(validUser, HttpStatus.OK);
		}
	}

}
