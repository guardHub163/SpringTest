import com.gdchent.cn.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class AppTest {

    @Test
    public void shouldAnswerWithTrue(){

    }
    /**
     * 测试方法，使用junit
     * 1.定义方法,public void 方法名自定义的(){}
     * 2.在方法的上面加入@Test
     */

    @Test
    public void test02(){
        //spring.xml放在项目的根之下,只给出文件名称
        String config="spring.xml";
        //使用FileSystemXml读取配置文件
        ApplicationContext context=new FileSystemXmlApplicationContext(config);
        SomeService someService = (SomeService) context.getBean("someServiceBean");
        someService.doSome();
    }
}
