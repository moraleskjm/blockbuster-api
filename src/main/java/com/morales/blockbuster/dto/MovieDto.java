package com.morales.blockbuster.dto;

import com.morales.blockbuster.models.enums.MovieFormat;
import com.morales.blockbuster.models.enums.MovieGenre;
import java.math.BigDecimal;

public record MovieDto(String title,
                       int releaseYear,
                       MovieGenre movieGenre,
                       MovieFormat movieFormat,
                       int stock,
                       String upc,
                       BigDecimal dailyPrice) {
}

/// Example Json
///{ "title":"The Dark Knight",
/// "releaseYear":2008,"movieGenre":"SCIFI",
/// "movieFormat":"BLURAY",
/// "stock":4,
/// "upc":"883929064502",
/// "dailyPrice":3.49 }