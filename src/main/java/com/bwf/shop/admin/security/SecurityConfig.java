package com.bwf.shop.admin.security;

import com.bwf.shop.admin.security.handle.LoginSuccessHandle;
import com.bwf.shop.admin.security.handle.LogoutSuccessHandle;
import com.bwf.shop.admin.security.handle.PermissionErrorHandle;
import com.bwf.shop.admin.service.impl.AdminService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;

import javax.annotation.Resource;

/*授权认证配置类*/
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter { //安全设置适配器

    @Resource
    private AdminService adminService;

    @Resource
    private GrantPermission grantPermission;

    @Resource
    private  ValidPermission validPermission;

    //认证失败处理器
    @Resource
    private PermissionErrorHandle permissionErrorHandle;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //配置用户的登录的方式
        auth.userDetailsService(adminService) //根据用户填写账户名称 获取用户对象
                .passwordEncoder(new BCryptPasswordEncoder()); //将获取的用户对象的密码和用户填写的密码加密后进行判断
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //配置过滤外的请求路径
        // 配置 Security 过滤请求的 例外
        web.ignoring().antMatchers("/administrator/login","/common/**","/img/**","/css/**","/js/**","/favicon.ico")
                .antMatchers("/swagger-ui.html", "/swagger-resources/**", "/images/**",
                        "/webjars/**", "/v2/api-docs", "/configuration/ui", "/configuration/security");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //配置springSecurity安全流程
        http.headers().frameOptions().disable() // 不允许嵌套iframe的查询
        .and()
        .authorizeRequests()// 配置 请求需要权限验证
        .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {

            @Override
            public <O extends FilterSecurityInterceptor> O postProcess(O o) {
                o.setSecurityMetadataSource(grantPermission); //配置授权对象
                o.setAccessDecisionManager(validPermission); //配置认证对象
                return o;
            }
        })
        .and()
        .formLogin() //开启表单验证
        .loginPage("/administrator/login") // 指定登录表单页面的url路径
        .loginProcessingUrl("/administrator/logindo") //指定验证登录表单的url路径
        .usernameParameter("username") // 账户的参数名称
        .passwordParameter("userpass")//账户密码的参数名称
        .successHandler(new LoginSuccessHandle())// 配置登录验证的成功处理器
        .permitAll()
        .and()
        .logout() //开启安全退出验证
        .logoutUrl("/administrator/logout") //指定安全退出url路径
        .logoutSuccessHandler(new LogoutSuccessHandle()) //配置安全退出处理器
        .permitAll()
        .and()
        .csrf() //跨域请求
        .disable() //禁用
        .exceptionHandling() //异常处理
        .accessDeniedHandler(permissionErrorHandle); // 配置权限认证失败处理器




    }

}

