package com.example.interviewtest;

public interface ImageCache<K,V> {

	void put(K k,V v);
	
	V get(K k);
}
