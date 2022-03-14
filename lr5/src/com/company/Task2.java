package com.company;

import java.util.List;

public class Task2
{
    private static int findMin(List<Integer> list)
    {
        int min = list.get(0);

        for(int i = 1; i < list.size(); i++)
        {
            if(list.get(i) < min)
            {
                min = list.get(i);
            }
        }
        return  min;
    }

    private static int findMax(List<Integer> list)
    {
        int max = list.get(0);

        for(int i = 1; i < list.size(); i++)
        {
            if(list.get(i) > max)
            {
                max = list.get(i);
            }
        }
        return  max;
    }

    private static int indexOf(List<Integer> list, int number)
    {
        for(int i= 0; i < list.size(); i++)
        {
            if(list.get(i) == number)
            {
                return i;
            }
        }
        return -1;
    }

    public static List<Integer> sort (List<Integer> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            boolean flag = true;
            for(int j = 0; j < list.size() - i - 1; j++)
            {
                if(list.get(j) > list.get(j + 1))
                {
                   flag = false;
                   int tmp = list.get(j);
                   list.set(j, list.get(j+1));
                   list.set(j+1, tmp);
                }
            }
            if(flag)
            {
                break;
            }
        }
        return list;
    }

    public static List<Integer> process(List<Integer> list)
    {
        int min = findMin(list);
        int max = findMax(list);
        int d;

        if(!((min - max) % (list.size()-1) == 0))
        {
            return list;
        }
        else
        {
            d = (max - min) / (list.size()-1);
            System.out.println(d);
            boolean isProg = true;
            for(int i = 0, n = min + d; i < list.size()-2; i++, n+=d)
            {
                if(indexOf(list, n) == -1)
                {
                    isProg = false;
                    break;
                }
            }

            if(isProg)
            {
                list = sort(list);
            }

            return list;
        }
    }
}
