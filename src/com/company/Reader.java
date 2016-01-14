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
}

