/*
 *  UCF COP3330 Fall 2021 Assignment 2 Solution
 *  Copyright 2021 Koby Montenegro
 */
package org.example;

    import java.util.Scanner;

    class Main
    {
        public static boolean numberCheck(String input) {
            try
            {
                Integer.parseInt(input);
            }
            catch (NumberFormatException e)
            {
                return false;
            }
            return true;
        }

        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);

            int restingHR;
            int age;

            // double checks that the resting pulse is a valid input
            while (true)
            {
                System.out.print("Enter Resting Pulse: ");
                String input = scan.nextLine();

                if (numberCheck(input)) {
                    //Takes string and converts into integer
                    restingHR = Integer.parseInt(input);
                    break;
                }
                else
                {
                    System.out.println("Error with the pulse has occurred.");
                }
            }

            // reading resting pulse until valid input
            while (true)
            {
                System.out.print("Enter Age: ");
                String input = scan.nextLine();

                // checking if input is number
                if (numberCheck(input))
                {
                    age = Integer.parseInt(input);
                    break;
                }
                else
                {
                    System.out.println("Error with the Age occurred");
                }

            }

            // Karvonen Formula
            System.out.println("Intensity\t| Rate");
            System.out.println("------------|--------");
            for (int intensity = 55; intensity <= 95; intensity += 5)
            {
                int targetRate = ((220 - age - restingHR) * intensity / 100) + restingHR;
                System.out.println(intensity + "%\t\t\t| " + targetRate + " bpm");
            }

            scan.close();
        }
    }

