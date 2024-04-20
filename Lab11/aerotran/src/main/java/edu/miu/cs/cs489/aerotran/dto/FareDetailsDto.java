package edu.miu.cs.cs489.aerotran.dto;

public record FareDetailsDto(String fareDetailsId , String fare, String seatType) {
    public FareDetailsDto(String fare, String seatType) {
        this(null, fare, seatType);
    }
}
