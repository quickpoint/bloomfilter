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
 * ����ԭ���: http://en.wikipedia.org/wiki/Bloom_filter
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: BloomFilter.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface BloomFilter {

    /**
     * �����ַ�����
     * 
     * <ul>
     * <li>��������������ַ������ı������������</li>
     * <li>����ַ����Ѿ��ڹ������д��ڣ������ӡ�</li>
     * </ul>
     * 
     * @param str �����ӵ��ַ���
     */
    void add(String str);

    /**
     * �ж��ַ����Ƿ��ڹ������С�
     * 
     * <ul>
     * <li>����ַ���Ϊnull�����ز�����</li>
     * <li>��������������ݱ��������ڣ���ʵ�ʵĴ洢��һ��������</li>
     * <li>��������������ݱ������ڣ���ʵ�ʵĴ洢�в�һ����ʵ�ʴ���(false positive)</li>
     * </ul>
     * 
     * @param str ���жϵ��ַ���
     * @return true��ʾ���ڣ�false��ʾ�����ڡ�
     */
    boolean contains(String str);

    /**
     * ������еı��λ��
     */
    void clear();

    /**
     * ��ȡλͼ�Ĵ�С��
     * 
     * @return λͼ��С
     */
    int size();

    /**
     * ��ȡ�������е��ַ���������
     * 
     * @return �ַ���ʵ�ʸ���
     */
    int count();

    /**
     * ��ȡλͼ��ĳλ��ʵ��ֵ��
     * 
     * @param index λͼ�е�λ����
     * @return  true��ʾ�Ѿ����ã�false��ʾδ���á�
     */
    boolean getBit(int index);
}
