import org.apache.dubbo.samples.basic.api.DemoService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsumerTest {
    @Test
    public void consumer1(){
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext(
                "consumer.xml");
        System.out.println("load");
        context.start();
        System.out.println("start");
        DemoService demoService=(DemoService) context.getBean("demoService");
        System.out.println("bean");
        System.out.println(demoService.sayHello("思寒"));

    }

}
