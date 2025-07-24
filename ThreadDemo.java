public class ThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        System.out.println(t1.getName());
        System.out.println(t1.getState());
        System.out.println(t1.getPriority());
        t1.start();
        System.out.println(t1.getState());

    }
}
