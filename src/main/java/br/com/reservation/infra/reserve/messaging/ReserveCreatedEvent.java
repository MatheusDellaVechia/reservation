package br.com.reservation.infra.reserve.messaging;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public record ReserveCreatedEvent(
        @JsonProperty("reserve_id")
        String reserveId,

        @JsonProperty("user_id")
        String userId,

        @JsonProperty("flight_number")
        String flightNumber,

        @JsonProperty("departure_airport")
        String departureAirport,

        @JsonProperty("arrival_airport")
        String arrivalAirport,

        @JsonProperty("departure_date")
        LocalDateTime departureDate,

        @JsonProperty("arrival_date")
        LocalDateTime arrivalDate,

        @JsonProperty("seat")
        String seat,

        @JsonProperty("reservation_code")
        String reservationCode,

        @JsonProperty("status")
        String status,

        @JsonProperty("purchase_date")
        LocalDateTime purchaseDate,

        @JsonProperty("event_timestamp")
        LocalDateTime eventTimestamp
) {
}

