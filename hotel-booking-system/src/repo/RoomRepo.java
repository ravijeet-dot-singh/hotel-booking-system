package repo;

import entity.Room;
import exception.InvalidDataException;

import java.util.*;

public class RoomRepo {

    private List<Room> rooms = new ArrayList<>();
    private Map<Long, List<Room>> roomsByHotel = new HashMap<>();
    private Map<Long, Room> roomById = new HashMap<>();

    public void addRoom(Room room, Long hotelId) throws Exception {

        try {
            if (this.roomById.containsKey(room.getId())) {
                throw new InvalidDataException("Room already exists with given id", "4003");
            }
            this.rooms.add(room);

            List<Room> roomsInHotel = this.roomsByHotel.getOrDefault(hotelId, new ArrayList<>());
            roomsInHotel.add(room);

            this.roomsByHotel.put(hotelId, roomsInHotel);
            this.roomById.put((long) room.getId(), room);
        } catch (Exception exception) {
            System.out.println("Exception while adding new room: " + exception.getMessage());
            throw new Exception("Unable to add room");
        }
    }

    public List<Room> getRoomsByHotelId(Long hotelId) {

        return this.roomsByHotel.getOrDefault(hotelId, new ArrayList<>());
    }

    public Room getHotelById(Long roomId) {

        return this.roomById.getOrDefault(roomId, null);
    }
}
