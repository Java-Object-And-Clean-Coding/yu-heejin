public class Main {
    public static void main(String[] args) {
        Child child = new Child();
        
        child.printParentNumber();
    }
}

class Parent {
    private int number = 32;
    
    public Parent() {
        
    }
    
    public Parent(int number) {
        this.number = number;
    }
    
    public int getNumber(){
        return number;
    }
}

class Child extends Parent {
    public Child() {
        super();
    }
    
    public void printParentNumber() {
        // System.out.println("number is " + number);  // error: number has private access in Parent
        System.out.println("number is " + getNumber());
        // 상속은 되지만 private이기 때문에 접근할 수 없음
    }
}