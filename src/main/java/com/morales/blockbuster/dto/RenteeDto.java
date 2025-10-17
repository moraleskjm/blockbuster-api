package com.morales.blockbuster.dto;

public record RenteeDto(String fullName,
                        String email,
                        String phoneNumber,
                        String membershipId,
                        String fullAddress) {
}
