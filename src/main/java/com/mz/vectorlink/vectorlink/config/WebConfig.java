package com.mz.vectorlink.vectorlink.config;





import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
public class WebConfig implements WebMvcConfigurer  {
	

   /*  @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    	configurer
    	          .defaultContentType(MediaType.APPLICATION_JSON)
    	          .favorPathExtension(true);
    	
    }
     
  
   * Configure ContentNegotiatingViewResolver
   
     
     @Bean
     public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
         ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
         resolver.setContentNegotiationManager(manager);

         // Define all possible view resolvers
         List<ViewResolver> resolvers = new ArrayList<>();

         resolvers.add(csvViewResolver());
       //  resolvers.add(excelViewResolver());
      //   resolvers.add(pdfViewResolver());

         resolver.setViewResolvers(resolvers);
         return resolver;
     }
     
     
      * Configure View resolver to provide XLS output using Apache POI library to
      * generate XLS output for an object content
      
     @Bean
     public ViewResolver excelViewResolver() {
         return new ExcelViewResolver();
     }

     
      * Configure View resolver to provide Csv output using Super Csv library to
      * generate Csv output for an object content
      
     @Bean
     public ViewResolver csvViewResolver() {
         return new CsvViewResolver();
     }

     
      * Configure View resolver to provide Pdf output using iText library to
      * generate pdf output for an object content
      
     @Bean
     public ViewResolver pdfViewResolver() {
         return new PdfViewResolver();
     }*/

}
