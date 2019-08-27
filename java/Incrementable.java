/** Class with a static counter. */
class Incrementable {
    /** The static counter field. */
    static int counter = 0;
    
    /** Increment the static counter field. */
    static void increment() { 
        Incrementable.counter++; 
    }
}