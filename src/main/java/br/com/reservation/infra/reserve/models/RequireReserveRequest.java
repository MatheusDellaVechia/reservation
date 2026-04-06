package br.com.reservation.infra.reserve.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record RequireReserveRequest(
        @JsonProperty(value = "user_id") String userID,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime departureDate,
        LocalDateTime arrivalDate,
        String seat,
        String reservation
) {
}
