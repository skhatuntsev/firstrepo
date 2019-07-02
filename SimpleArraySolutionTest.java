package com.javarush.task.task18.task1803;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.*;

public class SimpleArraySolutionTest {


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
