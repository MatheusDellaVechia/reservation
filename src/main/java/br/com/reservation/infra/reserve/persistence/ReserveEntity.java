package br.com.reservation.infra.reserve.persistence;

import br.com.reservation.domain.reserve.models.Status;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "reserves")
@Entity
@NoArgsConstructor
@Getter
public class ReserveEntity extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "fligth_number")
    private String flightNumber;

    @Column(name = "departure_airport")
    private String departureAirport;

    @Column(name = "arrival_airport")
    private String arrivalAirport;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "seat")
    private String seat;

    @Column(name = "reservation")
    private String reservationCode;

    @Column(name = "purchase")
    private LocalDateTime purchaseDate;

    public ReserveEntity(final UUID userId,
                         final String flightNumber,
                         final String departureAirport,
                         final String arrivalAirport,
                         final Status status,
                         final LocalDateTime departureDate,
                         final LocalDateTime arrivalDate,
                         final String seat,
                         final String reservationCode,
                         final LocalDateTime purchaseDate
    ) {
        this.userId = userId;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.status = status;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.seat = seat;
        this.reservationCode = reservationCode;
        this.purchaseDate = purchaseDate;
    }


    public UUID getUserId() {
        return userId;
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

    public Status getStatus() {
        return status;
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

    public String getReservationCode() {
        return reservationCode;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }
}
