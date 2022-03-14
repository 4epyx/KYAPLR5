package com.company;

import java.util.ArrayList;
import java.util.List;

public class Task1
{
    private static List<Integer> reverse (List<Integer> arr)
    {
        for(int i = 0; i < arr.size()/2; i++)
        {
            int tmp = arr.get(i);
            arr.set(i, arr.get(arr.size() - i - 1));
            arr.set(arr.size() - i - 1, tmp);
        }
        return arr;
    }
    private static List<Integer> toBinary(int n, int count)
    {
        List<Integer> bin = new ArrayList<>();

        while(n > 0)
        {
            bin.add(n % 2);
            n /= 2;
        }
        for(int i = bin.size(); i < count; i++)
        {
            bin.add(0);
        }
        bin = reverse(bin);
        return bin;
    }

    private static List<List<Integer>> allBinComb(int size)
    {
        List<List<Integer>> binComb = new ArrayList<>();
        for(int i = 0; i < Math.pow(2, size); i++)
        {
            binComb.add(toBinary(i, size));
        }
        return binComb;
    }

    private static List<List<Integer>> AllComb(List<Integer> weights)
    {
        List<List<Integer>> comb = new ArrayList<>();
        List<List<Integer>> binComb = allBinComb(weights.size());
        for(int i = 0; i < binComb.size(); i++)
        {
            List<Integer> w = new ArrayList<>();
            for(int j = 0; j < binComb.get(i).size(); j++)
            {
                if(binComb.get(i).get(j) == 1)
                {
                    w.add(weights.get(j));
                }
            }
            if(w.size() == 0)
            {
                List<Integer> nullList = new ArrayList<>();
                nullList.add(0);
                comb.add(nullList);
            }
            else
            {
                comb.add(w);
            }
        }
        return comb;
    }

    private static int sum(List<Integer> l)
    {
        int sum = 0;
        for(int i = 0; i < l.size(); i++)
        {
            sum += l.get(i);
        }
        return  sum;
    }

    public static List<List<Integer>> selectionCount(List<Integer> weights, int sumWeight)
    {
        List<List<Integer>> comb = AllComb(weights);
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < comb.size(); i++)
        {
            if(sum(comb.get(i)) == sumWeight)
            {
                res.add(comb.get(i));
            }
        }
        return res;
    }

}
