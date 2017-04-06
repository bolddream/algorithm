

public class ArrayHandler {


    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 1, -2, 3, 10, -4, 7, 2, -5 };
        MaxLocation loc = new MaxLocation(0,0);
        int max = findMaxSum(arr, 0, loc);
        System.out.println("MaxSum:" + max);
        System.out.println("start:" + loc.start + "end:" + loc.end);
    }
    
    public static Integer findMaxSum(int a[], int n, MaxLocation loc)
    {
        n = a.length;
        int curSum = 0;
        int maxSum = 0;
        loc.start = 0;
        for(int i = 0; i < n -1; i++)
        {
            curSum += a[i];
            
            if(curSum < 0)
            {
                curSum = 0;
                loc.start = i + 1;
            }
            
            if(curSum > maxSum)
            {
                maxSum = curSum;
                loc.end = i;
            }
        }
        
        //all data are negtive
        if(maxSum == 0)
        {
            maxSum = a[0];
            loc.start = 0;
            loc.end = 0;
            for(int i = 1; i < n -1; i++)
            {
                if(a[i] > maxSum)
                {
                    maxSum = a[i];
                    loc.start = i;
                    loc.end = i;
                }
            }
        }
        
        return maxSum;
    }

}
