package dto;

import java.util.ArrayList;
import java.util.List;

public class HotelSearchResponseDTO {

    private List<HotelSearchDTO> hotelSearchDTOS = new ArrayList<>();

    public HotelSearchResponseDTO(List<HotelSearchDTO> hotelSearchDTOS) {
        this.hotelSearchDTOS = hotelSearchDTOS;
    }

    public List<HotelSearchDTO> getHotelSearchDTOS() {
        return hotelSearchDTOS;
    }

    public void setHotelSearchDTOS(List<HotelSearchDTO> hotelSearchDTOS) {
        this.hotelSearchDTOS = hotelSearchDTOS;
    }
}
