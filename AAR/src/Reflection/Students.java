package Reflection;

public class Students extends Users{
    private String name;
    public Students(){
        this.name = "student";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                '}';
    }
}
