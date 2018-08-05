package com.siwoo.prospringjpa2.repository;

import com.siwoo.prospringjpa2.config.JpaConfiguration;
import com.siwoo.prospringjpa2.domain.Singer;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

public class TestJpaSingerRepository {

    SingerRepository singerRepository;
    SingerSummaryRepository singerSummaryRepository;

    @Before
    public void setup() {
        ApplicationContext c =
                new AnnotationConfigApplicationContext(JpaConfiguration.class);
        singerRepository = c.getBean(SingerRepository.class);
        singerSummaryRepository = c.getBean(SingerSummaryRepository.class);
    }

    @Test
    public void findById() {
        assertEquals(singerRepository.findById(1l).getFirstName(), "Siwoo");
        singerSummaryRepository.recentSingerSummary();
    }
}
