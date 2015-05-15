package LocalInnerClass;

public class C extends B {
	public void f3(){
		class InnerA extends A{}
		InnerA newA = new InnerA();
		newA.f1();
	}

}
