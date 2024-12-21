package iuh.fit.se.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import iuh.fit.se.dtos.FlightDTO;
import iuh.fit.se.entities.Flight;
import iuh.fit.se.services.FlightService;
import jakarta.validation.Valid;

@Controller
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/flights")
	public String getAllFlights(@Valid @ModelAttribute("flight") FlightDTO flightDTO, BindingResult result,
			Model model) {
		List<FlightDTO> flights = flightService.findAll();
		
		System.out.println(flights);
		FlightDTO flight = new FlightDTO();
		model.addAttribute("flight", flight);
		model.addAttribute("flights", flights);
		return "flight-list";
	}
	//Hiển thị thêm mới , cấp nhật chuyến bay
	@GetMapping({"/flights/add", "/flights/edit/{id}"})
	public String showForm(@PathVariable(value = "id", required = false) Integer id, Model model) {
		FlightDTO flight;
		// Kiểm tra nếu có id, tìm chuyến bay theo id để sửa
		if (id != null && id > 0) {
			flight = flightService.findById(id);
			if (flight == null) {
				return "redirect:/flights?error"; // Nếu không tìm thấy chuyến bay
			}
		} else {
			// Tạo mới chuyến bay khi không có id
			flight = new FlightDTO();
		}
		model.addAttribute("flight", flight);
		return "flight-form";
	}
	@PostMapping({"/flights/add", "/flights/edit/{id}"})
	public String createOrUpdateFlight( @ModelAttribute("flight") @Valid FlightDTO flightDTO, BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "flight-form";
		}
		  // Kiểm tra nếu chuyến bay mới có xung đột với các chuyến bay đã có trong hệ thống
	  
	    if (flightService.isConflict(flightDTO)) {
	        model.addAttribute("error", "Chuyến bay này có xung đột với các chuyến bay khác. Vui lòng kiểm tra lại.");
	        return "flight-form";  // Trở lại trang flight-form với thông báo lỗi
	    }
		
		if (flightDTO.getId() > 0) {
			
            flightService.update(flightDTO.getId(), flightDTO);
           
		}else {
			flightService.save(flightDTO);
		}
	
		return "redirect:/flights";
	}
	//Xóa chuyến bay
	@GetMapping("/flights/delete/{id}")
	public String deleteFlight(@PathVariable(value = "id", required = false)  Integer id) {
		flightService.delete(id);
		return "redirect:/flights";
	}
	

}
