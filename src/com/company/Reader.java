package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by tobix on 14.01.2016.
 */
public class Reader
{
    BufferedReader in;
    patches currpatch;
    List <patches> countrys = new ArrayList<patches>();


    public void readmap(String dir)

    {

        try
        {
            in = new BufferedReader(new FileReader(dir));
            String line;
            while ((line = in.readLine()) != null)
            {
                Stringhandler(line);
            }


        }
        catch (IOException ex)
        {
            System.out.println("File error!!");
            return;

        }


    }



    public void Stringhandler(String whole)                     //HANDLED bis jetzt nur alle patch-of Zeilen
    {
        String[] splite= whole.split(" ");
        int start = 0;


        if(splite[0].equals("patch-of"))
        {
            start = startget(splite);

            String name = nameget(splite, start);

            int[] xcor = makexcor(splite, start);
            int[] ycor = makeycor(splite, start);
            if(hasname(name))
            {
                currpatch=getname(name);
                currpatch.addarray(xcor, ycor);
            }
            else
            {
                currpatch= new patches(name, xcor, ycor);
                countrys.add(currpatch);
            }
        }
        if(splite[0].equals("capital-of")){
            start = startget(splite);
            String name = nameget(splite, start);
            int[] xcor = makexcor(splite, start);
            int[] ycor = makeycor(splite, start);

            if(hasname(name))
            {
                currpatch=getname(name);
                currpatch.addcapital(xcor[0], ycor[0]);
            }
            else
            {
                System.out.println("FEHLER in DATEI!!!!!");
                return;
            }


        }



    }

    public boolean digitcon(String test){
        try
        {
            int x = Integer.parseInt(test);
            return false;
        }
        catch(NumberFormatException e){
            return true;

        }


    }                               //Gibt bool zurück ob String eine Zahl ist !!!!!!!! WERTE VERTAUSCHT!!!!!!!


    public int[] makexcor (String[] strar, int beg){
        int leng = (strar.length - beg)/2;

        int[] xcor = new int[leng];
        for (int j = beg; j < strar.length; j +=2)
        {
            int index = (j - beg)/2;
            xcor[index] = Integer.parseInt(strar[j]);
        }


        return xcor;
    }                    //Macht ein int[] mit allen x-koordinaten der Zeile


    public int[] makeycor (String[] strar, int beg){
        int leng = (strar.length - beg)/2;
        int[] xcor = new int[leng];
        for (int j = (beg + 1); j < strar.length; j +=2)
        {
            int index = (j - beg)/2;
            xcor[index] = Integer.parseInt(strar[j]);
        }
        return xcor;
    }                   //Macht ein int[] mit allen y-koordinaten der Zeile


    public void printcountry(){                                     //Gibt die Namen aller Länder aus
        System.out.println(countrys.size());
        int jk=0;
        for (patches p:countrys)
        {
            p.print();
        }
    }


    public boolean hasname(String name){                            //Gibt bool zurück ob es bereits dieses Land gibt
        boolean gotit = false;
        for(patches p:countrys)
        {
           if(p.hasname(name)){
              return true;
           }
        }
        return false;
    }


    public patches getname(String name){                            //Gibt das Land zurück wessen Name gleich dem ist des überladenen Strings
        boolean gotit = false;
        for(patches p:countrys)
        {
            if(p.hasname(name)){
                return p;
            }
            }
        return null;
        }


    public int startget (String[] check){                           // Gibt den Start der koordinaten im String[] zurück
        int start = 0;
        for (int j = 1; digitcon(check[j]); j++)
        {
            start = j + 1;
        }

        return start;
    }


    public String nameget(String[] check, int start){               //Gibt den Namen des Strings zurück
        String name = check[1];
        for(int j = 2; j < start; j++)
        {
            name += " ";
            name += check[j];
        }
        return name;
    }

}

