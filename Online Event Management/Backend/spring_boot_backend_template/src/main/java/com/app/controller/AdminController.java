package com.app.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CateringDto;
import com.app.dto.HotelDto;
import com.app.entities.Admin;
import com.app.entities.Bookings;
import com.app.entities.Catering;
import com.app.entities.Hotel;
import com.app.entities.User;
import com.app.services.AdminService;
import com.app.services.CateringService;
import com.app.services.HotelService;
import com.app.services.UserService;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
	
	@Autowired
	private  AdminService adminService;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private CateringService cateringService;
	
	@Autowired
	private UserService userService;
	
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerAdmin(@Valid @RequestBody Admin admin, BindingResult bindingResult)
	{
		if(bindingResult.hasErrors())
		{
			return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
		}
		Admin registerAdmin = adminService.registerAdmin(admin);
		return ResponseEntity.ok("Admin Register Successfully...!");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginAdmin (@RequestParam String email, @RequestParam String password)
	{
		Admin admin = adminService.loginAdmin(email, password);
		if(admin!=null)
		{
			return ResponseEntity.ok("Admin login successfully...!");
		}
		else
		{
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("invalid Email or Password");
		}
	}
	
	
	@GetMapping("/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable Long id)
	{
		User user = userService.findById(id);
		if(user!=null)
		{
			return ResponseEntity.ok(user);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	
//	@PostMapping("/byFirstName")
//	public ResponseEntity<List<User>> getUsersByFirstName(@RequestParam String fname)
//	{
//	
//			List<User> users = userService.findByFirstName(fname);
//			if(users.isEmpty())
//			{
//				return ResponseEntity.ok(users);
//			}
//			else
//			{
//				return ResponseEntity.notFound().build();
//			}
//	}
	
	@PutMapping("/updateUser")
	public ResponseEntity<String> updateUserById(@RequestBody User user, @RequestParam Long id)
	{
		user.setId(id);
		
		return ResponseEntity.ok(userService.updateUser(user));
	}
	
//	@PostMapping("/addHotel")
//	public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotel, BindingResult bindingResult)
//	{
//		if(bindingResult.hasErrors())
//		{
//			return ResponseEntity.badRequest().body(null);
//		}
//		
//		Hotel newHotel = hotelService.addHotel(hotel);
//		return ResponseEntity.ok(newHotel);	
//	}
	
	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> addHotel(@RequestBody HotelDto hotel)
	{
		
		return ResponseEntity.ok(hotelService.addHotel(hotel));
	}
	
//	@PostMapping("/addCatering")
//	public ResponseEntity<Catering> addCatering(@RequestBody Catering catering, BindingResult bindingResult)
//	{
//		if(bindingResult.hasErrors())
//		{
//			return ResponseEntity.badRequest().body(null);
//		}
//		
//		Catering newCatering = cateringService.addCatering(catering);
//		return ResponseEntity.ok(newCatering);	
//	}
	
	@PostMapping("/addCatering")
	public ResponseEntity<Catering> addCatering(@RequestBody CateringDto catering)
	{
		return ResponseEntity.ok(cateringService.addCatering(catering));
			
	}
	
	@GetMapping("/getAllCatering")
	public ResponseEntity<?> getAllCatering()
	{
		try {
            return ResponseEntity.ok(cateringService.getAllCatering());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving catering list");
        }
	}
	
	@GetMapping("/getAllHotel")
	public ResponseEntity<?> getAllHotel()
	{
		try {
            return ResponseEntity.ok(hotelService.getAllHotel());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving catering list");
        }
	}
	
	@PutMapping("/updateHotel")
	public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel, @RequestParam Long id)
	{
		hotel.setId(id);
		
		return ResponseEntity.ok(hotelService.updateHotel(hotel));
	}
	
	@GetMapping("/{hotelName}")
    public ResponseEntity<Hotel> findHotelByName(@PathVariable String hotelName) {
        Hotel hotel = hotelService.findByName(hotelName);
        if (hotel != null) {
            return new ResponseEntity<>(hotel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
	
	}

}
