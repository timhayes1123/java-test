public class Initialize {
    /** Some fields to test default initialization. */
    public int testInt;
    public char testChar;
    
    /** Main entry point into the application. */
    public static void main(String[] args) {
        Initialize init = new Initialize();
        ATypeName aObj = new ATypeName();
        DataOnly doObj = new DataOnly();
        
        Integer intObj = new Integer(20);
        Boolean boolObj = new Boolean(false);
        Double doubleObj = new Double(33.33);
        
        int primInt = 10;
        boolean primBool = true;
        double primDouble = 66.66;
        
        intObj = primInt;
        boolObj = primBool;
        doubleObj = primDouble;
        
        doObj.i = 10;
        doObj.b = false;
        doObj.d = 33.33;
        Incrementable.increment();
        Incrementable.increment();
        Incrementable.increment();
        Incrementable test1 = new Incrementable();
        Incrementable test2 = new Incrementable();
        Incrementable test3 = new Incrementable();
        test2.increment();
        System.out.println("testInt = " + init.testInt);
        System.out.println("testChar = " + init.testChar);
        System.out.println(doObj.i);
        System.out.println(doObj.b);
        System.out.println(doObj.d);
        System.out.println(Incrementable.counter);
        System.out.println(test1.counter);
        System.out.println(test2.counter);
        System.out.println(test3.counter);
        System.out.println(intObj);
        System.out.println(boolObj);
        System.out.println(doubleObj);
        
        for (int loopIndex = 0; loopIndex < args.length; loopIndex++) {
            System.out.println(args[loopIndex]);
        }
    }
}