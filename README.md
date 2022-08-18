
![](https://img.shields.io/badge/spring-2.7.2-brightgreen)
![](https://img.shields.io/badge/security-5.7.2-blue)

# 1 . Deprecated 목록

-   WebSecurityConfigurerAdapter
-   SecurityContextPersistenceFilter

## 1\. 1 WebSecurityConfigurerAdapter Deprecated

```java
@Configuration  
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {  

    @Override  
    protected void configure(HttpSecurity http) throws Exception {  
        http  
            .authorizeHttpRequests((authz) -> authz  
                .anyRequest().authenticated()  
            )  
            .httpBasic(withDefaults());  
    }  

}  
```

-   기존 방식은 **WebSecurityConfigurerAdapter**를 상속받아 configure을 Override하여 구현한다.

```java
@Configuration  
public class SecurityConfiguration {  

    @Bean  
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {  
        http  
            .csrf().disable()  
            .formLogin().disable()    
                .authorizeHttpRequests((authz) -> authz  
                    .antMatchers("/admin").hasRole("ADMIN")  
                    .anyRequest().authenticated()  
                )  
            .httpBasic(withDefaults())  
            .authenticationManager(new CustomAuthenticationManager());  
        
        return http.build();  
    }  

}
```

-   상속을 받지 않고 bean으로 등록한다. 기존의 롤 부여 등 비슷하다.

## 1.2. SecurityContextPersistenceFilter Deprecated

-   기존에 인증된 정보가 있다면 다음 요청에서도 다시 인증을 하지않도록 SecurityContext를 공유하는 기능을 제공한다.
-   사용하게 된다면 아래와 같이 취소선으로 알려준다.

![image](https://user-images.githubusercontent.com/71534090/185418705-ab486d60-d673-496d-a280-73a0b9d03d3c.png)

# 2\. 참고문서

[https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter](https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter)  
[https://docs.spring.io/spring-security/reference/getting-spring-security.html](https://docs.spring.io/spring-security/reference/getting-spring-security.html)  
[https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html](https://docs.spring.io/spring-security/reference/servlet/authentication/session-management.html)
