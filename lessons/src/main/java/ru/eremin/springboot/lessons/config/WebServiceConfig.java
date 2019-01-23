package ru.eremin.springboot.lessons.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import ru.eremin.springboot.lessons.endpoint.NoteEndpoint;

/**
 * @autor Eremin Artem on 22.01.2019.
 */

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String WS_MAPPING = "/soap/*";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        final MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, WS_MAPPING);
    }

    @Bean(name = "NoteService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema xsdSchema) {
        final DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName(NoteEndpoint.PORT_TYPE_NAME);
        wsdl11Definition.setLocationUri(NoteEndpoint.LOCATION_URI);
        wsdl11Definition.setTargetNamespace(NoteEndpoint.NAMESPACE);
        wsdl11Definition.setSchema(xsdSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema xsdSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/noteEndpoint.xsd"));
    }


}
