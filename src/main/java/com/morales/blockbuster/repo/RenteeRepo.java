package com.morales.blockbuster.repo;

import com.morales.blockbuster.models.Rentee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RenteeRepo extends JpaRepository<Rentee, Integer> {
}
