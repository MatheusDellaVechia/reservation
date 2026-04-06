package br.com.reservation.domain.events;

import java.util.List;

@FunctionalInterface
public interface DomainEventPublisher {

    void publish(final List<DomainEvent> events);

}
