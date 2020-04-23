package ir.ac.kntu.userinterface;


import ir.ac.kntu.ScannerSingleton;
import ir.ac.kntu.area.Area;
import ir.ac.kntu.maputil.MapUtil;
import ir.ac.kntu.tourinformation.Tour;
import ir.ac.kntu.tourinformation.TourInformation;
import ir.ac.kntu.userlevel.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;


public class UserInterface {
    private static UserLevel currentUserLevel = new UserLevel();
    private static Admin admin = new Admin();
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    public static Date today = new Date(1399 , 2, 4  );
    private static ArrayList<Area> areas  = new ArrayList<>();
    private static ArrayList<TourLeader> tourLeaders = new ArrayList<>();
    private static ArrayList<TourInformation> primaryStructures = new ArrayList<>();
    private static ArrayList<Tour> tours = new ArrayList<>();
    private static ScannerSingleton input = ScannerSingleton.getInstance();

    private UserInterface() {
        if (currentUserLevel == null) {
            currentUserLevel = new UserLevel();
        }
        if (admin == null) {
            admin = new Admin();
        }
        if (employees == null) {
            employees = new ArrayList<>();
        }
        if (customers == null) {
            customers = new ArrayList<>();
        }
        if (today == null) {
            today = new Date(1399 , 2, 4  );
        }
        if (areas == null) {
            areas  = new ArrayList<>();
        }
        if (tourLeaders == null) {
            tourLeaders = new ArrayList<>();
        }
        if (primaryStructures == null) {
            primaryStructures = new ArrayList<>();
        }
        if (tours == null) {
            tours = new ArrayList<>();
        }
    }

    public static void handlerForLoginMenu(){
        clearScreen();
        printLoginMenuChoice();
        handlerForLoginMenuChoice();
    }

    private static void printLoginMenuChoice() {
        System.out.println("1- login as admin");
        System.out.println("2- login as employee");
        System.out.println("3- login as customer");
        System.out.println("4- login as tour leader");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForLoginMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        String userName,password;
        System.out.println("enter user name:");
        userName = input.nextLine();
        System.out.println("enter pass:");
        password = input.nextLine();
        switch (choice) {
            case "1":
                if (userName.equals(admin.getUserName()) && password.equals(admin.getPassword())) {
                    currentUserLevel.setRoles(new HashSet<>(Arrays.asList(Roles.values())));
                    handlerForMainMenu();
                }
                System.out.println("user or pass is incorrect or not exist");
                handlerForLoginMenu();
            case "2":
                for (int i = 0; i < employees.size(); i++) {
                    if (userName.equals(employees.get(i).getUserName()) && password.equals(employees.get(i).getPassword())) {
                        handlerForMainMenu();
                        currentUserLevel = new UserLevel((HashSet<Roles>) Employee.employeeUserLevel.getRoles().clone());
                    }
                }
                System.out.println("user or pass is incorrect or not exist");
                handlerForLoginMenu();
            case "3":
                for (int i = 0; i < customers.size(); i++) {
                    if (userName.equals(customers.get(i).getUserName()) && password.equals(customers.get(i).getPassword())) {
                        handlerForMainMenu();
                        currentUserLevel = new UserLevel((HashSet<Roles>) Customer.customerUserLevel.getRoles().clone());
                    }
                }
                System.out.println("user or pass is incorrect or not exist");
                handlerForLoginMenu();
            case "4":
                for (int i = 0; i < tourLeaders.size(); i++) {
                    if (userName.equals(tourLeaders.get(i).getUserName()) && password.equals(tourLeaders.get(i).getPassword())) {
                        handlerForMainMenu();
                        currentUserLevel = new UserLevel((HashSet<Roles>) TourLeader.tourLeaderUserLevel.getRoles().clone());
                    }
                }
                System.out.println("user or pass is incorrect or not exist");
                handlerForLoginMenu();
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForLoginMenu();
        }
    }

    private static void handlerForMainMenu(){
        clearScreen();
        printMainMenuChoice();
        handlerForMainMenuChoice();
    }

