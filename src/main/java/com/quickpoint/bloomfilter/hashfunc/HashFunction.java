/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter.hashfunc;

import java.io.Serializable;

/**
 * ��ϣ����
 * 
 * <p>
 * �����˶��ڹ�ϣ�����ķ�װ��
 * </p>
 * 
 * @author kui.lijk
 * @version $Id: HashFunction.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public interface HashFunction extends Serializable {

    /**
     * �����ݽ��й�ϣ��
     * 
     * @param content ����ϣ������
     * @return ��ϣ�������ϣֵ��
     */
    int hash(Object content);
}
