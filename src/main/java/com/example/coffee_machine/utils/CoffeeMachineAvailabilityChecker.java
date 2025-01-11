package com.example.coffee_machine.utils;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.coffee_machine.service.HolidayService;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class CoffeeMachineAvailabilityChecker {

    private final HolidayService holidayService;

    public boolean isOperational() {
        LocalDateTime now = LocalDateTime.now();
        LocalDate today = now.toLocalDate();

        // Check if it's outside working hours
        int hour = now.getHour();
        if (hour < 8 || hour >= 17) {
            return false;
        }

        // Check if it's a weekend
        DayOfWeek dayOfWeek = now.getDayOfWeek();
        if (dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY) {
            return false;
        }

        // Check if it's a public holiday
        List<LocalDate> publicHolidays = holidayService.getPublicHolidays("KZ", today.getYear());
        if (publicHolidays.contains(today)) {
            return false;
        }

        return true;
    }
}
