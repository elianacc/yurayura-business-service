package org.cny.yurayura.system.shiro;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * shiro config
 *
 * @author CNY
 * @since 2020-12-02
 */
@Configuration
public class ShiroConfig {

    /**
     * 创建ShiroFilterFactoryBean（shiro过滤器工厂）放入bean中
     *
     * @param securityManager
     * @return org.apache.shiro.spring.web.ShiroFilterFactoryBean
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
        // 设置安全管理器
        filterFactoryBean.setSecurityManager(securityManager);

        /*
         *  添加shiro内置过滤器
         *  anon: 无需认证即可访问
         *  authc: 必须认证才可访问
         *  user: 必须拥有记住我功能才可访问
         *  perms: 必须拥有某个权限才可访问
         *  role: 必须拥有某个角色才可访问
         * */
        Map<String, String> fillterMap = new LinkedHashMap<>();

        fillterMap.put("/api/comic/get*", "perms[select]");
        fillterMap.put("/api/comic/insert*", "perms[insert]");
        fillterMap.put("/api/comic/delete*", "perms[delete]");
        fillterMap.put("/api/comic/update*", "perms[update]");
        fillterMap.put("/api/sys/dict/getByDictCode", "perms[select]");
        fillterMap.put("/api/sys/dict/**", "perms[sys]");
        fillterMap.put("/api/sys/manager/getVerifyCode", "anon");
        fillterMap.put("/api/sys/manager/login", "anon");
        fillterMap.put("/api/sys/manager/logout", "anon");
        fillterMap.put("/api/sys/manager/judgeAuthen", "anon");
        fillterMap.put("/api/sys/manager/**", "perms[sys]");
        fillterMap.put("/api/sys/menu/getList", "perms[select]");
        fillterMap.put("/api/sys/menu/**", "perms[sys]");

        filterFactoryBean.setFilterChainDefinitionMap(fillterMap);

        return filterFactoryBean;
    }

    /**
     * 创建DefaultWebSecurityManager（默认安全管理器）放入bean中
     *
     * @param userRealm
     * @return org.apache.shiro.web.mgt.DefaultWebSecurityManager
     */
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 把ManagerRealm放入DefaultWebSecurityManager
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    /**
     * 创建自定义的Realm对象放入bean中
     *
     * @param
     * @return org.cny.yurayura.system.shiro.UserRealm
     */
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

}
