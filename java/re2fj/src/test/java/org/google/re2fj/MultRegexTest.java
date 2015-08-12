/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.google.re2fj;


import java.util.Arrays;
import junit.framework.TestCase;
import org.junit.Test;
/**
 *
 * @author hzx
 */
public class MultRegexTest {
    @Test
    public void testMultRegMatch() {
        MultRegex mReg = new MultRegex();
        String[] patterns = new String[] {"123.*?567","234.*?789","123456.*",".*890.*","7789.*"};
        mReg.addPatterns(patterns);
        mReg.compile();
        String text = "123456789";
        String[] matches = mReg.match(text);
        int[] indexes = mReg.getMatchIds(text);
        TestCase.assertTrue(matches.length==3);
        System.out.println(Arrays.toString(matches));
        System.out.println(Arrays.toString(indexes));
    }
}
