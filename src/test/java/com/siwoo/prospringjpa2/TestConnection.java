package com.siwoo.prospringjpa2;

import com.siwoo.prospringjpa2.config.JpaConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.EntityManagerFactory;

import static org.junit.Assert.assertNotNull;

public class TestConnection {

    ApplicationContext c = new AnnotationConfigApplicationContext(JpaConfiguration.class);

    @Test
    public void entityManagerFactory() {
        assertNotNull(c.getBean(EntityManagerFactory.class));
    }
}
