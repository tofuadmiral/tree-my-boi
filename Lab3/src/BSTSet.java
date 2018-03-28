// This class implements a binary search tree using TNodes defined by the TNode class
public class BSTSet {

    // instance fields ---------------------------------------------------------------------------

    private TNode root;

    // Constructors ---------------------------------------------------------------------------

    public BSTSet(){
        root = null;
    }

    public BSTSet(int[] input){
        // create set with elements in the array input, no repetitions

    }

    // Operations ---------------------------------------------------------------------------

    // return true if V is in this set, false otherwise
    public boolean isIn(int v){
        return true;
    }

    // add in element v to this set
    public void add(int v){

    }

    // remove element v from this set
    public void remove(int v){

    }

    // return a BSTSet that is the union of this set and s
    public BSTSet union(BSTSet s){

    }

    // return BSTSet that is the intersection of this and s
    public BSTSet intersection(BSTSet s){

    }

    // return number of elements in this set
    public int size(){

    }

    // return height of the BSTSet, empty set returns -1
    public int height(){

    }

    // print this BSTSet
    public void printBSTSet(){
        if (root==null)
            System.out.println("The set is empty");
        else{
            System.out.print("The set elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }
    // print using
    private void printBSTSet(TNode t){
        if(t!=null){
            printBSTSet(t.left);
            System.out.print(" " + t.element + ", ")
            printBSTSet(t.right);
        }
    }
}