package dto;

import entity.Room;

import java.time.LocalDate;
import java.util.List;

public class BookingRequestDTO {

    private Long hotelId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private List<Long> roomIds;

    public BookingRequestDTO(Long hotelId, LocalDate checkIn, LocalDate checkOut, List<Long> roomIds) {
        this.hotelId = hotelId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.roomIds = roomIds;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }
}
