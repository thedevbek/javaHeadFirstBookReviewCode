
public class Dog {

    String name;

    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "68";

        Dog[] myDogs = new Dog[3];
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        myDogs[0].name = "Blu";
        myDogs[1].name = "Red";

        System.out.println("last dog's name is");
        System.out.println(myDogs[2].name);

        int x =  0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

    private void bark() {
        System.out.println(name + " says Ruff!");
    }

    public void eat() {

    }
    public void chaseCat() {

    }
}
