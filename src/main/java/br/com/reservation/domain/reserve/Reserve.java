package br.com.reservation.domain.reserve;

import br.com.reservation.domain.AggregateRoot;
import br.com.reservation.domain.user.UserID;
import br.com.reservation.domain.reserve.models.Status;

import java.time.LocalDateTime;

public class Reserve extends AggregateRoot<ReserveID> {
    private final UserID userID;
    private final String flightNumber;
    private final String departureAirport;
    private final String arrivalAirport;
    private final LocalDateTime departureDate;
    private final LocalDateTime arrivalDate;
    private final String seat;
    private final String reservation;
    private final Status status;
    private final LocalDateTime purchaseDate;

    protected Reserve(
            final ReserveID reserveID,
            final UserID userID,
            final String flightNumber,
            final String departureAirport,
            final String arrivalAirport,
            final LocalDateTime departureDate,
            final LocalDateTime arrivalDate,
            final String seat,
            final String reservation,
            final Status status,
            final LocalDateTime purchaseDate
    ) {
        super(reserveID);
        this.userID = userID;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seat = seat;
        this.reservation = reservation;
        this.status = status;
        this.purchaseDate = purchaseDate;
        this.validate();
    }

    public static Reserve newReserve(
            final UserID userID,
            final String flightNumber,
            final String departureAirport,
            final String arrivalAirport,
            final LocalDateTime departureDate,
            final LocalDateTime arrivalDate,
            final String seat,
            final String reservation
    ) {
        final var status = Status.PENDING;
        final var purchase = LocalDateTime.now();
        return new Reserve(
                null, userID, flightNumber, departureAirport, arrivalAirport, departureDate,
                arrivalDate, seat, reservation, status, purchase
        );
    }

    public static Reserve with(final ReserveID reserveID,
                               final UserID userID,
                               final String flightNumber,
                               final String departureAirport,
                               final String arrivalAirport,
                               final LocalDateTime departureDate,
                               final LocalDateTime arrivalDate,
                               final String seat,
                               final String reservation,
                               final Status status,
                               final LocalDateTime purchaseDate
    ) {
        return new Reserve(
                reserveID, userID, flightNumber, departureAirport, arrivalAirport, departureDate,
                arrivalDate, seat, reservation, status, purchaseDate
        );
    }

    @Override
    public void validate() {
        if (userID == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Flight number cannot be null");
        }
    }

    public UserID getUserID() {
        return userID;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public LocalDateTime getDepartureDate() {
        return departureDate;
    }

    public LocalDateTime getArrivalDate() {
        return arrivalDate;
    }

    public String getSeat() {
        return seat;
    }

    public String getReservation() {
        return reservation;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
}
