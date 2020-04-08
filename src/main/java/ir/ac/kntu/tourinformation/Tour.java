package ir.ac.kntu.tourinformation;

import ir.ac.kntu.tourleader.TourLeader;

import java.util.Date;
import java.util.Objects;

public class Tour {
    private static int idHelper;
    private TourInformation tourInformation;
    private Date begin;
    private TourLeader tourLeader;
    private String id;

    public Tour(Tour tour) {
        this.tourInformation = tour.tourInformation;
        this.begin = tour.begin;
        this.tourLeader = tour.tourLeader;
        this.id = tour.getTourInformation().getName() + Integer.toString(++idHelper);
    }

    public Tour(TourInformation tourInformation, Date begin, TourLeader tourLeader) {
        this.tourInformation = tourInformation;
        this.begin = begin;
        this.tourLeader = tourLeader;
        this.id = tourInformation.getName() + Integer.toString(++idHelper);
    }

    public TourInformation getTourInformation() {
        return tourInformation;
    }

    public void setTourInformation(TourInformation tourInformation) {
        this.tourInformation = tourInformation;
    }

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public TourLeader getTourLeader() {
        return tourLeader;
    }

    public void setTourLeader(TourLeader tourLeader) {
        this.tourLeader = tourLeader;
    }

    public String getId() {
        return id;
    }

    public static int getIdHelper() {
        return idHelper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tour tour = (Tour) o;
        return Objects.equals(getTourInformation(), tour.getTourInformation()) &&
                Objects.equals(getId(), tour.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTourInformation(), getId());
    }

    @Override
    public String toString() {
        return "Tour{" +
                "tourInformation=" + tourInformation +
                ", begin=" + begin +
                ", tourLeader=" + tourLeader +
                ", id='" + id + '\'' +
                '}';
    }
}