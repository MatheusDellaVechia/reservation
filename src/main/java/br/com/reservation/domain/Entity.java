package br.com.reservation.domain;

import br.com.reservation.domain.events.DomainEvent;

import java.util.List;

public abstract class Entity<I extends Identifier> {

    protected final I id;

    private final List<DomainEvent> events;

    public I getId() {
        return this.id;
    }

    public abstract void validate();

    protected Entity(final I id) {
        this(id, null);
    }

    protected Entity(final I id, final List<DomainEvent> domainEvents) {
        this.id = id;
        this.events = domainEvents;
    }

    public void addEvent(DomainEvent event) {
        this.events.add(event);
    }

    public void clearEvents() {
        this.events.clear();
    }
}
