#!/usr/bin/env python

# -*- coding: utf-8 -*-

import sys
import pymysql
from tkinter import *


con = pymysql.connect(
    user='smart',
    passwd='hi123456',
    host='192.168.0.20',
    db='smarthome',
    charset='utf8'
)

cs = con.cursor(pymysql.cursors.DictCursor)



class CS():

    def __init__(self):

        self.window = Tk()
        self.window.geometry('500x500+300+300')
        self.window.title('CS')

        self.create_question()
        self.window.mainloop()
        
        

    def create_answer(self,csnum):
        cssetdict = self.selectOne_cs(csnum)
        answer = []
        question = []
        for i in cssetdict:
            answer.append(i['csAnswer'])
            question.append(i['csQuestion'])
        self.que_l = Label(self.window, text=question[0])
        self.ans_l = Label(self.window, text=answer[0])
        self.que_l.pack(anchor="c")
        self.ans_l.pack(anchor="e") 
        print("createrep_",csnum)
        self.create_nextbt()

 

    def destroy_label(self):
        for i in range(0,len(self.questionbuttonlst)):
            self.questionbuttonlst[i].destroy()

    def destroy_answer(self):
        self.ans_l.destroy()
        self.que_l.destroy()
        self.nextbt.destroy()
        self.endbt.destroy()
       
    def create_nextbt(self):
        self.nextbt = Button(self.window, text="더 질문하기", width = 50, command=self.nextbtevent)
        self.endbt = Button(self.window, text="질문 끝내기", width = 50, command=self.endbtevent)
        self.nextbt.pack()
        self.endbt.pack()

    def create_question(self):
        print("create_question")
        self.questionbuttonlst = []
        cssetdict = self.selectAll_cs()
        csquestion = []
        csnum = []
        for i in cssetdict:
            csquestion.append(i['csQuestion'])
            csnum.append(i['CSNum'])
        for i in range(0,len(csquestion)):
            self.questionbuttonlst.append(Button(self.window, text=csquestion[i], width = 50, command=lambda j=i:self.questionButton_click(csnum[j])))
            
        for i in range(0,len(self.questionbuttonlst)):
            self.questionbuttonlst[i].pack(anchor="c")

    def nextbtevent(self):
        self.destroy_answer()
        self.endbt.destroy()
        self.create_question()

    def endbtevent(self):
        self.window.destroy()


    def questionButton_click(self,csnum):
        print('questionButton_click()..')
        self.destroy_label()
        self.create_answer(csnum)


    def selectAll_cs(self):
        cs.execute('select * from cs')
        result = cs.fetchall()
        return result


        
    def selectOne_cs(self,csnum):
        print("selectOne_cs_",csnum)
        sql = 'select * from cs where csnum = %s'
        values = (csnum,)
        cs.execute(sql,values)
        result = cs.fetchall()
        return result



app = CS()

