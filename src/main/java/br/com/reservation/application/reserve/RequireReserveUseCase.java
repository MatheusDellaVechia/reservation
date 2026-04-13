package br.com.reservation.application.reserve;

import br.com.reservation.application.OutUseCase;
import br.com.reservation.application.UseCase;
import br.com.reservation.domain.user.UserID;
import br.com.reservation.domain.reserve.Reserve;
import br.com.reservation.domain.reserve.ReserveGateway;

@UseCase
public class RequireReserveUseCase
        extends OutUseCase<RequireReserveCommand, RequireReserveOutput> {

    private final ReserveGateway requireGateway;

    public RequireReserveUseCase(ReserveGateway requireGateway) {
        this.requireGateway = requireGateway;
    }

    @Override
    public RequireReserveOutput execute(RequireReserveCommand command) {
        final var reserve = Reserve.newReserve(
                UserID.from(command.userId()),
                command.flightNumber(),
                command.departureAirport(),
                command.arrivalAirport(),
                command.departureDate(),
                command.arrivalDate(),
                command.seat(),
                command.reservation()
        );
        return RequireReserveOutput.from(requireGateway.save(reserve));
    }
}
