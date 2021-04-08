package com.zipcodewilmington.singlylinkedlist;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void constructorTest() {
        // Given
        int expectedSize = 0;
        SinglyLinkedList<String> actual = new SinglyLinkedList<String>();

        // When
        int actualSize = actual.size();

        // Then
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void addTest() {
        // Given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();

        // When
        sll.add(4);
        sll.add(11);

        // Then
        Assert.assertEquals(2, (int) sll.size());
        Assert.assertEquals(4, (int) sll.get(0));
        Assert.assertEquals(11, (int) sll.get(1));
    }

    @Test
    public void removeTest() {
        // Given
        SinglyLinkedList<Long> sll = new SinglyLinkedList<Long>();

        // When
        sll.add(Long.MAX_VALUE);
        sll.add(Long.MIN_VALUE);
        sll.remove(0);

        // Then
        Assert.assertEquals(Long.MIN_VALUE, (long) sll.get(0));
    }


    @Test
    public void containsTest() {
        // Given
        SinglyLinkedList<Double> sll = new SinglyLinkedList<Double>();
        sll.add(4.11);
        sll.add(500.1);
        sll.add(431.8);

        // When
        boolean actualElem0 = sll.contains(4.11);
        boolean actualElem1 = sll.contains(500.2);
        boolean actualElem2 = sll.contains(431.8);

        // Then
        Assert.assertTrue(actualElem0);
        Assert.assertFalse(actualElem1);
        Assert.assertTrue(actualElem2);

    }

    @Test
    public void findTest(){
        // Given
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        sll.add("First");
        sll.add("Second");
        sll.add("Third");

        // When
        Integer actualFirst = sll.find("First");
        Integer actualSecond = sll.find("Second");
        Integer actualThird = sll.find("Third");

        // Then
        Assert.assertEquals(0, (int) actualFirst);
        Assert.assertEquals(1, (int) actualSecond);
        Assert.assertEquals(2, (int) actualThird);
    }

    @Test
    public void findSize() {
        // Given
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        sll.add("First");
        sll.add("Second");
        sll.add("Third");

        // When
        int actual = sll.size();

        // Then
        Assert.assertEquals(3, actual);
    }

    @Test
    public void getTest() {
        // Given
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();

        // When
        sll.add("First");
        sll.add("Second");
        String actualElem0 = sll.get(0);
        String actualElem1 = sll.get(1);

        // Then
        Assert.assertEquals("First", actualElem0);
        Assert.assertEquals("Second", actualElem1);

    }

    @Test
    public void sortTest() {
        // Given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(50);
        sll.add(4);
        sll.add(1);
        sll.add(1);
        sll.add(22);

        // When
        sll.sort();

        // Then
        Assert.assertEquals((Integer) 1, sll.get(0));
        Assert.assertEquals((Integer) 1, sll.get(1));
        Assert.assertEquals((Integer) 4, sll.get(2));
        Assert.assertEquals((Integer) 22, sll.get(3));
        Assert.assertEquals((Integer) 50, sll.get(4));

    }

    @Test
    public void testCopy() {
        // Given
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.add(50);
        sll.add(4);

        // When
        SinglyLinkedList<Integer> actual = sll.copy();
        Integer actual0 = actual.get(0);
        Integer actual1 = actual.get(1);

        // Then
        Assert.assertEquals((Integer) 50, actual0);
        Assert.assertEquals((Integer) 4, actual1);
    }
}
