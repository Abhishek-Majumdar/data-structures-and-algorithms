package main.com.leetcode.dsa.algorithm;

import java.util.ArrayList;

public class UnionFind {
    ArrayList<Integer> rank,root;
    int conComp=0;
    UnionFind(int n)
    {
        root=new ArrayList<Integer>();
        rank=new ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            root.add(i);
            rank.add(1);
        }
        conComp=n;
    }
    int find(int x)
    {
        if(x==root.get(x))
        {
            return x;
        }
        System.out.println(x);
        root.add(x,find(root.get(x)));
        return root.get(x);
    }
    void union(int x,int y)
    {
        int rootX=find(x),rootY=find(y);
        if(rootX!=rootY)
        {
            if(rank.get(rootX)>rank.get(rootY))
            {
                root.add(rootY,rootX);
            }
            else if(rank.get(rootX)<rank.get(rootY))
            {
                root.add(rootX,rootY);
            }
            else
            {
                root.add(rootY,rootX);
                rank.add(rootY,rootY+1);
                conComp-=1;
            }
        }
    }
}
