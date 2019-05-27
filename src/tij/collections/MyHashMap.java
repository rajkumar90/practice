package tij.collections;

import java.util.LinkedList;

public class MyHashMap<K,V> {
	static class Node<K,V> {
		Integer hashcode;
		K key;
		V val;
	}
	
	private final int SIZE = 1000;
	LinkedList<Node<K,V>>[] buckets;
	
	@SuppressWarnings("unchecked")
	MyHashMap() {
		buckets = new LinkedList[SIZE];
		for (int i = 0; i < SIZE; i++)
			buckets[i] = new LinkedList<Node<K,V>>();
	}
	
	public V get(K key) {
		int index = key.hashCode() % SIZE;
		LinkedList<Node<K,V>> list = buckets[index];
		
		V result = null;
		for (Node<K,V> node : list) {
			if (node.key.equals(key)) {
				result = node.val;
				break;
			}
		}
		return result;
	}
	
	public V put(K key, V val) {
		int index = key.hashCode() % SIZE;
		LinkedList<Node<K,V>> list = buckets[index];
		Node<K,V> node = new Node<K, V>();
		node.key = key;
		node.val = val;
		node.hashcode = key.hashCode();
		list.add(node);
		return val;
	}
	
	public static void main(String[] args) {
		MyHashMap<String, String> hm = new MyHashMap<String, String>();
		hm.put("a", "1");
		System.out.println(hm.get("a"));
		hm.put("ab", "2");
		System.out.println(hm.get("ab"));
	}

}
