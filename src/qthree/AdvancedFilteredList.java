package qthree;

import java.util.Collection;
import java.util.LinkedList;
import java.util.function.Consumer;

public class AdvancedFilteredList<E> extends LinkedList<E> {

    private AdvancedListFilter<E> advFilter;

    public AdvancedFilteredList(AdvancedListFilter<E> advFilter) {
        this.advFilter = advFilter;
    }

    @Override
    public void addFirst(E e) {
        super.addFirst(advFilter.filter(this, e));
//        try {
//            super.addFirst(advFilter.filter(this, e));
//        } catch (IllegalArgumentException ex){
//            System.out.println("Failed i.e. skipping");
//        }

    }

    @Override
    public void addLast(E e) {

        super.addLast(advFilter.filter(this, e));

//        try {
//            super.addLast(advFilter.filter(this, e));
//        } catch (IllegalArgumentException ex){
//        System.out.println("Failed i.e. skipping");
//    }

    }

    @Override
    public boolean add(E e) {
        return super.add(advFilter.filter(this, e));
//        try {
//            return super.add(advFilter.filter(this, e));
//        } catch (IllegalArgumentException ex){
//            System.out.println("Failed i.e. skipping");
//        }
//        return true;
    }


    @Override
    public void add(int index, E element) {
        super.add(index, advFilter.filter(this, element));

//        try {
//            super.add(index, advFilter.filter(this, element));
//        } catch (IllegalArgumentException ex){
//            System.out.println("Failed i.e. skipping");
//        }
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

        c.forEach((Consumer<E>) this::add);
        return true;

    }

//    @Override
//    public boolean addAll(int index, Collection<? extends E> c) {
//        if(c.stream().allMatch(predTest)){
//            return super.addAll(index, c);
//        } else {
//            throw new IllegalArgumentException(String.format("Wrong element type "));
//        }
//
//    }
}
