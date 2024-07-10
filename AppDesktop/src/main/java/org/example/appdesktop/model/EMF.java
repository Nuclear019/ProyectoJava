package org.example.appdesktop.model;

import jakarta.persistence.EntityManagerFactory;

import static jakarta.persistence.Persistence.createEntityManagerFactory;

public class EMF {
    private static volatile EntityManagerFactory emfInstance;
    private EMF() {}
    public static EntityManagerFactory get() {
        if (emfInstance == null) {
            synchronized (EMF.class) {
                if (emfInstance == null) {
                    emfInstance = createEntityManagerFactory("nbaDatabase");
                }
            }
        }
        return emfInstance;
    }
}
