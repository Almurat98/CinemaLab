package com.glt.entity;

import com.glt.enums.Status;
import com.glt.enums.Type;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{


    private int duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "DATE_TIME")
    private LocalDateTime releaseDate;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String summary;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genre;

}
