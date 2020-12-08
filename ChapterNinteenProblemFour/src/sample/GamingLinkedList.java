package sample;

import java.util.*;

public class GamingLinkedList
{
    /**
     The Node class stores a list element
     and a reference to the next node. This is an inner class not a field.
     */
    private class Node
    {


        // Node Stores player name, their score and next node.
        String playerName;
        int playerScore;
        Node next;

        /**
         Constructor.
         @param playerName The element to store in the node.
         @param playerScore The reference to the successor node.
         */

        Node(String playerName, int playerScore, Node node)
        {
            this.playerName = playerName;
            this.playerScore = playerScore;
            this.next = node;
        }

        /**
         Constructor.
         @param playerName The name of player
         @param playerScore The score player earned
         */

        Node(String playerName, int playerScore)
        {
            this.playerName = playerName;
            this.playerScore = playerScore;
            this.next = null;
        }

        // Methods
        public String getPlayerName()
        {
            return playerName;
        }

        public void setPlayerName(String playerName)
        {
            this.playerName = playerName;
        }

        public int getPlayerScore()
        {
            return playerScore;
        }

        public void setPlayerScore(int playerScore)
        {
            this.playerScore = playerScore;
        }
    }

    private Node first;  // list head
    private Node last;   // last element in list

    /**
     * Default Constructor.
     */

    public GamingLinkedList()
    {
        first = null;
        last = null;
    }

    /**
     The isEmpty method checks to see
     if the list is empty.
     @return true if list is empty,
     false otherwise.
     */

    public boolean isEmpty()
    {
        return first == null;
    }

    /**
     The size method returns the length of the list.
     @return The number of elements in the list.
     */

    public int size()
    {
        int count = 0;
        Node p = first;
        while (p != null)
        {
            // There is an element at p
            count ++;
            p = p.next;
        }
        return count;
    }


    /**
     The add method adds an element to
     the end of the list.
     @param playerName The name of the player
     @param playerScore The score the player earned
     */

    public void add(String playerName, int playerScore)
    {
        if (isEmpty())
        {
            first = new Node(playerName, playerScore);
            last = first;
        }
        else
        {
            // Add to end of existing list
            last.next = new Node(playerName, playerScore);
            last = last.next;
        }
    }


    /**
     The add method adds an element at a position.
     @param index The position at which to add
     the element.
     @param playerName The name of the player
     @param playerScore The score the player earned
     @exception IndexOutOfBoundsException When
     index is out of bounds.
     */
    public void add(int index, String playerName, int playerScore)
    {
        if (index < 0  || index > size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        // Index is at least 0
        if (index == 0)
        {
            // New element goes at beginning
            first = new Node(playerName, playerScore, first);
            if (last == null)
                last = first;
            return;
        }

        // Set a reference pred to point to the node that
        // will be the predecessor of the new node
        Node pred = first;
        for (int k = 1; k <= index - 1; k++)
        {
            pred = pred.next;
        }

        // Splice in a node containing the new element
        pred.next = new Node(playerName, playerScore, pred.next);

        // Is there a new last element ?
        if (pred.next.next == null)
            last = pred.next;
    }


    /**
     The toString method computes the string
     representation of the list.
     @return The string form of the list.
     */

    public String toString()
    {
        StringBuilder strBuilder = new StringBuilder();

        // Use p to walk down the linked list
        Node p = first;
        while (p != null)
        {
            strBuilder.append(p.playerName + " " + p.playerScore + "\n");
            p = p.next;
        }
        return strBuilder.toString();
    }


    // Need to review remove method. May need to be void to remove both
    // playerName and playerScore
    /**
     The remove method removes the element at an index.
     @param index The index of the element to remove.
     // @return The element removed.
     @exception IndexOutOfBoundsException When index is
     out of bounds.
     */

    public void remove(int index)
    {
        if (index < 0 || index >= size())
        {
            String message = String.valueOf(index);
            throw new IndexOutOfBoundsException(message);
        }

        String name;  // The player name
        int score; // The player score
        if (index == 0)
        {
            // Removal of first item in the list
            name = first.playerName;
            score = first.playerScore;

            first = first.next;
            if (first == null)
                last = null;
        }
        else
        {
            // To remove an element other than the first,
            // find the predecessor of the element to
            // be removed.
            Node pred = first;

            // Move pred forward index - 1 times
            for (int k = 1; k <= index -1; k++)
                pred = pred.next;

            // Store the value to return
            name = pred.next.playerName;
            score = pred.next.playerScore;

            // Route link around the node to be removed
            pred.next = pred.next.next;

            // Check if pred is now last
            if (pred.next == null)
                last = pred;
        }
    }

    public void clear()
    {
        first = null;
    }

    // Sort in Descending order so highest score is first (index 0)
    public void sort()
    {
        // Create sortedMap
        SortedMap<String, Integer> gamingScoresMap = new TreeMap<String, Integer>(Collections.reverseOrder());

        // Add all nodes to a sorted map
        // See if list is empty
        if(!isEmpty())
        {
            // Assign first to currentNode
            Node currentNode = first;

            while(currentNode == first ||currentNode.next != null)
            {
                gamingScoresMap.put(currentNode.getPlayerName(), currentNode.getPlayerScore());
                currentNode = currentNode.next;
            }
        }

        // Remove all nodes from Gaming linked list
        clear();


        // iterate through the sorted map BACKWARDS adding only 10

        // Using set to use iterator
        Set set = gamingScoresMap.entrySet();
        Iterator i = set.iterator();

        // Need to alter add method to be able to use here.
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            GamingLinkedList.add(me.getKey(),me.getValue());
        }

        // Add each key and value as a node to the Gaming linked list

    }



    public void insert(String playerName, int playerScore)
    {
        // Ignore any scores less than or equal to minimum score

        // checks score to see if player is in top 10

        // if player is in top 10, find correct location

        // only keep players 1-10 (index 0-9)


    }
}
