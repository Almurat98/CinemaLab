package com.glt.entity;

import com.glt.enums.State;
import com.glt.enums.Type;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Movie extends BaseEntity{


    private Integer duration;
    private String name;
    private BigDecimal price;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime releaseDate;
    @Enumerated(EnumType.STRING)
    private State state;
    @Column(columnDefinition = "text")
    private String summary;
    @Enumerated(EnumType.STRING)
    private Type type;

    @ManyToMany
    @JoinTable(name = "movie_genre_rel",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private List<Genre> genre;

    @Override
    public String toString() {
        return "Movie{" +
                "duration=" + duration +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", releaseDate=" + releaseDate +
                ", state=" + state +
                ", summary='" + summary + '\'' +
                ", type=" + type +
                '}';
    }
}
