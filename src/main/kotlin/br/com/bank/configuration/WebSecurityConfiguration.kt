package br.com.bank.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class WebSecurityConfiguration {

    @Bean
    fun filterChain(http: HttpSecurity) : SecurityFilterChain {

        http
            .csrf()
            .disable()
            .authorizeHttpRequests()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()

        return http.build()
       // return http.build()

      // return http.httpBasic(withDefaults()).build()



    }

    @Bean
    public fun userDetailsService(): UserDetailsService {
        val users: User.UserBuilder = User.withDefaultPasswordEncoder()
        val manager = InMemoryUserDetailsManager()
        manager.createUser(users.username("jeyziel").password("12345").roles("USER").build())
        manager.createUser(users.username("admin").password("password").roles("USER","ADMIN").build())
        return manager
    }




}