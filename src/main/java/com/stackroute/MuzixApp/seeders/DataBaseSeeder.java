package com.stackroute.MuzixApp.seeders;

import com.stackroute.MuzixApp.domain.Track;
import com.stackroute.MuzixApp.repository.MusicRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:name.properties")

@Component
public class DataBaseSeeder implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseSeeder.class);
    private MusicRepository musicRepository;
    @Value("${trackone}")
    private int firstTrack;
    @Value("${trackonename}")
    private String firstTrackName;
    @Value("${trackonecomment}")
    private String firstTrackComment;

    @Autowired
    private Environment env;

    //    @Bean
//    public IApplicationBeanService getService(){
//        return new ApplicationBeansService(env);
//    }
    @Value("${tracktwo}")
    private int secondTrack;
    //
//    private String secondTrackName;
//    private String secondTrackComment;
    @Autowired
    public DataBaseSeeder(MusicRepository musicRepository){
        this.musicRepository=musicRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        logger.info("Entering Data On Start via refreshed");

        Track track1 = new Track();
        track1.setTrackName(firstTrackName);
        track1.setTrackComments(firstTrackComment);
        track1.setTrackId(firstTrack);
        musicRepository.save(track1);


        Track track2 = new Track();
        track2.setTrackName(env.getProperty("tracktwoname"));
        track2.setTrackComments(env.getProperty("tracktwocomment"));

        track2.setTrackId(secondTrack);


        musicRepository.save(track2);

        logger.info("Initial data entered");
    }
}
