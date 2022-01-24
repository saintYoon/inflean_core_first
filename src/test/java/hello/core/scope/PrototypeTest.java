package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrototypeTest {
    @Test
    void prototypeBeanFind(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtyTypeBean.class);
        System.out.println("protoTypeBean1");
        ProtyTypeBean protyTypeBean1 = ac.getBean(ProtyTypeBean.class);
        System.out.println("protoTypeBean1");
        ProtyTypeBean protyTypeBean2 = ac.getBean(ProtyTypeBean.class);
        System.out.println("protoTypeBean1 = " + protyTypeBean1);
        System.out.println("protoTypeBean2 = " + protyTypeBean2);

        assertThat(protyTypeBean1).isNotSameAs(protyTypeBean2);

        ac.close(); //destroy가 자동으로 안먹으므로 수동으로 해줘야함
        protyTypeBean1.destroy();
        protyTypeBean2.destroy();
    }

    @Scope("prototype")
    static class ProtyTypeBean{
        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("ProtoTypeBean.destroy");
        }
    }


}
