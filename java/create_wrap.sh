cd ../
make all
cd java
rm re2fj/src/main/java/org/google/re2fj/wrapper/*.java re2fj/src/main/resources/lib/native/libre2fj.so
echo 'swig -c++ -java -package org.google.re2fj.wrapper re2fj.i'
swig -c++ -java -package org.google.re2fj.wrapper re2fj.i
mkdir -p re2fj/src/main/java/org/google/re2fj/wrapper/
mv *.java re2fj/src/main/java/org/google/re2fj/wrapper/
echo 'create wrapper'
g++ -O2 -fpic -c re2fj_wrap.cxx -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux
g++ -shared re2fj_wrap.o ../obj/libre2.a -o libre2fj.so
mkdir -p re2fj/src/main/resources/lib/native/
mv libre2fj.so re2fj/src/main/resources/lib/native/
echo 'complete'
