package com.musham.converzai;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SongController {
    private final TrendingService trendingService;

    public SongController(TrendingService trendingService) {
        this.trendingService = trendingService;
    }

    @GetMapping("/trending-songs")
    public List<Song> getTopTrendingSongs(@RequestParam(required = false) String genre) {
        if (genre != null) {
            return trendingService.getTopTrendingSongsByGenre(genre);
        }
        return trendingService.getTopTrendingSongs();
    }
}
