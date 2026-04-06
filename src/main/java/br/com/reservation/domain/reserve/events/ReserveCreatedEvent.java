package br.com.reservation.domain.reserve.events;

import br.com.reservation.domain.UserID;
import br.com.reservation.domain.events.DomainEvent;
import br.com.reservation.domain.events.DomainEventType;
import br.com.reservation.domain.reserve.ReserveID;

import java.time.Instant;

public record ReserveCreatedEvent(
        ReserveID reserveID,
        UserID userID,
        String flightNumber,
        Instant ocurredOn
) implements DomainEvent {

    public DomainEventType type() {
        return DomainEventType.RESERVE_CREATED;
    }
}
