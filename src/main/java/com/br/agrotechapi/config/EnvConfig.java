// package com.br.agrotechapi.config;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.env.Environment;
// import org.springframework.core.env.StandardEnvironment;
// import org.springframework.core.io.Resource;
// import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
// import org.springframework.core.io.support.ResourcePatternResolver;
// import org.springframework.util.StringUtils;

// import java.io.IOException;
// import java.nio.file.Files;
// import java.util.Properties;

// @Configuration
// public class EnvConfig {

//     @Autowired
//     private Environment environment;

//     public EnvConfig() {
//         try {
//             loadEnvVariables();
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }

//     private void loadEnvVariables() throws IOException {
//         ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
//         Resource[] resources = resourcePatternResolver.getResources("classpath:*.env");

//         for (Resource resource : resources) {
//             Properties properties = new Properties();
//             properties.load(resource.getInputStream());

//             for (String propertyName : properties.stringPropertyNames()) {
//                 String value = properties.getProperty(propertyName);
//                 if (!StringUtils.isEmpty(value)) {
//                     ((StandardEnvironment) environment).getSystemProperties().put(propertyName, value);
//                 }
//             }
//         }
//     }
// }
