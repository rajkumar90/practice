package practice.threads;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
	
	static class Node<T> {
		T val;
		Node<T> next;
	}
	
	LinkedList<T> head;
//	Node<T> head;
	
//	Node<T> tail;
	int capacity;
	ReentrantLock takeLock = new ReentrantLock();
	ReentrantLock putLock = new ReentrantLock();
	Condition notFull = putLock.newCondition();
	Condition notEmpty = takeLock.newCondition();
	
	MyBlockingQueue(int capacity) {
		this.capacity = capacity;
		head = new LinkedList<T>();
	}
	
	public void put(T e) throws InterruptedException {
		final ReentrantLock p = this.putLock;
		p.lock();
		try {
		while(capacity == head.size())
			notFull.await();
		
		head.add(e);
		signalNotEmpty();
		} finally {
			p.unlock();
		}
		
	}
	
	private void signalNotEmpty() {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			notEmpty.signal();
		} finally {
			takeLock.unlock();
		}
	}

	private void signalNotFull() {
		final ReentrantLock putLock = this.putLock;
		putLock.lock();
		try {
			notFull.signal();
		} finally {
			putLock.unlock();
		}
	}
	
	public T take() throws InterruptedException {
		final ReentrantLock takeLock = this.takeLock;
		takeLock.lock();
		try {
			while(head.size() == 0)
				notEmpty.await();
			
			signalNotFull();
			return head.remove();
		} finally {
			takeLock.unlock();
		}
	}
}
