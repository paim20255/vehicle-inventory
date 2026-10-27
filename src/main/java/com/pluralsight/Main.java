package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);
        
        Vehicle car = new Vehicle(101121, "Ford Explorer", "Red", 4500, 13500);
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        vehicles.add(car);

        Vehicle car2 = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles.add(car2);

        Vehicle car3 = new Vehicle(101123,"Chevrolet Malibu","Black",50000,9700);
        vehicles.add(car3);

        Vehicle car4 = new Vehicle(101124,"Honda Civic","White",70000,7500);
        vehicles.add(car4);

        Vehicle car5 = new Vehicle(101125,"Subaru Outback","Green",55000,14500);
        vehicles.add(car5);

        Vehicle car6 = new Vehicle(101126,"Jeep Wrangler","Yellow",30000,16000);
        vehicles.add(car6);

        for (Vehicle currentVehicle : vehicles) {
            System.out.println(currentVehicle.getColor());

        }
        String menuPrompt = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""";
        System.out.println(menuPrompt);
        String userInput = myScanner.nextLine();


        switch (userInput) {
            case "1" -> {
                for (Vehicle currentVehicle : vehicles) {
                    currentVehicle.getVehicleId();
                    currentVehicle.display();
                }
            }
            case "2" -> {
                System.out.println("Enter make/model to search for: ");
                String searchMakeModel = myScanner.nextLine();

                searchVehicles(searchMakeModel, vehicles);
            }
            case "3" -> {
                System.out.println("Enter minium search price: ");
                String priceMiniumText = myScanner.nextLine();
                double priceMinium = Double.parseDouble(priceMiniumText);

                System.out.println("Enter maximum search price: ");
                String priceMaximumText = myScanner.nextLine();
                double priceMaximum = Double.parseDouble(priceMaximumText);

                searchByPrice(priceMinium, priceMaximum, vehicles);
            }
            case "4" -> {
                System.out.println("Enter the color you want: ");
                String searchColor = myScanner.nextLine();

                searchForColor(searchColor, vehicles);
            }
            case "5" -> {
                System.out.println("Enter The vehicle info like this: 101123,Chevrolet Malibu,Black,50000,9700");
                String vehicleCsv = myScanner.nextLine();

                Vehicle newVehicle = parseVehicle(vehicleCsv);
                vehicles.add(newVehicle);


            }
                case "6" -> {
                    System.out.println("I'm Tired Goodbye!");

                }
            default -> {
                System.out.println("Not a option dumbass...");
             }
            }
        }

        public static Vehicle parseVehicle(String vehicleCsv) {
          String[] parts = vehicleCsv.split(Pattern.quote(","));

          String vehicleIdText = parts[0];
          long vehicleID = Long.parseLong(vehicleIdText);

          String makeModel = parts[1];

          String color = parts[2];

          int odometerReading = Integer.parseInt(parts[3]);

          double price = Double.parseDouble(parts[4]);


          Vehicle newCar = new Vehicle(vehicleID, makeModel, color, odometerReading, price);

            return null;
        }

    private static void searchByPrice(double priceMinium, double priceMaximum, ArrayList<Vehicle> vehicles) {
        for (Vehicle currentVehicle : vehicles) {
            double vehiclePrice = currentVehicle.getPrice();

            if( (vehiclePrice >= priceMinium) && (vehiclePrice <= priceMaximum) ) {
                currentVehicle.display();

            }
        }
    }

    private static void searchForColor(String searchColor, ArrayList<Vehicle> vehiclesToSearch) {
        for (Vehicle currentVehicle : vehiclesToSearch) {

            String currentColor = currentVehicle.getColor();
            if (currentColor.equals(searchColor)) {
                currentVehicle.display();
            }
        }
    }

    private static void searchVehicles(String searchMakeModel, ArrayList<Vehicle> vehicles) {
        for (Vehicle currentVehicle : vehicles) {
            String currenMakeModel = currentVehicle.getMakeModel();
           if (currenMakeModel.equals(searchMakeModel)) {
               currentVehicle.display();
           }


        }
    }


}
