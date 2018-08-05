package com.siwoo.prospringjpa2.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class JpaSingerSummaryRepository implements SingerSummaryRepository {

    @PersistenceContext
    EntityManager entityManager;

    public static final String SUMMARY_JPQL
            = "select s.firstName, s.lastName, a.title " +
            "from Singer s " +
            "left join s.albums a " +
            "where a.releaseDate = (select max(a2.releaseDate) from Album a2 " +
            "where a2.singer.id = s.id) ";

    @Transactional(readOnly = true)
    @Override
    public void recentSingerSummary() {
        List results = entityManager.createQuery(SUMMARY_JPQL).getResultList();

        results.forEach(result -> {
                    Object[] values = (Object[]) result;
                    System.out.println(values[0] +", " + values[1] + ", recent album " + values[2]);
                });
    }
}
