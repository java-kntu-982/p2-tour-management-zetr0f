package ir.ac.kntu.userlevel;

public class Admin extends User{
    public static UserLevel adminUserLevel;
    public Admin() {
        setUserName("admin");
        setPassword("@Adm1n");
    }

    @Override
    public String toString() {
        return "Admin{" + super.toString() + "}";
    }
}
