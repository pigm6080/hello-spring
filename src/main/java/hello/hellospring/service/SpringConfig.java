package hello.hellospring.service;

import hello.hellospring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    //private DataSource dataSource;
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em){
        this.em =em;
     //  this. dataSource = dataSource;

    }


    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());

    }

    @Bean
    public MemberRepository memberRepository(){
       // return new JdbcMemberRepository(dataSource);
       // return new JdbcTemplateMemberRepository(dataSource);
        return new JpaMemberRepository(em);
    }
}
