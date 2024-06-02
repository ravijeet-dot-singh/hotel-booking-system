package service;

import dto.BookingRequestDTO;
import dto.BookingResponseDTO;
import entity.Booking;
import entity.Hotel;
import entity.Payment;
import entity.Room;
import enums.BookingStatus;
import enums.PaymentStatus;
import exception.InvalidDataException;
import repo.HotelRepo;
import repo.RoomRepo;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class BookingService {

    private final HotelRepo hotelRepo;
    private final RoomRepo roomRepo;

    public BookingService(HotelRepo hotelRepo, RoomRepo roomRepo) {
        this.hotelRepo = hotelRepo;
        this.roomRepo = roomRepo;
    }

    public BookingResponseDTO bookHotel(BookingRequestDTO bookingRequestDTO) {
        BookingResponseDTO bookingResponseDTO = new BookingResponseDTO();
        try {
            Hotel hotel = this.hotelRepo.getHotelById(bookingRequestDTO.getHotelId());
            if (Objects.isNull(hotel)) {
                throw new InvalidDataException("Hotel does not exist with given id", "4003");
            }

            Booking booking = new Booking(
                    "BK1234",
                    hotel,
                    BookingStatus.PENDING,
                    LocalDateTime.of(bookingRequestDTO.getCheckIn(), LocalTime.of(10, 0, 0)),
                    LocalDateTime.of(bookingRequestDTO.getCheckOut(), LocalTime.of(12, 0, 0))
                    );

            long numberOfDays = bookingRequestDTO.getCheckIn().until(bookingRequestDTO.getCheckOut(), ChronoUnit.DAYS);

            AtomicReference<Double> totalCost = new AtomicReference<>(0.0);
            List<Long> selectedRoomIds = bookingRequestDTO.getRoomIds();

            hotel.getRooms().parallelStream().forEach(
                    room -> {
                        if (selectedRoomIds.contains(room.getId())) {
                            totalCost.updateAndGet(v -> new Double((double) (v + (numberOfDays * room.getCost()))));
                            List<Booking> bookings = room.getBookings();
                            bookings.add(booking);
                        }
                    }
            );
            //payment gets successful
            Payment payment = new Payment("TX-AB123", PaymentStatus.SUCCESSFUL);

            booking.setStatus(BookingStatus.CONFIRMED);

            bookingResponseDTO.setStatus(BookingStatus.CONFIRMED);
            bookingResponseDTO.setHotelName(hotel.getName());
            bookingResponseDTO.setTotalCost(totalCost.get());
            return bookingResponseDTO;
        } catch (Exception exception) {
            System.out.println("bookHotel | Exception = " + exception.getMessage());
            bookingResponseDTO.setStatus(BookingStatus.FAILED);
        }
        return bookingResponseDTO;
    }
}
