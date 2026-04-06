package br.com.reservation.domain.reserve;


import br.com.reservation.domain.Identifier;

public record ReserveID(String value)
        implements Identifier {

    public static ReserveID from(final String value) {
        return new ReserveID(value);
    }
}
