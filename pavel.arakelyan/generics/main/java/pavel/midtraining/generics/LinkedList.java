package pavel.midtraining.generics;

/**
 * This is a simple implementation of doubly linked list
 * @param <E>
 */
public class LinkedList<E>  {
    private int size;
    private WrapperElement<E> head;
    private WrapperElement<E> tail;

    public LinkedList(){
    }

    /**
     * Appends element from tail
     * @param element that should be appended
     */
    public void add(E element){
        WrapperElement<E> newWrapper = new WrapperElement<E>(element);
        WrapperElement<E> holder;
        if (tail == null){
            tail = newWrapper;
        }
        else{
            holder = tail;
            tail = newWrapper;
            holder.setFrontPointer(newWrapper);
            tail.setBackPointer(holder);
        }
        if (head == null){
            head = tail;
        }
        size++;
    }

    /**
     * Appends element after anchorElement
     * @param element that should be added
     * @param anchorElement in front of which element should be added
     */
    public void add(E element, E anchorElement){
        WrapperElement<E> anchorWrapper = getWrapperElement(anchorElement);
        if(anchorWrapper == null){
            add(element);
            return;
        }else{
            WrapperElement<E> backElement = anchorWrapper;
            WrapperElement<E> frontElement = anchorWrapper.getFrontPointer();
            WrapperElement<E> newWrapper = new WrapperElement<E>(element, frontElement, backElement);
            backElement.setFrontPointer(newWrapper);
            frontElement.setBackPointer(newWrapper);
            size++;
        }
    }

    /**
     * Gets element by index
     * @param index at which element should be returned
     * @return element
     */
    public E get(int index){
        if( head == null || index >= size){
            throw new IndexOutOfBoundsException("No such element at index : " + index);
        }
        WrapperElement<E> holder = head;
        int i = 0;
        while( i!=index && holder.getFrontPointer() != null ){
            holder = holder.getFrontPointer();
            i++;
        }
        return holder.getElement();
    }

    /**
     * Removes element from head
     * @return popped(removed) element
     */
    public E remove(){
        WrapperElement<E> holder;
        if( head != null){
            holder = head;
            if( head.getFrontPointer() == null ){
                tail = null;
                head = null;
            }else {
                head = head.getFrontPointer();
                head.setBackPointer(null);
            }
            size--;
            return holder.getElement();
        }else{
            return null;
        }
    }

    /**
     * Removes specified element
     * @param element that should be removed
     * @return popped(removed) element
     */
    public E remove(E element){
        WrapperElement<E> wrapperElement = getWrapperElement(element);
        WrapperElement<E> frontElement;
        WrapperElement<E> backElement;
        if(wrapperElement == null){
            return null;
        }else {
            frontElement = wrapperElement.getFrontPointer();
            backElement = wrapperElement.getBackPointer();
        }
        if(wrapperElement == head){
            remove();
        }else if(wrapperElement == tail){
            backElement.setFrontPointer(null);
            size--;
        }else {
            frontElement.setBackPointer(backElement);
            backElement.setFrontPointer(frontElement);
            size--;
        }
        return wrapperElement.getElement();
    }

    /**
     * Gets the wrapper element by element
     * @param element of which wrapper should be returned
     * @return wrapper element
     */
    private WrapperElement<E> getWrapperElement(E element){
        if( head == null){
            return null;
        }
        WrapperElement<E> holder = head;
        while( holder != null ){
            if( holder.getElement().equals(element)){
                return holder;
            }
            holder = holder.getFrontPointer();
        }
        return null;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public String toString() {
        if( head == null ){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        WrapperElement<E> holder = head;
        while( holder.getFrontPointer() != null ){
            sb.append(holder.getElement()+", ");
            holder = holder.getFrontPointer();
        }
        return sb.append(holder.getElement() + "]").toString();
    }

    /**
     * Wrapper for list elements
     * @param <E>
     */
    private class WrapperElement<E>{
        private final E element;
        /**
         * Holds the link to the front element
         */
        private WrapperElement<E> frontPointer;
        /**
         * Holds the link to the back element
         */
        private WrapperElement<E> backPointer;

        private WrapperElement(E element) {
            this.element = element;
        }

        public WrapperElement(E element,WrapperElement<E> frontPointer, WrapperElement<E> backPointer){
            this.element = element;
            this.frontPointer = frontPointer;
            this.backPointer = backPointer;
        }

        public E getElement(){
            return element;
        }

        public WrapperElement<E> getFrontPointer(){
            return frontPointer;
        }

        public WrapperElement<E> getBackPointer(){
            return backPointer;
        }

        public void setFrontPointer(WrapperElement<E> frontPointer){
            this.frontPointer = frontPointer;
        }

        public void setBackPointer(WrapperElement<E> backPointer){
            this.backPointer = backPointer;
        }
    }
}



