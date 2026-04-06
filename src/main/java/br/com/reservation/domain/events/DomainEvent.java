package br.com.reservation.domain.events;

import java.time.Instant;

@FunctionalInterface
public interface DomainEvent {

    Instant ocurredOn();
}
