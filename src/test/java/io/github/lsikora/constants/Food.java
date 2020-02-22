package io.github.lsikora.constants;

public enum Food {
    APPLE(Constants.APPLE_NAME),
    ORANGE (Constants.ORANGE_NAME),
    GHERKIN (Constants.GHERKIN_NAME),
    PICKLE (Constants.PICKLE_NAME),
    VEGETABLE (Constants.VEGETABLE_NAME),
    FRUIT (Constants.FRUIT_NAME);

    private String name;

    Food(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Constants {
        public static final String GLOBAL_MESSAGE = "Global message";
        public static final String APPLE_NAME = "apple";
        public static final String ORANGE_NAME = "orange";
        public static final String GHERKIN_NAME = "gherkin";
        public static final String PICKLE_NAME = "pickle";
        public static final String VEGETABLE_NAME = "vegetable";
        public static final String FRUIT_NAME = "fruit";
    }
}
