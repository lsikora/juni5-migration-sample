package io.github.lsikora.testtemplate;

import io.github.lsikora.extensions.FiveMinuteExtension;
import io.github.lsikora.parametrized.Food;
import org.junit.jupiter.api.extension.*;

import java.util.List;
import java.util.stream.Stream;

import static io.github.lsikora.parametrized.Food.APPLE;
import static io.github.lsikora.parametrized.Food.ORANGE;
import static java.util.Arrays.asList;

public class FruitNameProvider implements TestTemplateInvocationContextProvider {
    public FruitNameProvider() {
    }

    @Override
    public boolean supportsTestTemplate(ExtensionContext context) {
        return context.getTestMethod()
                .filter(it -> 1 == it.getParameterTypes().length)
                .map(it -> it.getParameterTypes()[0].equals(String.class))
                .orElse(false);
    }

    @Override
    public Stream<TestTemplateInvocationContext> provideTestTemplateInvocationContexts(ExtensionContext context) {
        return Stream.of(ctx(ORANGE), ctx(APPLE));
    }

    TestTemplateInvocationContext ctx(Food fruit) {
        return new TestTemplateInvocationContext() {
            @Override
            public List<Extension> getAdditionalExtensions() {
                return asList(new FiveMinuteExtension("Converted name from enum constant " + fruit),
                        new ParameterResolver() {
                            @Override
                            public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return String.class == parameterContext.getParameter().getType();
                            }

                            @Override
                            public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
                                return fruit.name();
                            }
                        }
                );
            }
        };
    }
}
