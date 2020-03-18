package continut;

import java.util.Objects;

public class Hospital implements Comparable<Hospital> {
    private String name;
    private int capacity;

    public Hospital(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hospital)) return false;
        Hospital hospital = (Hospital) o;
        return getCapacity() == hospital.getCapacity() &&
                getName().equals(hospital.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCapacity());
    }

    @Override
    public String toString() {
        return name;
    }

    /** Metoda compare pentru obiectele de tip hospital comparate dupa nume*/
    @Override
    public int compareTo(Hospital o) {
        return this.getName().compareTo(o.getName());
    }
}
