package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tobix on 14.01.2016.
 */
public class patches
{
    private String name;
    List<int[]> xcords = new ArrayList<int[]>();                        //Liste aller x-koordinaten dieses Landes, auch Inseln
    List<int[]> ycords = new ArrayList<int[]>();                        //selbe nur y koordinaten
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
    }

    public boolean hasname(String name){                                // Boolean ob dieses Objekt gleichen Namen hat wie der gesuchte
        return this.name.equals(name);

    }
    public void addcapital(int x, int y){
        xcapital = x;
        ycapital = y;
    }


}
