/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter.hashfunc;

/**
 * �򵥵��ַ�����ϣ������
 * 
 * @author kui.lijk
 * @version $Id: SimpleStringHashFunction.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public class SimpleStringHashFunction extends AbstractHashFunction {

    /** serialVersionUID. */
    private static final long serialVersionUID = 174034376328516223L;

    /** λ�����˷�Χ */
    private int               cap;
    
    /** ������ */
    private int               seed;

    /**
     * �����򵥵��ַ�����ϣ������
     * 
     * @param cap   λ�����˷�Χ
     * @param seed  ������
     */
    public SimpleStringHashFunction(int cap, int seed) {
        this.cap = cap;
        this.seed = seed;
    }

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.AbstractHashFunction#doHash(java.lang.Object)
     */
    @Override
    protected int doHash(Object content) {

        String str = content.toString();

        int result = 0;
        for (int len = str.length(), i = 0; i < len; i++) {
            result = seed * result + str.charAt(i);
        }

        return (cap - 1) & result;
    }

}
