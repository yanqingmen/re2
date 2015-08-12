/* 
 * File:   wrap_util.h
 * Author: hzx
 *
 * Created on 2015年4月23日, 下午10:45
 */

#ifndef WRAP_UTIL_H
#define	WRAP_UTIL_H
#include <re2/re2.h>
#include <re2/set.h>

using namespace std;

namespace re2 {

class Re2Options {
public:
    
    RE2::Options& GetOption() { return option; }
    bool utf8() { return option.utf8(); }
    void set_utf8(bool b) { option.set_utf8(b); }

    bool posix_syntax() { return option.posix_syntax(); }
    void set_posix_syntax(bool b) { option.set_posix_syntax(b); }

    bool longest_match() { return option.longest_match(); }
    void set_longest_match(bool b) { option.set_longest_match(b); }

    bool log_errors() { return option.log_errors(); }
    void set_log_errors(bool b) { option.set_log_errors(b); }

    long int max_mem() { return option.max_mem(); }
    void set_max_mem(long int m) { option.set_max_mem(m); }

    bool literal() { return option.literal(); }
    void set_literal(bool b) { option.set_literal(b); }

    bool never_nl() { return option.never_nl(); }
    void set_never_nl(bool b) { option.set_never_nl(b); }

    bool dot_nl() { return option.dot_nl(); }
    void set_dot_nl(bool b) { option.set_dot_nl(b); }

    bool never_capture() { return option.never_capture(); }
    void set_never_capture(bool b) { option.set_never_capture(b); }

    bool case_sensitive() { return option.case_sensitive(); }
    void set_case_sensitive(bool b) { option.set_case_sensitive(b); }

    bool perl_classes() { return option.perl_classes(); }
    void set_perl_classes(bool b) { option.set_perl_classes(b); }

    bool word_boundary() { return option.word_boundary(); }
    void set_word_boundary(bool b) { option.set_word_boundary(b); }

    bool one_line() { return option.one_line(); }
    void set_one_line(bool b) { return option.set_one_line(b); }
    
    void Copy(const Re2Options& src) { option.Copy(src.option); }
private:
    RE2::Options option;
};

class Re2Set {
public:
    Re2Set(Re2Options& options, int anchor_id) {
        RE2::Anchor anchor = (RE2::Anchor) anchor_id;
        set = new RE2::Set(options.GetOption(), anchor); }
    ~Re2Set() { delete set; }
    
    // Add adds regexp pattern to the set, interpreted using the RE2 options.
  // (The RE2 constructor's default options parameter is RE2::UTF8.)
  // Add returns the regexp index that will be used to identify
  // it in the result of Match, or -1 if the regexp cannot be parsed.
  // Indices are assigned in sequential order starting from 0.
  // Error returns do not increment the index.
  // If an error occurs and error != NULL, *error will hold an error message.
  int Add(const char* pattern, string* error) { 
      re2::StringPiece piece(pattern);
      return set->Add(piece, error); }

  // Compile prepares the Set for matching.
  // Add must not be called again after Compile.
  // Compile must be called before FullMatch or PartialMatch.
  // Compile may return false if it runs out of memory.
  bool Compile() { return set->Compile(); }

  // Match returns true if text matches any of the regexps in the set.
  // If so, it fills v with the indices of the matching regexps.
  bool Match(const char* text, vector<int>* v) const {
      re2::StringPiece piece(text);
      return set->Match(piece, v); }
    
private:
    RE2::Set* set;
};

class IntVectorPointer {
public:
    IntVectorPointer() { vec = new vector<int>(); }
    ~IntVectorPointer() { delete vec; }
    
    long unsigned int Size() { return vec->size(); }
    int Value(const long unsigned int& index) { return vec->at(index); }
    vector<int>* Pointer() { return vec; }
private:
    vector<int>* vec;
};

class StringPointer {
public:
    StringPointer() { str_p = new string(); }
    ~StringPointer() { delete str_p; }
    
    string* Pointer() { return str_p; }
    const char* ToString() { return str_p->c_str(); }
private:
    string* str_p;
};
}

#endif	/* WRAP_UTIL_H */

