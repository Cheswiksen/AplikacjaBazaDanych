package frontend.utils;

import javafx.beans.property.SimpleStringProperty;

public class CollisionView {
    private final SimpleStringProperty drug1;
    private final SimpleStringProperty drug2;
    private final SimpleStringProperty severity;
    private final SimpleStringProperty text;

    public CollisionView(String drug1, String drug2, String severity, String text) {
        this.drug1 = new SimpleStringProperty(drug1);
        this.drug2 = new SimpleStringProperty(drug2);
        this.severity = new SimpleStringProperty(severity);
        this.text = new SimpleStringProperty(text);
    }


    public String getDrug1() {
        return drug1.get();
    }

    public String getDrug2() {
        return drug2.get();
    }

    public String getText() {
        return text.get();
    }

    public String getSeverity() {
        return severity.get();
    }

    @Override
    public boolean equals(Object o) {
        CollisionView ce = (CollisionView) o;
        boolean result = getDrug1().equals(ce.getDrug1())
                || getDrug2().equals(ce.getDrug2())
                || getDrug1().equals(ce.getDrug2())
                || getDrug2().equals(ce.getDrug1());
        return result;
    }

    @Override
    public int hashCode() {
        return (this.drug1.hashCode() + this.drug2.hashCode() + this.severity.hashCode() + this.text.hashCode());
    }
}
