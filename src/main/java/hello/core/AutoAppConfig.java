package hello.core;

import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//설정정보를자동으로 긁어온다
@ComponentScan(
        //basePackages = "hello.core.member",
        //hello.core.member 에서 탑색해서 찾아들어간다.
        //패키지위치를 지정하지않고 설정정보위치를 프로젝트 최상단에 두는것이 관례!
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //AppConfig에 있는 Configuration을 자동으로 주입되는것을 방지하기 위해 필터설정
)
public class AutoAppConfig{

    //빈이름 중복테스트 수동으로 빈을 같은이름으로 등록
    //자동 vs 수동일 경우 수동이 우선순위를 가진다.
/*
    @Bean(name="memoryMemberRepository")
    MemoryMemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
*/

}
