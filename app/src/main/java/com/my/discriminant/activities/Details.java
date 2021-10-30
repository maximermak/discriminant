package com.my.discriminant.activities;

public class Details {
    public String writeDetails(int a, int b, int c){
        // D = ax^2 + bx + c
        double D, x1, x2;
String result;
        D = b*b - 4 * a * c;
        if(D < 0)
        {
            result = "Error, D<0";
        }
        if(D == 0)
        {
            x1 = -b/2*a;
            result = "D = ax^2 + bx + c \n " +
                    "D = " + a + "x^2 + " + b + "x + " + c +
                    "\n D = " + D +
                    "\n" + "x = " + x1;

        }
        else {


            x1 = (-b + Math.sqrt(D)) / 2 * a;
            x2 = (-b - Math.sqrt(D)) / 2 * a;
            result = "D = ax^2 + bx + c \n " +
                    "D = " + a + "x^2 + " + b + "x + " + c +
                    "\n D = " + D +
                    "\n" + "x1 = " + x1 +
                    "\n x2 = " + x2;
        }
        return result;

    }
}
