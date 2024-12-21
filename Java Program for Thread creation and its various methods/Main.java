class MyThread extends Thread {
    public void run() {
        System.out.println("Thread running");
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating thread objects
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();

        // Starting threads
        thread1.start();
        thread2.start();

        // Getting thread name
        System.out.println("Thread 1 name: " + thread1.getName());
        System.out.println("Thread 2 name: " + thread2.getName());

        // Setting thread name
        thread1.setName("Thread A");
        thread2.setName("Thread B");

        // Getting thread priority
        System.out.println("Thread 1 priority: " + thread1.getPriority());
        System.out.println("Thread 2 priority: " + thread2.getPriority());

        // Setting thread priority
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        // Checking if threads are alive
        System.out.println("Thread 1 alive: " + thread1.isAlive());
        System.out.println("Thread 2 alive: " + thread2.isAlive());

        // Waiting for threads to finish
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Checking if threads are alive after join
        System.out.println("Thread 1 alive: " + thread1.isAlive());
        System.out.println("Thread 2 alive: " + thread2.isAlive());

        System.out.println("Main thread exiting");
    }
}
