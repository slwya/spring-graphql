package com.example.springgraphql.domain.product.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class ProductControllerTest {
    @Autowired
    GraphQlTester graphQlTester;

    @Test
    void productByCodeTest() {
        String document = """
                    query {
                        productByCode(productCode : 1) {
                            productCode
                            productName
                            price
                          }
                    }
                """;

        // When
        // Then
        graphQlTester.document(document)
                .execute()
                .path("productByCode")
                .entity(JsonNode.class);
    }

    @Test
    void productsTest() {
        String document = """
                    query {
                        products{
                           productCode
                           productName
                           price
                         }
                    }
                """;

        // When
        // Then
        graphQlTester.document(document)
                .execute()
                .path("products")
                .entity(JsonNode.class);
    }

    @Test
    void insertProductTest() {
        String document = """
                    mutation {
                      insertProduct(input: {
                        productCode : 1,
                        productName : "!!!",
                        price : 1000000
                      })
                    }
                """;

        // When
        // Then
        graphQlTester.document(document)
                .execute()
                .path("insertProduct");
    }

    @Test
    void deleteProductTest() {
        String document = """
                    mutation {
                      deleteProduct(productCode : 1)
                    }
                """;

        // When
        // Then
        graphQlTester.document(document)
                .execute()
                .path("insertProduct");
    }
}
