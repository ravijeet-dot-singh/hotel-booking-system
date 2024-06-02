package dto;

import enums.BookingStatus;

public class BookingResponseDTO {

    private BookingStatus status;
    private String hotelName;
    private Double totalCost;
    private String message;

    public BookingResponseDTO() {
    }

    public BookingResponseDTO(BookingStatus status, String hotelName, Double totalCost, String message) {
        this.status = status;
        this.hotelName = hotelName;
        this.totalCost = totalCost;
        this.message = message;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BookingResponseDTO{" +
                "status=" + status +
                ", hotelName='" + hotelName + '\'' +
                ", totalCost=" + totalCost +
                ", message='" + message + '\'' +
                '}';
    }
}
