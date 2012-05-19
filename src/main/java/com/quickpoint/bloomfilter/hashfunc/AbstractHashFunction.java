/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter.hashfunc;

/**
 * 抽象的哈希函数，是哈希函数类层次基础。
 * 
 * @author kui.lijk
 * @version $Id: AbstractHashFunction.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public abstract class AbstractHashFunction implements HashFunction {

    /** serialVersionUID. */
    private static final long serialVersionUID = -1731119065054580294L;

    /** 
     * @see com.quickpoint.bloomfilter.hashfunc.HashFunction#hash(java.lang.Object)
     */
    @Override
    public int hash(Object content) {
        if (null == content) {
            return 0;
        }

        return doHash(content);
    }

    /**
     * 实际的hash计算。
     * 
     * @param content 待计算的内容
     * @return  hash值
     */
    protected abstract int doHash(Object content);
}
