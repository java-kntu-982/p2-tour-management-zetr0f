package ir.ac.kntu.userlevel;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    //    private static UserLevel userLevel;
    private String userName;
    private String password;
    private String email;
    private String phoneNumber;

    public User() {
    }

    public User(String userName, String password, String email, String phoneNumber) {
        setUserName(userName);
        setPassword(password);
        setEmail(email);
        setPhoneNumber(phoneNumber);
    }

    public User(User user) {
        setPhoneNumber(user.getPhoneNumber());
        setPassword(user.getPassword());
        setEmail(user.getEmail());
        setUserName(user.getUserName());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String regex = "^[a-z0-9_-]{3,15}$";
        if (Pattern.matches(regex, userName)) {
            this.userName = userName;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String regex = "^((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        if (matcher.matches()) {
            this.password = password;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (Pattern.matches(regex, email)) {
            this.email = email;
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        String regex = "^[0][9]\\d{9}$";
        if (Pattern.matches(regex, phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(getUserName(), user.getUserName()) &&
                Objects.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                Objects.equals(getPhoneNumber(), user.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail(), getPhoneNumber());
    }

    @Override
    public String toString() {
        return  "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'';
    }
}
