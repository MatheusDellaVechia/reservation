package br.com.reservation.infra.reserve.persistence;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class ReservePanacheRepository implements PanacheRepository<ReserveEntity> {

    @Transactional
    public ReserveEntity save(ReserveEntity entity) {
        persistAndFlush(entity);
        return entity;
    }


}
