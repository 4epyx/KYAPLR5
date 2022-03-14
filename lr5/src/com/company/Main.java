package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static String[] parseCmdArgs(String[] args)
    {
        return new String[]{args[0], args[1]};
    }

    public static void main(String[] args)
    {
        String[] IO = parseCmdArgs(args);
        if(args.length == 2)
        {
            List<Integer> list = new ArrayList<>();
            list = IOController.readArr(IO[0]);
            System.out.print("номер задания: ");
            Scanner in = new Scanner(System.in);
            int task = in.nextInt();
            if(task == 1)
            {
                System.out.print("Необходимая сумма: ");
                int sum = in.nextInt();
                List<List<Integer>> res = Task1.selectionCount(list, sum);
                IOController.writeArr(res, IO[1]);
                System.out.println("Результат записан в файл " + IO[1]);
            }
            else if (task == 2)
            {
                List<Integer> res = Task2.process(list);
                IOController.writeArr2(res, IO[1]);
                System.out.println("Результат записан в файл " + IO[1]);
            }
        }
        else
        {
            System.err.println("Нет необходимых параметров");
            System.exit(228);
        }
    }
}
