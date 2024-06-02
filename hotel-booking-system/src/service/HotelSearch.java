package service;

import dto.HotelSearchRequestDTO;
import dto.HotelSearchResponseDTO;
import entity.Hotel;

import java.util.List;

public interface HotelSearch {

    HotelSearchResponseDTO search(HotelSearchRequestDTO hotelSearchRequestDTO);
}
