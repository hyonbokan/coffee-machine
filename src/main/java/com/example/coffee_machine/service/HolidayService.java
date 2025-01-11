package com.example.coffee_machine.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.lang.String;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable; // make sure to import from spring, not jakarta!
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.coffee_machine.dto.PublicHoliday;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class HolidayService {
    
    private final RestTemplate restTemplate;    

    @Value("${nager.api.url}")
    private String nagerApiUrl;

    @Cacheable("publicHolidays")
    public List<LocalDate> getPublicHolidays(String countryCode, int year) {
        String url = String.format("%s/PublicHolidays/%d/%s", nagerApiUrl, year, countryCode);
        ResponseEntity<PublicHoliday[]> response = restTemplate.getForEntity(url, PublicHoliday[].class);

        if (response.getStatusCode() != HttpStatus.OK || response.getBody() == null) {
            throw new RuntimeException("Failed to fetch public holidays");
        }

        // parse the date field (string) into a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return Arrays.stream(response.getBody())
                     .map(holiday -> LocalDate.parse(holiday.getDate(), formatter))
                     .collect(Collectors.toList());
    }
}
