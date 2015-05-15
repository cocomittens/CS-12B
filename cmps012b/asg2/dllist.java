/* Name: Corrie Gripenstraw
 * ID: cgripens
 * Class: CMPS 12B
 * Date: November 5, 2014
 * Filename: dllist.java
 * Description: Class implementing doubly linked list of strings
 */
import java.util.*;
 
public class dllist {

   public enum position {FIRST, PREVIOUS, FOLLOWING, LAST};

   private class node {
      String item;
      node prev;
      node next;
   }

   private node first = null;
   private node current = null;
   private node last = null;
   private int currentPosition = 0;
   public int listSize = 0;

   public void setPosition (position pos) {
    switch(pos){
    case FIRST:
        current = first;
        currentPosition = 0;
        break;
    case LAST:
        current = last;
        currentPosition = listSize-1;
        break;
    case FOLLOWING:
        if(current != last){
            current = current.next;
         }
        currentPosition++;
        break;
    case PREVIOUS:
        if(current!=first){
            current = current.prev;
        }
        currentPosition--;
        break;
    default:
        break;
    }
    }

    public boolean isEmpty () {
        return (first == null);  
    }

    public String getItem () {
        if(listSize == 0)
            throw new NoSuchElementException();
        return current.item;
    } 

    public int getPosition () {
        if(listSize == 0)
            throw new NoSuchElementException();
        return currentPosition;  
    } 
 
    public void delete () {
        node temp = current;
        if(current == last && current == first){
            current = null;
            first = null;
            last = null;
            listSize = 0;
        }
        else if(current == last){
            current.prev.next = null;    
            current = current.prev;
            listSize--;
        }
        else if(current == first){
            current.next.prev = null;
            current = current.next;
            listSize--;
        }
        else{
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current = null;
            current = temp.next;
            listSize--;
        }
    }

    public void insert (String item, position pos) {
        node newNode = new node();
        switch(pos){
        case LAST:
            if(isEmpty())
                first = newNode;
            else{
                last.next = newNode;
                newNode.prev = last;     
            }
            newNode.item = item;
            last = newNode;
            current = newNode;
            listSize++;
            break;
        case FIRST:
            if(isEmpty())
                last = newNode;
            else
                first.prev = newNode;
            newNode.next = first;
            newNode.item = item;
            first = newNode;
            current = newNode;
            listSize++;
            break;
        case FOLLOWING:
            if(isEmpty()){
                newNode.item = item;
                first = newNode;
                last = newNode;
                current = newNode;
                listSize++;
                break;
             }
             if(current == last){
                 newNode.next = null;
                 last = newNode;
             }
             else{
                 newNode.next = current.next;
                 current.next.prev = newNode;
             }
            newNode.prev = current;
            newNode.item = item;
            current.next = newNode;
            current = newNode;
            listSize++;
            break;
        case PREVIOUS:
            if(isEmpty()){
                newNode.item = item;
                first = newNode;
                last = newNode;
                current = newNode;
                listSize++;
                break;
            }
            if(current==first){
                newNode.prev = null;
                first = newNode;
            }
            else{
                newNode.prev = current.prev;
                current.prev.next = newNode;
            }
            newNode.next = current;
            newNode.item = item;
            current.prev = newNode;
            current = newNode;
            listSize++;
            break;
        default:
            break;
        }
    }
}
