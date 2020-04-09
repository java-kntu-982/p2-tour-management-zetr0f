package ir.ac.kntu.area;


import java.util.Objects;
import java.util.regex.Pattern;

public class Area {
    private String name;
    private TypeOfArea typeOfArea;
    private String capital;

    public Area() {

    }

    public Area(String name, String capital) {
        setName(name);
        this.typeOfArea = TypeOfArea.FOREIGN;
        setCapital(capital);
    }

    public Area(String name) {
        setName(name);
        this.typeOfArea = TypeOfArea.DOMESTIC;
    }

    public Area(Area area) {
        this.name = area.getName();
        this.typeOfArea = area.getTypeOfArea();
        this.capital = area.capital;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String regex = "^(\\p{L}+(?:. |-| |'))*\\p{L}*$";
        if (Pattern.matches(regex, name)) {
            this.name = name;
        }
    }

    public TypeOfArea getTypeOfArea() {
        return typeOfArea;
    }

    public void setTypeOfArea(TypeOfArea typeOfArea) {
        this.typeOfArea = typeOfArea;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        String regex = "^(\\p{L}+(?:. |-| |'))*\\p{L}*$";
        if (Pattern.matches(regex, capital)) {
            this.capital = capital;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Area area = (Area) o;
        return Objects.equals(getName(), area.getName()) &&
                getTypeOfArea() == area.getTypeOfArea();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTypeOfArea());
    }

    @Override
    public String toString() {
        return "Area{" +
                "name='" + name + '\'' +
                ", typeOfArea=" + typeOfArea +
                '}';
    }
}
