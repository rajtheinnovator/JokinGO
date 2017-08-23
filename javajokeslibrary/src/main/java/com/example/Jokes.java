package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {


    public String retrieveMyJokes() {
        ArrayList<String> jokesArrayList = new ArrayList<>();

        jokesArrayList.add("Two bytes meet.  The first byte asks, Are you ill \n " +
                "The second byte replies, “No, just feeling a bit off.");

        jokesArrayList.add("Q. How did the programmer die in the shower\n" +
                "A. He read the shampoo bottle instructions: Lather. Rinse. Repeat.");
        jokesArrayList.add("How many programmers does it take to change a light bulb\n" +
                "None – It’s a hardware problem");
        jokesArrayList.add("Why do programmers always mix up Halloween and Christmas\n" +
                "Because Oct 31 equals Dec 25.");
        jokesArrayList.add("There are only 10 kinds of people in this world those who know binary and those who dont.");
        jokesArrayList.add("A programmer walks to the butcher shop and buys a kilo of meat.  An hour later he comes back upset that the butcher shortchanged him by 24 grams.");

        //more jokes can be added from the link: http://www.devtopics.com/best-programming-jokes/

        /* code below referenced from the @link: https://stackoverflow.com/a/13213941/5770629 */

        Random rand = new Random();
        String randomJoke = jokesArrayList.get(rand.nextInt(jokesArrayList.size()));
        return randomJoke;
    }

}