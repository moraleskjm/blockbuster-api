package com.morales.blockbuster.service;

import com.morales.blockbuster.dto.RenteeDto;
import com.morales.blockbuster.models.Rentee;
import com.morales.blockbuster.repo.RenteeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class RenteeService {

    @Autowired
    RenteeRepo renteeRepo;

    //Create rentee
    public RenteeDto createRentee(RenteeDto dto) {
        Rentee rentee = new Rentee();
        rentee.setFullName(dto.fullName());
        rentee.setEmail(dto.email());
        rentee.setPhoneNumber(dto.phoneNumber());
        rentee.setMembershipId(dto.membershipId());
        rentee.setFullAddress(dto.fullAddress());

        Rentee savedRentee = renteeRepo.save(rentee);
        return new RenteeDto(
                savedRentee.getFullName(),
                savedRentee.getEmail(),
                savedRentee.getPhoneNumber(),
                savedRentee.getMembershipId(),
                savedRentee.getFullAddress()
        );
    }

    // Get all rentees (sorted alphabetically by full name, case-insensitive)
    public List<RenteeDto> getAllRentees() {
        return renteeRepo.findAll()
                .stream()
                .sorted(Comparator.comparing(Rentee::getFullName, String.CASE_INSENSITIVE_ORDER))
                .map(r -> new RenteeDto(
                        r.getFullName(),
                        r.getEmail(),
                        r.getPhoneNumber(),
                        r.getMembershipId(),
                        r.getFullAddress()
                ))
                .toList();
    }

    // Find rentee by ID
    public RenteeDto getRenteeById(Integer id) {
        Rentee rentee = renteeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("No rentee found with ID: " + id));

        return new RenteeDto(
                rentee.getFullName(),
                rentee.getEmail(),
                rentee.getPhoneNumber(),
                rentee.getMembershipId(),
                rentee.getFullAddress()
        );
    }

    // Delete rentee
    public String deleteRentee(Integer id) {
        if (!renteeRepo.existsById(id)) {
            throw new RuntimeException("No rentee found with ID: " + id);
        }
        renteeRepo.deleteById(id);
        return "Deleted rentee with ID: " + id;
    }
}
