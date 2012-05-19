/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import com.quickpoint.bloomfilter.hashfunc.HashFunction;

/**
 * BloomFilter������
 * 
 * <p>
 * ��ƴ˹�����Ŀ����Ϊ�˷�װBloomFilter�Ĵ������̡�
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: BloomFilterFactory.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface BloomFilterFactory {

    /**
     * ����BloomFilter��
     * 
     * <ul>
     * <li>�̶���С��λͼ</li>
     * <li>�ַ����ַ���Сд����</li>
     * </ul>
     * 
     * @param size λͼ�Ĵ�С
     * @return BloomFilter 
     */
    BloomFilter createFilter(int size);

    /**
     * ����BloomFilter��
     * 
     * <ul>
     * <li>�̶���С��λͼ</li>
     * </ul>
     * 
     * @param size  λͼ�Ĵ�С
     * @param caseSensitive true �ַ���Сд���У�false �ַ���Сд������
     * @return BloomFilter
     */
    BloomFilter createFilter(int size, boolean caseSensitive);

    /**
     * ���ӹ�ϣ������
     * 
     * @param hashFunc  ��ϣ����
     */
    void addHashFunction(HashFunction hashFunc);

    /**
     * ɾ����ϣ������
     * 
     * @param hashFunc  ��ϣ����
     */
    void removeHashFunction(HashFunction hashFunc);
}
