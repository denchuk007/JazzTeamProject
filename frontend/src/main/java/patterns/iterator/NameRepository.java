package patterns.iterator;

import java.util.LinkedList;

public class NameRepository implements Container {
    private LinkedList<String> names = new LinkedList<>();

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }

    public void addName(String name) {
        names.addLast(name);
    }

    private class NameIterator implements Iterator {

        int index;

        @Override
        public boolean hasNext() {
            if(index < names.size()){
                return true;
            }
            return false;
        }

        @Override
        public Object next() {
            if(this.hasNext()){
                return names.get(index++);
            }
            return null;
        }
    }
}