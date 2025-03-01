package kr.or.ddit.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
<<<<<<< HEAD
=======
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
>>>>>>> branch 'main' of https://github.com/sunday1284/jsp_spring02.git
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
	
	
	
//	@Bean
//	public UserDetailsService userDetailsService() {
//		//한사람의 사용자 UserDetails
//		UserDetails a001 = User.builder()
//			.username("a001")
//			//db 저장 -> 암호화
//			.password(passwordEncoder().encode("asdfasdf"))
//			.roles("USER")
//			.build();
//		UserDetails c001 = User.builder()
//				.username("c001")
//				.password(passwordEncoder().encode("7777"))
//				.roles("USER","ADMIN")
//				.build();
//
//		return new InMemoryUserDetailsManager(a001, c001);
//	}
	
	
    /**
     * 인증(AuthentiactionManager)과 인가(AuthorizationManager)를 지원하는 필터 체인 구조 형성.
     * AntPathRequestMatcher **와일드 카드 두개일때 씀
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(customizer->customizer.disable()) // csrf 토큰 , customizer.disable() ->끄기
            .authorizeHttpRequests(authorize -> 
            	authorize
            		//ROLE_ADMIN이면 , permitAll ->  누구나 가능 , authenticated -> 로그인한 사용자만
            		.requestMatchers(new AntPathRequestMatcher("/member/memberInsert.do")).permitAll()
            		.requestMatchers(new AntPathRequestMatcher("/member/memberList.do")).hasRole("ADMIN")
            		.requestMatchers(new AntPathRequestMatcher("/member/memberDetail.do")).hasRole("ADMIN")
            		.requestMatchers(new AntPathRequestMatcher("/member/**")).authenticated()
            		.requestMatchers(new AntPathRequestMatcher("/mypage")).authenticated()
            		//등록, 수정 방식(POST)일때만(관리자용)
            		.requestMatchers(new AntPathRequestMatcher("/prod/**", "POST")).hasRole("ADMIN")
            		.requestMatchers(new AntPathRequestMatcher("/buyer/**")).hasRole("ADMIN")
            		.anyRequest().permitAll() // 모든 자원을 보호 , permitAll -> 비보호
            )
            //로그인폼도 만들어줌 -> 커스터마이징 기능
            .formLogin(customizer->
            	customizer.loginPage("/login/loginForm.jsp")
            	//처리 url
            		.loginProcessingUrl("/Login/LoginProcess")
            		.usernameParameter("memId")
            		.passwordParameter("memPass")
            		.permitAll() //누구나 접근 가능 
            ).logout(customizer->
            	customizer.logoutUrl("/Login/Logout")
            			.logoutSuccessUrl("/")
            );
    
        return http.build();
    }
   

}
