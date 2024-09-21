package com.example.project;

import java.util.HashMap;

public class LinkedList<T> implements List<T> {
	private Node<T> head;
	private Node<T> current;

	public LinkedList() {
		head = current = null;
	}

	public boolean empty() {
		return head == null;
	}

	public boolean last() {
		return current.next == null;
	}

	public boolean full() {
		return false;
	}

	public void findFirst() {
		current = head;
	}

	public void findNext() {
		current = current.next;
	}

	public T retrieve() {
		return current.data;
	}

	public void update(T e) {
		current.data = e;
	}

	public void insert(T e) {
		if (empty()) {
			current = head = new Node<T>(e);
		} else {
			Node<T> tmp = current.next;
			current.next = new Node<T>(e);
			current = current.next;
			current.next = tmp;
		}
	}

	public void remove() {
		if (current == head) {
			head = head.next;
		} else {
			Node<T> tmp = head;
			while (tmp.next != current) {
				tmp = tmp.next;
			}
			tmp.next = current.next;
		}
		if (current.next == null) {
			current = head;
		} else {
			current = current.next;
		}
	}

	public T mostFrequentElement() {
		HashMap<T, Integer> freq = new HashMap<>();

		if (head == null)
			return null;

		current = head;
		T i;
		
		while (current != null) {
			i = current.data;
			if (freq.containsKey(i)) 
				freq.put(i, freq.get(i)+1);
			
			else {
				freq.put(i, 1);
			}

			current = current.next;
		}

		T key = head.data;
		int freqMax = freq.get(head.data);

		current = head.next;
		while (current != null) {
			i = current.data;
			
			if (freq.get(i) > freqMax) {
				freqMax = freq.get(i);
				key = i;
			}
				
			
			current = current.next;
		}

		return key;

	}

}
