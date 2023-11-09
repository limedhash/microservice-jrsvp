package security;

//@EnableWebSecurity
//@Configuration
//public class SecurityConfig extends VaadinWebSecurity {
public class SecurityConfig {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests(auth ->
//                auth.requestMatchers(
//                        AntPathRequestMatcher.antMatcher(HttpMethod.GET, "/images/*.png")).permitAll());
//        super.configure(http);
//        setLoginView(http, MainRoute.class);
//    }
//
//    @Bean
//    public UserDetailsService users() {
////        PasswordEncoder ped = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        UserDetails user = User.builder()
//                .username("user")
//                // password = password with this hash, don't tell anybody :-)
//                .password("user")
//                .roles("USER")
//                .build();
//        UserDetails admin = User.builder()
//                .username("admin")
//                .password("admin")
//                .roles("USER", "ADMIN")
//                .build();
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}