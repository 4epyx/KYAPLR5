package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOController
{
    public static List<Integer> readArr(String inputFile)
    {
        List<String> n = new ArrayList<String>();
        try (FileReader reader = new FileReader(inputFile))
        {
            Scanner scan  = new Scanner(reader);
            n.add(scan.nextLine());
        }
        catch (IOException e)
        {
            System.err.println("Не найден файл");
            System.exit(228);
        }
        String[] f = n.get(0).split(" ");
        List<Integer> Arr = new ArrayList<>();

        for(int i = 0; i < f.length; i++)
        {
            Arr.add(Integer.parseInt(f[i]));
        }

        return Arr;
    }

    public static void writeArr(List<List<Integer>> Arr, String outputFile)
    {
        try(FileWriter writer = new FileWriter(outputFile))
        {
            for(int i = 0; i < Arr.size(); i++)
            {
                for(int j = 0; j < Arr.get(i).size(); j++)
                {
                    writer.write(Arr.get(i).get(j) + " ");
                }
                writer.write('\n');
            }
        }catch (IOException e)
        {
            System.err.println("Не найден файл для записи");
            System.exit(228);
        }
    }

    public static void writeArr2(List<Integer> Arr, String outputFile)
    {
        try(FileWriter writer = new FileWriter(outputFile))
        {
            for(int i = 0; i < Arr.size(); i++)
            {
                writer.write(Arr.get(i) + " ");
            }
        }catch (IOException e)
        {
            System.err.println("Не найден файл для записи");
            System.exit(228);
        }
    }

}
