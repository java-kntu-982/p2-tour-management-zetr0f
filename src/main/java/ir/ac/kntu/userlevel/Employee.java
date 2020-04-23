package ir.ac.kntu.userlevel;

import java.util.Objects;

public class Employee extends User {
    private static UserLevel employeeUserLevel;
    private Date dateOfBirth = new Date();
    private double salaryBase;

    public Employee(String userName, String password, String email, String phoneNumber, Date dateOfBirth
            , double salaryBase) {
        super(userName, password, email, phoneNumber);
        this.dateOfBirth = dateOfBirth;
        this.salaryBase = salaryBase;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getSalaryBase() {
        return salaryBase;
    }

    public void setSalaryBase(double salaryBase) {
        this.salaryBase = salaryBase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Employee)) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Employee employee = (Employee) o;
        return Objects.equals(getDateOfBirth(), employee.getDateOfBirth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDateOfBirth());
    }

    @Override
    public String toString() {
        return "Employee{" + super.toString() +
                "dateOfBirth=" + dateOfBirth +
                ", salaryBase=" + salaryBase +
                '}';
    }
}
