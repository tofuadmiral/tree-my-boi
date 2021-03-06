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
       System.out.println("heap is preserved, as evidenced by: ");
       System.out.println(test2.toString());


        // test 5: heapsort an array to prove that everything works
        System.out.println("\nTest 5: heapsort an array");
        testarray[0] = 40;
        testarray[1] = 11;
        testarray[2] = 7;
        testarray[3] = 55;
        testarray[4] = 23;
        testarray[5] = 1;
        testarray[6] = 99;
        testarray[7] = 21;
        testarray[8] = 65;
        testarray[9] = 64;
        test1.heapsort(testarray);

        for(int i = 0; i<10; i++){
            System.out.println(testarray[i]);
        }

        MaxHeap test3 = new MaxHeap(testarray);

       // test 6 double size:

        System.out.println("\nTest 6: Try to insert if already full, show that size doubles");
        System.out.println("previous size: " + test3.getSize());
        test3.insert(6);
        System.out.println("after insert size: "+test3.getSize());

    }

}
