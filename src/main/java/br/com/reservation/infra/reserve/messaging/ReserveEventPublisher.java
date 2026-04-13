package br.com.reservation.infra.reserve.messaging;

import io.smallrye.reactive.messaging.rabbitmq.OutgoingRabbitMQMetadata;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.jboss.logging.Logger;

import java.time.ZonedDateTime;

@ApplicationScoped
public class ReserveEventPublisher {

    private static final Logger LOG = Logger.getLogger(ReserveEventPublisher.class);

    @Channel("reserve-created")
    Emitter<ReserveCreatedEvent> emitter;

    public void publishReserveCreated(ReserveCreatedEvent event) {
        try {
            LOG.infof("Publishing reserve created event for reserve: %s", event.reserveId());

            OutgoingRabbitMQMetadata metadata = new OutgoingRabbitMQMetadata.Builder()
                    .withRoutingKey("reserve.created")
                    .withTimestamp(ZonedDateTime.now())
                    .build();

            Message<ReserveCreatedEvent> message = Message.of(event)
                    .addMetadata(metadata);

            emitter.send(message);

            LOG.infof("Reserve created event published successfully for reserve: %s", event.reserveId());
        } catch (Exception e) {
            LOG.errorf(e, "Error publishing reserve created event for reserve: %s", event.reserveId());
            throw new RuntimeException("Failed to publish reserve created event", e);
        }
    }
}

