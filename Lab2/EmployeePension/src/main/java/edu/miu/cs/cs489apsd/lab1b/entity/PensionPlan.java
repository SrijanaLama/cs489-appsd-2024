package edu.miu.cs.cs489apsd.lab1b.entity;

import java.time.LocalDate;

public class PensionPlan {

    private String planReferenceNumber;
    private LocalDate enrollmentDate;
    private double monthlyContribution;


    public String getPlanReferenceNumber() {
        return planReferenceNumber;
    }

    public void setPlanReferenceNumber(String planReferenceNumber) {
        this.planReferenceNumber = planReferenceNumber;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public double getMonthlyContribution() {
        return monthlyContribution;
    }

    public void setMonthlyContribution(double monthlyContribution) {
        this.monthlyContribution = monthlyContribution;
    }

    public PensionPlan() {
    }

    public PensionPlan(String planReferenceNumber, LocalDate enrollmentDate, double monthlyContribution) {
        this.planReferenceNumber = planReferenceNumber;
        this.enrollmentDate = enrollmentDate;
        this.monthlyContribution = monthlyContribution;
    }

    @Override
    public String toString() {
        return "{" +
                "planReferenceNumber:'" + planReferenceNumber + '\'' +
                ", enrollmentDate:" + enrollmentDate +
                ", monthlyContribution:" + monthlyContribution +
                '}';
    }

    public String toJSONString() {
        return String.format("\t{ \"planReferenceNumber\":%s, \"enrollmentDate\":\"%s\", \"monthlyContribution\":\"%s\"}",
                planReferenceNumber, enrollmentDate, monthlyContribution);
    }
}
