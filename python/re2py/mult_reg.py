'''fast multi reg match via re2'''
#-*- coding:utf-8 -*-

import re2py

class MultReg(object):
    '''class for muiltiple regular expression match'''

    def __init__(self, archor_id=0, maxm=100):
        self.option = re2py.Re2Options()
        self.option.set_max_mem(maxm*1024*1024)
        self.archor_id = archor_id
        self.re2_set = re2py.Re2Set(self.option, archor_id)
        self.reg_map = {}
        self.vec_p = re2py.IntVectorPointer()
        self.str_p = re2py.StringPointer()

    def add_reg(self, reg_string):
        '''add regular expression to MultReg machine'''
        reg_id = self.re2_set.Add(reg_string, self.str_p.Pointer())
        self.reg_map[reg_id] = reg_string
        return reg_id


    def add_regs(self, reg_list):
        ''''add a list of regs to MultReg machine'''
        result = [self.add_reg(reg_string) for reg_string in reg_list]
        return result

    def compile(self):
        '''compile reg machine'''
        return self.re2_set.Compile()

    def match(self, text):
        '''match reg for given text'''
        self.re2_set.Match(text, self.vec_p.Pointer())
        result = [self.reg_map[self.vec_p.Value(i)] for i in xrange(self.vec_p.Size())]
        return result
