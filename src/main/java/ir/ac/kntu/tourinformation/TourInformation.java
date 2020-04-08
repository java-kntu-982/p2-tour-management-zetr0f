package ir.ac.kntu.tourinformation;

import ir.ac.kntu.area.Area;

import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;

public class TourInformation {
    private String name;
    private int timeOfTour;
    private Area area;
    private double price;
    private int minOfParticipants;
    private int maxOfParticipants;
    private TypeOfTravel typeOfTravel;
    private Area origin;
    private Area destination;
    private String[] visitedPlaces;

    public TourInformation(TourInformation tourInformation) {
        if (tourInformation != null) {
            setName(tourInformation.name);
            setTimeOfTour(tourInformation.timeOfTour);
            setArea(tourInformation.area);
            setPrice(tourInformation.price);
            setMinOfParticipants(tourInformation.minOfParticipants);
            setMaxOfParticipants(tourInformation.maxOfParticipants);
            setTypeOfTravel(tourInformation.typeOfTravel);
            setOrigin(tourInformation.origin);
            setDestination(tourInformation.destination);
            setVisitedPlaces(tourInformation.visitedPlaces);
        }
    }

    public TourInformation(String name, int timeOfTour, Area area, double price, int minOfParticipants
            , int maxOfParticipants, TypeOfTravel typeOfTravel, Area origin, Area destination, String[] visitedPlaces) {
        setName(name);
        setTimeOfTour(timeOfTour);
        setArea(area);
        setPrice(price);
        setMinOfParticipants(minOfParticipants);
        setMaxOfParticipants(maxOfParticipants);
        setTypeOfTravel(typeOfTravel);
        setOrigin(origin);
        setDestination(destination);
        setVisitedPlaces(visitedPlaces);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String regex = "^[A-Za-z]{2,}$";
        if (Pattern.matches(regex, name)) {
            this.name = name;
        }
    }

    public int getTimeOfTour() {
        return timeOfTour;
    }

    public void setTimeOfTour(int timeOfTour) {
        if (timeOfTour > 0) {
            this.timeOfTour = timeOfTour;
        }
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (Double.compare(price , 0d) > 0) {
            this.price = price;
        }
    }

    public int getMinOfParticipants() {
        return minOfParticipants;
    }

    public void setMinOfParticipants(int minOfParticipants) {
        if (minOfParticipants >= 0 && minOfParticipants <= maxOfParticipants) {
            this.minOfParticipants = minOfParticipants;
        }
    }

    public int getMaxOfParticipants() {
        return maxOfParticipants;
    }

    public void setMaxOfParticipants(int maxOfParticipants) {
        if (maxOfParticipants >= minOfParticipants) {
            this.maxOfParticipants = maxOfParticipants;
        }
    }

    public TypeOfTravel getTypeOfTravel() {
        return typeOfTravel;
    }

    public void setTypeOfTravel(TypeOfTravel typeOfTravel) {
        this.typeOfTravel = typeOfTravel;
    }

    public Area getOrigin() {
        return origin;
    }

    public void setOrigin(Area origin) {
        this.origin = origin;
    }

    public Area getDestination() {
        return destination;
    }

    public void setDestination(Area destination) {
        this.destination = destination;
    }

    public String[] getVisitedPlaces() {
        return visitedPlaces.clone();
    }

    public void setVisitedPlaces(String[] visitedPlaces) {
        if (visitedPlaces != null && visitedPlaces.length == this.visitedPlaces.length) {
            this.visitedPlaces = visitedPlaces;
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
        TourInformation that = (TourInformation) o;
        return getTimeOfTour() == that.getTimeOfTour() &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getArea(), that.getArea()) &&
                getTypeOfTravel() == that.getTypeOfTravel();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "TourInformation{" +
                "name='" + name + '\'' +
                ", timeOfTour=" + timeOfTour +
                ", area=" + area +
                ", price=" + price +
                ", minOfParticipants=" + minOfParticipants +
                ", maxOfParticipants=" + maxOfParticipants +
                ", typeOfTravel=" + typeOfTravel +
                ", origin=" + origin +
                ", destination=" + destination +
                ", visitedPlaces=" + Arrays.toString(visitedPlaces) +
                '}';
    }
}
