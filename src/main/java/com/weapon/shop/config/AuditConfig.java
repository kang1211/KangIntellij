
// 자동감사기능(생성일자, 수정일자, 생성자, 수정자) 작업

package com.weapon.shop.config;

import com.weapon.shop.config.AuditorAwareImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration// 스프링의 java구성 클래스
@EnableJpaAuditing// 자동감사기능(생성일자, 수정일자, 생성자, 수정자 관리 기능)
public class AuditConfig {
    @Bean// 스프링에 빈 객체 제공
    public AuditorAware<String> auditorProvider()
    {
        return new AuditorAwareImpl();
    }
    // Spring Data JPA에서 자동 감사를 위해 사용자 정보를 관리하는 인터페이스
    // AuditorAware 인터페이스의 구현체인 AuditorAwareImpl을 반환
}
