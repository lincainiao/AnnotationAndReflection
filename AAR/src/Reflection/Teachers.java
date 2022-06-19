package Reflection;

public class Teachers extends Users{
    private String name;
    public Teachers(){
        this.name = "teacher";
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
        return "Teachers{" +
                "name='" + name + '\'' +
                '}';
    }
}
