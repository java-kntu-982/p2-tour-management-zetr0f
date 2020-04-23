package ir.ac.kntu.userlevel;

public class Customer extends User {
    private static UserLevel customerUserLevel;
    @Override
    public String toString() {
        return "Customer{"+ super.toString() +"}";
    }
}
