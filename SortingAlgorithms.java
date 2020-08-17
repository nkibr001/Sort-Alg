import java.util.*;

public class SortingAlgorithms 
{
    static void bubbleSort(int[]list)
    {
        int x=list.length;
        for(int i=0;i<x-1;i++)
        {
            for(int j=0;j<x-i-1;j++)
            {
                if(list[j]>list[j+1])
                {
                    int temp=list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
    }
    
    static void insertionSort(int[]list)
    {
        int x=list.length;
        for(int i=1;i<x;i++)
        {
            int temp=list[i];
            int j=i-1;
            while(j>=0&&temp<list[j])
            {
                list[j+1]=list[j];
                j--;
            }
            list[j+1]=temp;
        }
    }
    
    static void mergeSort(int[]list)
    {
        mergeSort(list,0,list.length-1);
    }
    
    static private void mergeSort(int[]list, int start, int end)
    {
        if(start<end)
        {
            int mid=(start+end)/2;
            
            mergeSort(list,start,mid);
            mergeSort(list,mid+1,end);
            merge(list,start,mid,end);
        }
    }
    
    static private void merge(int[]list,int start, int mid, int end)
    {
        int[]temp=new int[end-start+1];
        
        for(int i=0;i<temp.length;i++)
        {
            temp[i]=list[start+i];
        }
        
        int a=start;
        int b=mid+1;
        int c=start;
        
        while(a!=(mid+1)&&b!=(end+1))
        {
            if(temp[a-start]<temp[b-start])
            {
                list[c]=temp[a-start];
                a++;
            }
            else
            {
                list[c]=temp[b-start];
                b++;
            }
            c++;
        }
        
        if(b==end+1)
        {
            while(a!=(mid+1))
            {
                list[c]=temp[a-start];
                a++;
                c++;
            }
        }
   
    }
    
    static void quickSort(int[]list)
    {
        quicksort(0,list.length-1,list);
    }
    
    static private void quicksort(int start, int end, int[]list)
    {
        int temp;
        int pivot=findPivot(start,end);
        
        temp=list[pivot];
        list[pivot]=list[end];
        list[end]=temp;
        
        pivot=end;
        
        int i=start;
        int j=end-1;
        
        boolean iterationCompleted=false;
        while(!iterationCompleted)
        {
            while(list[i]<list[pivot])
            {
                i++;
            }
            while((j>=0)&&(list[pivot]<list[j]))
            {
                j--;
            }
                if(i<j)
                {
                    temp=list[i];
                    list[i]=list[j];
                    list[j]=temp;
                    i++;
                    j--;
                }
                else
                {
                    iterationCompleted=true;
                }
                
        }
        
        temp=list[i];    
        list[i]=list[pivot];
        list[pivot]=temp;
        
        if(start<i-1)
        {
            quicksort(start,i-1,list);
        }
        if(i+1<end)
        {
            quicksort(i+1,end,list);
        }
        
    }
    static private int findPivot(int start, int end)
    {
        return(start+end)/2;
    }
    
    static void selectionSort(int[]list)
    {
        int x=list.length;
        for(int i=0;i<x-1;i++)
        {
            int min=i;
            for(int j=i+1;j<x;j++)
            {
                if(list[j]<list[min])
                {
                    min=j;
                }
            }
                    int temp=list[min];
                    list[min]=list[i];
                    list[i]=temp;
        }
    }
    
    static void fillArray(int[]list)
    {
        Random rand= new Random();

        for (int i=0;i<list.length;i++)
        {
            list[i]=rand.nextInt(100);
        }
    }
    
    static void printArray(int[]list)
    {
        for(int i=0;i<list.length;i++)
        {
            System.out.println(list[i]);
        }
    }
    
}
