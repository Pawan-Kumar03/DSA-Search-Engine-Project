package com.example.projectdsa;

class RecentlySearch
{
    String arr[];
    int top;
    int size;
    RecentlySearch()
    {
        size = 6;
        top = 0;
        arr = new String[6];
        arr[0] = "/0";
        arr[1] = "/0";
        arr[2] = "/0";
        arr[3] = "/0";
        arr[4] = "/0";
        arr[5] = "/0";
    }
    void Push(String data)
    {   
        if(top > size-1)
        {
            //top++;
            top = top%size;
        }
        arr[top++] = data;
    }
    void printArray()
    {
        for(int i=0;i<size;i++)
        {
            System.out.println(arr[i]+" ");
        }
        System.out.println("\n");
    }
    // public static void main(String[] args) {
    //     RecentlySearch n = new RecentlySearch();
    //     n.Push("oppo mobile phones 1 ");
    //     n.Push("oppo mobile phones 2 ");
    //     n.Push("oppo mobile phones 3 ");
    //     n.Push("oppo mobile phones 4 ");
    //     n.Push("oppo mobile phones 5 ");
    //     n.Push("oppo mobile phones 6 ");
    //     n.printArray();
    //     n.Push("oppo mobile phones 7 ");
    //     n.Push("oppo mobile phones 8 ");
    //     n.printArray();
    // }
}