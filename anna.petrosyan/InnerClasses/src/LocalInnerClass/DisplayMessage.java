package LocalInnerClass;

/**
 * Created by Emil on 15.05.2015.
 */
public class DisplayMessage {
    public static void main(String[] args)
    {
        class Greeting implements Runnable
        {
            private final String text;

            public Greeting(String text)
            {
                super();
                this.text = text;
            }

            public void run()
            {
                System.out.println("Hello " + text);
            }
        }

        new Greeting("Anna").run();
        new Greeting("Lilit").run();
    }
}
