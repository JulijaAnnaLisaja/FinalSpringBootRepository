package com.cse.spring.component;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * CommandLineRunnerComponent test class definition.
 *
 * @author julija.anna.lisaja@accenture.com
 */
@SpringBootTest
public class CommandLineRunnerComponentTest {

    @SpyBean
    CommandLineRunnerComponent commandLineTaskExecutor;

    @Test
    void whenContextLoads_thenRunnersRun() throws Exception {
        verify(commandLineTaskExecutor, times(1)).run(any());
    }
}
