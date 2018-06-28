package com.booking.dto;

import java.sql.Timestamp;
import java.util.List;

import lombok.Data;

public @Data class ProductReservationDto {
    private int id;
    private String name;
    private int fileId;
    private String observationTime;
    private Timestamp displayStart;
    private Timestamp displayEnd;
    private String placeStreet;
    private String placeLot;
    private List<ProductPriceDto> productPrices;
}
