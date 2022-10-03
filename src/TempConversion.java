import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {
        return convertK2C(kelvin) * (9.0/5.0 + 32.0);
    }

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return Double.parseDouble(input.nextLine());
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.nextLine();
    }
    public static String getConvertToUnit() {
        Scanner unitScanner = new Scanner(System.in);
        System.out.print("Enter the temperature unit to convert to: ");
        String convertTo = unitScanner.nextLine();
        return convertTo;
    }
    public static void main(String[] args) {
        Scanner unitScanner;
        String convertTo;
        double temperature;

        TempConversion tempConversion = new TempConversion();
        String unitChoice = "";
        boolean shouldRun = true;

        while(shouldRun) {
            System.out.println();
            System.out.println("Please enter your choice of letter: ");
            unitChoice  =  getUnitChoice();

            switch (unitChoice) {
                case "C":
                    convertTo = getConvertToUnit();
                    temperature = getTemp(convertTo);
                    switch (convertTo) {
                        case "F":
                            System.out.println("Result " + temperature + "°C is "  + convertC2F(temperature) + "°F");
                            break;
                        case "K":
                            System.out.println("Result " + temperature + "°C is " + convertC2K(temperature) + "°K");
                            break;
                    }
                    break;

                case "F":
                    convertTo = getConvertToUnit();
                    temperature = getTemp(convertTo);

                    switch (convertTo) {
                        case "C":
                            System.out.println("Result " + temperature + "°F is " + convertF2C(temperature) + "°C");
                            break;
                        case "K":
                            System.out.println("Result " + temperature + "°F is " +convertF2K(temperature) + "°K");
                            break;
                    }
//                    if (convertTo.equals("C")) {
//                        System.out.println("Result " + temperature + "°F is " + convertF2C(temperature) + "°C");
//                    } else if (convertTo.equals("K")) {
//                        System.out.println("Result " + temperature + "°F is " +convertF2K(temperature) + "°K");
//                    }
                    break;

                case "K":
                    convertTo = getConvertToUnit();
                    temperature = getTemp(convertTo);

                    switch (convertTo) {
                        case "C":
                            System.out.println("Result " + temperature + "°K is " + convertK2C(temperature) + "°C");
                            break;
                        case "F":
                            System.out.println("Result " + temperature + "°K is " + convertK2F(temperature) + "°F");
                    }
//                    if (convertTo.equals("C")) {
//                        System.out.println("Result " + temperature + "°K is " + convertK2C(temperature) + "°C");
//                    } else if (convertTo.equals("F")) {
//                        System.out.println("Result " + temperature + "°K is " + convertK2F(temperature) + "°F");
//                    }
                    break;

                case "Q":
                    shouldRun = false;
                    break;
            }
            }


    }
}