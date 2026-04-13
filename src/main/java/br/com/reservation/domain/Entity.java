package br.com.reservation.domain;


public abstract class Entity<I extends Identifier> {

    protected final I id;


    public I getId() {
        return this.id;
    }

    public abstract void validate();

    protected Entity(final I id) {
        this.id = id;
    }
}
