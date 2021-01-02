/* QueueOfDoublesInterface
 * 
 * This interface specifies the API for a queue of
 * double values.
 *
 * The only methods specified are enqueue, dequeue,
 * and isEmpty(), because that is enough to
 * illustrate the API of a queue.
 *
 * A more useful queue interface would also specify
 * access to the value at the head of the list (peek),
 * and to the queue's size.
 */

public interface QueueOfDoublesInterface {
    public void enqueue(double d); // add d to the end of the queue
    public void dequeue();         // remove the first item in the queue
    public boolean isEmpty();      // return whether or not the queue is emtpy
}