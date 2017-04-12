

public class ArrayHandler {


    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] arr = { 3, 11, -12, 99, -100, 1, -2, 3, 10, -4, 7, 2, -5 };
        MaxLocation loc = new MaxLocation(0,0);
        int max = findMaxSum(arr, 0, loc);
        System.out.println("MaxSum:" + max);
        System.out.println("start:" + loc.start + "end:" + loc.end);
//        String src = "asdfw3erdfasdxcc";
//        String sub = "fw3";
//        int loc = findSubString(src, sub);
//        System.out.println(loc);
    }
    
    public static int findSubString(String src, String sub)
    {
        return src.indexOf(sub);
    }
    
    public static Integer findMaxSum(int a[], int n, MaxLocation loc)
    {
        n = a.length;
        int curSum = 0;
        int maxSum = 0;
        loc.start = 0;
        int tempStart = 0;
        for(int i = 0; i < n -1; i++)
        {
            curSum += a[i];
            
            if(curSum < 0)
            {
                curSum = 0;
                tempStart = i + 1;
            }
            
            if(curSum > maxSum)
            {
                maxSum = curSum;
                loc.end = i;
            }
        }
        
        if(tempStart <= loc.end)
        {
            loc.start = tempStart;
        }
        
        //all data are negative
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
