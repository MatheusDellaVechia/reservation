package br.com.reservation.application.reserve;

import java.time.LocalDateTime;

public record RequireReserveCommand(
        String userId,
        String flightNumber,
        String departureAirport,
        String arrivalAirport,
        LocalDateTime departureDate,
        LocalDateTime arrivalDate,
        String seat,
        String reservation
) {

    public static RequireReserveCommand from(
            final String userId,
            final String flightNumber,
            final String departureAirport,
            final String arrivalAirport,
            final LocalDateTime departureDate,
            final LocalDateTime arrivalDate,
            final String seat,
            final String reservation
    ) {
        return new RequireReserveCommand(userId, flightNumber, departureAirport, arrivalAirport, departureDate,
                arrivalDate, seat, reservation);
    }
}
