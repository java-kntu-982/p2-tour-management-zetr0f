package ir.ac.kntu.userlevel;

public class Customer extends User {
    public static UserLevel customerUserLevel;

    public Customer(String userName, String password, String email, String phoneNumber) {
        super(userName, password, email, phoneNumber);
        if (customerUserLevel == null) {
            customerUserLevel = new UserLevel();
        }
    }

    @Override
    public String toString() {
        return "Customer{"+ super.toString() +"}";
    }
}
