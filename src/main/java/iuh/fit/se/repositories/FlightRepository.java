package iuh.fit.se.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.fit.se.entities.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer>{
	@Query(value = "Select * from Flight f order by f.departure_date DESC, f.airplane_name ASC", nativeQuery = true)
	List<Flight> findAllFlightSort();
	
	@Query(value = "Select f.* from Flight f where f.airplane_name like %:keyword%", nativeQuery = true)
	List<Flight> search(String keyword);

}
