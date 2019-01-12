import org.apache.dubbo.samples.basic.api.DemoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    @Test
    public void consumer1() throws InterruptedException {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
                "consumer.xml");
        System.out.println("load");
        context.start();
        System.out.println("start");
        DemoService demoService=(DemoService) context.getBean("demoService");
        System.out.println("bean");
        for(int i=0;i<10;i++) {
            Thread.sleep(1000);
            System.out.println(demoService.sayHello("思寒 "+i));
        }

    }

}
