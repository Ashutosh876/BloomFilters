package org.example;

import org.apache.commons.codec.digest.MurmurHash2;
import java.util.*;

class MurMurBloomFilter implements BloomFilter {

  private byte[] bitArray;
  private int filterSize;

  public MurMurBloomFilter(int filterSize) {
    this.filterSize = filterSize;
    this.bitArray = new byte[filterSize];
    Arrays.fill(bitArray, (byte) 0);
  }

  @Override
  public boolean doesExists(String s) {
    int hash = MurmurHash2.hash32(s);
    int index = Math.abs(hash % filterSize);
    return (bitArray[index]) != 0;
  }

  public void add(String s) {
    int hash = MurmurHash2.hash32(s);
    int index = Math.abs(hash % filterSize);
    bitArray[index] = (byte) 1;
  }

  public void remove(String s) {
  }

  public static void main(String[] args) {

    MurMurBloomFilter murMurBloomFilter = new MurMurBloomFilter(6);
    murMurBloomFilter.add("a");
    murMurBloomFilter.add("ab");
    murMurBloomFilter.add("abc");
    murMurBloomFilter.add("abcd");
    System.out.println(murMurBloomFilter.doesExists("abcd"));
  }
  
}
