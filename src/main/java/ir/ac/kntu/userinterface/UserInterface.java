package ir.ac.kntu.userinterface;

import java.util.Calendar;
import java.util.Date;

public class UserInterface {
    public static Date today = new Date(1399 , 1, 21  );

    private UserInterface() {
    }



    private static void clearScreen() {
        System.out.println(System.lineSeparator().repeat(50));
    }
}
