public class Person {
    private int id;
    private String name;
    private int age;
    private String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters
    public int getId()  {
        return id;
    }

    public String getName() { 
        return name; 
    }

    public int getAge() {
        return age; 
    }

    public String getPhoneNumber() {
        return phoneNumber; }

    public void setName(String name) {
         this.name = name; 
    }

    public void setAge(int age) {
         this.age = age; 
    }

    public void setPhoneNumber(String phoneNumber) {
         this.phoneNumber = phoneNumber; 
    }

    @Override
    public String toString() {
        return String.format("Person Id: %d%n Person name: %s%n Person age: %d%n Person phone number: %s%n",
         id, name, age, phoneNumber);
    }
}

