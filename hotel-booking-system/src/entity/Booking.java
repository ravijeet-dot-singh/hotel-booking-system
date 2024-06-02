package entity;

import enums.BookingStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Booking {

    private String id;
    private Hotel hotel;
    private BookingStatus status;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    private List<Room> rooms = new ArrayList<>();

    public Booking(String id, Hotel hotel, BookingStatus status, LocalDateTime checkIn, LocalDateTime checkOut) {
        this.id = id;
        this.hotel = hotel;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Booking(String id, Hotel hotel, BookingStatus status, LocalDateTime checkIn, LocalDateTime checkOut, List<Room> rooms) {
        this.id = id;
        this.hotel = hotel;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.rooms = rooms;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
