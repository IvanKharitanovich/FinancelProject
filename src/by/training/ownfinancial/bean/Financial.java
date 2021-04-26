package by.training.ownfinancial.bean;

import java.util.Objects;

public class Financial {

    private String owner;
    private double value;

    public Financial() {
    }

    public Financial(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public double getValue() {
        return value;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Financial financial = (Financial) o;
        return value == financial.value &&
                Objects.equals(owner, financial.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, value);
    }

    @Override
    public String toString() {
        return "Financial{" +
                "owner='" + owner + '\'' +
                ", value=" + value +
                '}';
    }
}
