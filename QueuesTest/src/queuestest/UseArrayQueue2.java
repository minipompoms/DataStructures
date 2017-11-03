package queuestest;


public class UseArrayQueue2 {

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		
	Integer element1 = 1;
        Integer element2 = 0;
       Integer element3 = 4;
      q.enqueue(element2);
       
        q.enqueue(element1);
    q.enqueue(element1 + element3);
   // System.out.println(element1+element3);
    element2 = q.dequeue();
    q.enqueue(element3 * element3);
q.enqueue(element2);
q.enqueue(3);
element1 = q.dequeue();
//System.out.println(element1 + " " + element2 + " " + element3);
/*while (!q.isEmpty())
{
element1 = q.dequeue();
System.out.println(element1);
}*/

Queue<Integer> nq = new Queue<>();
int elemt1 = 4;
int elemt3= 0;

int elemt2= elemt1 + 1;
nq.enqueue(elemt2);
nq.enqueue(elemt2+ 1);
nq.enqueue(elemt1);
elemt2 = nq.dequeue();
elemt1 = elemt2 + 1;
nq.enqueue(elemt1);
nq.enqueue(elemt3);
while (!nq.isEmpty())
{
elemt1 = nq.dequeue();
System.out.println(elemt1);
}
		
		

	}

}
