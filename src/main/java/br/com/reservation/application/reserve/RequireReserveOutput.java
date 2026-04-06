package br.com.reservation.application.reserve;

import br.com.reservation.domain.reserve.Reserve;
import br.com.reservation.domain.reserve.models.Status;

public record RequireReserveOutput(String id, Status status) {

    public static RequireReserveOutput from(final Reserve reserve) {
        return new RequireReserveOutput(reserve.getId().value(), reserve.getStatus());
    }
}
