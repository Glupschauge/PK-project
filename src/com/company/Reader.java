package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.awt.*;
import java.util.*;




/**
 * Created by tobix on 14.01.2016.
 */
public class Reader
{
    BufferedReader in;
    String lastline;
    patches lastpatch;


    public void readmap(String dir)

    {

        try
        {
            in = new BufferedReader(new FileReader(dir));
            String line;
            while ((line = in.readLine()) != null)
            {

                System.out.println(line);
                Stringhandler(line);
            }


        } catch (IOException ex)
        {
            System.out.println("File error!!");
            return;

        }


    }

    public void Stringhandler(String whole){
        String[] splite= whole.split(" ");
        int start = 0;


        if(splite[0].equals("patch-of") || splite[0].equals("capital-of"))
        {
            for (int j = 1; digitcon(splite[j]); j++)
            {
                start = j + 1;
            }
            if(splite[0].equals(lastline)){
                lastpatch.addarray(splite, start);}
            else {
                String name = splite[1];
                for(int j = 2; j < start; j++){
                    name += splite[j];
                }
                lastpatch= new patches(name);
                lastpatch.makearray(splite, start);
            lastline = splite[0];}


            System.out.println(start);
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


    }

    public int[] makexcor (String[] strar, int beg){
        int leng = (strar.length - beg)/2;

        int[] xcor = new int[leng];
        for (int j = beg; j < strar.length; j +=2)
        {
            int index = (j - beg)/2;
            xcor[index] = Integer.parseInt(strar[j]);
        }


        return xcor;
    }

    public int[] makeycor (String[] strar, int beg){
        int leng = (strar.length - beg)/2;

        int[] xcor = new int[leng];
        for (int j = (beg + 1); j < strar.length; j +=2)
        {
            int index = (j - beg)/2;
            xcor[index] = Integer.parseInt(strar[j]);
        }


        return xcor;
    }
}

