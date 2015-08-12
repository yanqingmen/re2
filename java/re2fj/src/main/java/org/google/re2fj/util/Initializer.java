/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.google.re2fj.util;

import java.io.IOException;
import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author hzx
 */
public class Initializer {
    private static final Log logger = LogFactory.getLog(Initializer.class);
    
    static boolean initialized = false;
    public final static String nativePath = "./lib/native";
    public final static String nativeResourcePath = "/lib/native/";
    
    public static synchronized void InitRe2FJ() throws IOException {
        if(initialized == false) {
            addNativeDir(nativePath);
            try {
                System.loadLibrary("re2fj");
            } 
            catch (UnsatisfiedLinkError e) {
                try {
                    NativeUtils.loadLibraryFromJar(nativeResourcePath + System.mapLibraryName("re2fj"));
                }
                catch (IOException e1) {
                    throw e1;
                }
            }
            initialized = true;
        }
    }
    
    public static void addNativeDir(String s) throws IOException {
        try {
            Field field = ClassLoader.class.getDeclaredField("usr_paths");
            field.setAccessible(true);
            String[] paths = (String[]) field.get(null);
            for (String path : paths) {
                if (s.equals(path)) {
                    return;
                }
            }
            String[] tmp = new String[paths.length+1];
            System.arraycopy(paths,0,tmp,0,paths.length);
            tmp[paths.length] = s;
            field.set(null, tmp);
        } catch (IllegalAccessException  e) {
            logger.error(e.getMessage());
            throw new IOException("Failed to get permissions to set library path"); 
        } catch (NoSuchFieldException e) {
            logger.error(e.getMessage());
            throw new IOException("Failed to get field handle to set library path"); 
        }
    }
}
