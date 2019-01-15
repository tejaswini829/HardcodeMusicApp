package com.stackroute.MuzixApp.seeders;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.repository.MusicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:name.properties")

@Component
public class DataLoader implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(DataLoader.class);

    private MusicRepository musicRepository;

    @Value("${trackthree}")
    private int thirdTrack;
    @Value("${trackthreename}")
    private String thirdTrackName;
    @Value("${trackthreecomment}")
    private String thirdTrackComment;

    @Autowired
    public DataLoader(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Loading data via CLR");


        Track track = new Track();
        track.setTrackId(thirdTrack);
        track.setTrackName(thirdTrackName);
        track.setTrackComments(thirdTrackComment);
        musicRepository.save(track);


    }
}