package iuh.fit.se.services;

import java.util.List;

import iuh.fit.se.dtos.FlightDTO;
import iuh.fit.se.entities.Flight;

public interface FlightService {
	public FlightDTO findById(int id);
	public FlightDTO save(FlightDTO flightDTO);
	public boolean delete(int id);
	public FlightDTO update(int id, FlightDTO flightDTO);
	List<FlightDTO> search(String keyword);
	List<FlightDTO> findAll();
	public boolean isConflict(FlightDTO flightDTO);

}
