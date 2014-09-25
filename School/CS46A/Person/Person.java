public class Person
{
    private Person father;
    private Person mother;
    /*
     * This contructs a person in which their mother and father are unknown
     */
    public Person()
    {
        father = null;
        mother = null;
    }
    /*
    Constructs a person.
    @param father the father, or null if not known
    @param mother the mother, or null if not known
     */
    public Person(Person father, Person mother)
    {
        this.father = father;
        this.mother = mother;
    }
    /*
     * This tests whether the person is a Parent of the other person
     * @param other the other person
     * @return true or false
     */
    public boolean isParent (Person other)
    {
      return this.equals(other.mother) || this.equals(other.father);
    }
    /*
     * This tests whether the person is a grandparent of the other person
     * @param other the other person
     * @return true or false
     */
    public boolean isGrandParent (Person other)
    {
        
        return this.isParent(other.father) || this.isParent(other.mother);
    }
    /*
     * This tests whether the person is a sibling of the other person
     * @param other the other person
     * @return true or false
     */
    public boolean isSibling(Person other)
    {
        return (this.mother.equals(other.mother) && this.father.equals(other.father));
    }

}
