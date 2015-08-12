%module re2fj
%{
#include "wrap_util.h"
%}

%include "std_string.i"
%include "std_vector.i"
%include "std_map.i"
%include "wrap_util.h"

namespace std {
    %template(IntVector) vector<int>;
    %template(DoubleVector) vector<double>;
    %template(String2IntMap) map<string,int>;
    %template(Int2StringMap) map<int,string>;
}

