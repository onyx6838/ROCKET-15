package com.vti.backend;

import com.vti.entity.Student;

import java.util.*;

public class Exercise1 {
    public void Ques1() {
        // a
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Nguyen Van A"));
        studentList.add(new Student("Nguyen Van A"));
        studentList.add(new Student("Nguyen Van A"));
        studentList.add(new Student("Nguyen Van B"));
        // a
        System.out.println("List Size " + studentList.size());
        // b
        System.out.println("Element 4 " + studentList.get(3).getName());
        // c
        System.out.println("First ele " + studentList.get(0).toString());
        System.out.println("Last ele " + studentList.get(studentList.size() - 1));
        // d
        studentList.add(0, new Student("Ele 1"));
        // e
        studentList.add(studentList.size(), new Student("Ele 5"));
        // f
        System.out.println("list");
        System.out.println("Size = " + studentList.size());
        studentList.forEach(System.out::println);
        // e
        System.out.println("rev list");
        studentList = reverseList(studentList);
        studentList.forEach(System.out::println);
        // g
        // h
        // i
        // j
        studentList.forEach(x -> {
            if (x.getId() == 2) {
                x.setName("");
            }
        });
        // k
        studentList.stream().filter(x -> x.getId() == 5).forEach(studentList::remove);
        // h
        List<Student> studentCopies = new ArrayList<>(studentList);
        studentCopies.forEach(System.out::println);
    }

    public List<Student> reverseList(List<Student> beList) {
        List<Student> revList = new ArrayList<>();
        for (int i = beList.size() - 1; i >= 0; i--) {
            revList.add(beList.get(i));
        }
        return revList;
    }

    public void findById(int id, List<Student> beList) {
        for (Student stu :
                beList) {
            if (stu.getId() == id) System.out.println();
        }
    }

    public void findByName(String name, List<Student> beList) {
        for (Student stu :
                beList) {
            if (stu.getName().equals(name)) System.out.println();
        }
    }

    public void printDuplicateName(List<Student> beList) {
        for (int i = 0; i < beList.size() - 1; i++) {
            for (int j = i + 1; j < beList.size() - 1; j++) {
                if (beList.get(i).getName().equals(beList.get(j).getName()))
                    System.out.println(beList.get(i).getName()
                            + " dup with " + beList.get(j).getName());
            }
        }
    }

    public void Ques2(){
        Stack<Student> studentStack = new Stack<>();
        studentStack.add(new Student("Nguyễn Văn Nam"));
        studentStack.add(new Student("Nguyễn Văn Huyên"));
        studentStack.add(new Student("Trần Văn Nam"));
        studentStack.add(new Student("Nguyễn Văn A"));
        // a
        for (Student stu:
             studentStack) {
            System.out.println(studentStack.peek());
        }
        // b

    }

    public void copyFromStack (Stack stack, Queue queue) {
        Iterator it = stack.iterator ();
        while (it.hasNext()) {
            queue.add(it.next());
        }
    }
}
