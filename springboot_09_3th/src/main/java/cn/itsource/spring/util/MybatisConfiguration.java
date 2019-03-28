package cn.itsource.spring.util;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

public class MybatisConfiguration {
    //相当于xml  中的一个bean
    @Bean
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