    private static void printMainMenuChoice() {
        System.out.println("1- tour leader's menu");
        System.out.println("2- tour's menu");
        System.out.println("3- area's menu");
        System.out.println("4- map's menu");
        System.out.println("5- employee's menu");
        System.out.println("6- customer's menu");
        System.out.println("7- admin's menu");
        System.out.println("L- logout");
        System.out.println("h- help");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForMainMenuChoice() {
        String choice = input.nextLine();
        switch (choice) {
            case "1":
                handlerForTourLeaderMenu();
                break;
            case "2":
                handlerForTourMenu();
                break;
            case "3":
                handlerForAreaMenu();
                break;
            case "4":
                handlerForMapMenu();
                break;
            case "5":
                handlerForEmployeeMenu();
            case "6":
                handlerForCustomerMenu();
            case "7":
                if (!currentUserLevel.getRoles().contains(Roles.ADMINEDIT)){
                    break;
                }
                handlerForAdminMenu();
            case "L":
                currentUserLevel = new UserLevel();
                handlerForLoginMenu();
            case "h":
                System.out.println("we have 4 part , U can choose one of them, it's better to declare object bt this way" +
                        "\nArea/place -> Leader -> TourInformation -> PrimaryStructures");
                pause();
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForMainMenu();
        }
        pause();
        handlerForMainMenu();
    }

    private static void handlerForCustomerMenu() {
        clearScreen();
        printCustomerMenuChoice();
        handlerForCustomerMenuChoice();
    }

    private static void printCustomerMenuChoice() {
        System.out.println("1- add");
        System.out.println("2- remove");
        System.out.println("3- edit");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForCustomerMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        String userName,password;
        System.out.println("enter user name:");
        userName = input.nextLine();
        System.out.println("enter pass:");
        password = input.nextLine();
        switch (choice) {
            case "1":
                if (currentUserLevel.getRoles().contains(Roles.CUSTOMERADD)) {
                    break;
                }
                String phoneNumber,email;
                System.out.println("enter phone number:");
                phoneNumber = input.nextLine();
                System.out.println("enter email:");
                email = input.nextLine();
                customers.add(new Customer(userName,password,phoneNumber,email));
            case "2":
                if (currentUserLevel.getRoles().contains(Roles.CUSTOMERREMOVEOREDIT)) {
                    break;
                }
                for (int i = 0; i < customers.size(); i++) {
                    if (customers.get(i).getUserName().equals(userName) && customers.get(i).getPassword().equals(password)) {
                        customers.remove(i);
                        System.out.println("successful");
                        pause();
                        handlerForMainMenu();
                    }
                    System.out.println("not found");
                    handlerForMainMenu();
                }
            case "3":
                if (currentUserLevel.getRoles().contains(Roles.CUSTOMERREMOVEOREDIT)) {
                    break;
                }
                //TODO
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForEmployeeMenu();
        }
        pause();
        handlerForEmployeeMenu();
    }

    private static void handlerForAdminMenu() {
        clearScreen();
        printAdminMenuChoice();
        handlerForAdminMenuChoice();
    }

    private static void printAdminMenuChoice() {
        System.out.println("1- edit username");
        System.out.println("2- edit password");
        System.out.println("3- edit employee user level");
        System.out.println("4- edit tour leader user level");
        System.out.println("5- edit customer user level");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForAdminMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1":
                System.out.println("enter your user name:");
                admin.setUserName(input.nextLine());
            case "2":
                System.out.println("enter your password");
                admin.setPassword(input.nextLine());
            case "3":
                System.out.println("all roles is :" + Arrays.toString(Roles.values()) + "\ncurrent employee rules is:" + Employee.employeeUserLevel.getRoles());
                System.out.println("enter 1 for add and 2 for remove");
                String choice1 = input.nextLine();
                System.out.println("enter your choice from rules for remove or add");
                if (choice1.equals("1")) {
                    Employee.employeeUserLevel.getRoles().add(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("add success");
                } else if (choice1.equals("2")){
                    Employee.employeeUserLevel.getRoles().remove(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("remove success");
                }
                System.out.println("input is incorrect");
            case "4":
                System.out.println("all roles is :" + Arrays.toString(Roles.values()) + "\ncurrent employee rules is:" + TourLeader.tourLeaderUserLevel.getRoles());
                System.out.println("enter 1 for add and 2 for remove");
                String choice2 = input.nextLine();
                System.out.println("enter your choice from rules for remove or add");
                if (choice2.equals("1")) {
                    TourLeader.tourLeaderUserLevel.getRoles().add(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("add success");
                } else if (choice2.equals("2")){
                    TourLeader.tourLeaderUserLevel.getRoles().remove(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("remove success");
                }
                System.out.println("input is incorrect");
            case "5":
                System.out.println("all roles is :" + Arrays.toString(Roles.values()) + "\ncurrent employee rules is:" + Customer.customerUserLevel.getRoles());
                System.out.println("enter 1 for add and 2 for remove");
                String choice3 = input.nextLine();
                System.out.println("enter your choice from rules for remove or add");
                if (choice3.equals("1")) {
                    Customer.customerUserLevel.getRoles().add(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("add success");
                } else if (choice3.equals("2")){
                    Customer.customerUserLevel.getRoles().remove(Roles.valueOf(input.nextLine().toUpperCase()));
                    System.out.println("remove success");
                }
                System.out.println("input is incorrect");
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForAdminMenu();
        }
        pause();
        handlerForAdminMenu();
    }

    private static void handlerForEmployeeMenu() {
        clearScreen();
        printEmployeeMenuChoice();
        handlerForEmployeeMenuChoice();
    }


    private static void printEmployeeMenuChoice() {
        System.out.println("1- add");
        System.out.println("2- remove");
        System.out.println("3- edit");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForEmployeeMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        String userName,password;
        System.out.println("enter user name:");
        userName = input.nextLine();
        System.out.println("enter pass:");
        password = input.nextLine();
        switch (choice) {
            case "1":
                if (currentUserLevel.getRoles().contains(Roles.EMPLOYEEADD)) {
                    break;
                }
                String phoneNumber,email;
                System.out.println("enter phone number:");
                phoneNumber = input.nextLine();
                System.out.println("enter email:");
                email = input.nextLine();
                employees.add(new Employee(userName, password, email, phoneNumber, new Date(1380,1,1), 12000));
            case "2":
                if (currentUserLevel.getRoles().contains(Roles.EMPLOYEEREMOVEOREDIT)) {
                    break;
                }
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i).getUserName().equals(userName) && employees.get(i).getPassword().equals(password)) {
                        employees.remove(i);
                        System.out.println("successful");
                        pause();
                        handlerForMainMenu();
                    }
                    System.out.println("not found");
                    handlerForMainMenu();
                }
            case "3":
                if (currentUserLevel.getRoles().contains(Roles.EMPLOYEEREMOVEOREDIT)) {
                    break;
                }
                //TODO
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForEmployeeMenu();
        }
        pause();
        handlerForEmployeeMenu();
    }

    private static void handlerForTourLeaderMenu() {
        clearScreen();
        printTourLeaderMenuChoice();
        handlerForTourLeaderMenuChoice();
    }

    private static void printTourLeaderMenuChoice() {
        System.out.println("1- show all leader's");
        System.out.println("2- add leader");
        System.out.println("3- delete leader");
        System.out.println("4- edit leader");
        System.out.println("5- search leader");
        System.out.println("h- help");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForTourLeaderMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1":
                if (tourLeaders.isEmpty()) {
                    System.out.println("no leader");
                    break;
                }
                for (int i = 1; i < tourLeaders.size()+1; i++) {
                    System.out.println(i + " ");
                    System.out.println(tourLeaders.get(i - 1));
                }
                break;
            case "2":
                if (!currentUserLevel.getRoles().contains(Roles.TOURLEADERADD)) {
                    break;
                }
                if (areas.isEmpty()) {
                    System.out.println("you don't have any area's , please create first");
                    pause();
                    handlerForMainMenu();
                }
                Date date = new Date();
                TourLeader tourLeader = new TourLeader();
                System.out.println("enter id pls:");
                tourLeader.setId(input.nextLine());
                System.out.println("enter first name pls:");
                tourLeader.setFirstName(input.nextLine());
                System.out.println("enter last name pls:");
                tourLeader.setLastName(input.nextLine());
                System.out.println("enter date of birth:\n");
                tourLeader.setDateOfBirth(new Date());
                System.out.println("enter year:");
                int year;
                year = input.nextInt();
                System.out.println("enter month:");
                int month = input.nextInt();
                System.out.println("enter day:");
                int day = input.nextInt();
                tourLeader.setDateOfBirth(new Date(year, month , day));
                System.out.println("enter date od recruitment:\n");
                System.out.println("enter year:");
                year = input.nextInt();
                System.out.println("enter month:");
                month = input.nextInt();
                System.out.println("enter day:");
                day = input.nextInt();
                tourLeader.setDateOfRecruitment(new Date(year, month, day));
                System.out.println("if maritalStatus is true enter t , else enter f");
                if (input.nextLine().trim().equals("t")) {
                    tourLeader.setMaritalStatus(true);
                }
                System.out.println(areas.toString());
                System.out.println("how many area's the leader know?");
                int i = input.nextInt();
                if (i > areas.size()){
                    System.out.println("tooo big , try again:");
                    i = input.nextInt();
                }
                for (int j = 0; j < i; j++) {
                    System.out.println("enter the name of area:");
                    String name = input.nextLine();
                    for (int k = 0; k < areas.size(); k++) {
                        if (areas.get(k).getName().equals(name)) {
                            tourLeader.getAreas().add(areas.get(k));
                            break;
                        }
                        if (k == areas.size()) {
                            System.out.println("your name not exist , try another name");
                            j--;
                        }
                    }
//                    System.out.println("enter the area name:");
//                    String name = input.nextLine();
//                    System.out.println("if your area is foreign enter 1 and id domestic enter 0:");
//                    if (input.nextInt() == 1){
//                        System.out.println("enter the capital:");
//                        tourLeader.getAreas().add(new Area(name, input.nextLine()));
//                    } else {
//                        tourLeader.getAreas().add(new Area(name));
//                    }
                }
                System.out.println("add complete : " + tourLeader);
                tourLeaders.add(tourLeader);
                break;
            case "3":
                if (!currentUserLevel.getRoles().contains(Roles.TOURLEADERREMOVEOREDIT)) {
                    break;
                }
                if (tourLeaders.isEmpty()) {
                    System.out.println("no leader");
                    break;
                }
                System.out.println(tourLeaders);
                System.out.println("enter the id of leader to delete");
                String id = input.nextLine();
                tourLeaders.removeIf(leader -> leader.getId().equals(id));
                break;
            case "4":
                if (!currentUserLevel.getRoles().contains(Roles.TOURLEADERREMOVEOREDIT)) {
                    break;
                }
                if (tourLeaders.isEmpty()) {
                    System.out.println("no leader");
                    break;
                }
                int editIndex = -1;
                System.out.println(tourLeaders);
                System.out.println("enter the id of leader to edit");
                for (int j = 0; j < tourLeaders.size(); j++) {
                    if (tourLeaders.get(j).getId().equals(input.nextLine())) {
                        editIndex = j;
                        break;
                    }
                }
                if (editIndex == -1) {
                    clearScreen();
                    System.out.println("not found");
                    break;
                }
                System.out.println("for edit first name enter yes else no:");
                if (input.nextLine().equals("yes")) {
                    System.out.println("enter first name:");
                    tourLeaders.get(editIndex).setFirstName(input.nextLine());
                }
                System.out.println("for edit last name enter yes else no:");
                if (input.nextLine().equals("yes")) {
                    System.out.println("enter last name:");
                    tourLeaders.get(editIndex).setLastName(input.nextLine());
                }
                System.out.println("for edit id enter yes else no:");
                if (input.nextLine().equals("yes")) {
                    System.out.println("enter id:");
                    tourLeaders.get(editIndex).setId(input.nextLine());
                }
                System.out.println("for edit marital status enter yes else no:");
                if (input.nextLine().equals("yes")) {
                    tourLeaders.get(editIndex).setMaritalStatus(!tourLeaders.get(editIndex).getMaritalStatus());
                }
                break;
            case "5":
                if (tourLeaders.isEmpty()) {
                    System.out.println("no leader");
                    break;
                }
                handlerForSearchLeaderMenu();
                break;
            case "h":
                System.out.println("choose one of them , it's better to first add something");
                pause();
                handlerForTourLeaderMenu();
                break;
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForTourLeaderMenu();
        }
        pause();
        handlerForTourLeaderMenu();
    }

    private static void handlerForSearchLeaderMenu() {
        clearScreen();
        printSearchLeaderMenuChoice();
        handlerForSearchLeaderMenuChoice();
    }

    private static void printSearchLeaderMenuChoice() {
        System.out.println("1- search by first name");
        System.out.println("2- search by last name");
        System.out.println("3- search by areas that leader know's");
        System.out.println("4- search by age");
        System.out.println("h- help");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForSearchLeaderMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1":
                System.out.println("enter first name:");
                System.out.println(TourLeader.searchByFirstName(tourLeaders, input.nextLine()));
                break;
            case "2":
                System.out.println("enter last name:");
                System.out.println(TourLeader.searchByLastName(tourLeaders, input.nextLine()));
                break;
            case "3":
                Area area;
                System.out.println("enter Area name:");
                String name = input.nextLine();
                System.out.println("enter capital(if is domestic enter name again)");
                String capital = input.nextLine();
                if (name.equals(capital)){
                    area = new Area(name);
                } else {
                    area = new Area(name, capital);
                }
                System.out.println(TourLeader.searchByArea(tourLeaders, area));
                break;
            case "4":
                handlerSearchByTourLeaderAge();
                break;
            case "h":
                pause();
                handlerForSearchPrimaryStructuresMenu();
                break;
            case "m":
                handlerForTourLeaderMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForSearchLeaderMenu();
        }
        pause();
        handlerForSearchLeaderMenu();
    }

