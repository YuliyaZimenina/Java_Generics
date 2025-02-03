package com.zimenina.julia.genericArray;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
Generics
 */

public class GenericArray <T extends Comparable<T>> {

    // Typed Array Initialization
    T[] array;
    static Scanner scanner = new Scanner(System.in);

    // Class constructor
    public GenericArray() {
    }

    //Class constructor with parameters
    public GenericArray(T[] array) {
        this.array = array;
    }

    // Getters and Setters
    public T[] getArray() {
        return array;
    }

    public void setArray(T[] array) {
        this.array = array;
    }

    // Methods for working with an array

    // Method for filling an array from the keyboard
    public T[] fillArrayWithKeyboard(Scanner in, Class<T> tClass) {
        System.out.println("Enter the length of the array: ");
        int sizeArray = choiceLengthArray();
        T[] array = (T[]) Array.newInstance(tClass, sizeArray);
        for (int i = 0; i < array.length; i++) {
            java.lang.constant.Constable element = null;
            if (tClass == Integer.class) {
                element = scanner.nextInt();
            } else if (tClass == Double.class) {
                element = scanner.nextDouble();
            } else if (tClass == String.class) {
                element = scanner.nextLine();
            }

            array[i] = tClass.cast(element);
        }
        return array;
    }

    // Method for filling an array with random numbers
    public T[] randomFillArray(Class<T> clazz) {
        Random random = new Random();
        System.out.println("Enter the length of the array: ");
        int sizeArray = choiceLengthArray();
        T[] array = (T[]) Array.newInstance(clazz, sizeArray);
        for (int i = 0; i < array.length; i++) {
            java.lang.constant.Constable element = null;
            if (clazz == Integer.class) {
                element = random.nextInt(10);
            } else if (clazz == Double.class) {
                element = random.nextDouble();
            } else if (clazz == String.class) {
                Random random1 = new Random();
                String[] word = new String[]{"Z", "W", "R", "Q", "L", "M", "T", "I", "C", "G", "X", "E", "B", "T", "A", "E", "D", "Y", "N", "P"};
                element = word[random1.nextInt(word.length)];
            }
            array[i] = clazz.cast(element);
        }
        return array;
    }

    // Method for finding the maximum value in an array
    public void maxElementArray(T[] array) {
        T max = array[0];
        for (T value : array) {
            if (max.compareTo(value) < 0) {
                max = value;
            }
        }
        System.out.println("The maximum value of an array element is: " + max);
    }

    // Method for finding the minimum value in an array
    public void minElementArray(T[] array) {
        T min = array[0];
        for (T value : array) {
            if (min.compareTo(value) > 0) {
                min = value;
            }
        }
        System.out.println("The minimum value of an array element is: " + min);
    }

    // Method for calculating the arithmetic mean
    public Double averageElementArray(T[] array, Class<T> tClass) {
        Double average = 0.0;
        if (tClass == Integer.class) {
            for (T value : array) {
                average += (Integer) value;
            }
            average = average / array.length;
        }
        if (tClass == Double.class) {
            for (T value : array) {
                average += (Double) value;
            }
            average = average / array.length;
            System.out.println("The arithmetic mean is " + average);
        }
        if (tClass == String.class) {
            System.out.println("The specified array of type String. The arithmetic mean cannot be calculated");
        }

        return average;
    }

    // Method for sorting array elements in ascending order
    public <T> void sortAscending(T[] array) {
        Arrays.sort(array);
        System.out.println("Array sorted in ascending order: " + Arrays.toString(array));
    }

    // Method for sorting the elements of an array in descending order
    public <T> void sortDescending(T[] array) {
        Arrays.sort(array);
        T element;
        for (int i = 0; i < array.length / 2; i++) {
            element = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = element;
        }
        System.out.println("Array sorted in descending order: " + Arrays.toString(array));
    }

    // Method for finding a value in an array (binary search)
    public void binarySearch(T[] array, T search) {
        int amount = 0;
        int index = 0;
        Arrays.sort(array);
        for (T value : array) {
            if (search.equals(value)) {
                index = 1;
                amount += 1;
            }
        }

        if (index == 1) {
            System.out.println("The index of the item you are looking for: " + search + " Result: " + Arrays.binarySearch(array, search));
            System.out.println("Number of coincidences: " + amount);
        } else {
            System.out.println("Set value: " + search + " is missing in the array");
        }
    }

    // Method for replacing a value in an array with another value
    public <T> T[] changeElementArray(T[] array, int index, Class<T> tClass) {
        System.out.println("Enter the value of the element to be replaced: ");
        Object element = null;
        if (tClass == Integer.class && scanner.hasNextInt()) {
            element = scanner.nextInt();
            array[index] = (T) element;
        }

        if (tClass == Double.class && scanner.hasNextDouble()) {
            element = scanner.nextDouble();
            array[index] = (T) element;
        }

        if (tClass == String.class && scanner.hasNextLine()) {
            element = scanner.nextLine();
            array[index] = (T) element;
        }
        return array;
    }


    // Сhoosing the type of elements in an array
    public Class<T> choiceTypeElement() {
        Class clazz = Object.class;
        System.out.println("Select array type: ");
        System.out.println("1 - String - array of strings");
        System.out.println("2 - Integer - array of integers");
        System.out.println("3 - Double - an array of fractional numbers");

        while (true) {
            if (scanner.hasNextLine()) {
                int i = scanner.nextInt();
                switch (i) {
                    case 1:
                        System.out.println("Array data type String");
                        clazz = String.class;
                        break;

                    case 2:
                        System.out.println("Array data type Integer ");
                        clazz = Integer.class;
                        break;

                    case 3:
                        System.out.println("Array data type Double");
                        clazz = Double.class;
                        break;

                    default:
                        System.out.println("You entered an invalid parameter. Re-enter");
                        this.choiceTypeElement();
                        break;
                }
                break;
            } else {
                System.out.println("ВYou entered an invalid parameter. Re-enter");
                this.choiceTypeElement();
            }
        }
        return clazz;
    }

