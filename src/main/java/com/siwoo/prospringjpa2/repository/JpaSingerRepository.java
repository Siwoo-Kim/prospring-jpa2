package com.siwoo.prospringjpa2.repository;

import com.siwoo.prospringjpa2.domain.Singer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class JpaSingerRepository implements SingerRepository {
    private final static String NATIVE_SELECT_ALL
            = "select id, first_name, last_name, birth_date, version " +
            "from singer";
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Singer> findAll() {
        return entityManager
                .createNamedQuery(Singer.FIND_ALL, Singer.class)
                .getResultList();
    }

    @Override
    public List<Singer> findAllFetched() {
        return entityManager
                .createNamedQuery(Singer.FIND_ALL_FETCHED, Singer.class)
                .getResultList();
    }

    @Override
    public Singer findById(long id) {
        return entityManager
                .createNamedQuery(Singer.FIND_BY_ID, Singer.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
