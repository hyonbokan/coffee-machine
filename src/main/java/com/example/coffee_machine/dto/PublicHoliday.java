package com.example.coffee_machine.dto;

import lombok.Data;

@Data
public class PublicHoliday {
    private String date;
    private String localName;
    private String name;
    private boolean global;
}
