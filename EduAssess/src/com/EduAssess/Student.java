package com.EduAssess;
class Student {

    int hallTicket;
    String name;

    String subjects[]={"Mathematics","Science","English","Social","Computer"};

    int marks[] = new int[5];
    int total;

    Student(int ht,String n){
        hallTicket=ht;
        name=n;
    }

    void setMarks(int m[]){

        total=0;

        for(int i=0;i<5;i++){
            marks[i]=m[i];
            total+=m[i];
        }
    }

    void recalculateTotal(){

        total=0;

        for(int i=0;i<5;i++)
            total+=marks[i];
    }

    void display(){

        System.out.println("\nHallTicket: "+hallTicket);
        System.out.println("Name: "+name);

        for(int i=0;i<5;i++)
            System.out.println(subjects[i]+" : "+marks[i]);

        System.out.println("Total: "+total);
    }
}