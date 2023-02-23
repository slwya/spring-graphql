package com.example.springgraphql.global.handler;

import org.springframework.http.HttpStatus;

/**
 * <pre>
 * GraphQL InternalServerError Excpetion
 * 비지니스 로직 처리 중 오류가 발생한 경우
 * </pre>
 *
 * @since 2022. 9. 20.
 */
public class GraphQlInternalServerErrorException extends GraphQlCustomException {
    public GraphQlInternalServerErrorException(String message) {
        super(message, HttpStatus.INTERNAL_SERVER_ERROR, "INTERNAL_SERVER_ERROR");
    }
}
