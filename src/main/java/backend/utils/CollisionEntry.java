package backend.utils;

import javafx.beans.property.SimpleStringProperty;

public class CollisionEntry {
    public SimpleStringProperty drug1;
    public SimpleStringProperty drug2;
    public SimpleStringProperty collisionText;
    public SimpleStringProperty collisionSeverity;

    public CollisionEntry(String drug1, String drug2, String collisionText, String collisionSeverity) {
        this.drug1 = new SimpleStringProperty(drug1);
        this.drug2 = new SimpleStringProperty(drug2);
        this.collisionSeverity = new SimpleStringProperty(collisionSeverity);
        this.collisionText = new SimpleStringProperty(collisionText);
    }

    public String getDrug1() {
        return drug1.get();
    }

    public String getDrug2() {
        return drug2.get();
    }

    public String getCollisionText() {
        return collisionText.get();
    }

    public String getCollisionSeverity() {
        return collisionSeverity.get();
    }
}
