package LearnSelenium;

import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommonFutures {
    public static void main(String[] args) throws IOException {
        CommonFutures t = new CommonFutures();
        System.out.print("what is your name my dear friend: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String name = bufferedReader.readLine();
        t.sayHello(name);
    }

    @Test
    public void t2() {
        System.out.println("1231");
    }

    private void sayHello(String name) {
        System.out.println("Hello: " + name);
    }
}
