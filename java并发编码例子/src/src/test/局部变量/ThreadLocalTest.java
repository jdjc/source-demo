package test.�ֲ�����;

import java.util.Random;

public class ThreadLocalTest implements Runnable{
    
    ThreadLocal<Studen> studenThreadLocal = new ThreadLocal<Studen>();

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println(currentThreadName + " is running...");
        Random random = new Random();
        int age = random.nextInt(100);
        System.out.println(currentThreadName + " is set age: "  + age);
        Studen studen = getStudent(); //ͨ�����������Ϊÿ���̶߳�������newһ��student����ÿ���̵߳ĵ�student���󶼿������ò�ͬ��ֵ
        studen.setAge(age);
        System.out.println(currentThreadName + " is first get age: " + studen.getAge());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println( currentThreadName + " is second get age: " + studen.getAge());
        
    }
    
    private Studen getStudent() {
        Studen studen = studenThreadLocal.get();
        if (null == studen) {
            studen = new Studen();
            studenThreadLocal.set(studen);
        }
        return studen;
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        Thread t1 = new Thread(t,"Thread A");
        Thread t2 = new Thread(t,"Thread B");
        t1.start();
        t2.start();
    }
    
}

class Studen{
    int age;
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    
}