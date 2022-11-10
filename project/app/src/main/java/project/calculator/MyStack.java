package project.calculator;

public class MyStack<T> {
    private T[] data;
    private int size=-1;

    public MyStack(){
        this(1000);
    }

    public MyStack(int capacity){
        data=(T[]) new Object[capacity];
    }

    public int size(){
        return size+1;
    }

    public boolean isEmpty(){
        return size==-1;
    }

    public void push(T element){
        if(size==data.length) throw new IllegalStateException("Stack is full");
        data[++size]=element;
    }

    public T pop(){
        if(this.isEmpty()) return null;
        T temp=data[size];
        data[size--]=null;
        return temp;
    }

    public T top(){
        if(this.isEmpty()) return null;
        return data[size];
    }
}

