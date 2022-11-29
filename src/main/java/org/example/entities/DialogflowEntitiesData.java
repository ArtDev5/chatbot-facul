package org.example.entities;

import java.util.Map;

public class DialogflowEntitiesData {
    private String intent;
    private Map<String, String> entities;

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public Map<String, String> getEntities() {
        return entities;
    }

    public void setEntities(Map<String, String> entities) {
        this.entities = entities;
    }

    @Override
    public String toString() {
        return "EntitiesData{" +
                "intent='" + intent + '\'' +
                ", entities=" + entities +
                '}';
    }
}