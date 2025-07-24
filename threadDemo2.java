public class threadDemo2 extends Thread{

    public void start(){
        System.out.println("thread is started");
    }

    public static void main(String[] args) {
        threadDemo2 obj = new threadDemo2();
        obj.start();
    }
}
