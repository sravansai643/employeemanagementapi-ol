package com.employeemanagement.util;
public class EmployeeCalUtil {

    public static Double calculateHra(Double sal) {
        if (sal <= 50000)
            return sal * 0.2;
        else if (sal > 50000 && sal <= 100000)
            return sal * 0.3;
        else
            return sal * 0.5;
    }

    public static Double calculateDa(Double sal) {
        if (sal <= 50000)
            return sal * 0.1;
        else if (sal > 50000 && sal <= 100000)
            return sal * 0.2;
        else
            return sal * 0.4;
    }

    public static Double calculateTax(Double sal) {
        if (sal < 50000) {
            return 0.0;
        } else if (sal >= 50000 && sal <= 75000)
            return sal * 0.1;
        else if (sal > 75000 && sal <= 100000)
            return sal * 0.15;
        else
            return sal * 0.20;
    }

}
