package iuh.fit.se.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class FlightDTO {
	private int id;
	@NotNull(message = "Airplane name must not be Null")
	@NotEmpty(message = "Airplane name must not be Empty")
	private String airplane_name;
	
	@NotNull(message = "Departure Airport name must not be Null")
	@NotEmpty(message = "Departure Airport name must not be Empty")
	private String departure_airport;
	
	@NotNull(message = "Arrival Airport name must not be Null")
	@NotEmpty(message = "Arrival Airport name must not be Empty")
	private String arrival_airport;
	
	@NotNull(message = "Departure date name must not be Null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Departure date must be in the present or future")
	@Temporal(TemporalType.DATE)
	private Date departure_date;
	
	@NotNull(message = "Arrival date name must not be Null")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Arrival date must be in the present or future")
	@Temporal(TemporalType.DATE)
	private Date arrival_date;
	
	@NotNull(message = "Seat fare must not be Null")
	@Min(value = 1, message = "Seat fare must not be less than 0")
	private double seat_fare;
	
	@NotNull(message = "Flight status must not be Null")
	
	private Boolean flight_status;

	public FlightDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FlightDTO(int id,
			@NotNull(message = "Airplane name must not be Null") @NotEmpty(message = "Airplane name must not be Empty") String airplane_name,
			@NotNull(message = "Departure Airport name must not be Null") @NotEmpty(message = "Departure Airport name must not be Empty") String departure_airport,
			@NotNull(message = "Arrival Airport name must not be Null") @NotEmpty(message = "Arrival Airport name must not be Empty") String arrival_airport,
			@NotNull(message = "Departure date name must not be Null") Date departure_date,
			@NotNull(message = "Arrival date name must not be Null") Date arrival_date,
			@NotNull(message = "Seat fare must not be Null") @Min(value = 1, message = "Seat fare must not be less than 0") double seat_fare,
			@NotNull(message = "Flight status must not be Null") @NotEmpty(message = "Flight status must not be Empty") Boolean flight_status) {
		super();
		this.id = id;
		this.airplane_name = airplane_name;
		this.departure_airport = departure_airport;
		this.arrival_airport = arrival_airport;
		this.departure_date = departure_date;
		this.arrival_date = arrival_date;
		this.seat_fare = seat_fare;
		this.flight_status = flight_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAirplane_name() {
		return airplane_name;
	}

	public void setAirplane_name(String airplane_name) {
		this.airplane_name = airplane_name;
	}

	public String getDeparture_airport() {
		return departure_airport;
	}

	public void setDeparture_airport(String departure_airport) {
		this.departure_airport = departure_airport;
	}

	public String getArrival_airport() {
		return arrival_airport;
	}

	public void setArrival_airport(String arrival_airport) {
		this.arrival_airport = arrival_airport;
	}

	public Date getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(Date departure_date) {
		this.departure_date = departure_date;
	}

	public Date getArrival_date() {
		return arrival_date;
	}

	public void setArrival_date(Date arrival_date) {
		this.arrival_date = arrival_date;
	}

	public double getSeat_fare() {
		return seat_fare;
	}

	public void setSeat_fare(double seat_fare) {
		this.seat_fare = seat_fare;
	}

	public Boolean getFlight_status() {
		return flight_status;
	}

	public void setFlight_status(Boolean flight_status) {
		this.flight_status = flight_status;
	}

	@Override
	public String toString() {
		return "FlightDTO [id=" + id + ", airplane_name=" + airplane_name + ", departure_airport=" + departure_airport
				+ ", arrival_airport=" + arrival_airport + ", departure_date=" + departure_date + ", arrival_date="
				+ arrival_date + ", seat_fare=" + seat_fare + ", flight_status=" + flight_status + "]";
	}
	

}
