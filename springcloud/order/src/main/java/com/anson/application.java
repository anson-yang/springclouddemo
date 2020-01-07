package com.anson;


        import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
        import org.springframework.boot.SpringApplication;
        import org.springframework.boot.autoconfigure.SpringBootApplication;
        import org.springframework.boot.web.servlet.ServletRegistrationBean;
       // import org.springframework.cloud.client.loadbalancer.LoadBalanced;
        import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
        import org.springframework.cloud.netflix.hystrix.EnableHystrix;
        import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
        import org.springframework.cloud.openfeign.EnableFeignClients;
        import org.springframework.context.annotation.Bean;
       // import org.springframework.web.client.RestTemplate;

/**
 * @description: TODO
 * @author: anson
 * @Date: 2019/12/20 23:46
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@EnableHystrixDashboard
public class application
{
    public  static void main(String[] args)
    {
        SpringApplication.run(application.class);
    }

//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() {
//        return new RestTemplate();
//    }

    @Bean
    public ServletRegistrationBean getServlet(){
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
