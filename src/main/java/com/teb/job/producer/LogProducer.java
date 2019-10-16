package com.teb.job.producer;

import java.util.Date;
import java.util.Random;

public class LogProducer {

    private static final String[] CITIES = {"ISTANBUL", "TOKYO", "MOSCOW", "BEIJING", "LONDON"};

    private static final LogLevel[] LOG_LEVEL_ENUMS = LogLevel.values();
    private static final int LOG_LEVEL_SIZE = LOG_LEVEL_ENUMS.length;
    private static final Random RANDOM = new Random();

    public static Log createLog() {
        String cityName = getCityName();
        return new Log(
                new Date(),
                String.format("Log from %s", cityName),
                getRandomLogLevel(),
                cityName
        );
    }


    private static LogLevel getRandomLogLevel() {
        return LOG_LEVEL_ENUMS[RANDOM.nextInt(LOG_LEVEL_SIZE)];
    }

    private static String getCityName() {
        return CITIES[RANDOM.nextInt(5)];
    }

}
