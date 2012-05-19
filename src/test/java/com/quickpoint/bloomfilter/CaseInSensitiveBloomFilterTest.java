/**
 * quickpoint, jkltk2000 AT 126 DOT com.
 * Copyright (c) 2012 All Rights Reserved.
 * Code is licensed with BSD. See COPYRIGHT.BSD file. 
 */
package com.quickpoint.bloomfilter;

import junit.framework.TestCase;

import com.quickpoint.bloomfilter.hashfunc.SimpleStringHashFunction;

/**
 * CaseInSensitiveBloomFilterTest
 * 
 * @author kui.lijk
 * @version $Id: CaseInSensitiveBloomFilterTest.java, v 1.0 2012-5-19 kui.lijk Exp $
 */
public class CaseInSensitiveBloomFilterTest extends TestCase {
    private static final int DEFAULT_SIZE = 1 << 25;

    private BloomFilter      filter;

    protected void setUp() throws Exception {
        super.setUp();

        BloomFilterFactory factory = new DefaultBloomFilterFactory();
        int seeds[] = { 5, 7, 11, 13, 31, 37 };
        for (int i = 0, len = seeds.length; i < len; i++) {
            factory.addHashFunction(new SimpleStringHashFunction(DEFAULT_SIZE, seeds[i]));
        }

        filter = factory.createFilter(DEFAULT_SIZE, false);
    }

    public void test_add() {
        String str = "quickpoint";
        filter.add(str);
        assertTrue(filter.contains(str));
    }

    public void test_case_in_sensitive() {
        String str = "quickpoint";
        filter.add(str);
        assertTrue(filter.contains("QUICKPOINT"));
    }
}
