package Section3_Threads.Implenenting;
public class MyRunnable implements Runnable{
    
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("Counting up using MyRunnable: " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MyRunnable has finished executing!");
    }

    public static void main(String[] args) {
        MyRunnable myRunnable1 = new MyRunnable();
        Thread thread1 = new Thread(myRunnable1); //passing MyRunnable obj to thread class

        MyRunnable2 myRunnable2 = new MyRunnable2();
        Thread thread2 = new Thread(myRunnable2);
        thread1.start();
        thread2.start();
    }


}
