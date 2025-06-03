//package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StudentLinkedList studentLinkedList = new StudentLinkedList();
        CourseLinkedList courseLinkedList = new CourseLinkedList();
        GradeLinkedList gradeLinkedList = new GradeLinkedList();

        int T, a, b, p;

        T = scan.nextInt();
        a = scan.nextInt();
        b = scan.nextInt();
        p = scan.nextInt();

        for (int i = 1; i <= T; i++) {
            String command;
            command = scan.next();

            if (command.equals("ADDS")) {
                int code = scan.nextInt();
                String name = scan.next();
                studentLinkedList.insert(new Student(code, name));
            } else if (command.equals("ADDC")) {
                int code = scan.nextInt();
                String name = scan.next();
                courseLinkedList.insert(new Course(code, name));
            } else if (command.equals("ADDG")) {
                int student_code = scan.nextInt();
                int course_code = scan.nextInt();
                int semester_code = scan.nextInt();
                float value = scan.nextFloat();
                gradeLinkedList.insert(new Grade(student_code, course_code, semester_code, value));
            } else if (command.equals("EDITS")) {
                int code = scan.nextInt();
                String name = scan.next();
                studentLinkedList.edit(code, name);
            } else if (command.equals("EDITC")) {
                int code = scan.nextInt();
                String name = scan.next();
                courseLinkedList.edit(code, name);
            } else if (command.equals("EDITG")) {
                int student_code = scan.nextInt();
                int course_code = scan.nextInt();
                float value = scan.nextFloat();
                gradeLinkedList.edit(student_code, course_code, value);
            } else if (command.equals("DELETES")) {
                int code = scan.nextInt();
                studentLinkedList.delete(code);
                gradeLinkedList.delete_by_student_code(code);
            } else if (command.equals("DELETEC")) {
                int code = scan.nextInt();
                courseLinkedList.delete(code);
                gradeLinkedList.delete_by_course_code(code);
            } else if (command.equals("DELETEG")) {
                int student_code = scan.nextInt();
                int course_code = scan.nextInt();
                gradeLinkedList.delete(student_code, course_code);
            } else if (command.equals("NUMBERC")) {
                int code = scan.nextInt();
                System.out.println(gradeLinkedList.count_student_code(code));
            } else if (command.equals("NUMBERS")) {
                int code = scan.nextInt();
                System.out.println(gradeLinkedList.count_course_code(code));
            }
        }
    }
}

class Student {
    public int code;
    public String name;
    CourseLinkedList courses;
    public Student next;

    public Student(int code, String name) {
        this.code = code;
        this.name = name;
        this.next = null;
    }
}

class StudentLinkedList {
    private Student head;

    StudentLinkedList() {
        head = null;
    }

    public void insert(Student student) {
        if (head == null) {
            head = student;
        } else {
            student.next = head;
            head = student;
        }
    }

    public void edit(int code, String name) {
        Student temp = head;

        while (temp != null) {
            if (temp.code == code) {
                temp.name = name;
                break;
            }

            temp = temp.next;
        }
    }

    public void delete(int code) {
        if (head == null) {
            return;
        }

        if (head.code == code) {
            head = head.next;
            return;
        }

        Student prev = null;
        Student curr = head;

        while (curr != null) {
            if (curr.code == code) {
                prev.next = curr.next;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

class Course {
    public int code;
    public String name;
    public Course next;

    public Course(int code, String name) {
        this.code = code;
        this.name = name;
        this.next = null;
    }
}

class CourseLinkedList {
    private Course head;

    CourseLinkedList() {
        head = null;
    }

    public void insert(Course course) {
        if (head == null) {
            head = course;
        } else {
            course.next = head;
            head = course;
        }
    }

    public void edit(int code, String name) {
        Course temp = head;

        while (temp != null) {
            if (temp.code == code) {
                temp.name = name;
                break;
            }

            temp = temp.next;
        }
    }

    public void delete(int code) {
        if (head == null) {
            return;
        }

        if (head.code == code) {
            head = head.next;
            return;
        }

        Course prev = null;
        Course curr = head;

        while (curr != null) {
            if (curr.code == code) {
                prev.next = curr.next;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }
}

class Grade {
    public int student_code;
    public int course_code;
    public int semester;
    public float value;
    Grade next;

    public Grade(int student_code, int course_code, int semester, float value) {
        this.student_code = student_code;
        this.course_code = course_code;
        this.semester = semester;
        this.value = value;
        this.next = null;
    }
}

class GradeLinkedList {
    private Grade head;

    GradeLinkedList() {
        head = null;
    }

    public void insert(Grade grade) {
        if (head == null) {
            head = grade;
        } else {
            grade.next = head;
            head = grade;
        }
    }

    public void edit(int student_code, int course_code, float value) {
        Grade temp = head;

        while (temp != null) {
            if (temp.student_code == student_code && temp.course_code == course_code) {
                temp.value = value;
                break;
            }

            temp = temp.next;
        }
    }

    public void delete_by_student_code(int student_code) {
        if (head == null) {
            return;
        }

        while (head != null && head.student_code == student_code) {
            head = head.next;
        }

        Grade prev = null;
        Grade curr = head;

        while (curr != null) {
            if (curr.student_code == student_code) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void delete_by_course_code(int course_code) {
        if (head == null) {
            return;
        }

        while (head != null && head.course_code == course_code) {
            head = head.next;
        }

        Grade prev = null;
        Grade curr = head;

        while (curr != null) {
            if (curr.course_code == course_code) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
    }

    public void delete(int student_code, int course_code) {
        if (head == null) {
            return;
        }

        if (head.student_code == student_code && head.course_code == course_code) {
            head = head.next;
            return;
        }

        Grade prev = null;
        Grade curr = head;

        while (curr != null) {
            if (curr.student_code == student_code && curr.course_code == course_code) {
                prev.next = curr.next;
                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public int count_student_code(int code) {
        Grade temp = head;
        int count = 0;

        while (temp != null) {
            if (temp.student_code == code) {
                count = count + 1;
            }
            temp = temp.next;
        }

        return count;
    }

    public int count_course_code(int code) {
        Grade temp = head;
        int count = 0;

        while (temp != null) {
            if (temp.course_code == code) {
                count = count + 1;
            }
            temp = temp.next;
        }

        return count;
    }
}
