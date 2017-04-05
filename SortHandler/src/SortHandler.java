
public class SortHandler {
    
    public static void main(String args[])
    {
        int a[] = {13,12,5,71,2,54,9,6};  
//        straightInsertSort(a,8);  
//        print(a,8);
//        shellSort(a, 8);
//        print(a,8);
//        simpleSelectSort(a,8);
//        print(a,8);
//        bubbleSort2(a, 8);
//        print(a,8);
        quickSort(a,8);
        print(a,8);
    }
    
    

    public static void print(int a[], int n){  
        for(int j= 0; j<n; j++){  
            System.out.print(a[j]);
            System.out.print("     ");
        }  
        System.out.println();
    }  
    
    public static void straightInsertSort(int a[], int n)
    {
        if(n <= 1)
        {
            return;
        }
        
        for(int i = 1; i < n; i++)
        {
            int x = a[i];
            int j = i -1;
            while(j >= 0 && a[j] > x)
            {
                a[j+1] = a[j];
                j--;
            }
            
            a[j+1] = x;
            
            print(a,8);
        }
    }
    
    public static void shellInsertSort(int a[], int n, int dk)
    {
        if(n <= 1 || dk > n)
        {
            return;
        }
        
        for(int i = dk * 2 -1; i < n; i++)
        {
            int x = a[i];
            int j = i - dk;
            while(j >= 0 && a[j] > x)
            {
                a[j+dk] = a[j];
                j = j - dk;
            }
            
            a[j+dk] = x;
            
            print(a,8);
        }
    }
    
    public static void shellSort(int a[], int n)
    {
        int dk = n/2;
        while(dk >= 1)
        {
            shellInsertSort(a, n, dk);
            dk = dk/2;
        }
    }
    
    public static void simpleSelectSort(int a[], int n)
    {
        int index = 0;
        for(int i = 0; i < n-1; i++)
        {
            index = i;
            for(int j = i; j < n-1; j++)
            {
                if(a[j+1] < a[index])
                {
                    index = j+1;
                }
            }
            
            if(index != i)
            {
                int temp = a[index];
                a[index] = a[i];
                a[i] = temp;
            }
            
            print(a,8);
        }
    }
    
    public static void heapSelectSort(int a[], int n)
    {
        
    }
    
    public static void bubbleSort(int a[], int n)
    {
        for(int i = 0; i < n-1; i++)
        {
            for(int j = 0; j < n-i-1; j++)
            {
                if(a[j] > a[j+1])
                {
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            print(a,8);
        }
    }
    
    public static void bubbleSort2(int a[], int n)
    {
        int high, low, temp;
        high = n -1;
        low = 0;
        while(low < high)
        {
            for(int j = low; j < high; j++)
            {
                if(a[j] > a[j+1])
                {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            low ++;
            
            for(int k = high; k > low; k--)
            {
                if(a[k] < a[k-1])
                {
                    temp = a[k];
                    a[k] = a[k-1];
                    a[k-1] = temp;
                }
            }
            high --;
            
            print(a, 8);
        }
    }
    
    public static void swap(int a[], int i, int j)
    {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
    
    public static int partition(int a[], int low, int high)
    {
    	int pivotLoc = low;
    	int temp;
    	while(low < high)
    	{
    		while(a[high] > a[pivotLoc] && low < high)
    		{
    			high --;
    		}
    		
    		if(low < high)
    		{
    			swap(a, pivotLoc, high);
    			pivotLoc = high;
    		}
    		else
    		{	
    			break;
    		}
    		
    		while(a[low] < a[pivotLoc] && low < high)
    		{
    			low ++;
    		}
    		
    		if(low < high)
    		{
    			swap(a, pivotLoc, low);
    			pivotLoc = low;
    		}
    		else
    		{
    			break;
    		}
    	}
    	
    	print(a, 8);
    	
    	return pivotLoc;
    }
    
    public static void quickSort(int a[], int low, int high)
    {
    	if(low < high)
    	{
    		int pivotLoc = partition(a, low, high);
    		quickSort(a, low, pivotLoc - 1);
    		quickSort(a, pivotLoc + 1, high);
    	}
    }
    
    public static void quickSort(int a[], int length)
    {
    	quickSort(a, 0, length-1);
    }
}
