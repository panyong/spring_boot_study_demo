package com.rambo.demo.component.configuration;

import com.rambo.demo.component.Interceptor.AuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.nio.charset.Charset;
import java.util.List;

/**
 * User: za-panyong
 * Date: 2019/5/15
 * Time: 18:41
 */
@Configuration
public class WebMvcConfigure extends WebMvcConfigurationSupport {
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authInterceptor()).addPathPatterns("/*");
    }

    /*
     * 该方法不建议使用，因为此方法接管了Spring初始化时对HttpMessageConverters的初始化过程，接管以后，Spring不再对此进行初始化
     * 该方法在 extendMessageConverters 之前执行
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(stringHttpMessageConverters());
        System.out.println("sss");
    }*/

    /**
     * 建议使用该方法进行HttpMessageConverters的修改，此时的converters已经是Spring初始化过的
     * 因为加入了Filter、Listener和Interceptor等，导致Spring的HttpMessageConverters中的String转换类默认使用ISO-9**编码
     * 所以这里对Spring已经初始化过的StringHttpMessageConverter的编码进行修改
     * @param converters
     */
    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.forEach(converter -> {
            if (converter instanceof StringHttpMessageConverter){
                ((StringHttpMessageConverter) converter).setDefaultCharset(Charset.forName("UTF-8"));
            }
        });
    }

    @Bean
    public AuthInterceptor authInterceptor(){
        return new AuthInterceptor();
    }


    /*
     * 因为上面的configureMessageConverters不建议使用，所以该方法也不需要了
    @Bean
    public HttpMessageConverter<String> stringHttpMessageConverters(){
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
        return stringHttpMessageConverter;
    }*/
}
