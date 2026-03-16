package com.EduAssess;

class RevaluationQueue {

    int hallTicket[] = new int[100];
    int subjectIndex[] = new int[100];

    int front=-1;
    int rear=-1;

    void enqueue(int ht,int sub){

        if(front==-1)
            front=0;

        rear++;

        hallTicket[rear]=ht;
        subjectIndex[rear]=sub;
    }

    void dequeue(){
        front++;
    }

    boolean isEmpty(){
        return front==-1 || front>rear;
    }
}