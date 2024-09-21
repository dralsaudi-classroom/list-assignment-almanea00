package com.example.project;

public class ListTester {
    public static <T> void circularLeftShift(List <T> list, int n)
    {
    	if(list.empty())
    		return;
    	
    	int size = 1;
    	list.findFirst();
    	
        while(!list.last()) {
        	list.findNext();
        	size++;
        }
        
        T[] temp = (T[]) new Object[size];
        
        int counter = 0;
        list.findFirst();
        
        while(!list.last()) {
        	temp[(counter+n*(size-1)) % size] = list.retrieve();
        	list.findNext();
        	counter++;
        }
        
        temp[(counter+n*(size-1)) % size] = list.retrieve();
        
        counter = 0;
        list.findFirst();
        
        while(!list.last()) {
        	list.update(temp[counter]);
        	list.findNext();
        	counter++;
        }
        list.update(temp[counter]);
    }
    public static <T> void reverseCopy(DLL<T> l1, DLL<T> l2)
    {
    	if (l1.empty())
			return;

		while (!l1.last()) {
			l1.findNext();
		}

		l2.findFirst();
		while (!l1.first()) {
			l2.insert(l1.retrieve());
			l1.findPrevious();
		}
		l2.insert(l1.retrieve());
    }
}
