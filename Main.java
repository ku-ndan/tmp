//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ArithmeticException{


        int a = 5;
        int b = 0;
        int [] arr = {1,2,3,4,5,6,7,8,9};
        try{

            System.out.println(arr[10]);
            System.out.println(a/b);
        } catch (Exception e) {
            System.out.println("so long"+ e.getMessage()+" "+e.getClass());
        }
        System.out.println("Program ends here!");

    }
}