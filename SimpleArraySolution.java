package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;

/*
Самые частые байты
*/

public class SimpleArraySolution {

    public static void main(String[] args) throws Exception {

        /* Open readers, get a filename */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(file);

        /* Log the startup point startTime */
        long startTime = new Date().getTime();

        /* Create a simple array of lenght 256, put a byte in corresponding index from 0 to 255, +1 its value by index */
        long[] array = new long[256];
        while (fileInputStream.available() > 0) {
            array[fileInputStream.read()]++;
        }

        /* Iterate through the array, find the most abundant byte and
            give the variable mostAbundantCounter its abundance */

        long mostAbundantCounter = 0;

        for (int i = 0; i < array.length  ; i++) {
            if (array[i] > mostAbundantCounter) {
                mostAbundantCounter = array[i];
            }
        }

        /* Using mostAbundantCounter value, iterate through array, print all
            the bytes with mostAbundantCounter abundance value with a space " " separator */

        for (int i = 0; i < array.length ; i++) {
            if (array[i] == mostAbundantCounter) {
                System.out.print(i + " ");
            }
        }

        /* Close Input Stream. TODO better use try with resources */

        fileInputStream.close();

        /*Print run time in milliseconds from a new line*/

        System.out.print(System.getProperty("line.separator"));
        System.out.println("This run was finished in, ms: " + (new Date().getTime() - startTime));

    }



}
