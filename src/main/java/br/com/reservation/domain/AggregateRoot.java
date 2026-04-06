package br.com.reservation.domain;

import br.com.reservation.domain.events.DomainEvent;

import java.util.List;

public abstract class AggregateRoot<I extends Identifier> extends Entity<I> {

    protected AggregateRoot(final I id, final List<DomainEvent> domainEvents) {
        super(id, domainEvents);
    }
}
