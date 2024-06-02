package dto;

import entity.Room;

import java.util.List;

public class HotelSearchDTO {

    private Long hotelId;
    private String hotelName;
    private List<Room> rooms;

    public HotelSearchDTO(Long hotelId, String hotelName, List<Room> rooms) {
        this.hotelId = hotelId;
        this.hotelName = hotelName;
        this.rooms = rooms;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
