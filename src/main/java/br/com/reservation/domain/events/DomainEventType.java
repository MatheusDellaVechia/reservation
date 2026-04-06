package br.com.reservation.domain.events;

public enum DomainEventType {

    RESERVE_CREATED("reserve.created"),
    RESERVE_CONFIRMED("reserve.confirmed"),
    RESERVE_CANCELLED("reserve.cancelled"),
    RESERVE_PAYMENT_COMPLETED("reserve.payment.completed");

    private final String eventName;

    DomainEventType(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return this.eventName;
    }
}
