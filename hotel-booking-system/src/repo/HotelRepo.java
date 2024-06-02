package repo;

import entity.Address;
import entity.Hotel;
import exception.InvalidDataException;

import java.util.*;

public class HotelRepo {

    private List<Hotel> hotels = new ArrayList<>();
    private Map<String, List<Hotel>> hotelsByCity = new HashMap<>();
    private Map<Long, Hotel> hotelsById = new HashMap<>();

    public void addHotel(Hotel hotel) throws Exception {

        try {
            if (this.hotelsById.containsKey(hotel.getId())) {
                throw new InvalidDataException("Hotel already exists with given id", "4002");
            }
            validateHotelData(hotel);
            this.hotels.add(hotel);
            Address address = hotel.getAddress();
            List<Hotel> hotelsInCity = this.hotelsByCity.getOrDefault(address.getCity(), new ArrayList<>());
            hotelsInCity.add(hotel);

            this.hotelsByCity.put(address.getCity(), hotelsInCity);
            this.hotelsById.put(hotel.getId(), hotel);
        } catch (Exception exception) {
            System.out.println("Exception while adding new hotel: " + exception.getMessage());
            throw new Exception("Unable to add hotel");
        }
    }

    public List<Hotel> getHotelByCity(String city) {

        return this.hotelsByCity.getOrDefault(city, new ArrayList<>());
    }

    private void validateHotelData(Hotel hotel) {

        if (Objects.isNull(hotel.getId())
            || Objects.isNull(hotel.getName())
            || Objects.isNull(hotel.getAddress())
            || Objects.isNull(hotel.getRooms())) {
            throw new InvalidDataException("Hotel id/name/address/rooms is null", "4000");
        }
    }

    public Hotel getHotelById(Long hotelId) {

        return this.hotelsById.getOrDefault(hotelId, null);
    }

}
