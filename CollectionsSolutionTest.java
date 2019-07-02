package com.javarush.task.task18.task1803;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

public class CollectionsSolutionTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String testString = "/home/dreamerchant/1.txt";
    private final byte[] bytes = testString.getBytes();
    private final InputStream InContent = new ByteArrayInputStream(bytes);
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;

    @Before
    public void setUp() throws Exception {


            System.setOut(new PrintStream(outContent));
            System.setIn(InContent);


        }

    @After
    public void tearDown () throws Exception {
            System.setOut(originalOut);
            System.setIn(originalIn);
        }

        @Test
        public void main () throws Exception {
            CollectionsSolution.main(new String[] {});
            assertThat(outContent.toString(), containsString( "56 57 "));




        }

    }