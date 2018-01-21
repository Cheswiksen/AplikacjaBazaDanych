package frontend.controllers;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CollisionView {
    private final SimpleStringProperty Lek1;
    private final SimpleStringProperty Lek2;
    private final SimpleStringProperty Severity;
    private final SimpleStringProperty Text;

    public CollisionView(String lek1, String lek2, String severity, String text) {
        Lek1 = new SimpleStringProperty(lek1);
        Lek2 = new SimpleStringProperty(lek2);
        Severity = new SimpleStringProperty(severity);
        Text = new SimpleStringProperty(text);
    }


    public String getLek1() {
        return Lek1.get();
    }

    public String getLek2() {
        return Lek2.get();
    }

    public String getSeverity() {
        return Severity.get();
    }

    public String getText() {
        return Text.get();
    }
}
