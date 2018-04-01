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

    // insert into a heap
    public void insert(int n){
        
    }


}
