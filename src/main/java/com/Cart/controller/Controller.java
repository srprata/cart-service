//  package com.Cart.controller;
//
//  import java.util.Map;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.Cart.service.ProductService;
//
//import graphql.ExecutionInput;
//import graphql.ExecutionResult;
//import graphql.GraphQL;
//import graphql.schema.GraphQLSchema;
//import io.leangen.graphql.GraphQLSchemaGenerator;
//import io.leangen.graphql.metadata.strategy.query.AnnotatedResolverBuilder;
//import io.leangen.graphql.metadata.strategy.value.jackson.JacksonValueMapperFactory;
//
//  @RestController
//  public class Controller {
//
//	  private final GraphQL graphQL;
//
//      public Controller(ProductService productService) {
//          GraphQLSchema schema = new GraphQLSchemaGenerator()
//                  .withResolverBuilders(new AnnotatedResolverBuilder())
//                  .withOperationsFromSingleton(productService, ProductService.class)
//                  .withValueMapperFactory(new JacksonValueMapperFactory())
//                  .generate();
//          graphQL = GraphQL.newGraphQL(schema).build();
//      }
//
//
//      @ResponseBody
//      public Map<String, Object> graphql(@RequestBody Map<String, String> request, HttpServletRequest raw) {
//          ExecutionResult executionResult = graphQL.execute(ExecutionInput.newExecutionInput()
//                  .query(request.get("query"))
//                  .operationName(request.get("operationName"))
//                  .context(raw)
//                  .build());
//          return executionResult.toSpecification();
//      }
//  
//  }