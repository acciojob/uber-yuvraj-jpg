package com.driver.controllers;

import com.driver.model.Customer;
import com.driver.model.Driver;
import com.driver.services.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import com.driver.model.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminServiceImpl adminServiceimpl;
	@PostMapping("/register")
	public ResponseEntity<Void> registerAdmin(@RequestBody Admin admin){
		adminServiceimpl.adminRegister(admin);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Admin> updateAdminPassword(@RequestParam Integer adminId, @RequestParam String password){
		Admin updatedAdmin=adminServiceimpl.updatePassword(adminId,password);
		return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
	}

	@DeleteMapping("/delete")
	public void deleteAdmin(@RequestParam Integer adminId){
		adminServiceimpl.deleteAdmin(adminId);
	}

	@GetMapping("/listOfCustomers")
	public List<Customer> listOfCustomers() {
		return adminServiceimpl.getListOfCustomers();

	}

	@GetMapping("/listOfDrivers")
	public List<Driver> listOfDrivers(){
		return adminServiceimpl.getListOfDrivers();
	}
}