    private static void handlerSearchByTourLeaderAge() {
        clearScreen();
        printSearchByTourLeaderAgeChoice();
        handlerSearchByTourLeaderAgeChoice();
    }

    private static void printSearchByTourLeaderAgeChoice() {
        System.out.println("1- with one number");
        System.out.println("2- bigger than a number");
        System.out.println("3- smaller than a number");
        System.out.println("4- between two number");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerSearchByTourLeaderAgeChoice() {
        String choice = input.nextLine();
        clearScreen();
        int min,max;
        switch (choice) {
            case "1":
                System.out.println("enter number:");
                min = input.nextInt() - 1;
                max = min +2;
                System.out.println(TourLeader.searchByAge(tourLeaders,min , max ));
                break;
            case "2":
                System.out.println("enter number:");
                min = input.nextInt();
                max = 118;
                System.out.println(TourLeader.searchByAge(tourLeaders , min , max ));
                break;
            case "3":
                System.out.println("enter number:");
                max = input.nextInt() ;
                min = 18;
                System.out.println(TourLeader.searchByAge(tourLeaders , min , max ));
                break;
            case "4":
                System.out.println("enter min:");
                min = input.nextInt();
                System.out.println("enter max");
                max = input.nextInt();
                System.out.println(TourLeader.searchByAge(tourLeaders , min , max ));
                break;
            case "h":
                pause();
                handlerSearchByTourLeaderAge();
                break;
            case "m":
                handlerForSearchLeaderMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerSearchByTourLeaderAge();
        }
        pause();
        handlerSearchByTourLeaderAge();
    }

    private static void handlerForTourMenu() {
        clearScreen();
        printTourMenuChoice();
        handlerForTourMenuChoice();
    }

    private static void printTourMenuChoice() {
        System.out.println("1- show all primary structures");
        System.out.println("2- show all tour's");
        System.out.println("3- add primary structure");
        System.out.println("4- add tour");
        System.out.println("5- edit primary structure");
        System.out.println("6- edit tour");
        System.out.println("7- delete tour");
        System.out.println("8- search primary structure's");
        System.out.println("9- search tour's");
        System.out.println("h- help");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForTourMenuChoice() {
        String choice = input.toString();
        clearScreen();
        switch (choice) {
            case "1":
                if (primaryStructures.isEmpty()) {
                    System.out.println("please create one first :))");
                    break;
                }
                System.out.println(primaryStructures.toString());
                break;
            case "2":
                if (tours.isEmpty()) {
                    System.out.println("please create one first :))");
                    break;
                }
                System.out.println(tours.toString());
                break;
            case "3"://TODO
                if (currentUserLevel.getRoles().contains(Roles.TOURINFORMATIONADD)) {
                    break;
                }
                break;
            case "4"://TODO
                if (currentUserLevel.getRoles().contains(Roles.TOURADD)) {
                    break;
                }
                break;
            case "5"://TODO
                if (currentUserLevel.getRoles().contains(Roles.TOURINFORMATIONREMOVEOREDIT)) {
                    break;
                }
                break;
            case "6"://TODO
                if (currentUserLevel.getRoles().contains(Roles.TOURREMOVEOREDIT)) {
                    break;
                }
                break;
            case "7":
                if (currentUserLevel.getRoles().contains(Roles.TOURREMOVEOREDIT)) {
                    break;
                }
                if (tours.isEmpty()) {
                    System.out.println("please create one first :))");
                    break;
                }
                System.out.println(tours.toString());
                System.out.println("enter id to remove tour");
                tours.removeIf(tour -> tour.getId().equals(input.nextLine()));
                break;
            case "8":
                handlerForSearchPrimaryStructuresMenu();
                break;
            case "9":
                handlerForSearchToursMenu();
                break;
            case "h":
                pause();
                handlerForTourMenu();
                break;
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForTourMenu();
        }
        pause();
        handlerForTourMenu();
    }

    private static void handlerForSearchPrimaryStructuresMenu() {
        clearScreen();
        printSearchPrimaryStructuresMenuChoice();
        handlerForSearchPrimaryStructuresMenuChoice();
    }

    private static void printSearchPrimaryStructuresMenuChoice() {
        System.out.println("1- search by tour's length");
        System.out.println("2- search by visit(ed) places");
        System.out.println("3- search by base area");
        System.out.println("4- search by min & max participants");
        System.out.println("5- search by price");
        System.out.println("h- help");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForSearchPrimaryStructuresMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1":
                System.out.println("enter tour length:");
                System.out.println(TourInformation.searchByTourLength(primaryStructures, input.nextInt()));
                break;
            case "2":
                System.out.println("enter the place name");
                String name = input.nextLine();
                System.out.println(TourInformation.searchByVisitAreas(primaryStructures, name));
                break;
            case "3":
                if (areas.isEmpty()) {
                    System.out.println("no area's");
                }
                System.out.println(areas);
                System.out.println("enter the name of area:");
                String name1 = input.nextLine();
                System.out.println("enter the capital of area:(if it's city enter name again)");
                String capital = input.nextLine();
                if (name1.equals(capital)) {
                    System.out.println(TourInformation.searchByBaseArea(primaryStructures, new Area(name1)));
                } else {
                    System.out.println(TourInformation.searchByBaseArea(primaryStructures,new Area(name1, capital)));
                }
                break;
            case "4":
                int min , max;
                System.out.println("enter min:");
                min = input.nextInt();
                System.out.println("enter max:");
                max = input.nextInt();
                break;
            case "5":
                handlerSearchByPrimaryStructuresPrice();
                break;
            case "h":
                pause();
                handlerForSearchPrimaryStructuresMenu();
                break;
            case "m":
                handlerForTourMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForSearchPrimaryStructuresMenu();
        }
        pause();
        handlerForSearchPrimaryStructuresMenu();
    }

    private static void handlerSearchByPrimaryStructuresPrice() {
        clearScreen();
        printSearchByPrimaryStructuresPriceChoice();
        handlerSearchByPrimaryStructuresPriceChoice();
    }

    private static void printSearchByPrimaryStructuresPriceChoice() {
        System.out.println("1- with one number");
        System.out.println("2- bigger than a number");
        System.out.println("3- smaller than a number");
        System.out.println("4- between two number");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerSearchByPrimaryStructuresPriceChoice() {
        String choice = input.nextLine();
        clearScreen();
        double min , max;
        switch (choice) {
            case "1":
                System.out.println("enter number:");
                max = input.nextDouble() +1;
                min = max - 2d;
                TourInformation.searchByPrice(primaryStructures , min , max);
                break;
            case "2":
                System.out.println("enter number:");
                min = input.nextDouble() ;
                max = 10000000;
                TourInformation.searchByPrice(primaryStructures , min , max);
                break;
            case "3":
                System.out.println("enter number:");
                max = input.nextDouble() ;
                min = 0d;
                TourInformation.searchByPrice(primaryStructures , min , max);
                break;
            case "4":
                System.out.println("enter min");
                min = input.nextDouble();
                System.out.println("enter max:");
                max = input.nextDouble();
                TourInformation.searchByPrice(primaryStructures , min , max);
                break;
            case "h":
                pause();
                handlerSearchByPrimaryStructuresPrice();
                break;
            case "m":
                handlerForSearchPrimaryStructuresMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerSearchByPrimaryStructuresPrice();
        }
        pause();
        handlerSearchByPrimaryStructuresPrice();
    }

    private static void handlerForSearchToursMenu() {
        clearScreen();
        printSearchToursMenu();
        handlerForSearchTourMenuChoice();
    }

    private static void printSearchToursMenu() {
        System.out.println("1- search by leader(with first & last name)");
        System.out.println("2- search by begin & end date");
        System.out.println("3- search by tour's length");
        System.out.println("4- search by visit(ed) places");
        System.out.println("5- search by base area");
        System.out.println("6- search by min & max participants");
        System.out.println("7- search by price");
        System.out.println("h- help");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForSearchTourMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1"://TODO
                break;
            case "2":
                handlerSearchByTourBeginDate();
                break;
            case "3"://TODO
                break;
            case "4"://TODO
                break;
            case "5"://TODO
                break;
            case "6"://TODO
                break;
            case "7":
                handlerSearchByTourPrice();
                break;
            case "h":
                pause();
                handlerForSearchToursMenu();
                break;
            case "m":
                handlerForTourMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForSearchToursMenu();
        }
        pause();
        handlerForSearchToursMenu();
    }

    private static void handlerSearchByTourBeginDate() {
        clearScreen();
        printSearchByTourBeginDateChoice();
        handlerSearchByTourBeginDateChoice();
    }

    private static void printSearchByTourBeginDateChoice() {
        System.out.println("1- after a date");
        System.out.println("2- before a date");
        System.out.println("3- between two date");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerSearchByTourBeginDateChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1"://TODO
                break;
            case "2"://TODO
                break;
            case "3"://TODO
                break;
            case "h":
                pause();
                handlerSearchByTourBeginDate();
                break;
            case "m":
                handlerForSearchToursMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerSearchByTourBeginDate();
        }
        pause();
        handlerSearchByTourBeginDate();
    }

