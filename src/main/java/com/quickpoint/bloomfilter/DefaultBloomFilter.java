/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import java.util.BitSet;

import com.quickpoint.bloomfilter.hashfunc.HashFunction;

/**
 * Ĭ�ϵ�BloomFilterʵ�֡�
 * 
 * @author kui.lijk
 * @version $Id: DefaultBloomFilter.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public class DefaultBloomFilter implements BloomFilter {

    /** �ַ������� */
    private int            count;

    /** λͼ��С */
    private int            size;

    /** λͼ */
    private BitSet         bits;

    /** ��ϣ���� */
    private HashFunction[] hashFuncs;

    /** �Ƿ��ַ�����Сд����, Ĭ��Ϊ���� */
    private boolean        caseSensitive;

    /**
     * ������Сд���е�BloomFilter��
     * 
     * @param size  λͼ��С
     * @param hashFuncs ��ϣ����
     */
    public DefaultBloomFilter(int size, HashFunction[] hashFuncs) {
        // ��Сд����
        this(size, hashFuncs, true);
    }

    /**
     * ����BloomFilter��
     * 
     * @param size  λͼ��С
     * @param hashFuncs ��ϣ����
     * @param caseSensitive �ַ�����Сд����,true��ʾ���У�false��ʾ������
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
