class Parent {
 private void method1(){
  System.out.println("parent method1");
 }
 public void method2(){ // 부모 메소드밖에 알 수 없어서 child의 method1()를 알 수 없음
   method1();
 }
}

class Child extends Parent {
 public void method1(){
  System.out.println("child method1");   // 얘 어디감?
 }
 
 public void method2() {   // 재정의를 해야만 자식 클래스의 메소드를 알 수 있음
     method1();
 }
}

public class Test {
 public static void main(String[] args) {
  Child c = new Child();
  c.method2();
  c.method1();
 }
}