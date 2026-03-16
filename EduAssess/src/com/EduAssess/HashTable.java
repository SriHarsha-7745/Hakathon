package com.EduAssess;

class HashTable {

    Student table[] = new Student[200];

    int hash(int ht){
        return ht % 200;
    }

    void insert(Student s){
        table[hash(s.hallTicket)] = s;
    }

    Student search(int ht){
        return table[hash(ht)];
    }
}