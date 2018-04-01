public class MaxHeap {
    // instance fields
    private Integer[] array;
    private int size;
    private int items;

    // constructors


    // empty constructor
    public MaxHeap(int sizeofheap){
        array = new Integer[sizeofheap];
        size = sizeofheap;
        items = 0;
    }

    // constructor from array
    public MaxHeap(Integer[] someArray){
        items = someArray.length;
        size = items;
        array = new Integer[size];
        for(int i = 0; i<size; i++){
            this.insert(someArray[i]);
        }
    }

    public void insert(int value) {
        // insert into heap
        if (size == array.length){
            // have to reallocate bc too many i.e. full
            size = size*2;
            Integer[] newtable = new Integer[size];
            for(int i = 0; i<size/2; i++){
                // copy old elements into new table
                newtable[i] = array[i];
            }
            // set as new array
            array = newtable;
        }
        else {
            items++;
            array[items - 1] = value;
            siftUp(items - 1);
        }
    }

    private void siftUp(int nodeIndex) {
        int parentIndex, temp;
        if (nodeIndex != 0) {
            parentIndex = getParent(nodeIndex);
            // now that we have parent, compare to parent. if parent smaller, swap
            // otherwise don't swap, and keep doing this recursively.
            if (array[parentIndex] < array[nodeIndex]) {
                temp = array[parentIndex];
                array[parentIndex] = array[nodeIndex];
                array[nodeIndex] = temp;
                siftUp(parentIndex);
            }
        }
    }



    // helper methods
    public int getParent(int index){
        return (index - 1)/2;
    }

    public int getLeftChild(int index){
        return 2*index+1;
    }

    public int getRighChild(int index){
        return 2*index+2;
    }

    private int deleteMax(){

    }

    public String toString(){

    }

    public static void heapsort(Integer[] arrayToSort){

    }


    // accessors

    public int getSize (){
        return this.size;
    }

    public int getItems(){
        return this.items;
    }


}
