public class TestMaxHeap {
    public static void main(String[] args) {

        // test 1: create table, but it's empty
        System.out.println("Test 1: Create an empty MaxHeap:");
        MaxHeap test1 = new MaxHeap(25);
        System.out.println(test1.toString());

        // test 2: insert a few elements into the table
        System.out.println("Test 2: insert some items into the MaxHeap");
        test1.insert(4);
        test1.insert(5);
        test1.insert(1);
        test1.insert(10);
        System.out.println(test1.toString());


        // test 3: second constructor
        System.out.println("\nTest 3: Create heap from array");
        Integer[] testarray = new Integer[10];
        for (int i = 0; i<10; i++){
            testarray[i] = i;
        }
        MaxHeap test2 = new MaxHeap(testarray);
        System.out.println(test2.toString());


        // test 4: delete max
       int maxelement = test2.deleteMax();
       System.out.println("The max element is: " + maxelement);



        // test 5: insert until we have to rehash
        System.out.println("\nTest 5: insert till we need to reallocate");


        // test 6: try insert and count
        System.out.println("\nTest 6: try insert and count, 1 probe: ");

        // test 7: try insert and count
        System.out.println("\nTest 7: try insert and count, >1 probes: ");

        // test 8: get average probes for successful search
        // just change 0.1 to other load factors to find the load factor for each test case
        System.out.println("\nTest 8: find successful search count ");

    }

}
