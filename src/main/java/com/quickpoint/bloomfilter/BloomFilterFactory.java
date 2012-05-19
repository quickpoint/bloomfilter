/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import com.quickpoint.bloomfilter.hashfunc.HashFunction;

/**
 * BloomFilter工厂。
 * 
 * <p>
 * 设计此工厂的目的是为了封装BloomFilter的创建过程。
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: BloomFilterFactory.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface BloomFilterFactory {

    /**
     * 创建BloomFilter。
     * 
     * <ul>
     * <li>固定大小的位图</li>
     * <li>字符串字符大小写敏感</li>
     * </ul>
     * 
     * @param size 位图的大小
     * @return BloomFilter 
     */
    BloomFilter createFilter(int size);

    /**
     * 创建BloomFilter。
     * 
     * <ul>
     * <li>固定大小的位图</li>
     * </ul>
     * 
     * @param size  位图的大小
     * @param caseSensitive true 字符大小写敏感，false 字符大小写不敏感
     * @return BloomFilter
     */
    BloomFilter createFilter(int size, boolean caseSensitive);

    /**
     * 增加哈希函数。
     * 
     * @param hashFunc  哈希函数
     */
    void addHashFunction(HashFunction hashFunc);

    /**
     * 删除哈希函数。
     * 
     * @param hashFunc  哈希函数
     */
    void removeHashFunction(HashFunction hashFunc);
}
