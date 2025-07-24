public class threadDemo3 implements Runnable{
    @Override
    public void run() {
        System.out.println("thread is running!!");
    }

    public static void main(String[] args) throws InterruptedException {
        threadDemo3 obj = new threadDemo3();
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getPriority());
        System.out.println(Thread.currentThread().getState());
        System.out.println("Total thread Count : "+ Thread.activeCount());
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName());
        obj.run();
        System.out.println("Total thread Count : "+ Thread.activeCount());
        System.out.println(Thread.currentThread().getState());
        System.out.println("Program ends here!!");
    }

}
