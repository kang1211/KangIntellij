
// 현재 인증된 사용자 정보를 가져와서 Optional에 담는 작업
// 이로써 현재 사용자 정보를 제공 가능

package com.weapon.shop.config;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
// AuditorAware<String>의 구현체 AuditorAwareImpl
    @Override
    public Optional<String> getCurrentAuditor() {
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        // 현재 사용자 정보 객체 생성
        String userId="";
        if(authentication != null){
            userId = authentication.getName();
            // 현재 사용자 정보의 Name을 userId필드에 삽입
        }
        return Optional.of(userId);
        // userId 변수를 Optional의 객체로 넘김
    }
}
