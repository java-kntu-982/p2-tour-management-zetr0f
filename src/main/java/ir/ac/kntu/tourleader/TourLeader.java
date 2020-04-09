package ir.ac.kntu.tourleader;


import ir.ac.kntu.area.Area;
import ir.ac.kntu.userinterface.UserInterface;

import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;

public class TourLeader {
    private String id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth = new Date();
    private Date dateOfRecruitment = new Date();
    private Boolean maritalStatus;
    private ArrayList<Area> areas = new ArrayList<>();

    public TourLeader(){
    }

    public TourLeader(String id, String firstName, String lastName, Date dateOfBirth, Date dateOfRecruitment, Boolean maritalStatus, ArrayList<Area> areas) {
        setId(id);
        setFirstName(firstName);
        setLastName(lastName);
        setDateOfBirth(new Date(dateOfBirth));
        setDateOfRecruitment(new Date(dateOfRecruitment));
        setMaritalStatus(maritalStatus);
        setAreas(new ArrayList<>(areas));
    }

    public TourLeader(TourLeader tourLeader) {
        this.id = tourLeader.id;
        this.firstName = tourLeader.getFirstName();
        this.lastName = tourLeader.getLastName();
        this.dateOfBirth = tourLeader.getDateOfBirth();
        this.dateOfRecruitment = tourLeader.getDateOfRecruitment();
        this.areas = tourLeader.getAreas();
        this.maritalStatus = tourLeader.getMaritalStatus();

    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return new Date(dateOfBirth);
    }

    public Date getDateOfRecruitment() {
        return new Date(dateOfRecruitment);
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public ArrayList<Area> getAreas() {
        return areas;
    }

    public void setId(String id) {//must 10 length
        String regex = "^\\d{10}$";
        if (Pattern.matches(regex,id)) {
            this.id = id;
        }
    }

    public void setFirstName(String firstName) {// min 3 length
        String regex = "^[A-Za-z]{2,}$";
        if(Pattern.matches(regex,firstName)) {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {//min 3 length
        String regex = "^[A-Za-z]{2,}$";
        if (Pattern.matches(regex, lastName)) {
            this.lastName = lastName;
        }
    }

    public void setDateOfBirth(Date dateOfBirth) {
        if (dateOfBirth == null) {
            dateOfBirth = new Date(0,1,1);
        }
        if (dateOfRecruitment.getYear() - 18 >= dateOfBirth.getYear()) {
            this.dateOfBirth = dateOfBirth;
        }
    }

    public void setDateOfRecruitment(Date dateOfRecruitment) {
        if (dateOfBirth.getYear() + 18 <= dateOfRecruitment.getYear()) {
            this.dateOfRecruitment = dateOfRecruitment;
        }
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public void setAreas(ArrayList<Area> areas) {
        this.areas = areas;
    }

    public static ArrayList<TourLeader> searchByFirstName(ArrayList<TourLeader> tourLeaders , String firstName) {
        if (firstName == null || tourLeaders.isEmpty()) {
            return null;
        }
        ArrayList<TourLeader> ans = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getFirstName().equals(firstName)) {
                ans.add(tourLeader);
            }
        }
        return ans;
    }

    public static ArrayList<TourLeader> searchByLastName(ArrayList<TourLeader> tourLeaders , String lastName) {
        if (lastName == null || tourLeaders.isEmpty()) {
            return null;
        }
        ArrayList<TourLeader> ans = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.getFirstName().equals(lastName)) {
                ans.add(tourLeader);
            }
        }
        return ans;
    }

    public static ArrayList<TourLeader> searchByArea(ArrayList<TourLeader> tourLeaders , Area area) {
        if (area == null || tourLeaders.isEmpty()) {
            return null;
        }
        ArrayList<TourLeader> ans = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (!tourLeader.getAreas().isEmpty() && tourLeader.getAreas().contains(area)) {
                ans.add(tourLeader);
            }
        }
        return ans;
    }

    public static ArrayList<TourLeader> searchByAge(ArrayList<TourLeader> tourLeaders , int min , int max) {//max maximum is 117
        if (tourLeaders.isEmpty()) {
            return null;
        }
        ArrayList<TourLeader> ans = new ArrayList<>();
        for (TourLeader tourLeader : tourLeaders) {
            if (tourLeader.calculateAge() < max && tourLeader.calculateAge() > min) {
                ans.add(tourLeader);
            }
        }
        return ans;
    }

    private int calculateAge(){
        return UserInterface.today.getYear() - dateOfBirth.getYear();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TourLeader that = (TourLeader) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "TourLeader{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", dateOfRecruitment=" + dateOfRecruitment +
                ", maritalStatus=" + maritalStatus +
                ", areas=" + areas +
                '}';
    }
}