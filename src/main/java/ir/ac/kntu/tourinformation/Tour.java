package ir.ac.kntu.tourinformation;

import ir.ac.kntu.area.Area;
import ir.ac.kntu.tourleader.Date;
import ir.ac.kntu.tourleader.TourLeader;

import java.util.ArrayList;
import java.util.Objects;

public class Tour {
    private static int idHelper;
    private TourInformation tourInformation = new TourInformation();
    private Date begin = new Date();
    private TourLeader tourLeader = new TourLeader();
    private String id;

    public Tour() {

    }

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

    public static ArrayList<Tour> searchByLeader(ArrayList<Tour> tours , TourLeader leader) {
        if (tours == null || tours.isEmpty() || leader == null) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourLeader().equals(leader)) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByDate(ArrayList<Tour> tours , Date begin , Date end) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            Date endOfTour = new Date(tour.getBegin());
            for (int i = 0; i < tour.getTourInformation().getTimeOfTour() - 1 ; i++) {
                endOfTour = endOfTour.nextDay();
            }
            if ((tour.getBegin().compareTo(begin) >= 0) && (endOfTour.compareTo(end) <= 0)) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByLength(ArrayList<Tour> tours , int length) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourInformation().getTimeOfTour() == length) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByVisitedPlace(ArrayList<Tour> tours , String area) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourInformation().getVisitedPlaces().contains(area)) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByBaseArea(ArrayList<Tour> tours , Area area) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourInformation().getArea().equals(area)) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByParticipants(ArrayList<Tour> tours , int minOfParticipants , int maxOfParticipants) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourInformation().getMaxOfParticipants() <= maxOfParticipants && tour.getTourInformation().getMinOfParticipants() >= minOfParticipants) {
                ans.add(tour);
            }
        }
        return ans;
    }

    public static ArrayList<Tour> searchByPrice(ArrayList<Tour> tours  , double min , double max) {
        if (tours == null || tours.isEmpty()) {
            return null;
        }
        ArrayList<Tour> ans = new ArrayList<>();
        for (Tour tour : tours) {
            if (tour.getTourInformation().getPrice() < max && tour.getTourInformation().getPrice() > min) {
                ans.add(tour);
            }
        }
        return ans;
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