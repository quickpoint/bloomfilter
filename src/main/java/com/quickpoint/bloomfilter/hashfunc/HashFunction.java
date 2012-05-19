/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter.hashfunc;

import java.io.Serializable;

/**
 * 哈希函数
 * 
 * <p>
 * 定义了对于哈希函数的封装。
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: HashFunction.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface HashFunction extends Serializable {

    /**
     * 对内容进行哈希。
     * 
     * @param content 待哈希的内容
     * @return 哈希结果，哈希值。
     */
    int hash(Object content);
}
