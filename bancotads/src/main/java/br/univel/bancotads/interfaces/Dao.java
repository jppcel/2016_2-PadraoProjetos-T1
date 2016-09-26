package br.univel.bancotads.interfaces;

import java.util.Map;

public interface Dao<T, K> {
	public void insert(T t);
	public void update(T t, K k);
	public void delete(K k);
	public T search(K k);
	public Map<K,T> search(String field, String text);
	public Map<K,T> listAll();
}
