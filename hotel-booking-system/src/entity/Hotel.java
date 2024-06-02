package entity;

import java.util.List;

public class Hotel {

    private Long id;
    private String name;
    private Integer numberOfFloors;
    private Integer numberOfRooms;

    private List<Room> rooms;

    private Address address;

    public Hotel(Long id, String name, Integer numberOfFloors, Integer numberOfRooms, List<Room> rooms, Address address) {
        this.id = id;
        this.name = name;
        this.numberOfFloors = numberOfFloors;
        this.numberOfRooms = numberOfRooms;
        this.rooms = rooms;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
