package io.github.lsikora.extensions;

import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

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
