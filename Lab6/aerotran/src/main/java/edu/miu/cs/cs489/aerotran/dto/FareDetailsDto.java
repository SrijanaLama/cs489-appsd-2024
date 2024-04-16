package edu.miu.cs.cs489.aerotran.dto;

public record FareDetailsDto(String fareDetailsId , String fair, String seatType) {
    public FareDetailsDto(String fair, String seatType) {
        this(null, fair, seatType);
    }
}
