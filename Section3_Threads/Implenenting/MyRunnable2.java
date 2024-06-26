package Section3_Threads.Implenenting;
public class MyRunnable2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Counting up using MyRunnable2: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MyRunnable2 has finished executing!");
    }
    }

    

