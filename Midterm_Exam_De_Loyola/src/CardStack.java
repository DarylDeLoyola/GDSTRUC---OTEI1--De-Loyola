import java.util.EmptyStackException;

public class CardStack {
    private Cards[] stack;
    private int top;



    public CardStack(int capacity) {
        stack = new Cards[capacity];
        top = -1;
    }

    public void push(Cards card) {
        if (top == stack.length - 1) {
            Cards[] newStack = new Cards[stack.length * 2];
            System.arraycopy(stack, 0, newStack, 0,stack.length);
            stack = newStack;
        }

        stack[++top] = card;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public Cards pop()  {
        if (isEmpty())
            throw new EmptyStackException();

        Cards poppedCards = stack[top];
        stack[top] = null;
        top--;
        return poppedCards;
    }

    public Cards peek() {
        if (isEmpty())
            throw new EmptyStackException();

        return stack[top];
    }

    public void printstack() {
        System.out.println("Printing stack...");

        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
