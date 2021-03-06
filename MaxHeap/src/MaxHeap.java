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
        size = someArray.length;
        array = new Integer[size];
        // insert every element from the array into the heap.
        // When you insert, it'll be done in order.
        for(int i = 0; i<size; i++){
            this.insert(someArray[i]);
        }
    }

    public void insert(int value) {
        // insert into heap
        if (items == array.length){
            // have to reallocate bc too many i.e. full
            this.size = size*2;
            Integer[] newtable = new Integer[size];
            for(int i = 0; i<size/2; i++){
                // copy old elements into new table
                newtable[i] = array[i];
            }
            // set as new array
            array = newtable;
        }
        else {
            items++; // we're adding an item, so add to end
            array[items - 1] = value;
            siftUp(items - 1);
        }
    }

    private void siftUp(int nodeIndex) {
        int parentIndex, temp;
        if (nodeIndex != 0) {
            parentIndex = getParent(nodeIndex);
            // now that we have parent, compare to parent. if parent smaller or null, swap
            // otherwise don't swap, and keep doing this recursively.
            if ((array[parentIndex] == null) || array[parentIndex]< array[nodeIndex]) {
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

    public int deleteMax(){
        if (items == 0) // no elements in heap
            return 0;
        // replace root with last item, and delete it
        int root = array[0];
        array[0] = array[items-1];
        items--;
        size --;

        int i = 0;
        while(true){
            int l = getLeftChild(i);
            int r = getRighChild(i);

            //If left in array, left bigger than parent, left bigger than right, then swap
            if((l<=(size-1))&&(array[i]<array[l])&&(array[l]>array[r])){

                int temp = array[i];
                array[i] = array[l];
                array[l] = temp;

                i = l;

            }

            //If right in array, right bigger than parent, right bigger than left, then swap
            else if((r<=(size-1))&&(array[i]<array[r])) {

                int temp = array[i];
                array[i] = array[r];
                array[r] = temp;

                i = r;
            }

            // if we get this far we can break out bc we meet the rules of a heap
            else{
                break;
            }

        }
        // now we know it's a heap so we can return our value
        return root;
    }



    public String toString(){
        String stringrep = "";
        // we've gotta print diff levels on diff lines, so use the powers of two
        for(int i=0;i<size;i++){
            for(int j=0; j<Math.pow(2,i)&&j+Math.pow(2,i)<=size; j++){
                stringrep = stringrep + (array[j+(int)Math.pow(2,i)-1]+" ");
            }
            stringrep = stringrep + "\n";
        }
        return stringrep;
    }

    public void heapsort(Integer[] arrayToSort){
        MaxHeap sortedHeap = new MaxHeap(arrayToSort);

        // loop through sorted heap table and put into arraytosort
        for (int i =0; i<10; i++){
            arrayToSort[arrayToSort.length - 1 - i] = sortedHeap.deleteMax();
        }
    }


    // accessors

    public int getSize (){
        return this.size;
    }

    public int getItems(){
        return this.items;
    }


}
