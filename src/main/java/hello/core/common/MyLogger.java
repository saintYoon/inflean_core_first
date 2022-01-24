package hello.core.common;


import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
//@Scope("request")   //HTTP요청이 이뤄지는 순간에 하나씩 생성된다.
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)   //가짜를 만드는것
public class MyLogger {

    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL){
        this.requestURL = requestURL;
    }
    public void log(String message){
        System.out.println("[" + uuid+"]"+"["+requestURL+"] " + message);
    }

    @PostConstruct
    public void init(){
        uuid = UUID.randomUUID().toString();
        System.out.println("[" + uuid+"] request scope bean creaete : "+ this);
    }
    @PreDestroy //request스코프에는 destroy가 호출된다
    public void close(){
        System.out.println("myLogger = " + this);
        System.out.println("[" + uuid+"] request scope bean close : "+ this);
    }
}
