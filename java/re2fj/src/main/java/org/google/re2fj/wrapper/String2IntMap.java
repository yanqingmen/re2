/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.google.re2fj.wrapper;

public class String2IntMap {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected String2IntMap(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(String2IntMap obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        re2fjJNI.delete_String2IntMap(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public String2IntMap() {
    this(re2fjJNI.new_String2IntMap__SWIG_0(), true);
  }

  public String2IntMap(String2IntMap arg0) {
    this(re2fjJNI.new_String2IntMap__SWIG_1(String2IntMap.getCPtr(arg0), arg0), true);
  }

  public long size() {
    return re2fjJNI.String2IntMap_size(swigCPtr, this);
  }

  public boolean empty() {
    return re2fjJNI.String2IntMap_empty(swigCPtr, this);
  }

  public void clear() {
    re2fjJNI.String2IntMap_clear(swigCPtr, this);
  }

  public int get(String key) {
    return re2fjJNI.String2IntMap_get(swigCPtr, this, key);
  }

  public void set(String key, int x) {
    re2fjJNI.String2IntMap_set(swigCPtr, this, key, x);
  }

  public void del(String key) {
    re2fjJNI.String2IntMap_del(swigCPtr, this, key);
  }

  public boolean has_key(String key) {
    return re2fjJNI.String2IntMap_has_key(swigCPtr, this, key);
  }

}
