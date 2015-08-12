/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.5
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package org.google.re2fj.wrapper;

public class Re2Options {
  private long swigCPtr;
  protected boolean swigCMemOwn;

  protected Re2Options(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(Re2Options obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        re2fjJNI.delete_Re2Options(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public SWIGTYPE_p_RE2__Options GetOption() {
    return new SWIGTYPE_p_RE2__Options(re2fjJNI.Re2Options_GetOption(swigCPtr, this), false);
  }

  public boolean utf8() {
    return re2fjJNI.Re2Options_utf8(swigCPtr, this);
  }

  public void set_utf8(boolean b) {
    re2fjJNI.Re2Options_set_utf8(swigCPtr, this, b);
  }

  public boolean posix_syntax() {
    return re2fjJNI.Re2Options_posix_syntax(swigCPtr, this);
  }

  public void set_posix_syntax(boolean b) {
    re2fjJNI.Re2Options_set_posix_syntax(swigCPtr, this, b);
  }

  public boolean longest_match() {
    return re2fjJNI.Re2Options_longest_match(swigCPtr, this);
  }

  public void set_longest_match(boolean b) {
    re2fjJNI.Re2Options_set_longest_match(swigCPtr, this, b);
  }

  public boolean log_errors() {
    return re2fjJNI.Re2Options_log_errors(swigCPtr, this);
  }

  public void set_log_errors(boolean b) {
    re2fjJNI.Re2Options_set_log_errors(swigCPtr, this, b);
  }

  public int max_mem() {
    return re2fjJNI.Re2Options_max_mem(swigCPtr, this);
  }

  public void set_max_mem(int m) {
    re2fjJNI.Re2Options_set_max_mem(swigCPtr, this, m);
  }

  public boolean literal() {
    return re2fjJNI.Re2Options_literal(swigCPtr, this);
  }

  public void set_literal(boolean b) {
    re2fjJNI.Re2Options_set_literal(swigCPtr, this, b);
  }

  public boolean never_nl() {
    return re2fjJNI.Re2Options_never_nl(swigCPtr, this);
  }

  public void set_never_nl(boolean b) {
    re2fjJNI.Re2Options_set_never_nl(swigCPtr, this, b);
  }

  public boolean dot_nl() {
    return re2fjJNI.Re2Options_dot_nl(swigCPtr, this);
  }

  public void set_dot_nl(boolean b) {
    re2fjJNI.Re2Options_set_dot_nl(swigCPtr, this, b);
  }

  public boolean never_capture() {
    return re2fjJNI.Re2Options_never_capture(swigCPtr, this);
  }

  public void set_never_capture(boolean b) {
    re2fjJNI.Re2Options_set_never_capture(swigCPtr, this, b);
  }

  public boolean case_sensitive() {
    return re2fjJNI.Re2Options_case_sensitive(swigCPtr, this);
  }

  public void set_case_sensitive(boolean b) {
    re2fjJNI.Re2Options_set_case_sensitive(swigCPtr, this, b);
  }

  public boolean perl_classes() {
    return re2fjJNI.Re2Options_perl_classes(swigCPtr, this);
  }

  public void set_perl_classes(boolean b) {
    re2fjJNI.Re2Options_set_perl_classes(swigCPtr, this, b);
  }

  public boolean word_boundary() {
    return re2fjJNI.Re2Options_word_boundary(swigCPtr, this);
  }

  public void set_word_boundary(boolean b) {
    re2fjJNI.Re2Options_set_word_boundary(swigCPtr, this, b);
  }

  public boolean one_line() {
    return re2fjJNI.Re2Options_one_line(swigCPtr, this);
  }

  public void set_one_line(boolean b) {
    re2fjJNI.Re2Options_set_one_line(swigCPtr, this, b);
  }

  public void Copy(Re2Options src) {
    re2fjJNI.Re2Options_Copy(swigCPtr, this, Re2Options.getCPtr(src), src);
  }

  public Re2Options() {
    this(re2fjJNI.new_Re2Options(), true);
  }

}
