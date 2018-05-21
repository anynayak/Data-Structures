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
		int phIndex=0,chIndex=index;
		while(chIndex>0)
		{
			phIndex=chIndex/2;
			if(phIndex<1) break;
			if(heapArray[chIndex]<heapArray[phIndex])
			{
				swap(chIndex, phIndex);
			}
			else 
				break;
		}
	}
	
	public boolean deleteMin()
	{
		if(index>0)
		{
			heapArray[1]=heapArray[index];
			heapArray[index]=0;
			index--;
		}
		else 
			return false;

		int phIndex=1;
		while(phIndex<index)
		{
			int chIndex=phIndex*2;
			int chIndex1=phIndex*2+1;
			int largest=phIndex;
			if(chIndex<=index && heapArray[chIndex]<heapArray[largest])
			{
				largest=chIndex;
			}
			if( chIndex1<=index && heapArray[chIndex1]<heapArray[largest])
			{
				largest=chIndex1;
			}
			
			if(phIndex!=largest)
			{
				swap(phIndex, largest);
				phIndex=largest;
			}
			else
				break;
		}
		return true;
	}
	
	private void swap(int i, int j)
	{
		int temp=heapArray[i];
		heapArray[i]=heapArray[j];
		heapArray[j]=temp;
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
		hp.deleteMin();
		hp.deleteMin();
		hp.addElement(7);
		hp.addElement(8);
		hp.addElement(8);
		System.out.println(hp);
				
	}
}
