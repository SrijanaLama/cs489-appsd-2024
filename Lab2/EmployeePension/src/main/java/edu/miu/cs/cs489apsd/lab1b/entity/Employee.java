package edu.miu.cs.cs489apsd.lab1b.entity;


import java.time.LocalDate;


public class Employee {


    private long employeeId;
    private String firstName;
    private String lastName;
    private LocalDate employmentDate ;
    private double yearlySalary;

    private PensionPlan pensionPlan;

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getYearlySalary() {
        return yearlySalary;
    }

    public void setYearlySalary(double yearlySalary) {
        this.yearlySalary = yearlySalary;
    }

    public Employee() {
    }


    public Employee(long employeeId, String firstName, String lastName, LocalDate employmentDate, double yearlySalary, PensionPlan pensionPlan) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentDate = employmentDate;
        this.yearlySalary = yearlySalary;
        this.pensionPlan = pensionPlan;
    }

    @Override
    public String toString() {
        return "{" +
                "employeeId:" + employeeId +
                ", firstName:'" + firstName + '\'' +
                ", lastName:'" + lastName + '\'' +
                ", employmentDate:" + employmentDate +
                ", yearlySalary:" + yearlySalary +
                ", pensionPlan:" + pensionPlan +
                '}';
    }

    public PensionPlan getPensionPlan() {
        return pensionPlan;
    }

    public void setPensionPlan(PensionPlan pensionPlan) {
        this.pensionPlan = pensionPlan;
    }

    public String toJSONString() {
        return String.format("\t{ \"employeeId\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"employmentDate\":%s, \"yearlySalary\":%,.2f  ,\"pensionPlan\":%s}",
                employeeId, firstName, lastName, employmentDate, yearlySalary,pensionPlan != null ? pensionPlan.toJSONString() : null );
    }
}
