// MultiThreadedDemo.java

public class MultiThreadedDemo {

    public static void main(String[] args){
        // Create threads
        Thread t1 = new Thread(new Task("Thread 1"));
        Thread t2 = new Thread(new Task("Thread 2"));
        Thread t3 = new Thread(new Task("Thread 3"));

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }   
}

// Task class implementing Runnable
class Task implements Runnable{
    private final String name;

    Task(String name){
        this.name = name;
    }

    @Override
    public void run(){
        try{
            for (int i = 1; i <= 5; i++){
                System.out.println(name + " - Count: " + i);
                Thread.sleep(1000);
            }
        } catch(InterruptedException ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
}