/* Name: Corrie Gripenstraw
 * ID: cgripens
 * Class: CMPS 12B
 * Date: November 5, 2014
 * Filename: dllistTest.java
 * Description: Unit tests for dllist.java
 */

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class dllistTest {

    @Test
    public void startsEmptyTest(){
        dllist lst = new dllist();
        assertEquals(true, lst.isEmpty());
    }
   
    @Test
    public void insertEmptyTest(){
        dllist lst = new dllist();
        lst.insert("Item", dllist.position.LAST);
        assertEquals(false, lst.isEmpty());
    }

    @Test
    public void insertEnd(){
        dllist lst = new dllist();
        lst.insert("Item", dllist.position.LAST);
        assertEquals("Item", lst.getItem());
    }

    @Test
    public void insertEndTwo(){
	dllist lst = new dllist();
	lst.insert("Item 1", dllist.position.LAST);
	lst.insert("Item 2", dllist.position.LAST);
	assertEquals("Item 2", lst.getItem());
    }

    @Test
    public void insertFirst(){
    	dllist lst = new dllist();
	lst.insert("Item", dllist.position.FIRST);
        assertEquals("Item", lst.getItem());
    }
    
    @Test
    public void insertFirstTwo(){
	dllist lst = new dllist();
	lst.insert("Item 1", dllist.position.FIRST);
	lst.insert("Item 2", dllist.position.FIRST);
	assertEquals("Item 2", lst.getItem());
    }

    @Test
    public void setPositionFirst(){
	dllist lst = new dllist();
	lst.insert("Item 1", dllist.position.LAST);
	lst.insert("Item 2", dllist.position.LAST);
 	lst.setPosition(dllist.position.FIRST);
	assertEquals("Item 1", lst.getItem());
    }

    @Test
    public void setPositionLast(){
	dllist lst = new dllist();
	lst.insert("Item 1", dllist.position.FIRST);
	lst.insert("Item 2", dllist.position.FIRST);
	lst.setPosition(dllist.position.LAST);
	assertEquals("Item 1", lst.getItem());
    }
    
    @Test
    public void insertListLast(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.LAST);
	lst.insert("B", dllist.position.LAST);
	lst.insert("C", dllist.position.LAST);
	lst.insert("D", dllist.position.PREVIOUS);
	lst.setPosition(dllist.position.LAST);
	assertEquals("C", lst.getItem());
    }
 
    @Test
    public void insertListFirst(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.FIRST);
	lst.insert("B", dllist.position.FIRST);
	lst.insert("C", dllist.position.FIRST);
	lst.insert("D", dllist.position.FOLLOWING);
	lst.setPosition(dllist.position.FIRST);
	assertEquals("C", lst.getItem());
	}

    @Test
    public void randList(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.FIRST);
	lst.insert("B", dllist.position.FOLLOWING);
	lst.insert("C", dllist.position.FIRST);
	lst.insert("D", dllist.position.LAST);
	lst.insert("E", dllist.position.PREVIOUS);
	lst.setPosition(dllist.position.FIRST);
	assertEquals("C", lst.getItem());
	lst.setPosition(dllist.position.FOLLOWING);
	assertEquals("A", lst.getItem());
	lst.setPosition(dllist.position.LAST);
	assertEquals("D", lst.getItem());
	lst.setPosition(dllist.position.PREVIOUS);
	assertEquals("E", lst.getItem());
	lst.setPosition(dllist.position.PREVIOUS);
	assertEquals("B", lst.getItem());
    }

    @Test 
    public void randListGetPos(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.FIRST);
	lst.insert("B", dllist.position.FOLLOWING);
	lst.insert("C", dllist.position.FIRST);
	lst.insert("D", dllist.position.LAST);
	lst.insert("E", dllist.position.PREVIOUS);
	lst.setPosition(dllist.position.FIRST);
	assertEquals(0, lst.getPosition());
    }
   
    @Test
    public void deleteLast(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.FIRST);
	lst.insert("B", dllist.position.FOLLOWING);
	lst.insert("C", dllist.position.FOLLOWING);
	lst.delete();
	assertEquals("B", lst.getItem());

    }

    @Test
    public void deleteFirst(){
	dllist lst = new dllist();
	lst.insert("A", dllist.position.LAST);
	lst.insert("B", dllist.position.PREVIOUS);
	lst.insert("C", dllist.position.PREVIOUS);
	lst.delete();
	assertEquals("B", lst.getItem());
    }
   
}
