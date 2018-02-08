/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import memory.GarbageCollector;

/**
 * @author ialsmadi
 */
public class OSLab2 {

    public static void main(String[] args) {
        //   Test1();
        //  Test2();
        // Test3();
        //Test4();
        //  Test5();
        //   Test6();
        Test7();
    }

    public static void Test1() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";

        gc.addHeapObject(id);

        System.out.println(gc.memUse());

        System.out.println(gc.isMarked(id));

        System.out.println(gc.isInHeapMemory(id));

        System.out.println(gc.isInStackMemory(id));

        System.out.println(gc.isInMemory(id));

        gc.mark();

        System.out.println(gc.isMarked(id));

        gc.sweep();

        System.out.println(gc.isInMemory(id));

        System.out.println(gc.memUse());

    }

    public static void Test6() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";
        String id2 = "testObject2";
        String id3 = "testObject3";


        gc.addHeapObject(id);
        gc.addHeapObject(id2);
        gc.addHeapObject(id3);

        gc.addStackObject(id);
        gc.addStackObject(id2);

        gc.addReference(id, id2);

        System.out.println(gc.memUse());

        System.out.println(gc.isInHeapMemory(id));

        System.out.println(gc.isInStackMemory(id));

        System.out.println(gc.isInMemory(id));

        gc.mark();

        gc.sweep();

        System.out.println(gc.memUse());

        System.out.println(gc.isInHeapMemory(id3));
    }

    public static void Test7() {

        GarbageCollector gc = new GarbageCollector();

        for (int k = 0; k < 2; k++) {
            String id = ""+k;
            System.out.println("Adding an object with ID " + id + " to heap.");
            gc.addHeapObject(id);
            System.out.println("Adding an object with ID " + id + " to stack.");
            gc.addStackObject(id);
            System.out.println("Creating a link between the stack object with ID " + id + " and the heap object with ID " + id);
            gc.getStackObject(id).addNeighbour(gc.getHeapObject(id));
            System.out.println("Memory usage: " + gc.memUse());
            System.out.println("Object with ID " + id + " is in heap: " + gc.isInHeapMemory(id));
            System.out.println("Object with ID " + id + " is in stack: " + gc.isInStackMemory(id));
//            System.out.println(gc.isInMemory(id));
            System.out.println("Running garbage collector...");
            gc.mark();
            gc.sweep();
            System.out.println("Heap usage: " + gc.heapUse() + " Stack usage: " + gc.stackUse());
        }
        System.out.println("\nNo objects were deleted by garbage collector because the link was created " +
                "\nbetween stack and heap objects with the same IDs.\n");
        System.out.println("Removing the link between the stack object with ID 0 and the heap object with ID 0.");
        gc.removeReference("0","0");
        System.out.println("Heap usage: " + gc.heapUse() + " Stack usage: " + gc.stackUse());
        System.out.println("Running garbage collector...");
        gc.mark();
        gc.sweep();
        System.out.println("Heap usage: " + gc.heapUse() + " Stack usage: " + gc.stackUse());
        if (gc.getStackObject("0") != null) System.out.println("The object with ID 0 is in stack.");
        else System.out.println("The object with ID 0 is not in stack.");
        if (gc.getHeapObject("0") != null) System.out.println("The object with ID 0 is in heap.");
        else System.out.println("The object with ID 0 is not in heap.");
        System.out.println("The object with ID 0 was deleted from heap because " +
                "\nthe link from stack object with the same ID was deleted.");
    }

    public static void Test5() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";
        String id2 = "testObject2";
        String id3 = "testObject3";
        String id4 = "testObject4";
        String id5 = "testObject4";

        gc.addHeapObject(id2);
        gc.addHeapObject(id3);
        gc.addHeapObject(id4);
        gc.addHeapObject(id5);

        gc.addStackObject(id);

        gc.addReference(id, id2);
        gc.addReference(id, id3);
        gc.addReference(id, id4);

        gc.mark();

        gc.sweep();

        System.out.println(gc.memUse());
    }


    public static void Test4() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";
        String id2 = "testObject2";
        String id3 = "testObject3";
        String id4 = "testObject4";
        String id5 = "testObject4";

        gc.addHeapObject(id2);
        gc.addHeapObject(id3);
        gc.addHeapObject(id4);
        gc.addHeapObject(id5);

        gc.addStackObject(id);

        gc.addReference(id, id2);
        gc.addReference(id2, id3);
        gc.addReference(id2, id4);

        gc.mark();

        gc.sweep();

        System.out.println(gc.memUse());
    }


    public static void Test3() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";
        String id2 = "testObject2";
        String id3 = "testObject3";
        String id4 = "testObject4";
        String id5 = "testObject4";

        gc.addHeapObject(id2);
        gc.addHeapObject(id3);
        gc.addHeapObject(id4);
        gc.addHeapObject(id5);

        gc.addStackObject(id);
        gc.addStackObject(id2);
        gc.addStackObject(id3);
        gc.addStackObject(id4);

        gc.addReference(id, id2);
        gc.addReference(id2, id3);
        gc.addReference(id2, id4);

        gc.mark();

        gc.sweep();

        System.out.println(gc.memUse());

        gc.removeReference(id2, id4);
        gc.removeReference(id2, id4);
        gc.removeReference(id2, id4);

        gc.mark();

        gc.sweep();

        System.out.println(gc.memUse());
    }


    public static void Test2() {

        GarbageCollector gc = new GarbageCollector();

        String id = "testObject";
        String id2 = "testObject2";
        String id3 = "testObject3";

        gc.addHeapObject(id);
        gc.addHeapObject(id3);
        gc.addStackObject(id2);

        gc.addReference(id2, id);
        gc.mark();
        gc.sweep();

        System.out.println(gc.memUse());

        gc.removeReference(id2, id);
        gc.mark();
        gc.sweep();

        System.out.println(gc.memUse());
    }
}
