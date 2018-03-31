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
        // insert the integer n into the heap properly
        // i.e. insert at end and percolate up until not greater than above
        if(size == numelements){ // then it's full so don't insert
            return;
        }
        else{ // we can insert it
            size++;
            nodes[size-1] = n;
            percolateUp(size-1);
        }

    }

    public void percolateUp(int nodeIndex){
        int parentIndex, temp;
        if(nodeIndex!=0){
            parentIndex = nodes[(nodeIndex-1)/2;
            if(nodes[parentIndex]>nodes[nodeIndex]){
                // swap the two nodes
                temp = nodes[parentIndex];
                nodes[parentIndex] = nodes[nodeIndex];
                nodes[nodeIndex] = temp;
                percolateUp(parentIndex);
            }
        }
    }

    public boolean isIn(int n){
        // check if n element is in the heap
        if(n>this.nodes[0]) // bigger than max so obviously not in
            return false;
        else{       // this case we have to actually look through it

        }
        return false;
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
