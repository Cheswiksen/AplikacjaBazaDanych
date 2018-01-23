package backend.utils;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Clob;
import java.sql.SQLException;

public class DosageData {
    private SimpleStringProperty drug;
    private SimpleStringProperty animal;
    private SimpleStringProperty min;
    private SimpleStringProperty max;
    private SimpleStringProperty method;
    private SimpleStringProperty unit;
    private SimpleStringProperty comment;

    public DosageData(String drug, String animal, Float min, Float max, String method, String unit, Clob comment) {
        this.drug = new SimpleStringProperty(drug);
        if (animal != null)
            this.animal = new SimpleStringProperty(animal);
        this.min = new SimpleStringProperty(Float.toString(min));
        if (max != null)
            this.max = new SimpleStringProperty(Float.toString(max));
        this.method = new SimpleStringProperty(method);
        this.unit = new SimpleStringProperty(unit);
        if (comment != null) {
            try {
                this.comment = new SimpleStringProperty(comment.getSubString(1, (int) comment.length()));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public SimpleStringProperty animalProperty() {
        return animal;
    }

    public SimpleStringProperty drugProperty() {
        return drug;
    }

    public SimpleStringProperty maxProperty() {
        return max;
    }

    public SimpleStringProperty methodProperty() {
        return method;
    }

    public SimpleStringProperty minProperty() {
        return min;
    }

    public SimpleStringProperty unitProperty() {
        return unit;
    }

    public SimpleStringProperty commentProperty() {
        return comment;
    }
}
