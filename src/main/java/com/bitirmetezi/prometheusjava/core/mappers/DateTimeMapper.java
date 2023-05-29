package com.bitirmetezi.prometheusjava.core.mappers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class DateTimeMapper {
    public static String map(Long timestamp){
        LocalDateTime localDateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(timestamp), ZoneOffset.ofHours(3));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    public static Long map(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(stringDate, formatter);

        return localDateTime.toEpochSecond(ZoneOffset.ofHours(3));
    }
}
