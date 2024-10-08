// src/Temperatur.java
public class Temperatur {

    // temperatur i celsius
    private double temp;

    // Standard constructor
    public Temperatur() {
        temp = 0;
    }

    // Copy constructor
    public Temperatur(Temperatur other) {
        temp = other.celsius();
    }

    // Get method for Celsius
    public double celsius() {
        return temp;
    }

    // Set method for Celsius
    public void celsius(double c) {
        temp = c;
    }

    // Get method for Fahrenheit
    public double fahrenheit() {
        return 9.0 / 5.0 * temp + 32.0;
    }

    // Set method for Fahrenheit
    public void fahrenheit(double f) {
        temp = (f - 32) * 5.0 / 9.0;
    }

    // Equals method to compare temperatures
    public boolean equals(Temperatur other) {
        return temp == other.celsius();
    }

    // Helper method to determine the sign
    private int signum(double tal) {
        if (tal < 0)
            return -1;
        else if (tal > 0)
            return 1;
        else
            return 0;
    }

    // CompareTo method
    public int compareTo(Temperatur t) {
        return signum(temp - t.celsius());
    }

    // toString method to print temperature in both scales
    @Override
    public String toString() {
        return "[" + celsius() + "C, " + fahrenheit() + "F]";
    }

    // src/Temperatur.TemperaturTest.java
    public static class TemperaturTest {

        public static void main(String[] argv) {
            Temperatur t1 = new Temperatur();

            // Set and display temperature in Celsius
            t1.celsius(100);
            System.out.println(t1); // Output: [100.0C, 212.0F]

            // Set and display temperature in Fahrenheit
            t1.fahrenheit(0);
            System.out.println(t1); // Output: [-17.7778C, 0.0F]

            // Copy constructor test
            Temperatur t2 = new Temperatur(t1);
            System.out.println("t1 og t2 ens: " + t1.equals(t2)); // Output: true

            // Set new value to t1 and compare with t2
            t1.celsius(0);
            System.out.println(t1); // Output: [0.0C, 32.0F]
            System.out.println("t1 compare to t2: " + t1.compareTo(t2)); // Output: -1
        }
    }
}