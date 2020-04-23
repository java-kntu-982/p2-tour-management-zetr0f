package ir.ac.kntu.userlevel;


import java.util.HashSet;
import java.util.Objects;

public class UserLevel {
    private HashSet<Roles> roles = new HashSet<>();
//    private ArrayList<Roles> employeeArr = new ArrayList<>(Collection<>(Roles.TOURREMOVEOREDIT, Roles.AREAADD, Roles.AREAREMOVEOREDIT, Roles.TOURINFORMATIONREMOVEOREDIT, Roles.TOURINFORMATIONADD));
//    private HashSet<Roles> employeeRoles = new HashSet<>();

    public UserLevel(){
    }
    public UserLevel(HashSet<Roles> roles) {
        this.roles = roles;
    }

    public HashSet<Roles> getRoles() {
        return roles;
    }

    public void setRoles(HashSet<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserLevel{" +
                "roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserLevel)) {
            return false;
        }
        UserLevel userLevel = (UserLevel) o;
        return Objects.equals(getRoles(), userLevel.getRoles());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoles());
    }
}
