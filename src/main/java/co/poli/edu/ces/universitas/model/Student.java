package co.poli.edu.ces.universitas.model;

public class Student {

    public int id;
    protected String document;
    private String name;

    public int getId(){
        return this.id;
    }

    private void setId(int id){
        this.id = id;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "El estudiante se llama: " + this.name + " su documento es: " + this.document;
    }
}
