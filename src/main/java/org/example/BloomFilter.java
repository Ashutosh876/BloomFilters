package org.example;

interface BloomFilter {

  public boolean doesExists(String s);

  public void add(String s);

  public void remove(String s);
}

