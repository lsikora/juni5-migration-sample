package io.github.lsikora.extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

/*This class is one of simplest possible JUnit 5 extensions implementation*/
public class FiveMinuteExtension implements BeforeEachCallback {
    private String message;

    public FiveMinuteExtension(String message) {
        this.message = message;
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println(message);
    }
}
