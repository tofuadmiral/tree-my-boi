public class MaxHeap {

    // INSTANCE FIELDS
    private Integer[] table;
    private int size;
    private int numelements;

    // CONSTRUCTORS

    public MaxHeap(int n){
        size = n;
        numelements =0;
        table = new Integer[n];
    }

    public MaxHeap(Integer[] someArray){
        // make a maxheap from the someArray passed
        // first initialize a new array of integers
        numelements = someArray.length;
        size = numelements*2+1;
        for (int i = 0; i<numelements; i++){
            // loop through all elements in the array and add to the array
            // add takes care of duplicates and other cases
            this.insert(someArray[i]);
        }
    }

    // PUBLIC METHODS

    public void insert(int n){
        // insert the integer n into the heap properly, duplicates are ALLOWED. 
        // i.e. insert at end and percolate up until not greater than above
        if(size == numelements){ // then it's full so don't insert
            return;
        }
        else{ // we can insert it
            size++;
            // insert at bottom
            table[size-1] = n;
            // then percolate it up to where it's supposed to be
            percolateUp(size-1);
        }
    }

    public void percolateUp(int nodeIndex){
        // allocate variables for switch
        int parentIndex, temp;
        // make sure we don't switch if we're at the beginning
        if(nodeIndex!=0){
            parentIndex = table[(nodeIndex-1)/2];
            // max heap so check that parent is smaller then swap if true
            if(table[parentIndex]<table[nodeIndex]){
                // swap the two table
                temp = table[parentIndex];
                table[parentIndex] = table[nodeIndex];
                table[nodeIndex] = temp;
                // recursively keep going until we have it in the right place
                percolateUp(parentIndex);
            }
        }
    }

    public boolean isIn(int n){
        // check if n element is in the heap
        if(n>this.table[0]) // bigger than max so obviously not in
            return false;
        else{       // this case we have to actually look through it

        }
        return false;
    }

    private int deleteMax(){
        // delete the maximum element in the heap (i.e. the root) and return it,
        // then replace with the appropriate next element
        int root = table[1];


        return root;
    }

    public String toString(){
        // return a string representation of the heap in level order
        return "";
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
