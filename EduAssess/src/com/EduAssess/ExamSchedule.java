package com.EduAssess;

import java.util.Scanner;

class ExamSchedule {

    String subjects[] = {
        "Mathematics",
        "Science",
        "English",
        "Social",
        "Computer"
    };

    String date[] = new String[5];
    String time[] = new String[5];

    Scanner sc = new Scanner(System.in);

    /* ---------- CREATE EXAM SCHEDULE ---------- */

    void createSchedule() {

        System.out.println("\n===== CREATE EXAM SCHEDULE =====");

        for(int i = 0; i < 5; i++) {

            System.out.println("\nSubject: " + subjects[i]);

            System.out.print("Enter Exam Date: ");
            date[i] = sc.next();

            System.out.print("Enter Exam Time: ");
            time[i] = sc.next();
        }

        System.out.println("\nExam Schedule Created Successfully");
    }

    /* ---------- DISPLAY EXAM SCHEDULE ---------- */

    void showSchedule() {

        System.out.println("\n===== EXAM SCHEDULE =====");

        for(int i = 0; i < 5; i++) {

            if(date[i] != null) {

                System.out.println(
                    subjects[i] + " : " + date[i] + "  " + time[i]
                );

            } else {

                System.out.println(
                    subjects[i] + " : Schedule Not Created"
                );
            }
        }
    }
}