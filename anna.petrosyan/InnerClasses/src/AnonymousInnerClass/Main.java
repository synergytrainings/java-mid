package AnonymousInnerClass;

/**
 * Created by Emil on 15.05.2015.
 */
public class Main {
    public static void main(String[] args) {
        new Thread() {
            public void run() {
                try {
                    sleep(4000);
                    System.out.println("hello");
                }
                catch (InterruptedException e)
                {
                    System.out.println(" EXCEPTION : " + e.toString());
                }
            }
        }.start();
    }
}
