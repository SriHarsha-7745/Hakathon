package com.EduAssess;



class ExaminerCircularQueue {

    String examiners[]={"ProfA","ProfB","ProfC"};

    int size=examiners.length;

    int index=0;

    String getExaminer(){

        String e=examiners[index];

        index=(index+1)%size;

        return e;
    }
}