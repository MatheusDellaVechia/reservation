package br.com.reservation.domain;

public record UserID(String value) implements ValueObject {

    public UserID {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("ID cannot be null");
        }
    }

    public static UserID from(final String value) {
        return new UserID(value);
    }
}
