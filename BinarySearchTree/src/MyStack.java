
import java.util.EmptyStackException;


public class MyStack {
    private Node head;
    public MyStack()
    {
        head=null;
    }
    public boolean isEmpty()
    {
        return head==null;

    }

    public TNode top()
    {
        return head.element;
    }

    public void push(TNode item)
    {
        head = new Node(item,head);
    }
    public TNode pop() throws EmptyStackException
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
        {
            TNode e=head.element; // Element to pop
            head=head.next; // Bypass ﬁrst node
            return e;
        }


    }

}
