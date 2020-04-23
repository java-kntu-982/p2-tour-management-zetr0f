package ir.ac.kntu;


import ir.ac.kntu.userinterface.UserInterface;
import ir.ac.kntu.userlevel.*;

import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        Customer.customerUserLevel = new UserLevel();
        Employee.employeeUserLevel = new UserLevel();
        TourLeader.tourLeaderUserLevel = new UserLevel();
        Customer.customerUserLevel.setRoles(new HashSet<>(Arrays.asList(Roles.values())));
        Employee.employeeUserLevel.setRoles(new HashSet<>(Arrays.asList(Roles.values())));
        TourLeader.tourLeaderUserLevel.setRoles(new HashSet<>(Arrays.asList(Roles.values())));
        UserInterface.handlerForLoginMenu();
    }
}
