package backend.utils;

import java.sql.Clob;
import java.sql.SQLException;

public class CollisionData {

    public String drugName;
    public String collisionText;
    public String collisionSeverity;

    public CollisionData(String drugName, Clob collisionText, String collisionSeverity) {
        this.drugName = drugName;
        this.collisionSeverity = collisionSeverity;
        try {
            this.collisionText = collisionText.getSubString(1, (int) collisionText.length());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
