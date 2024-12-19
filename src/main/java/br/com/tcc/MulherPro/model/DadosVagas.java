package br.com.tcc.MulherPro.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVagas(@JsonAlias  ("title") String titulo,
                         @JsonAlias ("company") String empresa,
                         @JsonAlias ("location") String localidade,
                         @JsonAlias("redirect_url") String link) {
    public static class Company {
        private String displayName;

        // Getter
        public String getDisplayName() {
            return displayName;
        }

        // Setter
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

    public static class Location {
        private String displayName;

        // Getter
        public String getDisplayName() {
            return displayName;
        }

        // Setter
        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }
}

