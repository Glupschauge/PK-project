package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tobias on 14.01.2016.
 */
public class kontinent {

    List<patches> Länder = new ArrayList<patches>();
    public String name;
    public int points;

    public kontinent(String name, int points){
        this.name = name;
        this.points = points;
    }

    public void addcountry(patches p){
        Länder.add(p);
    }
    public void print(){
        System.out.println();
        System.out.println(name+":");
        System.out.println(points);
        for(patches p:Länder){
            System.out.println(p.name);
        }

    }



}
