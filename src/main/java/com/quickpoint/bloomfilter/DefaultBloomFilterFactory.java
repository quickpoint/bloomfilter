/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import java.util.HashSet;
import java.util.Set;

import com.quickpoint.bloomfilter.hashfunc.HashFunction;

/**
 * 默认的BloomFilter工厂实现。
 * 
 * @author kui.lijk
 * @version $Id: DefaultBloomFilterFactory.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public class DefaultBloomFilterFactory implements BloomFilterFactory {

    /** 哈希函数 */
    private Set<HashFunction> hashFuncs = new HashSet<HashFunction>();

    public DefaultBloomFilterFactory() {
    }

    /** 
     * @see com.quickpoint.bloomfilter.BloomFilterFactory#createFilter(int)
     */
    @Override
    public BloomFilter createFilter(int size) {
        return createFilter(size, true);
    }

    /** 
     * @see com.quickpoint.bloomfilter.BloomFilterFactory#createFilter(boolean)
     */
    @Override
    public BloomFilter createFilter(int size, boolean caseSensitive) {
        return new DefaultBloomFilter(size, getHashFunctions(), caseSensitive);
    }

    /** 
     * @see com.quickpoint.bloomfilter.BloomFilterFactory#addHashFunction(com.quickpoint.bloomfilter.hashfunc.HashFunction)
     */
    @Override
    public void addHashFunction(HashFunction hashFunc) {
        if (null == hashFunc) {
            return;
        }

        if (hashFuncs.contains(hashFunc)) {
            return;
        }

        hashFuncs.add(hashFunc);
    }

    /** 
     * @see com.quickpoint.bloomfilter.BloomFilterFactory#removeHashFunction(com.quickpoint.bloomfilter.hashfunc.HashFunction)
     */
    @Override
    public void removeHashFunction(HashFunction hashFunc) {
        if (null == hashFunc) {
            return;
        }

        hashFuncs.remove(hashFunc);
    }

    /**
     * 返回所有的哈希函数。
     * 
     * @return 哈希函数数组
     */
    private HashFunction[] getHashFunctions() {
        return hashFuncs.toArray(new HashFunction[0]);
    }
}
