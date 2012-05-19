/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import java.util.BitSet;

import com.quickpoint.bloomfilter.hashfunc.HashFunction;

/**
 * 默认的BloomFilter实现。
 * 
 * @author kui.lijk
 * @version $Id: DefaultBloomFilter.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public class DefaultBloomFilter implements BloomFilter {

    /** 字符串个数 */
    private int            count;

    /** 位图大小 */
    private int            size;

    /** 位图 */
    private BitSet         bits;

    /** 哈希函数 */
    private HashFunction[] hashFuncs;

    /** 是否字符串大小写敏感, 默认为敏感 */
    private boolean        caseSensitive;

    /**
     * 创建大小写敏感的BloomFilter。
     * 
     * @param size  位图大小
     * @param hashFuncs 哈希函数
     */
    public DefaultBloomFilter(int size, HashFunction[] hashFuncs) {
        // 大小写敏感
        this(size, hashFuncs, true);
    }

    /**
     * 创建BloomFilter。
     * 
     * @param size  位图大小
     * @param hashFuncs 哈希函数
     * @param caseSensitive 字符串大小写敏感,true表示敏感，false表示不敏感
     */
    public DefaultBloomFilter(int size, HashFunction[] hashFuncs, boolean caseSensitive) {
        if (0 > size) {
            throw new IllegalArgumentException("illegal size:" + size);
        }

        if (null == hashFuncs || hashFuncs.length < 0) {
            throw new IllegalArgumentException("illegal functions.");
        }

        this.count = 0;
        this.size = size;
        this.bits = new BitSet(size);
        this.hashFuncs = hashFuncs;
        this.caseSensitive = caseSensitive;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#add(java.lang.String)
     */
    @Override
    public void add(String str) {
        if (null == str) {
            return;
        }

        if (contains(str)) {
            return;
        }

        for (HashFunction eachFunc : hashFuncs) {
            bits.set(eachFunc.hash(str), true);
        }

        count++;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#contains(java.lang.String)
     */
    @Override
    public boolean contains(String str) {
        if (null == str) {
            return false;
        }

        if (!caseSensitive) {
            str = str.toLowerCase();
        }

        for (HashFunction eachFunc : hashFuncs) {
            boolean exist = bits.get(eachFunc.hash(str));
            if (!exist) {
                return false;
            }
        }

        return true;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#clear()
     */
    @Override
    public void clear() {
        bits.clear();
        this.count = 0;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#size()
     */
    @Override
    public int size() {
        return size;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#count()
     */
    @Override
    public int count() {
        return count;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.BloomFilter#getBit(int)
     */
    @Override
    public boolean getBit(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index is out of scope, " + index);
        }

        return bits.get(index);
    }

}
