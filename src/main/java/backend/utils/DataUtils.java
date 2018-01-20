package backend.utils;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import org.hibernate.Session;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

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
    //Zwraca dane wszystkich kolizji zadanego DrugsEntity.
    public static List<CollisionData> getCollisionData(DrugsEntity drug) {
        List<CollisionData> results = null;
        try (Session session = Connections.getSession()) {
            String collisionQuery = "SELECT drug_name, comment, severity_text\n" +
                    "FROM Dosage_Collisions\n" +
                    "JOIN Drugs ON Dosage_Collisions.drug_id=Drugs.drug_id\n" +
                    "JOIN Collision_Groups ON Dosage_Collisions.collision_group_id=Collision_Groups.collision_group_id\n" +
                    "JOIN Collision_Severities ON Collision_Groups.collision_severity_id=Collision_Severities.collision_severity_id\n" +
                    "JOIN(\n" +
                    "SELECT Dosage_Collisions.collision_group_id\n" +
                    "FROM Dosage_Collisions\n" +
                    "JOIN Drugs ON Dosage_Collisions.drug_id=Drugs.drug_id\n" +
                    "JOIN Collision_Groups ON Dosage_Collisions.collision_group_id=Collision_Groups.collision_group_id\n" +
                    "JOIN Collision_Severities ON Collision_Groups.collision_severity_id=Collision_Severities.collision_severity_id\n" +
                    "WHERE drug_name='" + drug.getDrugName() + "'\n" +
                    ") collisions_for_given_drug ON Dosage_Collisions.collision_group_id=collisions_for_given_drug.collision_group_id\n" +
                    "WHERE drug_name != '" + drug.getDrugName() + "';";
            List rawResults = session.createNativeQuery(collisionQuery).list();
            results = parseRawResults(rawResults);

        }
        return results;
    }

    private static List<CollisionData> parseRawResults(List rawResults) {
        List<CollisionData> results = new ArrayList<>();
        for (Object r : rawResults) {
            Object[] data = (Object[]) r;
            String drug_name = (String) data[0];
            Clob commentClob = (Clob) data[1];
            String severity = (String) data[2];
            results.add(new CollisionData(drug_name, commentClob, severity));
        }
        return results;
    }
}
