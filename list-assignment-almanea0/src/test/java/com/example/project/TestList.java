package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestList {

   @Test
   public void testMostFrequentElement1()
   {
      LinkedList<Character> list = new LinkedList<Character>();
      list.insert('A');
      list.insert('B');
      list.insert('C');
      list.insert('B');
      list.insert('C');
      list.insert('D');
      list.insert('E');
      assertEquals('B', list.mostFrequentElement());
   }
   @Test
   public void testMostFrequentElement2()
   {
      LinkedList<Character> list = new LinkedList<Character>();
      list.insert('A');
      list.insert('A');
      list.insert('A');
      list.insert('A');
      assertEquals('A', list.mostFrequentElement());
   }
   @Test
   public void testMostFrequentElement3()
   {
      LinkedList<String> list = new LinkedList<String>();
      list.insert("Hello");
      assertEquals("Hello", list.mostFrequentElement());
   }
   @Test
   public void testMostFrequentElement4()
   {
      LinkedList<Character> list = new LinkedList<Character>();
      list.insert('B');
      list.insert('A');
      list.insert('A');
      list.insert('B');
      list.insert('B');
      assertEquals('B', list.mostFrequentElement());
   }
   @Test
   public void testMostFrequentElement5()
   {
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.insert(1);
      list.insert(1);
      list.insert(2);
      list.insert(2);
      list.insert(2);
      assertEquals(Integer.valueOf(2), list.mostFrequentElement());
   }
   @Test
   public void testCircularLeftShift1()
   {
      LinkedList<Character> list = new LinkedList<Character>();
      list.insert('A');
      list.insert('B');
      list.insert('C');
      list.insert('D');
      list.insert('E');
      ListTester.circularLeftShift(list, 2);
      list.findFirst();
      assertEquals(Character.valueOf('C'), list.retrieve());
      list.findNext();
      assertEquals(Character.valueOf('D'), list.retrieve());
      list.findNext();
      assertEquals(Character.valueOf('E'), list.retrieve());
      list.findNext();
      assertEquals(Character.valueOf('A'), list.retrieve());
      list.findNext();
      assertEquals(Character.valueOf('B'), list.retrieve());
   }
   @Test
   public void testCircularLeftShift2()
   {
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.insert(1);
      list.insert(2);
      ListTester.circularLeftShift(list, 3);
      list.findFirst();
      assertEquals(Integer.valueOf(2), list.retrieve());
      list.findNext();
      assertEquals(Integer.valueOf(1), list.retrieve());
   }
   @Test
   public void testCircularLeftShift3()
   {
      LinkedList<Integer> list = new LinkedList<Integer>();
      list.insert(1);
      ListTester.circularLeftShift(list, 1);
      list.findFirst();
      assertEquals(Integer.valueOf(1), list.retrieve());
   }
   @Test
   public void testCircularLeftShift4()
   {
      LinkedList<String> list = new LinkedList<String>();
      list.insert("First");
      list.insert("Second");
      list.insert("First");
      list.insert("Fourth");
      list.insert("Fifth");
      ListTester.circularLeftShift(list, 2);
      list.findFirst();
      assertEquals("First", list.retrieve());
      list.findNext();
      assertEquals("Fourth", list.retrieve());
      list.findNext();
      assertEquals("Fifth", list.retrieve());
      list.findNext();
      assertEquals("First", list.retrieve());
      list.findNext();
      assertEquals("Second", list.retrieve());
   }
   @Test
   public void testRemoveBetween1()
   {
      DLL<Character> list = new DLL<Character>();
      list.insert('A');
      list.insert('B');
      list.insert('C');
      list.insert('D');
      list.insert('E');
      list.insert('F');
      list.removeBetween('B', 'E');
      assertEquals('A', list.retrieve());
      list.findNext();
      assertEquals('B', list.retrieve());
      list.findNext();
      assertEquals('E', list.retrieve());
      list.findNext();
      assertEquals('F', list.retrieve());
   }
   @Test
   public void testRemoveBetween2()
   {
      DLL<Character> list = new DLL<Character>();
      list.insert('A');
      list.insert('B');
      list.insert('C');
      list.insert('D');
      list.insert('E');
      list.insert('F');
      list.removeBetween('A', 'F');
      assertEquals('A', list.retrieve());
      list.findNext();
      assertEquals('F', list.retrieve());
   }
   @Test
   public void testRemoveBetween3()
   {
      DLL<Integer> list = new DLL<Integer>();
      list.insert(1);
      list.removeBetween(1, 3);
      assertEquals(Integer.valueOf(1), list.retrieve());
   }
   @Test
   public void testRemoveBetween4()
   {
      DLL<String> list = new DLL<String>();
      list.insert("First");
      list.insert("Second");
      list.insert("Third");
      list.insert("Fourth");
      list.removeBetween("First", "Fifth");
      list.findFirst();
      assertEquals("First", list.retrieve());
      list.findNext();
      assertEquals("Second", list.retrieve());
      list.findNext();
      assertEquals("Third", list.retrieve());
      list.findNext();
      assertEquals("Fourth", list.retrieve());
      list.removeBetween("Zero", "Fourth");
      list.findFirst();
      assertEquals("First", list.retrieve());
      list.findNext();
      assertEquals("Second", list.retrieve());
      list.findNext();
      assertEquals("Third", list.retrieve());
      list.findNext();
      assertEquals("Fourth", list.retrieve());
   }
   @Test
   public void testReverseCopy1()
   {
      DLL<Character> list1 = new DLL<Character>();
      DLL<Character> list2 = new DLL<Character>();
      list1.insert('A');
      list1.insert('B');
      list1.insert('C');
      list1.insert('D');
      ListTester.reverseCopy(list1, list2);
      list2.findFirst();
      assertEquals('D', list2.retrieve());
      list2.findNext();
      assertEquals('C', list2.retrieve());
      list2.findNext();
      assertEquals('B', list2.retrieve());
      list2.findNext();
      assertEquals('A', list2.retrieve());
   }
   @Test
   public void testReverseCopy2()
   {
      DLL<Character> list1 = new DLL<Character>();
      DLL<Character> list2 = new DLL<Character>();
      list1.insert('A');
      list1.insert('A');
      list1.insert('B');
      list1.insert('B');
      ListTester.reverseCopy(list1, list2);
      list2.findFirst();
      assertEquals('B', list2.retrieve());
      list2.findNext();
      assertEquals('B', list2.retrieve());
      list2.findNext();
      assertEquals('A', list2.retrieve());
      list2.findNext();
      assertEquals('A', list2.retrieve());
      list1.findFirst();
      list1.remove();
      list1.remove();
      while(!list2.empty())
         list2.remove();
      ListTester.reverseCopy(list1, list2);
      list2.findFirst();
      assertEquals('B', list2.retrieve());
      list2.findNext();
      assertEquals('B', list2.retrieve());
      
   }
   @Test
   public void testReverseCopy3()
   {
      DLL<Integer> list1 = new DLL<Integer>();
      DLL<Integer> list2 = new DLL<Integer>();
      ListTester.reverseCopy(list1, list2);
      assertTrue(list2.empty());
      list1.insert(1);
      ListTester.reverseCopy(list1, list2);
      assertEquals(Integer.valueOf(1), list2.retrieve());
   }
   @Test
   public void testReverseCopy4()
   {
      DLL<String> list1 = new DLL<String>();
      DLL<String> list2 = new DLL<String>();
      list1.insert("First");
      list1.insert("Second");
      list1.insert("Third");
      ListTester.reverseCopy(list1, list2);
      list2.findFirst();
      assertEquals("Third", list2.retrieve());
      list2.findNext();
      assertEquals("Second", list2.retrieve());
      list2.findNext();
      assertEquals("First", list2.retrieve());
   }
}
