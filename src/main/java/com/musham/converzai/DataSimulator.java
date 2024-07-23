package com.musham.converzai;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.IntStream;

@Component
public class DataSimulator {
    private final SongRepository songRepository;
    private final Random random = new Random();

    public DataSimulator(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostConstruct
    public void init() {
        IntStream.range(0, 1000).forEach(i -> {
            Song song = generateRandomSong();
            songRepository.save(song);
        });
    }

    private Song generateRandomSong() {
        Song song = new Song();
        song.setTitle("Song Title " + random.nextInt(1000));
        song.setArtist("Artist " + random.nextInt(100));
        song.setAlbum("Album " + random.nextInt(100));
        song.setGenre("Genre" + random.nextInt(10));

        SongStats songStats = new SongStats();
        songStats.setPlayCount(random.nextInt(10000));
        songStats.setUserRating(random.nextDouble() * 5);
        songStats.setSocialMediaShares(random.nextInt(1000));
        songStats.setGeographicPopularity("Region " + random.nextInt(10));
        songStats.setLastPlayed(getRandomDate());
        songStats.setSong(song);

        song.setSongStats(List.of(songStats));

        return song;
    }


    private Date getRandomDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_MONTH, -1 * random.nextInt(100));
        return calendar.getTime();
    }
}
