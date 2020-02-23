package io.github.lsikora.dynamic.testtemplateprovider;

import io.github.lsikora.constants.Food;
import io.github.lsikora.extensions.FiveMinuteExtension;
import org.junit.jupiter.api.extension.*;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.stream.Stream.of;

/*This class shows example of simple TestTemplate provider. It will create a
dynamic test for each value in Food enum*/
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
        return of(Food.values())
                .map(it -> templateContext(it, context));
    }

    TestTemplateInvocationContext templateContext(Food fruit, ExtensionContext context) {
        return new TestTemplateInvocationContext() {
            @Override
            public String getDisplayName(int invocationIndex) {
                return context.getTestMethod()
                        .map(it -> ("Converted enum name:" + fruit.getName()))
                        .orElse("Unknown parameter");
            }

            @Override
            public List<Extension> getAdditionalExtensions() {
                return asList(new FiveMinuteExtension("Converted name from enum " + fruit),
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
