export PY_VERSION=python2.7
export PY_INC=/usr/include/python2.7


cd ../
make all
cd python
rm re2py/_re2py.so
echo 'swig -c++ -python re2py.i'
swig -c++ -python re2py.i
mv re2py.py re2py/
echo 'create wrapper'
g++ -O2 -fpic -c re2py_wrap.cxx -I${PY_INC}
g++ -shared re2py_wrap.o ../obj/libre2.a -l${PY_VERSION} -o _re2py.so
mv _re2py.so re2py/
echo 'complete'
