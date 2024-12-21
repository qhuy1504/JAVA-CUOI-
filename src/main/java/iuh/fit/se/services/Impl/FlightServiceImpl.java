package iuh.fit.se.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.fit.se.dtos.FlightDTO;
import iuh.fit.se.entities.Flight;
import iuh.fit.se.repositories.FlightRepository;
import iuh.fit.se.services.FlightService;

@Service
public class FlightServiceImpl implements FlightService {
	
	@Autowired
	FlightRepository flightRepository;
	@Autowired
	ModelMapper modelMapper;
	
	private FlightDTO covertToDTO(Flight flight) {
		FlightDTO flightDTO = modelMapper.map(flight, FlightDTO.class);
		return flightDTO;
	}

	private Flight covertToEntity(FlightDTO flightDTO) {
		Flight flight = modelMapper.map(flightDTO, Flight.class);
		return flight;
	}

	@Override
	public FlightDTO findById(int id) {
		// TODO Auto-generated method stub
		Flight flight = flightRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Khong tim thay Flight: " + id));
		System.out.println("Flight found: " + flight);
		return this.covertToDTO(flight);
	}

	@Override
	public FlightDTO save(FlightDTO flightDTO) {
		// TODO Auto-generated method stub
		Flight flight = this.covertToEntity(flightDTO);
		flight = flightRepository.save(flight);
		System.out.println("Flight saved: " + flight);
		return this.covertToDTO(flight);
		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		this.findById(id);
		flightRepository.deleteById(id);
		return true;
	}

	@Override
	public FlightDTO update(int id, FlightDTO flightDTO) {
		// TODO Auto-generated method stub
		this.findById(id);
		flightRepository.save(this.covertToEntity(flightDTO));
		System.out.println("SAVE ENTITY" +flightDTO.getId());
		return flightDTO;
	}

	@Override
	public List<FlightDTO> search(String keyword) {
		// TODO Auto-generated method stub
		
		return flightRepository.search(keyword).stream().map(this::covertToDTO).collect(Collectors.toList());
	}

	@Override
	public List<FlightDTO> findAll() {
		// TODO Auto-generated method stub
		
		return flightRepository.findAllFlightSort().stream().map(this::covertToDTO).collect(Collectors.toList());
	}

	@Override
	public boolean isConflict(FlightDTO flight) {
	    // Lấy tất cả các chuyến bay đã có trong hệ thống
	    List<Flight> flights = flightRepository.findAll();
	    
	    for (Flight existingFlight : flights) {
	        // Kiểm tra xem loại máy bay có trùng không
	        if (existingFlight.getAirplane_name().equals(flight.getAirplane_name())) {
	            
	            // Kiểm tra xung đột ngày giờ cho chuyến bay mới
	            // 1. Kiểm tra nếu departure_date của chuyến bay mới nằm trong khoảng từ departure_date đến arrival_date của chuyến bay cũ
	            if ((flight.getDeparture_date().equals(existingFlight.getDeparture_date()) || 
	                 flight.getDeparture_date().after(existingFlight.getDeparture_date())) &&
	                flight.getDeparture_date().before(existingFlight.getArrival_date())) {
	                return true;  // Trùng lặp thời gian khởi hành
	            }
	            
	            // 2. Kiểm tra nếu arrival_date của chuyến bay mới nằm trong khoảng từ departure_date đến arrival_date của chuyến bay cũ
	            if ((flight.getArrival_date().equals(existingFlight.getArrival_date()) || 
	                 flight.getArrival_date().after(existingFlight.getDeparture_date())) &&
	                flight.getArrival_date().before(existingFlight.getArrival_date())) {
	                return true;  // Trùng lặp thời gian đến
	            }

	            // 3. Kiểm tra nếu khoảng thời gian chuyến bay mới hoàn toàn chồng lấp với chuyến bay cũ
	            if (flight.getDeparture_date().before(existingFlight.getArrival_date()) &&
	                flight.getArrival_date().after(existingFlight.getDeparture_date())) {
	                return true;  // Xung đột thời gian chuyến bay hoàn toàn
	            }
	        }
	    }
	    return false;  // Không có xung đột
	}
}

