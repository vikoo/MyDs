package com.vikoo.myds.linkedlist;

import android.content.Intent;
import android.location.Location;
import android.os.Parcelable;
import android.util.Log;

import java.util.HashSet;

/**
 * Created by vekariya.r on 24/09/17.
 */

public class LinkedListVik {

    public static final String TAG = "LinkedList";
    public Node head;

    public static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
        }
    }

    public void insertEnd(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = head;
            // to reach to last position
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(data);
        }
    }

    public void insertFront(int data) {
        if (head == null) {
            head = new Node(data);
        } else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
    }

    public void insertAfterNode(Node node, int data) {
        if (node != null) {
            Node temp = new Node(data);
            temp.next = node.next;
            node.next = temp;
        }
    }

    public void insertAfterPosition(int data, int position) {
        if (position <= 0) {
            return;
        }
        Node temp = head;
        int count = 1;
        while (temp != null && count < position) {
            temp = temp.next;
            count++;
        }
        if (temp != null) {
            Node newNode = new Node(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void insertBeforePosition(int data, int position) {
        if (position <= 0) {
            return;
        } else if (position == 1) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        } else {
            insertAfterPosition(data, position - 1);
        }
    }

    public void deleteLast() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            // to reach to second last element
            while (temp.next != null && temp.next.next != null) {
                temp = temp.next;
            }
            Node lastNode = temp.next;
            temp.next = null;
            lastNode = null;

        }
    }

    public void deleteFirst() {
        if (head == null) {
            return;
        } else if (head.next == null) {
            head = null;
        } else {
            Node temp = head;
            head = head.next;
            temp = null;
        }
    }

    public void deletePostion(int position) {
        if (head == null) {
            return;
        } else if (position <= 0) {
            return;
        } else {
            // this is turning point
            position = position - 1;
            if (position == 0) {
                deleteFirst();
            } else {
                int count = 1;
                Node temp = head;
                while (temp.next != null && count < position) {
                    count++;
                    temp = temp.next;
                }
                if (temp != null) {
                    Node deleteNode = temp.next;
                    temp.next = deleteNode.next;
                    deleteNode = null;
                }
            }
        }
    }

    public void insertAtPosition(int data, int position) {
        if (head == null) {
            return;
        } else if (position <= 0) {
            return;
        } else {
            position = position - 1;
            if (position == 0) {
                Node newNode = new Node(data);
                newNode.next = head;
                head = newNode;
            } else {
                int count = 1;
                Node temp = head;
                while (temp.next != null && count < position) {
                    count++;
                    temp = temp.next;
                }
                if (temp != null && count >= position) {
                    Node newNode = new Node(data);
                    newNode.next = temp.next;
                    temp.next = newNode;
                }
            }
        }
    }

    public int getNodeAtPosition(int position) {
        if (head == null) {
            return -1;
        } else if (position == 0) {
            return -1;
        } else {
            int count = 1;
            Node temp = head;
            while (temp.next != null && count < position) {
                count++;
                temp = temp.next;
            }
            if (temp != null) {
                return temp.data;
            } else {
                return -1;
            }
        }
    }

    public void printAll() {
        Node temp = head;
        while (temp != null) {
            Log.i(TAG, temp.data + "");
            temp = temp.next;
        }
    }

    public int length() {
        int count = 0;
        Node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        Log.i(TAG, "length:" + count);
        return count;
    }

    public int lengthRecursive(Node node) {
        if (node == null) {
            return 0;
        } else {
            return 1 + lengthRecursive(node.next);
        }

    }

    public int indexOf(int data) {
        if (head == null) {
            return -1;
        } else {
            Node temp = head;
            int count = 0;
            boolean isFound = false;
            while (temp != null) {
                if (temp.data == data) {
                    isFound = true;
                    break;
                } else {
                    count++;
                }
                temp = temp.next;
            }
            if (isFound) {
                return count;
            } else {
                return -1;
            }
        }
    }

    public int indexOf(Node node, int data, int index){
        if(node == null){
            return -1;
        } else if(node.data == data){
            return index;
        } else{
            return indexOf(node.next, data, index +1);
        }
    }

    public boolean search(Node node, int data){
        if(node == null){
            return false;
        } else if(node.data == data){
            return true;
        } else{
            return search(node.next, data);
        }
    }


    // --------------------------------------------------------------------------
    // RUNNER Techniques
    // --------------------------------------------------------------------------
    public void printMiddle(){
        if(head == null){
            return;
        } else{
            Node temp = head;
            Node tempDouble = head.next;
            while(tempDouble != null && tempDouble.next!= null){
                temp = temp.next;
                tempDouble = tempDouble.next.next;
            }
            if(temp != null){
                Log.i(TAG, "middle element:" + temp.data);
            }
        }
    }

    public void printNthFromLast(int position){
        if(head == null){
            return;
        } else{
            Node temp = head;
            Node tempForward = head;
            int count = 0;
            while(tempForward != null && count < position){
                tempForward = tempForward.next;
                count++;
            }
            if(tempForward != null){
                while (tempForward != null){
                    temp = temp.next;
                    tempForward = tempForward.next;
                }
                if(temp != null){
                    Log.i(TAG, position + "th node from last:" + temp.data);
                }
            }
        }
    }

    public boolean detectLoop(){
        if(head == null){
            return false;
        } else{
//            head.next.next.next.next = head.next.next;
            Node temp = head;
            Node forwardTemp = head.next;

            while (forwardTemp != null && forwardTemp.next != null){
                if(temp.data == forwardTemp.data){
                    return true;
                }
                temp = temp.next;
                forwardTemp = forwardTemp.next.next;
            }
            return false;
        }
    }

    public boolean detectLoopHashing(){
        if(head == null){
            return false;
        } else{
//            head.next.next.next.next = head.next.next;
            HashSet<Integer> set = new HashSet<>();
            Node temp = head;
            while (temp != null){
                if(set.contains(temp.data)){
                    return true;
                } else{
                    set.add(temp.data);
                    temp = temp.next;
                }
            }
            return false;
        }
    }

    public void deleteAll(){
        head = null;
    }

    public void reverseList(){
        if(head == null){
            return;
        } else if(head.next == null){
            return;
        } else {
            Node current = head;
            Node next = current.next;
            Node previous = null;
            while (current != null){
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            head = previous;
        }
    }
}
