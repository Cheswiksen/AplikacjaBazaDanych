package backend.utils;

import backend.entities.DrugsEntity;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.List;

public class CollisionData {
    private String drugName;
    private String collisionText;
    private String collisionSeverity;
    public CollisionData(String drugName, Clob collisionText, String collisionSeverity){
        this.drugName=drugName;
        this.collisionSeverity=collisionSeverity;
        try {
            this.collisionText=collisionText.getSubString(1, (int) collisionText.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getCollisionSeverity() {
        return collisionSeverity;
    }

    public String getDrugName() {
        return drugName;
    }

    public String getCollisionText() {
        return collisionText;
    }
}
