package com.musham.converzai;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrendingService {
    private final SongRepository songRepository;

    public TrendingService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Cacheable("topTrendingSongs")
    public List<Song> getTopTrendingSongs() {
        return songRepository.findAll().stream()
                .flatMap(song -> song.getSongStats().stream())
                .sorted(this::compareSongStats)
                .limit(100)
                .map(SongStats::getSong)
                .collect(Collectors.toList());
    }

    @Cacheable("topTrendingSongsByGenre")
    public List<Song> getTopTrendingSongsByGenre(String genre) {
        return songRepository.findByGenre(genre).stream()
                .flatMap(song -> song.getSongStats().stream())
                .sorted(this::compareSongStats)
                .limit(100)
                .map(SongStats::getSong)
                .collect(Collectors.toList());
    }

    private int compareSongStats(SongStats s1, SongStats s2) {
        double score1 = calculateTrendingScore(s1);
        double score2 = calculateTrendingScore(s2);
        return Double.compare(score2, score1);
    }

    private double calculateTrendingScore(SongStats songStats) {
        double playCountScore = songStats.getPlayCount() * 0.4;

        LocalDateTime lastPlayed = songStats.getLastPlayed().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime now = LocalDateTime.now();
        double recencyScore = (1.0 / (1 + lastPlayed.until(now, ChronoUnit.HOURS))) * 0.3;

        double ratingScore = songStats.getUserRating() * 0.2;
        double socialMediaScore = songStats.getSocialMediaShares() * 0.1;
        return playCountScore + recencyScore + ratingScore + socialMediaScore;
    }
}
