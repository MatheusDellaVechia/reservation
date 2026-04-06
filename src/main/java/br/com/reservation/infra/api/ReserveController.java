package br.com.reservation.infra.api;

import br.com.reservation.application.reserve.RequireReserveCommand;
import br.com.reservation.application.reserve.RequireReserveUseCase;
import br.com.reservation.infra.reserve.models.RequireReserveRequest;
import br.com.reservation.infra.reserve.models.RequireReserveResponse;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/reserves")
public class ReserveController {

    private final RequireReserveUseCase requireReserveUseCase;

    public ReserveController(RequireReserveUseCase requireReserveUseCase) {
        this.requireReserveUseCase = requireReserveUseCase;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createReserve(final RequireReserveRequest request) {
        final var command = RequireReserveCommand.from(
                request.userID(),
                request.flightNumber(),
                request.departureAirport(),
                request.arrivalAirport(),
                request.departureDate(),
                request.arrivalDate(),
                request.seat(),
                request.reservation()
        );
        final var out = requireReserveUseCase.execute(command);
        return Response.ok(RequireReserveResponse.from(out)).build();
    }
}
