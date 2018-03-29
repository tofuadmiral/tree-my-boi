public class MaxHeap {

    // INSTANCE FIELDS
    private Integer[] nodes;
    private int size;
    private int numelements;

    // CONSTRUCTORS

    public MaxHeap(int n){
        size = n;
        numelements =0;
        nodes = new Integer[n];
    }

    public MaxHeap(Integer[] someArray){

    }

    // PUBLIC METHODS

    public void insert(int n){
        // insert the integer n into the heap properly

    }

    private int deleteMax(){
        // delete the maximum element in the heap (i.e. the root) and return it,
        // then replace with the appropriate next element
    }

    public String toString(){
        // return a string representation of the heap in level order
    }

    public static void heapsort(Integer[] arrayToSort){
        // sort arrayToSort by making into a heap and then
        // delete max repeatedly and then copy back into the array
    }

    // ACCESSORS

    public int getSize (){
        return this.size;
    }
    
    public int getNumelements(){
        return this.numelements;
    }

}
