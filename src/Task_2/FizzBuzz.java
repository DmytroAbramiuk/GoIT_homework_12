package Task_2;

public class FizzBuzz {

    private int n;
    private int currentN;

    public FizzBuzz(int n) {
        this.n = n;
        this.currentN = 1;
    }

    private void incrementAndNotify(){
        currentN++;
        notifyAll();
    }

    private void makeWait(){
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void fizz(){
        while(currentN <= n){
            if(currentN % 3 == 0 && currentN % 5 != 0){
                System.out.println("fizz");
                incrementAndNotify();
            } else {
                makeWait();
            }
        }
    }

    public synchronized void buzz(){
        while(currentN <= n){
            if(currentN % 5 == 0 && currentN % 3 != 0){
                System.out.println("buzz");
                incrementAndNotify();
            } else {
                makeWait();
            }
        }
    }

    public synchronized void fizzBuzz(){
        while(currentN <= n){
            if(currentN % 5 == 0 && currentN % 3 == 0){
                System.out.println("fizzBuzz");
                incrementAndNotify();
            } else {
                makeWait();
            }
        }
    }

    public synchronized void notFizzBuzz(){
        while(currentN <= n){
            if(currentN % 5 != 0 && currentN % 3 != 0){
                System.out.println(currentN);
                incrementAndNotify();
            } else {
                makeWait();
            }
        }
    }
}
