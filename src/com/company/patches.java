package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobix on 14.01.2016.
 */
public class patches
{
    public String name;
    List<int[]> xcords = new ArrayList<int[]>();                        //Liste aller x-koordinaten dieses Landes, auch Inseln
    List<int[]> ycords = new ArrayList<int[]>();                        //selbe nur y koordinaten
    List<patches> neighbors = new ArrayList<patches>();                 //alle neighbors
    int xcapital;
    int ycapital;


    public patches(String name, int[]xcor, int[]ycor){                  // Konstructor
        this.name = name;
        xcords.add(xcor);
        ycords.add(ycor);
    }

    public void addarray(int[] xcor, int[] ycor){                       //Fals namen doppelt in der Map datei vorkommen also INSELN added diese die koordinaten zur liste
        xcords.add(xcor);
        ycords.add(ycor);
    }

    public void print (){
        System.out.println(name);                                       //Gibt Name dieses Patches aus und die capital koordinaten
        System.out.println("x = " + xcapital + " , y = " + ycapital);
        for(patches p:neighbors){
            System.out.println(p.name);
        }
        System.out.println("");
    }

    public boolean hasname(String name){                                // Boolean ob dieses Objekt gleichen Namen hat wie der gesuchte
        return this.name.equals(name);

    }

    public void addcapital(int x, int y){
        xcapital = x;
        ycapital = y;
    }

    public void singleneighbor(patches curr){
        neighbors.add(curr);

}

    public void listneighbor(List<patches> neighbors){
        this.neighbors.addAll(neighbors);

    }




}
