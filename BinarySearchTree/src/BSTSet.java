public class BSTSet {

    // INSTANCE FIELDS ------------------------------------------------------------------------------

    private TNode root;

    // CONSTRUCTORS ----------------------------------------------------------------------------------

    public BSTSet(){
        // there's nothing passed to it so just set root to null, empty set
        root = null;
    }

    public BSTSet(int[] input) {


        // first sort the array to make things easier
        insertionSort(input);

        // now that it's sorted, add one by one no duplicates
        for (int i = 0; i < input.length; i++)
            add(input[i]); // add using our add method which checks if something is already in so no duplicates

        // now make sure it's minimized height
        root = balancedBST(this.toArray(), 0, this.toArray().length - 1); // call our balancing method and set root to balanced
    }

    public void insertionSort(int[] array){
        int n = array.length;
        for (int i=1; i<n; ++i){
            int key = array[i];
            int j = i-1;
            while (j>=0 && array[j] > key){ // move the elements of the array up and then put the temp key// back in after we're done doing that
                array[j+1] = array[j];
                j = j-1;
            }
            array[j+1] = key;
        }
    }


    // method to balance the BST using indexing and recursion
    // time complexity is 2^n because recursive calls needed to balance each subtree
    private TNode balancedBST(int[] input, int start, int end){
        if (start>end) // start is greater than end so can't balance this
            return null; // must return null because it's an object returned
        int middle = (start+end)/2;
        // the balanced tree is just the middle + the balanced left and balanced right, given that the array
        // is already sorted, the middle value MUST be the root. this is based on the recursive nature of trees
        return new TNode(input[middle], balancedBST(input, start, middle-1), balancedBST(input, middle+1, end));
    }

    //
    private boolean isEmpty()
    {//checks if the tree is empty
        if (root==null)
            return true;
        return false;
    }

    // time complexity of isIn big theta log(n)
    // this is because worst case is that the node is a leaf, leaf is at max height, max
    // height is at log(n)
    public boolean isIn(int v) {
        // CHECK if this element v is in this tree
        if (isEmpty())
            return false;
        TNode node = root;
        while (true) {
            // go through and check
            if(node.element>v) {
                // v smaller so go left
                if (node.left==null) // if we reached end, not in here
                    return false;
                node=node.left; // keep going left
            }
            else if (node.element<v) {
                // we're bigger so keep going right
                if (node.right==null)
                    return false; // if we reach max and we're bigger not here
                node=node.right; // keep going right
            }
            else if (node.element==v)
                return true; // because we found the element return true
        }
    }

    public void add(int v) {
        // add the element v into the set, make sure not in set already
        // time complexity = log(n) because worst case is add to a leaf, which is max height, so log(n)
        // where n is number of nodes present
        if(isIn(v))
            return;
        if(isEmpty()) {// if it's empty, that means we need to create a new node and that's the only one
            root=new TNode(v,null,null); // create the new node and exit
            return;
        }
        // otherwise, we need to start traversing iteratively
        TNode node = root;
        while (true){
            // loop through looking for the node, if we get to the end and we didn't find, create it
            if(node.element>v) { // we're smaller so go left
                if (node.left==null) {// went all the way left and doesnt exist so create
                    node.left= new TNode(v,null,null);
                    return;
                }
                node=node.left;
            }
            else if (node.element<v) {
                // we're bigger so go right
                if (node.right==null) { // if we reach rightmost and not found, create it
                    node.right= new TNode(v,null,null);
                    return;
                }
                node=node.right; // if we didn't find, keep going right to look for it
            }
        }
    }

    public boolean remove(int v) {
        // remove the specified element
        // accomplished recursively so time complexity is 2^n at worst
        // 2^n + log(n) drop the non dominant term so big theta 2^n
        // space complexity is log(n) because our recursion depth is log(n)
        if(!isIn(v)) // if we can't find it in the tree, it can't be in the tree
            return false;
        root = remove(v, root); // recursively call until we remove
        return true;
    }
    // this is recursive, explained in the above method
    private TNode remove(int v, TNode node) {
        if (node.element>v){
            // v is smaller so go left recursively
            node.left= remove(v,node.left);
        }
        else if(node.element<v){
            // v is larger so go right recursively
            node.right= remove(v,node.right);
        }
        else if(node.left!=null && node.right!=null) {
            // we need to check if both it's children there, bc then
            // we need to delete carefully
            node.element = findMin(node.right).element;
            node.right = removeMin(node.right);
        }
        else{
            // this means it only has either right or left child
            // so let's select from which one it DOES have and replace its child with
            // it so effectively deleting it
            node =(node.left==null)?node.right:node.left;
        }
        return node; // return the node back to the function so we can access the root
    }

    private TNode findMin(TNode node){
        // find the minimum value in a tree, i.e. keep going left recursively.
        // # of left nodes must be equal to height or less so time complexity is
        // big theta log (n)
        if (node.left==null)
            return node;
        else
            return findMin(node.left);
    }

    private TNode removeMin(TNode node){
        // remove the minimum element
        // time complexity is of log(n) because we keep going left
        // log(n) space complexity because pushing log n function calls to the stack
        if (node==null)
            return null;
        else if (node.left!=null) {
            // since we're not at the end keep going left
            node.left=removeMin(node.left);
            return node; // at the end return this so we have access to the tree again
        }
        else
            return node.right; // replacing with right means replacing with null so we're good
    }

    private String tostring(){
        // convert this tree to a string, call upon our recursive method
        return tostring(root);
    }

    private String tostring(TNode node){
        // recursively make this a string
        // time complexity of 2^n
        // space complexity of n + log(n) so drop the non-dominant term so only big theta n
        if(node==null)
            return ""; // tree is empty so return the empty string
        String output = ""; // initialize our string so we can add to it
        output +=node.element+",";
        return tostring(node.left) + output + tostring(node.right);
    }

    private int[] toArray() {
        // convert the tree to an integer array
        // convert to strings first, then split strings and convert to array
        // time complexity is 2^n same as our toString because it uses our toString method
        // space complexity is 2*n which is big theta n
        String[] s = this.tostring().split(",");
        // make sure we have space to add the new integers
        int[] output = new int[s.length];

        for (int i=0;i<s.length;i++) // loop through values and parse to an integer
            output[i]=Integer.parseInt(s[i]);
        // finally, give back our integer array to whoever called us
        return output;
    }

    public BSTSet union(BSTSet s){
        // union means both elements in this and that in the new one
        // if either this or s is empty, we can just return that (saves time)
        // time complexity: 2^n
        // space complexity:  because of the toArray method / drop the coefficients
        if(this.isEmpty() || s.isEmpty())
            return s.isEmpty()?this:s;
        // convert both this and s into arrays
        int[] sArray = s.toArray();
        int[] thisArray = toArray();
        // initialize a new set to return values
        BSTSet union = new BSTSet();
        for (int i=0; i<sArray.length; i++) // add elements of s first
            union.add(sArray[i]);
        for (int j=0; j<thisArray.length; j++) // then add elements of this
            union.add(thisArray[j]);
        return new BSTSet(union.toArray()); // pass the array to our
        // height minimizer so we can make it minimzed height
        // note ****** our add method takes care of duplicates so no duplicates will be present.
    }

    public BSTSet intersection(BSTSet s) {
        // returns the elements that both this and s have
        // sa,e as before, if one is empty, just return empty set bc can't have anything in common
        // time complexity is 2^n because of toArray
        // space complexity is n because drop the leading coefficients
        if(this.isEmpty()||s.isEmpty())
            return new BSTSet();

        // make them both arrays so we can loop through them
        int[] sArray = s.toArray();
        int[] thisArray = toArray();

        // initialize our new set
        BSTSet intersection = new BSTSet();

        // begin looping through our sets
        for (int i=0; i<thisArray.length; i++) {
            // loop through this array and find every element that matches
            for(int j=0; j<sArray.length; j++) {
                if(sArray[j]==thisArray[i])
                    intersection.add(sArray[j]); // if they add, add it to the array
            }
        }
        // we might loop through everything and find no matches, so just return an empty set then
        if (intersection.isEmpty())
            return new BSTSet();

        // if we got this far, we have elements in intersection so just
        // make it an array and use our constructor to minimize the size
        return new BSTSet(intersection.toArray());
    }

    public void printBSTSet() {
        // print this BST set in increasing order
        // printing is time complexity n^2
        if(root==null)
            System.out.println("Set is empty"); // this means that empty set so print error message
        else {
            System.out.print("Elements are: ");
            printBSTSet(root);
            System.out.print("\n");
        }
    }
    private void printBSTSet(TNode node){
        // previous print calls this print because other one isn't recursive bc public
        // TIME COMPLEXITY: O(n) because recursive traversal but only hit node once
        // space is complexity is log(n)
        if(node!=null) { // ensure that it's not empty
            printBSTSet(node.left); // want to print least to greatest so go left first
            System.out.print(" " + node.element + ", "); // next is root
            printBSTSet(node.right); // finally print all values right
        }
    }

    public void printNonRec ( ) {
        //printing inorder using stacks
        if (root == null)
        {
            System.out.println("This Set is Empty");
            return;
        }

        TNode n = root;
        MyStack stk = new MyStack();
        String out="";
        while (n != null){
            //in this loop all left most children and root are stored
            stk.push(n);
            n = n.left;
        }

        while (!stk.isEmpty()) {
            n = stk.pop();  //taking out the elements from the stack
            out+=n.element + ", "; //storing in a string

            if (n.right != null) //if there's an element on the right
            {
                n = n.right;

                while (n != null) //storing that element and all left children to it
                {
                    stk.push(n);
                    n = n.left;
                }
            }
        }
        System.out.println("The set elements are: "+out); //printing
    }

    // ACCESSORS ------------------------

    public int size() {
        // return n i.e. number of nodes in the binary tree
        return size(root); // call our recursive method
    }

    private int size(TNode node){
        // recursively calculate number of nodes in this tree
        // time complexity = 2^n
        // space complexity log(n)
        if(node==null)
            return 0; // there are no nodes bc first is null so zero nodes
        return size(node.left) +  1 + size(node.right); // recursively call and add sizes
        // every time we split it should add one therefore for every node
    }

    public int height(){
        // get the height of this tree (i.e. log of size)
        return height(root); // call our recursive private method
    }

    private int height(TNode node) {
        // recursively find the height of this tree
        // time of 2^n
        // space complexity: log(n)
        if (node==null)
            return -1; // no elements at all means -1 height, not zero because zero would be one element

        int righth = height(node.right);
        int lefth = height(node.left);
        // the greater height should be the one added in the case that the tree has a bigger side
        // on either branch, so account for this
        int height = righth>lefth?righth+1:lefth+1; // plus one because of the negative one in the beginning
        return height;
    }

} // end class BSTSet
