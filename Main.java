import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.*;

public class Main 
{
    public static void main (String args[])
    {
        new Main();
    }
    public Main()
    {
       String outputFilename="output.csv";
       PrintWriter output=null;
       //open output stream
       try
       {
           output=new PrintWriter(new FileWriter (outputFilename));
           
       }catch (IOException ex)
        {
           System.out.println("failed");
           System.exit(1);
       }
               
        int[] arr1=new int[0];
        int[] arr2=new int[0];
        int[] arr3=new int[0];
        int[] arr4=new int[0];
        int[] arr5=new int[0];
        //creates 5 arrays to test all 5 sort methods
        
        output.printf("Length,Bubble Sort,Insertion Sort,Merge Sort,Quick Sort,Selection Sort\n");

        for(int i=0;i<1000;i++)
        {
            arr1=Arrays.copyOf(arr1, arr1.length+10);
            SortingAlgorithms.fillArray(arr1);
            
            arr2=Arrays.copyOf(arr1, arr2.length+10);   
            arr3=Arrays.copyOf(arr1, arr3.length+10);   
            arr4=Arrays.copyOf(arr1, arr4.length+10);   
            arr5=Arrays.copyOf(arr1, arr5.length+10);
            
            //increases each array by 10 in size with every iteration
            
            //sT = startTime
            //eT= elapsedTime
            
            long sT1=System.nanoTime();
            SortingAlgorithms.bubbleSort(arr1);
            long eT1=System.nanoTime()-sT1;
           
            long sT2=System.nanoTime();
            SortingAlgorithms.insertionSort(arr2);
            long eT2=System.nanoTime()-sT2;
            
            long sT3=System.nanoTime();
            SortingAlgorithms.mergeSort(arr3);
            long eT3=System.nanoTime()-sT3;
            
            long sT4=System.nanoTime();
            SortingAlgorithms.quickSort(arr4);
            long eT4=System.nanoTime()-sT4;
            
            long sT5=System.nanoTime();
            SortingAlgorithms.selectionSort(arr5);
            long eT5=System.nanoTime()-sT5;
            
            //times each sort process
            
            output.println(arr1.length + "," + eT1 + "," + eT2 + "," + eT3 + "," + eT4 + "," + eT5 );
            
        }
        
        output.close();
    }
}

