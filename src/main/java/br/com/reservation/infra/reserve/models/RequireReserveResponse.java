package br.com.reservation.infra.reserve.models;

import br.com.reservation.application.reserve.RequireReserveOutput;
import br.com.reservation.domain.reserve.models.Status;

public record RequireReserveResponse(String id, Status status) {

    public static RequireReserveResponse from(final RequireReserveOutput output) {
        return new RequireReserveResponse(output.id(), output.status());
    }
}
