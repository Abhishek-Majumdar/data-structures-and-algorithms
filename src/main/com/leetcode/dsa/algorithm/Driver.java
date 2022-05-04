package main.com.leetcode.dsa.algorithm;

public class Driver {

    public static int findCircleNum(int[][] isConnected)
    {
        int n=isConnected.length;
        UnionFind temp=new UnionFind(n);
        for(int i=0;i<isConnected.length;i++)
        {
            for(int j=0;j<isConnected[i].length;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                    temp.union(i,j);
            }
        }
        return temp.conComp;
    }

    public static void main(String[] args) {
        // [[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]
        int[][] arr = {{1,0,0,1}, {0,1,1,0}, {0,1,1,1}, {1,0,1,1}};
        System.out.println(Driver.findCircleNum(arr));
    }

}
