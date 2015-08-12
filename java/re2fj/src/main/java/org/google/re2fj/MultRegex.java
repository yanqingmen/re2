/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.google.re2fj;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.google.re2fj.util.Initializer;
import org.google.re2fj.wrapper.IntVector;
import org.google.re2fj.wrapper.Re2Options;
import org.google.re2fj.wrapper.Re2Set;
import org.google.re2fj.wrapper.StringPointer;


/**
 * Fast Multiple Regex Match via re2
 * @author hzx
 */
public class MultRegex {
    private static final Log logger = LogFactory.getLog(MultRegex.class);
    
    Re2Set reSet;
    Re2Options option;
    StringPointer errP;
    IntVector vec;
    Map<Integer, String> regexMap;
    
    //load native library
    static {
        try{
            Initializer.InitRe2FJ();
        }
        catch (IOException ex) {
            logger.error("load native library failed");
            logger.error(ex);
        }
    }
    
    
    public MultRegex() {
        option = new Re2Options();
        reSet = new Re2Set(option, 0);
        init();
    }
    
    /**
     * set max memeory for reSet, e.g. 100 means 100M
     * @param mem 
     */
    public MultRegex(int mem) {
        option = new Re2Options();
        option.set_max_mem(mem*1024*1024);
        reSet = new Re2Set(option, 0);
        init();
    }
    
    /**
     * set max memeory for reSet, e.g. 100 means 100M; 
     * set archor for Type of match. 
     *     archor == 0 means No anchoring
     *     archor == 1 means Anchor at start only
     *     archor == 2 means Anchor at start and end
     * @param mem
     * @param archor 
     */
    public MultRegex(int mem, int archor) {
        option = new Re2Options();
        option.set_max_mem(mem*1024*1024);
        reSet = new Re2Set(option, archor);
        init();
    }
    
    private void init() {
        errP = new StringPointer();
        vec = new IntVector();
        regexMap = new HashMap<>();
    }
    
    /**
     * add pattern to regex machine
     * @param pattern
     * @return index for given pattern
     */
    public int addPattern(String pattern) {
        int index = reSet.Add(pattern, errP.Pointer());
        regexMap.put(index, pattern);
        return index;
    }
    
    /**
     * add patterns to regex machine
     * @param patterns
     * @return indexes for given patterns
     */
    public int[] addPatterns(String[] patterns) {
        int[] indexes = new int[patterns.length];
        for(int i=0; i<patterns.length; i++) {
            indexes[i] = addPattern(patterns[i]);
        }
        return indexes;
    }
    
    /**
     * add patterns to regex machine
     * @param patterns
     * @return indexes for given patterns
     */
    public int[] addPatterns(List<String> patterns) {
        int[] indexes = new int[patterns.size()];
        for(int i=0; i<patterns.size(); i++) {
            indexes[i] = addPattern(patterns.get(i));
        }
        return indexes;
    }
    
    
    
    /**
     * compile the regex machine, should be called before match
     * @return 
     */
    public boolean compile() {
        return reSet.Compile();
    }
    
    /**
     * return the matched regex patterns
     * @param text
     * @return 
     */
    public String[] match(String text) {
        reSet.Match(text, vec);
        if(vec.isEmpty()) {
            return null;
        }
        String[] patterns = new String[(int) vec.size()];
        for(int i=0; i<vec.size(); i++) {
            patterns[i] = regexMap.get(vec.get(i));
        }
        
        return patterns;
    }
    
    /**
     * return the matched regex indexes
     * @param text
     * @return 
     */
    public int[] getMatchIds(String text) {
        reSet.Match(text, vec);
        if(vec.isEmpty()) {
            return null;
        }
        int[] indexes = new int[(int) vec.size()];
         for(int i=0; i<vec.size(); i++) {
            indexes[i] = vec.get(i);
        }
         return indexes;
    }
}
