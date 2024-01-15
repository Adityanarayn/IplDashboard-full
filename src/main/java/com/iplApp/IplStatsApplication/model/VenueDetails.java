package com.iplApp.IplStatsApplication.model;

import org.springframework.web.bind.annotation.CrossOrigin;

import jakarta.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenueDetails {
    private String stadiumName; // this might create a problem later in creating the bean


}
