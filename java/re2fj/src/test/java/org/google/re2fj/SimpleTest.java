/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.google.re2fj;

import java.io.IOException;
import org.google.re2fj.wrapper.Re2Options;
import org.google.re2fj.wrapper.Re2Set;
import org.google.re2fj.wrapper.StringPointer;

import org.google.re2fj.util.Initializer;
import org.google.re2fj.wrapper.IntVector;
/**
 *
 * @author hzx
 */
public class SimpleTest {
    public static void main(String[] args) throws IOException {
        Initializer.InitRe2FJ();
        
        Re2Options option = new Re2Options();
        option.set_max_mem(100*1024*1024);
        
        Re2Set reSet = new Re2Set(option, 0);
        
        StringPointer stringP = new StringPointer();
        
        String pat0 = "1234.*?789";
        String pat1 = "476567954976";
        String pat2 = "12345.*?89";
        
        System.out.println(reSet.Add(pat0, stringP.Pointer()));
        System.out.println(reSet.Add(pat1, stringP.Pointer()));
        System.out.println(reSet.Add(pat2, stringP.Pointer()));
        
        IntVector vec = new IntVector();
        
        String line = "1242312345678910";
        System.out.println(reSet.Compile());
        System.out.println(reSet.Match(line, vec));
        
        for(int i=0; i<vec.size(); i++) {
            System.out.print(vec.get(i) + "\t");
        }
        System.out.println();
    }
}
