package com.vikoo.myds;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vikoo.myds.linkedlist.LinkedListUtils;
import com.vikoo.myds.linkedlist.LinkedListVik;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        initLinkedListOperations();
        initMerge();
    }

    private void initLinkedListOperations(){
        LinkedListVik linkedList = new LinkedListVik();
        linkedList.length();
        linkedList.deleteLast();
        linkedList.insertEnd(1);
        linkedList.length();
        linkedList.deleteLast();
        linkedList.insertEnd(2);
        linkedList.insertEnd(3);
        linkedList.insertEnd(5);
        linkedList.insertEnd(6);
        linkedList.insertAfterPosition(4, 3);
        linkedList.insertAfterPosition(7, 6);
        linkedList.insertBeforePosition(0, 1);
        linkedList.insertBeforePosition(45, 6);
        linkedList.deleteLast();
        linkedList.deleteFirst();
        linkedList.deletePostion(2);
        linkedList.insertAtPosition(25,2);
        linkedList.insertAtPosition(1,1);
        linkedList.insertAtPosition(7,7);
        linkedList.insertAtPosition(6,7);
        linkedList.insertAtPosition(8,10);
        linkedList.insertAtPosition(9,9);
        linkedList.printAll();
        Log.i(LinkedListVik.TAG, "lenght Recursive:" + linkedList.lengthRecursive(linkedList.head));
        Log.i(LinkedListVik.TAG, "indexof:" + linkedList.indexOf(linkedList.head, 7, 0));
        linkedList.printMiddle();
        linkedList.printNthFromLast(1);
        linkedList.reverseList();
        linkedList.printAll();
        Log.i(LinkedListVik.TAG, "loop:" + linkedList.detectLoop());
        Log.i(LinkedListVik.TAG, "loopHashing:" + linkedList.detectLoopHashing());
    }

    public void initMerge(){
//        LinkedListVik listA = new LinkedListVik();
//        listA.insertEnd(1);
//        listA.insertEnd(2);
//        listA.insertEnd(5);
//
//        LinkedListVik listB = new LinkedListVik();
//        listB.insertEnd(2);
//        listB.insertEnd(3);
//        listB.insertEnd(5);
//        listB.insertEnd(6);
//
//        listA.head = LinkedListUtils.mergeSortedList(listA.head, listB.head);
//        listA.printAll();

        LinkedListVik listC = new LinkedListVik();
        listC.insertEnd(1);
        listC.insertEnd(2);
        listC.insertEnd(5);
        listC.insertEnd(5);
//        listC.head = LinkedListUtils.insertSortedList(listC.head, 5);
        LinkedListUtils.isPalindrome(listC.head);
        listC.printAll();

    }
}