    // Method for entering the value of the length of the array
    public int choiceLengthArray() {
        int lengthArray = 0;
        while (true) {
            if (scanner.hasNextLine()) {
                lengthArray = scanner.nextInt();
                if (lengthArray > 0) {
                    System.out.println("The length of the array is: " + lengthArray);
                    break;
                } else {
                    System.out.println("You have not entered an integer. Please enter an integer");
                }
            } else {
                System.out.println("You have not entered an integer. Please enter an integer");
            }
        }
        return lengthArray;
    }

    //Method for choosing the way to fill the array
    public int choiceMethodFillArray() {
        System.out.println("Choose a way to fill the array: ");
        System.out.println("1 - Fill an array with random values");
        System.out.println("2 - Fill the array from the keyboard");

        int userChoice = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                userChoice = scanner.nextInt();
                if (userChoice == 1 || userChoice == 2) {
                    switch (userChoice) {
                        case 1:
                            System.out.println("Fill an array with random values");
                            break;
                        case 2:
                            System.out.println("Fill the array from the keyboard");
                            break;
                    }
                    break;
                } else {
                    System.out.println("Invalid entries. Enter one of the suggested options.");
                }
                break;
            } else {
                System.out.println("Invalid entries. Enter one of the suggested options.");
            }
        }
        return userChoice;
    }


    // Method responsible for choosing an operation on an array
    public int menuArrayOperation() {
        System.out.println();
        System.out.println("Select an operation to work with an array: ");
        System.out.println ("1 - Select the minimum element of the array");
        System.out.println ("2 - Select the maximum element of the array");
        System.out.println ("3 - Output the arithmetic mean of all elements of the array");
        System.out.println ("4 - Sort array elements in ascending order");
        System.out.println ("5 - Sort array elements in descending order");
        System.out.println ("6 - Binary Search");
        System.out.println ("7 - Replace array element with a new one");
        System.out.println ("8 - Completion of work with an array");
        System.out.println();

        int i = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                i = scanner.nextInt();
                if (i >= 1 && i <= 8) {
                    break;
                } else {
                    System.out.println("This menu item does not exist. Re-enter");
                    menuArrayOperation();
                }
            }
        }
        return i;
    }

    public <T> T choiceElement(Class<T> tClass) {
        java.lang.constant.Constable element = null;
        while (true) {
            if (tClass == Integer.class) {
                if (scanner.hasNextInt()) {
                    element = scanner.nextInt();
                    break;
                } else {
                    System.out.println("The type of the entered variable does not match the type of the array: " + tClass.getName());
                }
            }

            if (tClass == Double.class) {
                if (scanner.hasNextDouble()) {
                    element = scanner.nextDouble();
                    break;
                } else {
                    System.out.println("The type of the entered variable does not match the type of the array: " + tClass.getName());
                }
            }

            if (tClass == String.class) {
                element = scanner.nextLine();
                break;
            } else {
                System.out.println("The type of the entered variable does not match the type of the array: " + tClass.getName());
            }
        }
        return tClass.cast(element);
    }

    //Method to run the program
    public void run() {
        Class<T> clazz = choiceTypeElement();
        int i = 0;
        while (true) {
            i = choiceMethodFillArray();
            if (i == 1 || i == 2) {
                break;
            }
        }

        GenericArray<T> userArray = new GenericArray<T>(array);
        switch (i) {
            case 1:
                array = randomFillArray(clazz);
                System.out.println("Array filled with random values: " + Arrays.toString(array));
                break;
            case 2:
                array = (fillArrayWithKeyboard(scanner, clazz));
                System.out.println();
                System.out.println("You have filled the array with the following values: " + Arrays.toString(array));
                break;
        }
        while (true) {
            int menuItem = menuArrayOperation();

            switch (menuItem) {
                case 1:
                    System.out.println("Finding the minimum element of an array: ");
                    minElementArray(array);
                    break;

                case 2:
                    System.out.println("Finding the maximum element of an array:");
                    maxElementArray(array);
                    break;

                case 3:
                    System.out.println("Arithmetic mean of all array elements: " +
                            userArray.averageElementArray(array, clazz));
                    break;

                case 4:
                    System.out.println("Sort array elements in ascending order: ");
                    userArray.sortAscending(array);
                    break;

                case 5:
                    System.out.println("Sorting the elements of an array in descending order: ");
                    userArray.sortDescending(array);
                    break;

                case 6:
                    System.out.println ("Binary Search:");
                    System.out.println ("Enter variable value:");
                    T a = choiceElement(clazz);
                    userArray.binarySearch(array, a);
                    break;

                case 7:
                    System.out.println ("Replace element by index in the array");
                    System.out.println ("Enter the index of the array element to be replaced:");
                    while (true) {
                        if (scanner.hasNextInt()) {
                            int index = scanner.nextInt();
                            if (index < array.length) {
                                userArray.changeElementArray(array, index, clazz);
                                System.out.println("Modified array: " + Arrays.toString(array));
                                break;
                            } else {
                                System.out.println("You entered a non-existent array index. Re-enter");
                            }
                        } else {
                            System.out.println("You entered a non-existent array index. Re-enter");
                        }
                    }
                    break;

                case 8:
                    System.out.println("Program completed");
                    break;

                default:
                    System.out.println("Re-enter");
                    break;
            }
            if (menuItem == 8) {
                break;
            }
        }
    }
}

