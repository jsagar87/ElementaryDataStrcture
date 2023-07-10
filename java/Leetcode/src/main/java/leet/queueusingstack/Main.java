package leet.queueusingstack;


import java.util.Stack;

class MyQueue {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();
    public MyQueue() {
        int size = 0;
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.size()>0) {
            return s2.pop();
        }
        if (s1.size()>0) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }

    public int peek() {
        if (s2.size()>0) {
            return s2.peek();
        }
        if (s1.size()>0) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
        }
        return s2.peek();
    }

    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}

public class Main {
    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.push(1);
        mq.push(2);
        mq.push(3);
        mq.push(4);
        System.out.println(mq.pop()); // should print 1
        System.out.println(mq.pop()); // should print 2
        mq.push(5);
        mq.push(6);
        System.out.println(mq.pop()); // should print 3
        System.out.println(mq.pop()); // should print 4
        System.out.println(mq.pop()); // should print 5
        System.out.println(mq.pop()); // should print 6
        System.out.println(mq.pop()); // should throw something
    }
}
