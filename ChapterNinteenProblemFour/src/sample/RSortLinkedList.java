//package sample;
//
//public class RSortLinkedList
//{
//    private Node first = null;  // list head
//    private Node last = null;   // last element in list
//
//    private Node reverse(Node list)
//    {
//        if(list == null || list.next == null)
//        {
//            return list;
//        }
//
//        Node head = list;
//        list = reverse(list.next);
//
//        Node refLast = list;
//        while(refLast.next != null)
//        {
//            refLast = refLast.next;
//        }
//
//        refLast.next = head;
//        head.next = null;
//
//        return list;
//    }
//
//    private Node sort(Node list)
//    {
//        if(list == null)
//        {
//            return null;
//        }
//
//        Node head = list;
//        list = sort(list.next);
//
//        list = insertSorted(head, list);
//
//        return list;
//    }
//
//    private Node insertSorted(Node n, Node sortedList)
//    {
//
//        if(sortedList == null || n.value.compareTo(sortedList.value) < 0)
//        {
//            n.next = sortedList;
//            return n;
//        }
//
//        sortedList.next = insertSorted(n, sortedList.next);
//        return sortedList;
//    }
//    /**
//     The Node class stores a list element
//     and a reference to the next node.
//     */
//
//    private class Node
//    {
//        Player player;
//        Node next;
//
//        /**
//         Constructor.
//         @param player The player (name and score) to store in the node.
//         @param n The reference to the successor node.
//         */
//
//        Node(Player player, Node n)
//        {
//            this.player = player;
//            next = n;
//        }
//
//        /**
//         Constructor.
//         @param player The element to store in the node.
//         */
//
//        Node(Player player)
//        {
//            // Call the other (sister) constructor.
//            this.player = player;
//            this.next = null;
//        }
//    }
//
//
//
//    /**
//     Constructor.
//     */
//
//    public RSortLinkedList()
//    {
//        first = null;
//        last = null;
//    }
//
//    /**
//     The isEmpty method checks to see
//     if the list is empty.
//     @return true if list is empty,
//     false otherwise.
//     */
//
//    public boolean isEmpty()
//    {
//        return first == null;
//    }
//
//    /**
//     The size method returns the length of the list.
//     @return The number of elements in the list.
//     */
//
//    public int size()
//    {
//        int count = 0;
//        Node p = first;
//        while (p != null)
//        {
//            // There is an element at p
//            count ++;
//            p = p.next;
//        }
//        return count;
//    }
//
//    /**
//     The add method adds an element to
//     the end of the list.
//     @param e The value to add to the
//     end of the list.
//     */
//
//    public void add(Player player)
//    {
//        if (isEmpty())
//        {
//            first = new Node(player);
//            last = first;
//        }
//        else
//        {
//            // Add to end of existing list
//            last.next = new Node(player);
//            last = last.next;
//        }
//    }
//
//    /**
//     The add method adds an element at a position.
//     @param e The element to add to the list.
//     @param index The position at which to add
//     the element.
//     @exception IndexOutOfBoundsException When
//     index is out of bounds.
//     */
//
//    public void add(int index, String e)
//    {
//        if (index < 0  || index > size())
//        {
//            String message = String.valueOf(index);
//            throw new IndexOutOfBoundsException(message);
//        }
//
//        // Index is at least 0
//        if (index == 0)
//        {
//            // New element goes at beginning
//            first = new Node(e, first);
//            if (last == null)
//                last = first;
//            return;
//        }
//
//        // Set a reference pred to point to the node that
//        // will be the predecessor of the new node
//        Node pred = first;
//        for (int k = 1; k <= index - 1; k++)
//        {
//            pred = pred.next;
//        }
//
//        // Splice in a node containing the new element
//        pred.next = new Node(e, pred.next);
//
//        // Is there a new last element ?
//        if (pred.next.next == null)
//            last = pred.next;
//    }
//
//    /**
//     The toString method computes the string
//     representation of the list.
//     @return The string form of the list.
//     */
//
//    public String toString()
//    {
//        StringBuilder strBuilder = new StringBuilder();
//
//        // Use p to walk down the linked list
//        Node p = first;
//        while (p != null)
//        {
//            strBuilder.append(p.value + "\n");
//            p = p.next;
//        }
//        return strBuilder.toString();
//    }
//
//    /**
//     The remove method removes the element at an index.
//     @param index The index of the element to remove.
//     @return The element removed.
//     @exception IndexOutOfBoundsException When index is
//     out of bounds.
//     */
//
//    public String remove(int index)
//    {
//        if (index < 0 || index >= size())
//        {
//            String message = String.valueOf(index);
//            throw new IndexOutOfBoundsException(message);
//        }
//
//        String element;  // The element to return
//        if (index == 0)
//        {
//            // Removal of first item in the list
//            element = first.value;
//            first = first.next;
//            if (first == null)
//                last = null;
//        }
//        else
//        {
//            // To remove an element other than the first,
//            // find the predecessor of the element to
//            // be removed.
//            Node pred = first;
//
//            // Move pred forward index - 1 times
//            for (int k = 1; k <= index -1; k++)
//                pred = pred.next;
//
//            // Store the value to return
//            element = pred.next.value;
//
//            // Route link around the node to be removed
//            pred.next = pred.next.next;
//
//            // Check if pred is now last
//            if (pred.next == null)
//                last = pred;
//        }
//        return element;
//    }
//
//    /**
//     The remove method removes an element.
//     @param element The element to remove.
//     @return true if the remove succeeded,
//     false otherwise.
//     */
//
////    public boolean remove(String element)
////    {
////        if (isEmpty())
////            return false;
////
////        if (element.equals(first.value))
////        {
////            // Removal of first item in the list
////            first = first.next;
////            if (first == null)
////                last = null;
////            return true;
////        }
////
////        // Find the predecessor of the element to remove
////        Node pred = first;
////        while (pred.next != null &&
////                !pred.next.value.equals(element))
////        {
////            pred = pred.next;
////        }
////
////        // pred.next == null OR pred.next.value is element
////        if (pred.next == null)
////            return false;
////
////        // pred.next.value  is element
////        pred.next = pred.next.next;
////
////        // Check if pred is now last
////        if (pred.next == null)
////            last = pred;
////
////        return true;
////    }
//
//    public void reverse()
//    {
//        first = reverse(first);
//
//        // set the last reference
//        last = first;
//        if(last != null)
//        {
//            while(last.next != null)
//            {
//                last = last.next;
//            }
//        }
//    }
//
//    public void sort()
//    {
//        // Call the recursive method
//        first = sort(first);
//
//        // Rest the last reference
//        last = first;
//
//        if(last != null)
//        {
//            while (last.next != null)
//                last = last.next;
//        }
//    }
//
//    public void insert(String name, int score)
//    {
//
//    }
//}
