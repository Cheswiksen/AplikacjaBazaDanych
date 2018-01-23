package backend.utils;

import backend.entities.AnimalsEntity;
import backend.entities.DrugsEntity;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.Clob;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unchecked")
public class DataUtils {
    public static List<AnimalsEntity> getAnimals() {
        List<AnimalsEntity> animals;
        try (Session session = Connections.getSession()) {
            animals = session.createQuery("from AnimalsEntity ").list();
        }
        return animals;
    }

    public static List<DrugsEntity> getDrugs() {
        List<DrugsEntity> drugs;
        try (Session session = Connections.getSession()) {
            drugs = session.createQuery("from DrugsEntity ").list();
        }
        return drugs;
    }

    public static DrugsEntity getDrugByName(String name) {
        DrugsEntity drug;
        try (Session session = Connections.getSession()) {
            String hql = "from DrugsEntity where drugName=:name";
            Query q = session.createQuery(hql);
            q.setParameter("name", name);
            drug = (DrugsEntity) q.list().get(0);
        }
        return drug;
    }

    //Zwraca dane wszystkich kolizji zadanego DrugsEntity.
    public static List<CollisionData> getCollisionData(DrugsEntity drug) {
        List<CollisionData> results;
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
            results = parseRawCollisions(rawResults);
        }
        return results;
    }

    public static List<DosageData> getDosageData(AnimalsEntity animal, DrugsEntity drug) {
        List<DosageData> results;
        try (Session session = Connections.getSession()) {
            String dosageQuery = "SELECT Dosage_Method_Types.method_type_name, Dosage_Methods.unit_lower_value, Dosage_Methods.unit_higher_value, Units.unit_shortcut, Dosage_Comments.comment\n" +
                    "FROM Dosages  \n" +
                    "LEFT OUTER JOIN Animals  ON Animals.animal_id=Dosages.animal_id \n" +
                    "JOIN Drugs  ON Dosages.drug_id=Drugs.drug_id \n" +
                    "JOIN Dosage_Methods  on Dosage_Methods.dosage_id=Dosages.dosage_id\n" +
                    "JOIN Units on Dosage_Methods.unit_id=Units.unit_id \n" +
                    "JOIN Dosage_Method_Types on Dosage_Methods.dosage_method_type_id=Dosage_Method_Types.dosage_method_type_id \n" +
                    "LEFT OUTER JOIN Dosage_Comments on Dosage_Comments.dosage_id=Dosages.dosage_id\n" +
                    "WHERE (Dosages.animal_id IS NULL OR Animals.animal_name=" + animal.getAnimalName() + ") " +
                    "AND Drugs.drug_name=" + drug.getDrugName() + ";";
            List rawDosages = session.createNativeQuery(dosageQuery).list();
            results = parseRawDosages(rawDosages);
        }
        return results;
    }

    private static List<DosageData> parseRawDosages(List rawDosages) {
        return null;
    }

    private static List<CollisionData> parseRawCollisions(List rawCollisions) {
        List<CollisionData> results = new ArrayList<>();
        for (Object r : rawCollisions) {
            Object[] data = (Object[]) r;
            String drug_name = (String) data[0];
            Clob commentClob = (Clob) data[1];
            String severity = (String) data[2];
            results.add(new CollisionData(drug_name, commentClob, severity));
        }
        return results;
    }
}
