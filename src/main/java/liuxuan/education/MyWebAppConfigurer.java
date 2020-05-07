package liuxuan.education;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebAppConfigurer implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //外部访问路径映射到本地磁盘路径
        String photoPath = "C:\\Users\\sickb\\IdeaProjects\\ElearningServerV4\\data\\";
        registry.addResourceHandler("/p/**").addResourceLocations("file:"+photoPath+"photo\\");
        registry.addResourceHandler("/w/**").addResourceLocations("file:"+photoPath+"work\\");

    }
}
