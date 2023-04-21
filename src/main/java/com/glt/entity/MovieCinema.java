package com.glt.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class MovieCinema extends BaseEntity {

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;


}
