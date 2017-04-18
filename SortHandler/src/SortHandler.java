
public class SortHandler {
    
    public static void main(String args[])
    {
        //int a[] = {13,12,5,71,2,54,9,6};  
//        straightInsertSort(a,8);  
//        print(a,8);
//        shellSort(a, 8);
//        print(a,8);
//        simpleSelectSort(a,8);
//        print(a,8);
//        bubbleSort2(a, 8);
//        print(a,8);
//        quickSort(a,8);
//        print(a,8);
//        print(a,8);
//        heapSort(a,8);
//        print(a,8);
//        print(a,8);
//        mergeSort(a);
//        print(a,8);
//        
//        int[] a = { 49, 38, 65, 197, 76, 213, 27, 50 };
//        radixSort(a);
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
    
    public static void heapSort(int a[], int length)
    {
        
        buildHeap(a, length);
        print(a,8);
        
        for(int i = length -1; i > 0; i --)
        {
            swap(a, 0, i);
            heapAjust(a, 0, i-1);
            print(a,8);
        }
    }
    
    public static void buildHeap(int a[], int length)
    {
        for(int i = length/2 -1; i >= 0; i --)
        {
            heapAjust(a, i, length);
        }
    }
    
    public static void heapAjust(int a[], int s, int length)
    {
        if(s < 0)
        {
            return;
        }
        
        int child = 2 * s + 1;
        while(child < length)
        {
            if(child + 1 < length && a[child] > a[child + 1])
            {
                child ++;
            }
            if(a[child] < a[s])
            {
                swap(a, child, s);
                s = child;
                child = 2*s + 1;
            }
            else
            {
                break;
            }
        }
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
            
            for(int k = high; k > low; k--)
            {
                if(a[k] < a[k-1])
                {
                    temp = a[k];
                    a[k] = a[k-1];
                    a[k-1] = temp;
                }
            }
            low ++;
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

    public static void mergeSort(int a[])
    {
        int low = 0, high = a.length - 1;
        mergeSort(a, low, high);
    }
    
    public static void mergeSort(int a[], int low, int high)
    {
        System.out.println("mergeSort-- " + "low: " + low + " high: " + high);
        int mid = (low + high) / 2;
        if(low < high)
        {
            mergeSort(a, low, mid);
            mergeSort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
        print(a,8);
        return;
    }



    private static void merge(int[] a, int low, int mid, int high) 
    {
        if(low >= high)
        {
            return;
        }
        int[] temp = new int[high - low + 1];
        
        int i=low, j=mid + 1, k=0;
        for(; i <= mid && j <= high; k++)
        {
            if(a[i] < a[j])
            {
                temp[k] = a[i];
                i++;
            }
            else
            {
                temp[k] = a[j];
                j++;
            }
        }
        
        if(i <= mid)
        {
            for(; i <= mid; i++,k++)
            {
                temp[k] = a[i];
            }
        }
        else if(j <= high)
        {
            for(; j <= high; j++,k++)
            {
                temp[k] = a[j];
            }
        }
        
        for(int m = 0; m < temp.length; m++)
        {
            a[m + low] = temp[m];
        }
    }
    
    public static int getMaxDigits(int a[])
    {
    	//first get the max one
    	int max = a[0];
    	for(int i = 1; i < a.length; i++)
    	{
    		if(max < a[i])
    		{
    			max = a[i];
    		}
    	}
    	if(max < 0)
    	{
    		return -1;
    	}
    	
    	//then get the max digits
    	int digits = 0;
    	while(max > 0)
    	{
    		digits ++;
    		max /= 10;
    	}
    	return digits;
    }
    
    public static int getNumInPosition(int number, int digit)
    {
    	for(int i = 0; i < digit; i ++)
    	{
    		number /= 10;
    	}
    	
    	number %= 10;
    	return number;
    }
    
    public static void radixSort(int a[])
    {
    	int length = a.length;
    	int digits = getMaxDigits(a);
    	int array[][] = new int[10][a.length + 1];
    	for(int i = 0; i < 10; i++)
    	{
    		//the first element stores the column count; 
    		//instantiate
       		array[i][0] = 0;  
    	}
    	
    	print(a, 8);
    	
    	for(int i = 0; i < digits; i++)
    	{
    		for(int j = 0; j < length; j++)
    		{
    			int row = getNumInPosition(a[j], i);
    			int col = ++array[row][0];
    			array[row][col] = a[j];
    		}
    		
    		for(int row = 0, m = 0; row < 10; row++)
    		{
    			int cols = array[row][0];
    			for(int col = 1; col <= cols; col++)
    			{
    				a[m++] = array[row][col];
    			}
    			
    			//reinitialize
    			array[row][0] = 0;
    		}
    		
    		print(a, 8);
    	}
    }

    
}
