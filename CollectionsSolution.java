package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class CollectionsSolution {
    public static void main(String[] args) throws Exception {


        /* Open readers, get a filename */
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String file = reader.readLine();

            FileInputStream fileInputStream = new FileInputStream(file);

            /* Log the startup point instantiating Date object with getTime in long value startTime */
            long startTime = new Date().getTime();

            /* Instantiate a HashMap to store (valueToCount) : (counter) in it.
             Pay attention: The valueToCount is a key here,
             the counter is a value of a HashMap */

            HashMap<Integer, Integer> hashMap = new HashMap<>();

            /* While fileInputStream has data, read a byte to int variable data,
             check if HashMap already have this byte, if it is, +1 counter, if not,
             put it in a HasMap and set its counter to 1 */

            while (fileInputStream.available() > 0) {
                int data = fileInputStream.read();
                if (hashMap.containsKey(data)) {
                    int count = hashMap.get(data) + 1;
                    hashMap.put(data, count);
                } else {
                    hashMap.put(data, 1);
                }
            }

            /* Iterate through the hashMap.values, find the most abundant byte and
            give the variable mostAbundantCounter its abundance */

            long mostAbundantCounter = 0;
            for (Integer i : hashMap.values()) {
                if (i > mostAbundantCounter) {
                    mostAbundantCounter = i;
                }
            }

            /* Using mostAbundantCounter value, iterate through hashMap.entrySet, print all
            the bytes with mostAbundantCounter abundance value with a space " " separator */

            for (Map.Entry<Integer, Integer> i : hashMap.entrySet()) {
                if (i.getValue() == mostAbundantCounter) {
                    System.out.print(i.getKey() + " ");
                }
            }

            /* Close IO Stream. TODO better use try with resources */

            fileInputStream.close();

            /*Print run time in milliseconds from a new line*/

            System.out.print(System.getProperty("line.separator"));
            System.out.println("This run was finished in, ms: " + (new Date().getTime() - startTime));

    }
    }
