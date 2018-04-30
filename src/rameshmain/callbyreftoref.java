package rameshmain;

public class callbyreftoref {
int x = 30;
int y = 40;
	public static void main(String[] args) {
		callbyreftoref obj = new callbyreftoref();
		obj.swap(obj);
		System.out.println(obj.x);
		System.out.println(obj.y);
		
		System.out.println(obj.sum(obj));
	}
	public void swap(callbyreftoref t) {
		
		int temp;
		temp = t.x;
		t.x= t.y;
		t.y = temp;
			}

	
public int sum(callbyreftoref f) {
		
		int temp;
		temp = f.x+f.y;
		return temp;
			}

}
