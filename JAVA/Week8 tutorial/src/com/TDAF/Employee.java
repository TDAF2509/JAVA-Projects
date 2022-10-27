package com.TDAF;

import java.util.Arrays;

public class Employee {
    private String name;
    private Job job;
    private Company company;

    public Employee(String name, Job job, Company company) {
        this.name = name;
        this.job = job;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addEmployee(){
        Employee[] e=company.getListOfEmployees();
        Employee[] t=new Employee[company.getNumberOfEmployees()];
//        for (int i =0; i<t.length;i++){
//            t[i]=e[i];
//        }
        System.out.println(Arrays.toString(e));
        System.out.println(Arrays.toString(t));

    }
}
