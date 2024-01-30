package rvt;

public class Student {
    public String name;
    public String surname;
    public String email;
    public String group;


    public Student(String name, String surname, String email, String group) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.group = group;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getGroup()
    {
        return this.group;
    }
    
    public String toString() {
        return String.format("{%s, %s, %s, %s}", this.name, this.surname, this.email, this.group);
    }

    public String[] toArray() {
        return new String[] {
            this.name,
            this.surname,
            this.email,
            this.group
        };
    }
}
