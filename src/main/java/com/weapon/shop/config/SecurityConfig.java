
// 보안설정, 로그인, 로그아웃, 접근권한, 비밀번호 인코딩 작업

package com.weapon.shop.config;

import com.weapon.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration// 스프링의 java구성 클래스
@EnableWebSecurity// 스프링Security를 구성하는데 필요한 설정
public class SecurityConfig {

    @Autowired
    MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.formLogin()
                .loginPage("/members/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/members/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/") ;
// 로그인 페이지, 로그인 성공, 로그인 실패, 로그아웃 등의 정의 설정

        http.authorizeRequests()
                .mvcMatchers("/css/**", "/javascript/**", "/image/**").permitAll()
                .mvcMatchers("/" , "/members/**", "/item/**", "/images/**").permitAll()
                .mvcMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();
// URL패턴별로 접근 권한 설정
        http.csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
// 메서드를 통해 CSRF(Cross-Site Request Forgery) 설정을 정의
        return http.build();// SpringSecurity의 필터체인 완성
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
// 비밀번호의 인코더를 생성하는 메서드
}









