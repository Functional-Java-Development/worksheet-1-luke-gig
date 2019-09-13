package qtwo;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Predicate;

public class FilteredList<E> extends LinkedList<E> {

    private Predicate<E> predTest;

    //    a
    FilteredList(Predicate<E> pred) {
        this.predTest = pred;
    }

    @Override
    public boolean add(E e) {
        if (predTest.test(e)){
            return super.add(e);
        }
        throw new IllegalArgumentException(String.format("Wrong element type %s", e));
    }

    @Override
    public void add(int index, E element) {
        if (predTest.test(element)){
            super.add(index, element);
        } else {
            throw new IllegalArgumentException(String.format("Wrong element type %s", element));
        }

    }

    @Override
    public void addFirst(E e) {
        if (predTest.test(e)){
            super.addFirst(e);
        } else {
            throw new IllegalArgumentException(String.format("Wrong element type %s", e));
        }
    }


    @Override
    public void addLast(E e) {
        if (predTest.test(e)){
            super.addLast(e);
        } else {
            throw new IllegalArgumentException(String.format("Wrong element type %s", e));
        }
    }

    @Override
    public void push(E e) {
        this.addFirst(e);
    }

    @Override
    public boolean offerFirst(E e) {
        this.addFirst(e);
        return true;
    }

    @Override
    public boolean offer(E e) {
        this.addLast(e);
        return true;
    }

    @Override
    public boolean offerLast(E e) {
        this.addLast(e);
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {

        if(c.stream().allMatch(predTest)){
            return super.addAll(c);
        } else {
            throw new IllegalArgumentException(String.format("Wrong element type "));
        }

    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        if(c.stream().allMatch(predTest)){
            return super.addAll(index, c);
        } else {
            throw new IllegalArgumentException(String.format("Wrong element type "));
        }

    }
}
