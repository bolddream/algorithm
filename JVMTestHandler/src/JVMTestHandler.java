
public class JVMTestHandler {

    public static void main(String args[])
    {
        new JVMTestHandler().doTest();
        //new JVMTestHandler().infinitelyRecursiveMethod(1);
    }
    
    public void doTest()
    {
        Integer M = new Integer(1 * 1024 * 1024);
        byte[] bytes = new byte[1 * M];
        bytes = null;
        System.gc();
        bytes = new byte[1 * M];
        bytes = new byte[1 * M];
        System.gc();
        System.out.println();
    }

    private static long count = 0;
    
    public void infinitelyRecursiveMethod(long a){
        System.out.println(count++);
        infinitelyRecursiveMethod(a);
    }
}
