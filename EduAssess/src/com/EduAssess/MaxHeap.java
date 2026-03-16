package com.EduAssess;

class MaxHeap {

    Student heap[]=new Student[100];

    int size=0;

    void insert(Student s){

        heap[size]=s;

        int i=size;

        while(i>0 && heap[(i-1)/2].total < heap[i].total){

            Student temp=heap[i];
            heap[i]=heap[(i-1)/2];
            heap[(i-1)/2]=temp;

            i=(i-1)/2;
        }

        size++;
    }

    void showTop(){

        if(size==0){
            System.out.println("No Students");
            return;
        }

        System.out.println("\nTop Ranked Student");
        heap[0].display();
    }
}