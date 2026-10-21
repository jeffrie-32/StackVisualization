/* Description: <Describe what this program does briefly>
Programmed by: <GANDING, TACAN, PAHUYO, BARANDA, MALLRARI> <BSIT> <48160> 
<DATA STRUCTURE AND ALGORITHMS>
Last Modified: <date of latest revision>
Version: <version number>
[Acknowledgements: <list of sites and or sources, generative AI used and with
the prompt>]
*/

public class Stack {
    private int[] elements = new int[10];
    private int top = -1;

    public boolean push(int value) {
        if (top == elements.length - 1) {
            return false;
        }

        elements[++top] = value;
        return true;
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }

        return elements[top--];
    }

    public Integer peek() {
        if (isEmpty()) {
            return null;
        }

        return elements[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == elements.length - 1;
    }

    public int size() {
        return top + 1;
    }

    public void clear() {
        top = -1;
    }

    public int getElement(int index) {
        return elements[index];
    }
}