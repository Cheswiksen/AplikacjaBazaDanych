package backend.utils;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Clob;
import java.sql.SQLException;

public class CollisionData {

    public SimpleStringProperty drugName;
    public SimpleStringProperty collisionText;
    public SimpleStringProperty collisionSeverity;
    public CollisionData(String drugName, Clob collisionText, String collisionSeverity){
        this.drugName = new SimpleStringProperty(drugName);
        this.collisionSeverity = new SimpleStringProperty(collisionSeverity);
        try {
            this.collisionText = new SimpleStringProperty(collisionText.getSubString(1, (int) collisionText.length()));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public SimpleStringProperty getCollisionSeverity() {
        return collisionSeverity;
    }

    public SimpleStringProperty getDrugName() {
        return drugName;
    }

    public SimpleStringProperty getCollisionText() {
        return collisionText;
    }
}
