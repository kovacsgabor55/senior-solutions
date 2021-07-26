package com.example.movie;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<Integer> ratings;

    public Movie(String title) {
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    public void addRatings(int rating) {
        ratings.add(rating);
    }
}
