package com.EduAssess;
import java.util.Scanner;

public class EduAssess {

    static Scanner sc = new Scanner(System.in);

    static HashTable students = new HashTable();
    static MarksStack undoStack = new MarksStack();
    static RevaluationQueue revalQueue = new RevaluationQueue();
    static ExaminerCircularQueue examinerQueue = new ExaminerCircularQueue();
    static MaxHeap heap = new MaxHeap();
    static ExamSchedule schedule = new ExamSchedule();


    static void addStudent(){

        System.out.print("HallTicket: ");
        int ht = sc.nextInt();

        System.out.print("Name: ");
        String name = sc.next();

        Student s = new Student(ht,name);

        students.insert(s);

        System.out.println("Student Added");
    }

    /* ---------- ENTER MARKS ---------- */

    static void enterMarks(){

        System.out.print("HallTicket: ");
        int ht = sc.nextInt();

        Student s = students.search(ht);

        if(s==null){
            System.out.println("Student Not Found");
            return;
        }

        undoStack.push(ht,s.marks);

        int m[] = new int[5];

        System.out.println("Enter Marks for 5 Subjects");

        for(int i=0;i<5;i++)
            m[i]=sc.nextInt();

        s.setMarks(m);

        heap.insert(s);

        System.out.println("Marks Updated");
    }

    /* ---------- UNDO MARKS ---------- */

    static void undoMarks(){

        if(undoStack.isEmpty()){
            System.out.println("Nothing to Undo");
            return;
        }

        int ht = undoStack.getHallTicket();

        Student s = students.search(ht);

        int old[] = undoStack.pop();

        s.setMarks(old);

        System.out.println("Marks Restored");
    }

    /* ---------- REQUEST REVALUATION ---------- */

    static void requestRevaluation(){

        System.out.print("HallTicket: ");
        int ht = sc.nextInt();

        Student s = students.search(ht);

        if(s==null){
            System.out.println("Student Not Found");
            return;
        }

        System.out.println("Select Subject (1-5)");
        int sub = sc.nextInt();

        revalQueue.enqueue(ht,sub);

        System.out.println("Revaluation Request Added");
    }

    /* ---------- PROCESS REVALUATION ---------- */

    static void processRevaluation(){

        if(revalQueue.isEmpty()){
            System.out.println("No Revaluation Requests");
            return;
        }

        int ht = revalQueue.hallTicket[revalQueue.front];
        int sub = revalQueue.subjectIndex[revalQueue.front];

        Student s = students.search(ht);

        System.out.println("\nProcessing Request");

        String examiner = examinerQueue.getExaminer();

        System.out.println("Examiner Assigned: "+examiner);

        System.out.println("Examiner Checking Answer Sheet...");

        System.out.print("Enter Updated Marks: ");
        int newMarks = sc.nextInt();

        s.marks[sub-1] = newMarks;

        s.recalculateTotal();

        System.out.println("Marks Updated Successfully");

        revalQueue.dequeue();
    }

    /* ---------- SHOW STUDENT ---------- */

    static void showStudent(){

        System.out.print("HallTicket: ");
        int ht = sc.nextInt();

        Student s = students.search(ht);

        if(s!=null)
            s.display();
        else
            System.out.println("Student Not Found");
    }

    /* ---------- EXAM SCHEDULE ---------- */

    static void createExamSchedule(){
        schedule.createSchedule();
    }

    static void showExamSchedule(){
        schedule.showSchedule();
    }

    /* ---------- MENU ---------- */

    public static void main(String args[]){

        int choice;

        do{

            System.out.println("\n===== EduAssess System =====");

            System.out.println("1 Add Student");
            System.out.println("2 Enter Marks");
            System.out.println("3 Undo Marks");
            System.out.println("4 Request Revaluation");
            System.out.println("5 Process Revaluation");
            System.out.println("6 Show Student");
            System.out.println("7 Show Top Student");
            System.out.println("8 Create Exam Schedule");
            System.out.println("9 Show Exam Schedule");
            System.out.println("10 Exit");

            System.out.print("Choice: ");
            choice = sc.nextInt();

            switch(choice){

                case 1: addStudent(); break;
                case 2: enterMarks(); break;
                case 3: undoMarks(); break;
                case 4: requestRevaluation(); break;
                case 5: processRevaluation(); break;
                case 6: showStudent(); break;
                case 7: heap.showTop(); break;
                case 8: createExamSchedule(); break;
                case 9: showExamSchedule(); break;
                case 10: System.out.println("System Closed"); break;
                default: System.out.println("Invalid Choice");
            }

        }while(choice!=10);
    }
}