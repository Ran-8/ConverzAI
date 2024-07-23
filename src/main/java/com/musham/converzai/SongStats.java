package com.musham.converzai;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import java.util.Date;

@Entity
@Data
public class SongStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int playCount;
    private double userRating;
    private int socialMediaShares;
    private String geographicPopularity;
    private Date lastPlayed;

    @ManyToOne
    @JoinColumn(name = "song_id", nullable = false)
    @JsonBackReference
    private Song song;
}
