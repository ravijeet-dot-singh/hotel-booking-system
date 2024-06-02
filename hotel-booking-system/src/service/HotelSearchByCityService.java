package service;

import dto.HotelSearchDTO;
import dto.HotelSearchRequestDTO;
import dto.HotelSearchResponseDTO;
import entity.Booking;
import entity.Hotel;
import entity.Room;
import exception.GenericException;
import repo.HotelRepo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchByCityService implements HotelSearch {

    private final HotelRepo hotelRepo;

    public HotelSearchByCityService(HotelRepo hotelRepo) {
        this.hotelRepo = hotelRepo;
    }

    @Override
    public HotelSearchResponseDTO search(HotelSearchRequestDTO hotelSearchRequestDTO) {

        try {
            HotelSearchResponseDTO hotelSearchResponseDTO = new HotelSearchResponseDTO(new ArrayList<>());

            List<Hotel> hotels = hotelRepo.getHotelByCity(hotelSearchRequestDTO.getCity());
            List<Hotel> requiredHotels = new ArrayList<>();

            hotels.stream().forEach(hotel -> {
                List<Room> availableRooms = hotel.getRooms().stream()
                        .filter(
                                room -> isRoomAvailableOnRequiredDate(room, hotelSearchRequestDTO.getCheckIn(), hotelSearchRequestDTO.getCheckOut())
                        ).collect(Collectors.toList());
                if (!availableRooms.isEmpty()) {
                    HotelSearchDTO hotelSearchDTO = new HotelSearchDTO(hotel.getId(), hotel.getName(), availableRooms);
                    hotelSearchResponseDTO.getHotelSearchDTOS().add(hotelSearchDTO);
                }
            });
            return hotelSearchResponseDTO;
        } catch (Exception exception) {
            throw new GenericException("Unable to search hotels at the moment", "5000");
        }
    }

    private boolean isRoomAvailableOnRequiredDate(Room room,
                                                  LocalDate checkIn,
                                                  LocalDate checkOut) {

        List<Booking> bookings = room.getBookings();
        for (Booking booking : bookings) {
            if (checkIn.isAfter(booking.getCheckIn().toLocalDate())
                || checkOut.isBefore(booking.getCheckOut().toLocalDate())) {
                return false;
            }
        }
        return true;
    }
}
