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
        if(size == numelements){ // then it's full so allocate double size
            Integer[] newtable = new Integer[size*2];
            // copy the element's into the new array
            for (int i = 0; i<size; i++){
                newtable[i] = table[i];
            }
            // now, swap arrays and fix size
            this.table = newtable;
            this.size = size*2;
        }
        size++;
        // insert at bottom
        table[size-1] = n;
        // then percolate it up to where it's supposed to be
        percolateUp(size-1);
    }

    public void percolateUp(int nodeIndex){
        // allocate variables for switch
        int parentIndex, temp;
        // make sure we don't switch if we're at the beginning
        if(nodeIndex!=0){
            // set the parent
            parentIndex = table[(nodeIndex-1)/2];
            // max heap so check that parent is smaller then swap if true
            if(table[parentIndex]<table[nodeIndex]){
                // swap the two table elements
                temp = table[parentIndex];
                table[parentIndex] = table[nodeIndex];
                table[nodeIndex] = temp;
                // recursively keep going until we have it in the right place
                percolateUp(parentIndex);
            }
        }
    }


    private int deleteMax(){
        // delete the maximum element in the heap (i.e. the root) and return it,
        // then replace with the appropriate next element i.e. smallest
        int root = table[1]; // one we want to return later
        table[1] = table[size-1]; // replace with last element
        this.size--;
        heapify(this.table, 1); // changes table to become a max heap again
        return root;
    }

    public void heapify(Integer[]table, int index){
        int largest = index;
        int l = index*2;
        int r = index*2+1;

        // if left child larger than root
        if (l<size && table[l] > table[largest])
            largest = l;

        // if right child bigger than biggest so far
        if (r < size && table[r] > table[largest])
            largest = r;

        // if largest is not the ROOT of the tree
        if (largest != index){
            int swap = table[index];
            // swap the two positions
            table[index] = table[largest];
            table[largest] = swap;
            // recursively swap elements down
            heapify(table, largest);
        }
    }

    public String toString(){
        // return a string representation of the heap in level order
       int it, bin = 1;
       String stringrep = "";
       for (it=1; it<size; it++){
           stringrep = stringrep + table[it] + ", ";
           if (it == bin){
               bin = bin*2;
               it =1;
               stringrep+="\n";
           }
       }
       return stringrep;
    }


    public static void heapsort(Integer[] arrayToSort){
        // sort arrayToSort by making into a heap and then
        // delete max repeatedly and then copy back into the array
        MaxHeap newheap = new MaxHeap(arrayToSort);
        for (int i = 0; i<arrayToSort.length; i++){
            // loop through, delete max and keep adding to sorted array
            arrayToSort[arrayToSort.length-i] = newheap.deleteMax();
        }
    }

    // ACCESSORS

    public int getSize (){
        return this.size;
    }

    public int getNumelements(){
        return this.numelements;
    }

}
