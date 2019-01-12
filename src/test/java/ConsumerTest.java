import org.apache.dubbo.samples.basic.api.DemoService;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class ConsumerTest {
    static ClassPathXmlApplicationContext context;
    static DemoService demoService;
    @BeforeClass
    public static void beforeClass(){
        if(context==null) {
            context = new ClassPathXmlApplicationContext(
                    "consumer.xml");
            System.out.println("load");
            context.start();
            System.out.println("start");
        }
        demoService=(DemoService) context.getBean("demoService");

    }
    @Test
    public void consumer1() throws InterruptedException {

        System.out.println("bean");
        for(int i=0;i<10;i++) {
            System.out.println(demoService.sayHello("思寒 "+i));
        }

    }

    @Test
    public void sayHelloWithNotSafe(){
        String result=demoService.sayHello("");
        assertThat(result, containsString("seveniruby says hello to ,"));
        String result2=demoService.sayHello(" ");
        assertThat(result2, containsString("seveniruby says hello to  ,"));
    }

    @Test
    public void sayHelloWithSpec(){
        String result=demoService.sayHello("\"");
        assertThat(result, containsString("seveniruby says hello to \","));
    }

    @Test
    public void sayHelloWithSql(){
        String result=demoService.sayHello("' or 1=1");
        assertThat(result, containsString("seveniruby says hello to \" or 1=1,"));
    }


}
