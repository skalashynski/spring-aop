package com.example.p353;

import com.example.p342.SimpleAdvice;
import com.example.p349.bean.Guitar;
import com.example.p352.bean.Guitarist;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectjexpPointcutDemo {
    public static void main(String[] args) {
        Guitarist johnMayer = new Guitarist();
        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();

        pc.setExpression("execution(* sing*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(johnMayer);
        pf.addAdvisor(advisor);
        Guitarist proxy = (Guitarist) pf.getProxy();
        proxy.sing();
        proxy.sing2();
        proxy.rest();
    }
}
