package Section3_Threads.Extending;

public class Extending_Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Counting up using Extending_Thread2: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("thread2 finished");
    }
    
}
