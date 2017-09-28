package com.vikoo.myds.linkedlist;

import android.location.Location;
import android.util.Log;

/**
 * Created by vekariya.r on 24/09/17.
 */

public class LinkedListUtils {

    public static LinkedListVik.Node mergeSortedListRecursive(LinkedListVik.Node listA, LinkedListVik.Node listB){
        if(listA == null){
            return listB;
        } else if(listB == null){
            return listA;
        } else{
            if(listA.data >= listB.data){
                listB.next = mergeSortedListRecursive(listA, listB.next);
                return listB;
            } else {
                listA.next = mergeSortedListRecursive(listA.next, listB);
                return listA;
            }
        }
    }

    public static LinkedListVik.Node mergeSortedList(LinkedListVik.Node listA, LinkedListVik.Node listB){
        if(listA == null){
            return listB;
        } else if(listB == null){
            return listA;
        } else{
            LinkedListVik.Node head = new LinkedListVik.Node(0);
            LinkedListVik.Node result = head;
            while (listA != null || listB != null) {
                if (listA != null && listB != null) {
                    if (listA.data < listB.data) {
                        result.next = listA;
                        listA = listA.next;
                    } else {
                        result.next = listB;
                        listB = listB.next;
                    }
                    result = result.next;
                } else {
                    break;
                }
            }
            if(listA == null){
                    result.next = listB;
                } else{
                    result.next = listA;
                }

            return head.next;
        }
    }

    public static LinkedListVik.Node insertSortedList(LinkedListVik.Node list, int data){
        if(list == null){
            return new LinkedListVik.Node(data);
        } else{
            boolean isAdded = false;
            LinkedListVik.Node temp = list;
            while (temp.next != null){
                if(temp.next.data <= data){
                    temp = temp.next;
                } else{
                    LinkedListVik.Node newNode = new LinkedListVik.Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                    isAdded = true;
                    break;
                }
            }
            if(!isAdded){
                LinkedListVik.Node newNode = new LinkedListVik.Node(data);
                temp.next = newNode;
            }
            return list;
        }
    }

    public static boolean isPalindrome(LinkedListVik.Node list){
        LinkedListVik.Node head = list;
        if(list == null || list.next == null){
            return true;
        } else{
            LinkedListVik.Node slow = head;
            LinkedListVik.Node fast = head.next;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast.next = fast.next.next;
            }
            Log.i(LinkedListVik.TAG, "middle:" + slow.data);

            while (list != null){
                Log.i(LinkedListVik.TAG, "data:" + list.data);
                list = list.next;
            }
            return true;
        }
    }
}
