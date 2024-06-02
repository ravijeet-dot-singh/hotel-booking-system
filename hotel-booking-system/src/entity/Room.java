package entity;

import enums.RoomStatus;
import enums.RoomType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Room {

    private Long id;
    private RoomType type;
    private RoomStatus status;
    private Double cost;
    private List<Booking> bookings = new ArrayList<>();

    public Room(Long id, RoomType type, RoomStatus status, Double cost) {
        this.id = id;
        this.type = type;
        this.status = status;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
}
