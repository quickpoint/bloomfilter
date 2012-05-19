/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

/**
 * BloomFilter
 * 
 * <p>
 * 具体原理见: http://en.wikipedia.org/wiki/Bloom_filter
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: BloomFilter.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface BloomFilter {

    /**
     * 增加字符串。
     * 
     * <ul>
     * <li>向过滤器中增加字符串，改变过滤器的内容</li>
     * <li>如果字符串已经在过滤器中存在，则不增加。</li>
     * </ul>
     * 
     * @param str 待增加的字符串
     */
    void add(String str);

    /**
     * 判断字符串是否在过滤器中。
     * 
     * <ul>
     * <li>如果字符串为null，返回不存在</li>
     * <li>如果过滤器中内容表明不存在，则实际的存储中一定不存在</li>
     * <li>如果过滤器中内容表明存在，则实际的存储中不一定是实际存在(false positive)</li>
     * </ul>
     * 
     * @param str 待判断的字符串
     * @return true表示存在，false表示不存在。
     */
    boolean contains(String str);

    /**
     * 清除所有的标记位。
     */
    void clear();

    /**
     * 获取位图的大小。
     * 
     * @return 位图大小
     */
    int size();

    /**
     * 获取过滤器中的字符串个数。
     * 
     * @return 字符串实际个数
     */
    int count();

    /**
     * 获取位图的某位的实际值。
     * 
     * @param index 位图中的位索引
     * @return  true表示已经设置，false表示未设置。
     */
    boolean getBit(int index);
}
