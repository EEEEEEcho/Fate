package com.thinkInJava.chapter14;

public class Position {
    private String title;
    private Person person;
    public Position(String jobTitle,Person employee){
        title = jobTitle;
        person = employee;
        if (person == null){
            person = Person.NULL;
        }
    }

    public Position(String jobTitle){
        title = jobTitle;
        person = Person.NULL;
    }
    @Override
    public String toString() {
        return "Position{" +
                "title='" + title + '\'' +
                ", person=" + person +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        if (person == null){
            person = Person.NULL;
        }
    }
}
