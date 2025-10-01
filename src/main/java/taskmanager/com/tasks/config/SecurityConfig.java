package taskmanager.com.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/tasksmanager/signup", "/tasksmanager/login", "/", "/tasksmanager").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/tasksmanager/login")
                .defaultSuccessUrl("/tasksmanager/tasks/homepage", true)
                .failureUrl("/tasksmanager/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/tasksmanager/logout")
                .logoutSuccessUrl("/tasksmanager/login?logout=true")
                .permitAll()
            )
            .csrf(csrf -> csrf.disable()); // Disable CSRF for simplicity

        return http.build();
    }
}
