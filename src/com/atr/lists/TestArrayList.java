package com.atr.lists;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Jane","Jones", 123));
        employeeList.add(new Employee("John","Jones", 342));
        employeeList.add(new Employee("Mary","Jones", 345));

        employeeList.forEach(employee -> System.out.println(employee));
    }
}
