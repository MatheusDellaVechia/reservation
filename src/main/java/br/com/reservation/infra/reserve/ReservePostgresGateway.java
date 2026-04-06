package br.com.reservation.infra.reserve;

import br.com.reservation.domain.UserID;
import br.com.reservation.domain.reserve.Reserve;
import br.com.reservation.domain.reserve.ReserveGateway;
import br.com.reservation.domain.reserve.ReserveID;
import br.com.reservation.infra.reserve.persistence.ReserveEntity;
import br.com.reservation.infra.reserve.persistence.ReservePanacheRepository;
import jakarta.inject.Singleton;

import java.util.UUID;

@Singleton
public record ReservePostgresGateway(
        ReservePanacheRepository repository
) implements ReserveGateway {

    @Override
    public Reserve save(Reserve reserve) {
        final var entity = this.from(reserve);
        this.repository.save(entity);
        return this.toAggregate(entity);
    }

    private ReserveEntity from(final Reserve reserve) {
        return new ReserveEntity(
                UUID.fromString(reserve.getUserID().value()),
                reserve.getFlightNumber(),
                reserve.getDepartureAirport(),
                reserve.getArrivalAirport(),
                reserve.getStatus(),
                reserve.getDepartureDate(),
                reserve.getArrivalDate(),
                reserve.getSeat(),
                reserve.getReservation(),
                reserve.getPurchaseDate()
        );
    }

    private Reserve toAggregate(final ReserveEntity entity) {
        return Reserve.with(
                ReserveID.from(entity.getId().toString()),
                UserID.from(entity.getUserId().toString()),
                entity.getFlightNumber(),
                entity.getDepartureAirport(),
                entity.getArrivalAirport(),
                entity.getDepartureDate(),
                entity.getArrivalDate(),
                entity.getSeat(),
                entity.getReservationCode(),
                entity.getStatus(),
                entity.getPurchaseDate()
        );
    }
}
