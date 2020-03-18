package continut;

public class Resident implements Comparable<Resident> {
    private String name;

    public Resident(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + " ";
    }
/** Metoda compare pentru obiectele de tip resident comparate dupa nume*/
    @Override
    public int compareTo(Resident o) {
        return this.getName().compareTo(o.getName());
    }

}
