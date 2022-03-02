package lab01.tdd;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SimpleCircularList implements CircularList {

    private final List<Integer> list = new ArrayList<>();
    private int i = 0;

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Optional<Integer> next() {
        if(this.i == this.list.size()){
            this.i = 0;
        }
        Optional<Integer> v = Optional.of(this.list.get(this.i));
        this.i = this.i + 1;
        return v;
    }

    @Override
    public Optional<Integer> previous() {
        if(this.i == 0){
            this.i = this.list.size();
        }
        this.i = this.i - 1;
        Optional<Integer> v = Optional.of(this.list.get(this.i));
        return v;
    }

    @Override
    public void reset() {
        this.i = 0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        int j = Math.max(i, 0);
        int iterationToDo = 0;
        do{
            Optional<Integer> v = next();
            if(v.isPresent() && strategy.apply(v.get())){
                return v;
            }
            iterationToDo = iterationToDo + 1;
            j = j == size() ? 0 : j + 1;
        }while(iterationToDo < size());
        return Optional.empty();
    }
}
