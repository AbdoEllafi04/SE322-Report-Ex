package Section3_Threads.Extending;

public class Extending_Thread1 extends Thread {
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Counting up using Extending_Thread: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }  
        }
        System.out.println("thread1 finished");
    }
    public static void main(String[] args) {
        Extending_Thread1 thread1 = new Extending_Thread1(); //create thread object
        Extending_Thread2 thread2 = new Extending_Thread2();
        thread1.start();
        thread2.start();
    }
    
}

