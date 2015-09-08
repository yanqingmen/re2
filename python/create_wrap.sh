cd ../
make all
cd python
rm re2py/_re2py.so
echo 'swig -c++ -python re2py.i'
swig -c++ -python re2py.i
mv re2py.py re2py/
echo 'create wrapper'
g++ -O2 -fpic -c re2fj_wrap.cxx -I${JAVA_HOME}/include
g++ -shared re2fj_wrap.o ../obj/libre2.a -o _re2py.so
mv _re2py.so re2py/
echo 'complete'
