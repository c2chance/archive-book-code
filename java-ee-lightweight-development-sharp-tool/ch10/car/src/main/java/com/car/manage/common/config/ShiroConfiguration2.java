package com.car.manage.common.config;

import com.car.manage.common.filter.MShiroFilterFactoryBean;
import com.car.manage.common.security.AuthRealm;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置.
 */
@Configuration
public class ShiroConfiguration2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(ShiroConfiguration2.class);
    @Value("${single.logout.url}")
    private String singleLogout;

    /**
     * filter proxy.
     *
     * @return FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean delegatingFilterProxy() {
        LOGGER.info("注入Shiro的Web过滤器-->filterRegistrationBean");
        FilterRegistrationBean filterRegistration = new FilterRegistrationBean();
        DelegatingFilterProxy proxy = new DelegatingFilterProxy();
        proxy.setTargetFilterLifecycle(true);
        proxy.setTargetBeanName("shiroFilter");
        filterRegistration.setFilter(proxy);

        filterRegistration.addUrlPatterns("/*");
        filterRegistration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        return filterRegistration;
    }

    /**
     * ShiroFilter.<br/>
     * 注意这里参数中的 StudentService 和 IScoreDao 只是一个例子，因为我们在这里可以用这样的方式获取到相关访问数据库的对象，
     * 然后读取数据库相关配置，配置到 shiroFilterFactoryBean 的访问规则中。实际项目中，请使用自己的Service来处理业务逻辑。
     *
     * @param securityManager security manager
     * @return ShiroFilterFactoryBean
     */
    @Bean(name = "shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {

        LOGGER.info("注入Shiro的Web过滤器-->shiroFilter");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new MShiroFilterFactoryBean();

        //Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //要求登录时的链接(可根据项目的URL进行替换),非必须的属性,默认会自动寻找Web工程根目录下的"/login.jsp"页面
        //shiroFilterFactoryBean.setLoginUrl(singleLogout + "/sys/logout111");
        shiroFilterFactoryBean.setLoginUrl("/car/login");
        
        
        
        //登录成功后要跳转的连接,逻辑也可以自定义，例如返回上次请求的页面
        shiroFilterFactoryBean.setSuccessUrl("/index");
        //用户访问未对其授权的资源时,所显示的连接
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        /*定义shiro过滤器,例如实现自定义的FormAuthenticationFilter，需要继承FormAuthenticationFilter

        /*定义shiro过滤链 Map结构 * Map中key(xml中是指value值)的第一个'/'代表的路径是相对于
        HttpServletRequest.getContextPath()的值来的 * anon：它对应的过滤器里面是空的,什么都没做,
        这里.do和.jsp后面的*表示参数,比方说login.jsp?main这种 * authc：该过滤器下的页面必须验证后才能访问,
        它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.FormAuthenticationFilter
         */
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置退出过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "anon");
        filterChainDefinitionMap.put("logout", "anon");

        // <!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        // <!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        filterChainDefinitionMap.put("/login", "anon"); //anon 可以理解为不拦截
        filterChainDefinitionMap.put("login", "anon"); //anon 可以理解为不拦截
        filterChainDefinitionMap.put("/reg", "anon");
        filterChainDefinitionMap.put("/plugins/**", "anon");
        filterChainDefinitionMap.put("/pages/**", "anon");
        //filterChainDefinitionMap.put("/api/**", "anon");
        filterChainDefinitionMap.put("/dists/img/*", "anon");
        filterChainDefinitionMap.put("/webjars/**", "anon");
        filterChainDefinitionMap.put("/swragger*", "anon");
        filterChainDefinitionMap.put("/swragger*/*", "anon");
        filterChainDefinitionMap.put("/druid/*", "anon");
        filterChainDefinitionMap.put("/car/login", "anon");
        filterChainDefinitionMap.put("/car/login/single/**", "anon");
        filterChainDefinitionMap.put("/mobile/login", "anon");
        filterChainDefinitionMap.put("/mobile/login/single/**", "anon");
        //filterChainDefinitionMap.put("/mobile/login/logout", "anon");
        filterChainDefinitionMap.put("/mobile/register", "anon");
        filterChainDefinitionMap.put("/mobile/register/**", "anon");
        filterChainDefinitionMap.put("/mobile/index/**", "anon");
        filterChainDefinitionMap.put("/mobile/passports/**", "anon");
        filterChainDefinitionMap.put("/mobile/login/forget", "anon");
        filterChainDefinitionMap.put("/mobile/login/index2", "anon");
        filterChainDefinitionMap.put("/mobile/movingVehicle/**", "anon");
        //TODO
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * auth realm bean.
     *
     * @param cacheManager cache manager
     * @return auth realm
     */
    @Bean(name = "authRealm")
    public AuthRealm authRealm(@Qualifier("cacheManager") EhCacheManager cacheManager) {
        LOGGER.info("注入Shiro的Web过滤器-->authRealm");
        AuthRealm realm = new AuthRealm();
        realm.setCacheManager(cacheManager);
        return realm;
    }

    /**
     * Shiro生命周期处理器.
     *
     * @return life cycle bean post processor
     */
    @Bean(name = "lifecycleBeanPostProcessor")
    public static LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        LOGGER.info("注入Shiro的Web过滤器-->lifecycleBeanPostProcessor");
        return new LifecycleBeanPostProcessor();
    }

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions).
     * 需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能
     *
     * @return DefaultAdvisorAutoProxyCreator
     */
    @Bean
    @DependsOn({"lifecycleBeanPostProcessor"})
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        LOGGER.info("注入Shiro的Web过滤器-->advisorAutoProxyCreator");
        DefaultAdvisorAutoProxyCreator daap = new DefaultAdvisorAutoProxyCreator();
        daap.setProxyTargetClass(true);
        return daap;
    }

    /**
     * authorization advisor.
     *
     * @param securityManager security manager
     * @return authorization advisor
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(
            @Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        LOGGER.info("注入Shiro的Web过滤器-->authorizationAttributeSourceAdvisor");
        AuthorizationAttributeSourceAdvisor aasa = new AuthorizationAttributeSourceAdvisor();
        aasa.setSecurityManager(securityManager);
        return aasa;
    }

    /**
     * web security manager.
     *
     * @param authRealm    realm
     * @param cacheManager cache manager
     * @return DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager defaultWebSecurityManager(
            @Qualifier("authRealm") AuthRealm authRealm,
            @Qualifier("cacheManager") EhCacheManager cacheManager) {
        LOGGER.info("注入Shiro的Web过滤器-->securityManager");
        DefaultWebSecurityManager dwsm = new DefaultWebSecurityManager();
        dwsm.setRealm(authRealm);
        //      <!-- 用户授权/认证信息Cache, 采用EhCache 缓存 -->
        dwsm.setCacheManager(cacheManager);
        return dwsm;
    }

//    /**
//     * 加载shiroFilter权限控制规则（从数据库读取然后配置）
//     *
//     * @author car
//     * @create  2016年1月14日
//     */
//    private void loadShiroFilterChain(ShiroFilterFactoryBean shiroFilterFactoryBean, UserService stuService,
// IUserDao scoreDao){
//        /////////////////////// 下面这些规则配置最好配置到配置文件中 ///////////////////////
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
//        // authc：该过滤器下的页面必须验证后才能访问，它是Shiro内置的一个拦截器org.apache.shiro.web.filter.authc.
// FormAuthenticationFilter
//        filterChainDefinitionMap.put("/user", "authc");// 这里为了测试，只限制/user，实际开发中请修改为具体拦截的请求规则
//        // anon：它对应的过滤器里面是空的,什么都没做
//        LOGGER.info("##################从数据库读取权限规则，加载到shiroFilter中##################");
//        filterChainDefinitionMap.put("/user/edit/**", "authc,perms[user:edit]");// 这里为了测试，固定写死的值，也可以从
// 数据库或其他配置中读取
//
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/**", "anon");//anon 可以理解为不拦截
//
//        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
//    }

    /**
     * cache manager.
     *
     * @return cache manager
     */
    @Bean(name = "cacheManager")
    public EhCacheManager ehCacheManager() {
        LOGGER.info("注入Shiro的Web过滤器-->cacheManager");
        EhCacheManager em = new EhCacheManager();
        em.setCacheManagerConfigFile("classpath:ehcache-shiro.xml");
        return em;
    }
}
