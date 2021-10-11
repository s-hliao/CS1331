
public class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name+" "+age;
    }
    
    public static void main(String[]args) {
        Person[]people = new Person[15];
        
        for(int i = 0; i<people.length; i++) {
            if(people[i].age>21) {
                System.out.println(people[i]);
            }
        }
    }
    
}
