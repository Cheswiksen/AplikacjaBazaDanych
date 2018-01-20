package backend.utils;

import backend.entities.*;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SuppressWarnings("unchecked")
public class DataUtils {
    public static List<AnimalsEntity> getAnimals() {
        List<AnimalsEntity> animals = null;
        try (Session session = Connections.getSession()) {
            animals = session.createQuery("from AnimalsEntity ").list();
        }
        return animals;
    }

    public static List<DrugsEntity> getDrugs() {
        List<DrugsEntity> drugs = null;
        try (Session session = Connections.getSession()) {
            drugs = session.createQuery("from DrugsEntity ").list();
        }
        return drugs;
    }

    public static List<CollisionData> checkCollisions(List<DrugsEntity> drugsSelected) {
        List<CollisionData> data = null;

        for (DrugsEntity d : drugsSelected) {
            List<CollisionData> dupa = getCollisionData(d);
        }
        return data;
    }

    private static List<CollisionData> getCollisionData(DrugsEntity drug) {
        try (Session session = Connections.getSession()) {
            List<DosageCollisionsEntity> dosageCollisions = session.createQuery("from DosageCollisionsEntity ").list();
            List<CollisionGroupsEntity> collisionGroups = session.createQuery("from CollisionGroupsEntity ").list();
            List<DrugsEntity> drugs = session.createQuery("from DrugsEntity ").list();
            List<CollisionSeveritiesEntity> collisionSeveritioes = session.createQuery("from CollisionSeveritiesEntity ").list();
            List<DosageCollisionsEntity> collisionsWithDrug = dosageCollisions.stream().
                    filter(e -> e.getDrugsByDrugId().equals(drug)).collect(Collectors.toList());
            for (DosageCollisionsEntity col : collisionsWithDrug) {
                List<DosageCollisionsEntity> filteredCollisions = dosageCollisions.stream().
                        filter(e -> !e.equals(drug)
                                && e.getCollisionGroupsByCollisionGroupId().equals(col.getCollisionGroupsByCollisionGroupId())).collect(Collectors.toList());
            }

        }
        return null;
    }
}
