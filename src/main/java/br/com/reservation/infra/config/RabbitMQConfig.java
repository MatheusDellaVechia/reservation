package br.com.reservation.infra.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;

@ApplicationScoped
public class RabbitMQConfig {

    private static final Logger LOG = Logger.getLogger(RabbitMQConfig.class);

    private static final String EXCHANGE_NAME = "reserve-events";
    private static final String QUEUE_NAME = "reserve-created-queue";
    private static final String ROUTING_KEY = "reserve.created";

    @ConfigProperty(name = "rabbitmq-host", defaultValue = "localhost")
    String host;

    @ConfigProperty(name = "rabbitmq-port", defaultValue = "5672")
    int port;

    @ConfigProperty(name = "rabbitmq-username", defaultValue = "guest")
    String username;

    @ConfigProperty(name = "rabbitmq-password", defaultValue = "guest")
    String password;

    void onStart(@Observes StartupEvent ev) {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(port);
        factory.setUsername(username);
        factory.setPassword(password);

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {

            // Declarar o exchange
            channel.exchangeDeclare(
                    EXCHANGE_NAME,
                    BuiltinExchangeType.TOPIC,
                    true,  // durable
                    false, // auto-delete
                    null   // arguments
            );

            // Declarar a fila
            channel.queueDeclare(
                    QUEUE_NAME,
                    true,  // durable
                    false, // exclusive
                    false, // auto-delete
                    null   // arguments
            );

            // Fazer o bind da fila ao exchange
            channel.queueBind(
                    QUEUE_NAME,
                    EXCHANGE_NAME,
                    ROUTING_KEY
            );

            LOG.infof("RabbitMQ configured successfully: Exchange='%s', Queue='%s', RoutingKey='%s'",
                    EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY);

        } catch (Exception e) {
            LOG.error("Failed to configure RabbitMQ", e);
        }
    }
}

