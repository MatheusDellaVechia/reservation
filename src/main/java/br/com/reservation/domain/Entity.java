package br.com.reservation.domain;

public abstract class Entity<I extends Identifier> {

    protected final I i;

    public I getId() {
        return this.i;
    }

    public abstract void validate();

    protected Entity(I i) {
        this.i = i;
    }
}
