package j128_0531;

public class TryCatchFinallyRuntimeExceptionExample {

	public static void main(String[] args) {
		Try{ 
			Class class = Class.forName("java.lang.String2");
		}catch(ClassNotFoundException e) {
			System.out.println("클래스가 존재하지 않습니다.");
		}
		
	}

}