    private static void handlerSearchByTourPrice() {
        clearScreen();
        printSearchByTourPriceChoice();
        handlerSearchByTourPriceChoice();
    }

    private static void printSearchByTourPriceChoice() {
        System.out.println("1- with one number");
        System.out.println("2- bigger than a number");
        System.out.println("3- smaller than a number");
        System.out.println("4- between two number");
        System.out.println("m- Go To Previous Menu");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerSearchByTourPriceChoice() {
        String choice = input.nextLine();
        clearScreen();
        switch (choice) {
            case "1"://TODO
                break;
            case "2"://TODO
                break;
            case "3"://TODO
                break;
            case "4"://TODO
                break;
            case "h":
                pause();
                handlerSearchByTourPrice();
                break;
            case "m":
                handlerForSearchToursMenu();
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerSearchByTourPrice();
        }
        pause();
        handlerSearchByTourPrice();
    }

    private static void handlerForAreaMenu() {
        clearScreen();
        printAreaMenuChoice();
        handlerForAreaMenuChoice();
    }

    private static void printAreaMenuChoice() {
        System.out.println("1- show all area's");
        System.out.println("2- add area");
        System.out.println("3- edit area");
        System.out.println("4- remove area");
        System.out.println("h- help");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForAreaMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        String name,capital;
        switch (choice) {
            case "1":
                if (areas.isEmpty()) {
                    System.out.println("no area's , add one first");
                }
                System.out.println(areas);
                break;
            case "2":
                if (currentUserLevel.getRoles().contains(Roles.AREAADD)) {
                    break;
                }
                System.out.println( "name :");
                name = input.nextLine();
                System.out.println("capital(if it's a city enter the name again)");
                capital = input.nextLine();
                if (capital.equals(name)) {
                    areas.add(new Area(name));
                } else {
                    areas.add(new Area(name , capital));
                }
                break;
            case "3"://TODO
                if (currentUserLevel.getRoles().contains(Roles.AREAREMOVEOREDIT)) {
                    break;
                }
                break;
            case "4":
                if (currentUserLevel.getRoles().contains(Roles.AREAREMOVEOREDIT)) {
                    break;
                }
                System.out.println(areas);
                System.out.println("enter name ");
                name = input.nextLine();
                areas.removeIf(area -> area.getName().equals(name));
                break;
            case "h":
                pause();
                handlerForAreaMenu();
                break;
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForAreaMenu();
        }
        pause();
        handlerForAreaMenu();
    }

    private static void handlerForMapMenu() {
        clearScreen();
        printMapMenuChoice();
        handlerForMapMenuChoice();
    }

    private static void printMapMenuChoice() {
        System.out.println("1- show the origin of a tour");
        System.out.println("2- show the destination of a tour");
        System.out.println("3- show the origin and destination of a tour");
        System.out.println("4- show the current place of a foreign tour");
        System.out.println("5- show all place's of a foreign tour");
        System.out.println("6- show city or country in map");
        System.out.println("7- show 2 city in map");
        System.out.println("h- help");
        System.out.println("M- Go To Main Menu\n\n");
        System.out.println("Please Enter Your Choice:\n");
    }

    private static void handlerForMapMenuChoice() {
        String choice = input.nextLine();
        clearScreen();
        String city1,city2;
        switch (choice) {
            case "1"://TODO
                break;
            case "2"://TODO
                break;
            case "3"://TODO
                break;
            case "4"://TODO
                break;
            case "5"://TODO
                break;
            case "6":
                System.out.println("enter name:");
                MapUtil.showMap(input.nextLine());
                break;
            case "7":
                System.out.println("enter 1:");
                city1 = input.nextLine();
                System.out.println("enter 2");
                city2 = input.nextLine();
                MapUtil.showMap(city1,city2);
                break;
            case "h":
                pause();
                handlerForMapMenu();
                break;
            case "M":
                handlerForMainMenu();
                break;
            default:
                System.out.println("tour choice is not exist please try another");
                pause();
                handlerForMapMenu();
        }
        pause();
        handlerForMapMenu();
    }

    private static void clearScreen() {
        System.out.println(System.lineSeparator().repeat(50));
    }

    private static void pause() {
        System.out.println("press enter to continue ...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }
}
