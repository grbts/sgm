package domain;

public class Elements {
    String type;
    int id;
    Tags tags;

    public Elements(String type, int id, Tags tags) {
        this.type = type;
        this.id = id;
        this.tags = tags;
    }

    public Elements() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }
}
