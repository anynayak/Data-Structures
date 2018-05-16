import java.util.Arrays;

public class Heap {

	private int[] heapArray=new int[10];
	private int index=0;
	
	public boolean addElement(int value)
	{
		if(index<heapArray.length)
			heapArray[++index]=value;
		else 
			return false;
		heapify();
		return true;
	}
	
	private void heapify()
	{
		int chIndex=0;
		for (int i = 1; i < index; i++) 
		{
			chIndex=2*i+1;
			if(chIndex>=index) break;
			if(heapArray[i]<heapArray[chIndex])
			{
				int temp=heapArray[chIndex];
				heapArray[chIndex]=heapArray[index];
				heapArray[i]=temp;
			}
			if(heapArray[i]< heapArray[chIndex-1])
			{
				int temp=heapArray[chIndex-1];
				heapArray[chIndex-1]=heapArray[i];
				heapArray[i]=temp;
			}
		}
	}
	
	public boolean deleteMin()
	{
		if(index>1)
		{
			heapArray[1]=heapArray[index];
			heapArray[index]=0;
			index--;
		}
		else 
			return false;
		heapify();
		return true;
	}
	@Override
	public String toString() {
		return Arrays.toString(heapArray);
	}
	
	public static void main(String[] args) {
		Heap hp=new Heap();
		hp.addElement(1);
		hp.addElement(2);
		hp.addElement(3);
		hp.addElement(10);
		hp.addElement(11);
		hp.addElement(6);
		hp.deleteMin();
		System.out.println(hp);
				
	}
}
