package com.morales.blockbuster.models;

import com.morales.blockbuster.models.enums.MovieFormat;
import com.morales.blockbuster.models.enums.MovieGenre;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue //Use Integer for example in production we'd use UUID
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int releaseYear;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieGenre genre;

    /// private LocalDate dateOfBirth; (If we ever want to add pg13, rated r movies) :)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MovieFormat format;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private String upc;

    @Column(nullable = false)
    private BigDecimal dailyPrice;
}
