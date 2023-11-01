package com.pluralsight;
import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double punchIn;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
        this.punchIn = 0.0;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getPayRate() {
        return payRate;
    }
    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }
    public double getHoursWorked() {
        return hoursWorked;
    }
    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
    public void punchIn(double time) {
        punchIn = time;
    }
    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        punchIn = now.getHour() + now.getMinute() / 60.0;
    }
    public void punchOut(double time) {
        if (punchIn > 0) {
            double workedHours = time - punchIn;
            hoursWorked += workedHours;
            punchIn = 0.0;
        } else {
            System.out.println("You cannot punch out without punching in first.");
        }
    }
    public void punchOut() {
        if (punchIn > 0) {
            LocalDateTime now = LocalDateTime.now();
            double currentTime = now.getHour() + now.getMinute() / 60.0;
            double workedHours = currentTime - punchIn;
            hoursWorked += workedHours;
            punchIn = 0.0;
        } else {
            System.out.println("You cannot punch out without punching in first.");
        }
    }
    public double getTotalPay() {
        if (hoursWorked <= 40) {
            return hoursWorked * payRate;
        } else {
            double regularHours = 40 * payRate;
            double overtimeHours = (hoursWorked - 40) * (payRate * 1.5);
            return regularHours + overtimeHours;
        }
    }
    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }
    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }
}
