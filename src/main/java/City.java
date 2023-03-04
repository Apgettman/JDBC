import java.sql.Connection;
import java.util.Objects;

public class City {

    private int city;
    private String name;

    public City(int city, String name) {
        this.city = city;
        this.name = name;
    }

    public City(Connection connection) {

    }

    public int getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return this.city == city.city && Objects.equals(name, city.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, name);
    }

    @Override
    public String toString() {
        return "City{" +
                "city=" + city +
                ", name='" + name + '\'' +
                '}';
    }
}
