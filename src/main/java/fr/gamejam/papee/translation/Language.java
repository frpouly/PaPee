package fr.gamejam.papee.translation;

public enum Language {
    ENGLISH_US ("en_US"),
    FRENCH_FR ("fr_FR");

    private String locale;

    Language(String locale) {
        setLocale(locale);
    }

    public String getLocale() {
        return locale;
    }

    private void setLocale(String locale) {
        this.locale = (locale == null) ? "en_US" : locale;
    }
}
