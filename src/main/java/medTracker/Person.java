package medTracker;
/**



 * The {@code Person} class represents an individual with an ID, name, age, and phone number.


 * It serves as a base class for other entities such as patients.


 */
public class Person {
    private final int id;
    private final String name;
    private final int age;
    private final String phoneNumber;
    /**



     * Constructs a new Person with the specified attributes.


     *


     * @param id          The unique identifier of the person.


     * @param name        The name of the person.


     * @param age         The age of the person.


     * @param phoneNumber The contact phone number of the person.


     */
    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters and Setters

    // Getters and Setters






    /**


     * Gets the person's unique ID.


     *


     * @return The person's ID.


     */

    public int getId()  {
        return id;
    }
    /**



     * Gets the person's name.


     *


     * @return The person's name.


     */

    public String getName() { 
        return name; 
    }

    /**



     * Gets the person's age.


     *


     * @return The age of the person.


     */

    public int getAge() {
        return age; 
    }
    /**



     * Gets the person's phone number.


     *


     * @return The person's phone number.


     */
    public String getPhoneNumber() {
        return phoneNumber; }

    @Override
    public String toString() {
        return String.format("Person Id: %d%n Person name: %s%n Person age: %d%n Person phone number: %s%n",
         id, name, age, phoneNumber);
    }
}

