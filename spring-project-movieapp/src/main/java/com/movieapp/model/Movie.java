/**
 * @Author:Awadhesh
 * Date:14-05-2022
 * Time:14:39
 * Project Name:project-movie-application
 */
package com.movieapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Movie {
    @Id
    @GeneratedValue(generator = "movie_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "movie_gen",sequenceName = "movie_seq",initialValue = 1,allocationSize = 1)
    private Integer movieId;
    @Column(length = 20)
    private  String movieName;
    @Column(length = 20)
    private String language;
    @Column(length = 20)
    private String genre;
    @Column(length =20)
    private String type;
    @Column(length = 20)
    private String format;
    private double ratings;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "movie_id")
    @JsonIgnore
    private Set<Show> shows;

    public Movie(String movieName, String language, String genre, String type, String format, double ratings, Set<Show> shows) {
        this.movieName = movieName;
        this.language = language;
        this.genre = genre;
        this.type = type;
        this.format = format;
        this.ratings = ratings;
        this.shows = shows;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "movieId=" + movieId +
                ", movieName='" + movieName + '\'' +
                ", language='" + language + '\'' +
                ", genre='" + genre + '\'' +
                ", type='" + type + '\'' +
                ", format='" + format + '\'' +
                ", ratings=" + ratings +
                '}';
    }
}
