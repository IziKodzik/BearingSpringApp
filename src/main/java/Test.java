import java.util.*;

public class Test {

    public static void main(String[] args) {

        class C{
            public int id;
            public int val;

            public C(int id, int val) {
                this.id = id;
                this.val = val;
            }

            @Override
            public String toString() {
                return "C{" +
                        "id=" + id +
                        ", val=" + val +
                        '}';
            }

            @Override
            public int hashCode() {
                return super.hashCode();
            }

            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        }

        C a = new C(1,2);
        Set<C> set = new HashSet<>();
        set.add(a);
        Optional<C> o = set.stream().findFirst();
        o.get().id = 3;
        System.out.println(o);
        System.out.println(set);
    }


}
