package com.cse.spring.model;

import com.cse.spring.entity.PersonEntityTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Customized Exception model test class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
public class CustomizedExceptionModelTest {

    private static final Logger logger = LogManager.getLogger(PersonEntityTest.class);

    @Test
    public void testUserDetails_WithAllArgsConstructorAndGetters() {
        String message = "Nothing was found";
        String errorCode = "404";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ZonedDateTime timestamp = ZonedDateTime.now();

        CustomizedExceptionModel notFound = new CustomizedExceptionModel(message, errorCode, httpStatus, timestamp);
        assertThat(notFound.getMessage()).isEqualTo(message);
        assertThat(notFound.getErrorCode()).isEqualTo(errorCode);
        assertThat(notFound.getHttpStatus()).isEqualTo(httpStatus);
        assertThat(notFound.getTimestamp()).isEqualTo(timestamp);
    }
}
