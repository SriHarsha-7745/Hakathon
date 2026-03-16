package com.EduAssess;

class MarksStack {

    int marksStack[][] = new int[100][5];
    int hallTicket[] = new int[100];

    int top=-1;

    void push(int ht,int marks[]){

        top++;

        hallTicket[top]=ht;

        for(int i=0;i<5;i++)
            marksStack[top][i]=marks[i];
    }

    int[] pop(){

        int temp[] = new int[5];

        for(int i=0;i<5;i++)
            temp[i]=marksStack[top][i];

        top--;

        return temp;
    }

    int getHallTicket(){
        return hallTicket[top];
    }

    boolean isEmpty(){
        return top==-1;
    }
}