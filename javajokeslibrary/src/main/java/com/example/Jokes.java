package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Jokes {


    public String retrieveMyJokes() {
        ArrayList<String> jokesArrayList ;
        jokesArrayList = new ArrayList<>();
        jokesArrayList.add("this is a joke");
        jokesArrayList.add("this is another joke");

        //more jokes can be added from the link: http://www.devtopics.com/best-programming-jokes/

        /* code below referenced from the @link: https://stackoverflow.com/a/13213941/5770629 */

        Random rand = new Random();
        String randomJoke = jokesArrayList.get(rand.nextInt(jokesArrayList.size()));
        return randomJoke;
    }

}