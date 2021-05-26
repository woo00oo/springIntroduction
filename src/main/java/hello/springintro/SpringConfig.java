package hello.springintro;

import hello.springintro.repository.JdbcMemberRepository;
import hello.springintro.repository.MemberRepository;
import hello.springintro.repository.MemoryMemberRepository;
import hello.springintro.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

}
