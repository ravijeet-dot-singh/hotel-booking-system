import dto.*;
import entity.Address;
import entity.Hotel;
import entity.Room;
import enums.RoomStatus;
import enums.RoomType;
import repo.HotelRepo;
import repo.RoomRepo;
import service.BookingService;
import service.HotelSearchByCityService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelBookingSystem {

    private static final HotelRepo hotelRepo = new HotelRepo();
    private static final RoomRepo roomRepo = new RoomRepo();
    private static final HotelSearchByCityService hotelSearchByCityService = new HotelSearchByCityService(hotelRepo);
    private static final BookingService bookingService = new BookingService(hotelRepo, roomRepo);
    private static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public static void main(String[] args) throws Exception {
        System.out.println("hello world");

        addHotels();

        for (int i = 0 ; i < 3 ; i++) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter City:");
            String city = scanner.nextLine();

            List<Hotel> availableHotels = hotelRepo.getHotelByCity(city);
            if (availableHotels.isEmpty()) {
                System.out.println("Sorry we do not have any hotels in this city yet");
                continue;
            }

            System.out.println("Enter check-in day, month, year");
            int checkInDay = scanner.nextInt();
            int checkInMonth = scanner.nextInt();
            int checkInYear = scanner.nextInt();
            LocalDate checkIn = LocalDate.of(checkInYear, checkInMonth, checkInDay);

            System.out.println("Enter check-out day, month, year");
            int checkOutDay = scanner.nextInt();
            int checkOutMonth = scanner.nextInt();
            int checkOutYear = scanner.nextInt();

            LocalDate checkOut = LocalDate.of(checkOutYear, checkOutMonth, checkOutDay);

            HotelSearchRequestDTO hotelSearchRequestDTO = new HotelSearchRequestDTO(city, checkIn, checkOut);

            HotelSearchResponseDTO hotelSearchResponseDTO = hotelSearchByCityService.search(hotelSearchRequestDTO);
            if (hotelSearchResponseDTO.getHotelSearchDTOS().isEmpty()) {
                System.out.println("Sorry, all hotels are booked on provided dates");
                continue;
            }
            System.out.println("*****Available hotels are: **********");
            for (HotelSearchDTO hotel : hotelSearchResponseDTO.getHotelSearchDTOS()) {
                System.out.println("Id: " + hotel.getHotelId());
                System.out.println("Name: " + hotel.getHotelName());
                for (Room room : hotel.getRooms()) {
                    System.out.println("Room Id: " + room.getId());
                    System.out.println("Room Type: " + room.getType());
                    System.out.println("Cost/night: " + room.getCost());
                }

            }
            System.out.println("-----------------------------------");
            System.out.println("Enter id of selected hotel");
            long selectedId = scanner.nextLong();

            System.out.println("Enter id of selected room");
            long selectedRoomId = scanner.nextLong();

            List<Long> roomIds = new ArrayList<>();
            roomIds.add(selectedRoomId);

            BookingRequestDTO bookingRequestDTO = new BookingRequestDTO(selectedId, checkIn, checkOut, roomIds);
            BookingResponseDTO bookingResponseDTO = bookingService.bookHotel(bookingRequestDTO);

            System.out.println(bookingResponseDTO.toString());
        }



    }

    private static void addHotels() throws Exception {
        Room room1 = new Room(1L, RoomType.STANDARD, RoomStatus.AVAILABLE, 1000.0);
        Room room2 = new Room(2L, RoomType.DELUXE, RoomStatus.AVAILABLE, 1500.0);
        Room room3 = new Room(3L, RoomType.FAMILY_SUITE, RoomStatus.AVAILABLE, 2100.0);

        List<Room> rooms1 = new ArrayList<>();
        rooms1.add(room1);
        rooms1.add(room2);
        rooms1.add(room3);

        Address address1 = new Address("Mall Road", "Shimla", "India", "231009");
        Hotel hotel1 = new Hotel(1L, "LemonTree Hotel", 8, 3, rooms1, address1);

        Room room4 = new Room(4L, RoomType.STANDARD, RoomStatus.AVAILABLE, 1000.0);
        Room room5 = new Room(5L, RoomType.DELUXE, RoomStatus.AVAILABLE, 1500.0);
        Room room6 = new Room(6L, RoomType.FAMILY_SUITE, RoomStatus.AVAILABLE, 2100.0);

        List<Room> rooms2 = new ArrayList<>();
        rooms2.add(room4);
        rooms2.add(room5);
        rooms2.add(room6);

        Address address2 = new Address("AB Road", "Chandigarh", "India", "231009");
        Hotel hotel2 = new Hotel(2L, "Holiday Inn", 12, 3, rooms2, address2);

        hotelRepo.addHotel(hotel1);
        hotelRepo.addHotel(hotel2);
    }
}
