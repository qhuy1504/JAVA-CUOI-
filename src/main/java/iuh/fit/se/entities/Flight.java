package iuh.fit.se.entities;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.FutureOrPresent;

@Entity
@Table(name = "flight")
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 255)
	private String airplane_name;
	
	@Column(nullable = false, length = 255)
	private String departure_airport;
	
	@Column(nullable = false, length = 255)
	private String arrival_airport;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Departure date must be in the present or future")
	@Temporal(TemporalType.DATE)
	private Date departure_date;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@FutureOrPresent(message = "Departure date must be in the present or future")
	@Temporal(TemporalType.DATE)
	private Date arrival_date;
	
	private double seat_fare;
	private Boolean flight_status;
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Flight(int id, String airplane_name, String departure_airport, String arrival_airport, Date departure_date,
			Date arrival_date, double seat_fare, Boolean flight_status) {
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
		return "Flight [id=" + id + ", airplane_name=" + airplane_name + ", departure_airport=" + departure_airport
				+ ", arrival_airport=" + arrival_airport + ", departure_date=" + departure_date + ", arrival_date="
				+ arrival_date + ", seat_fare=" + seat_fare + ", flight_status=" + flight_status + "]";
	}
	

}
