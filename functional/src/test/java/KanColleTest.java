import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

class Kan {
    String name;
    String cv;
    public Kan(String name, String cv) {
        this.name = name;
        this.cv = cv;
    }
    public boolean isIdle() {
        return this.name.equals("那珂");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kan)) return false;

        Kan kan = (Kan) o;

        if (cv != null ? !cv.equals(kan.cv) : kan.cv != null) return false;
        if (name != null ? !name.equals(kan.name) : kan.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cv != null ? cv.hashCode() : 0);
        return result;
    }
}

public class KanColleTest {
    List<Kan> kantaiCollection = new ArrayList<>();
    @Before
    public void before() {
        kantaiCollection.add(new Kan("那珂", "佐倉綾音"));
        kantaiCollection.add(new Kan("鈴谷", "ブリドカットセーラ恵美"));
    }

    @Test
    public void 艦隊に鈴谷を含むか調べるレガシーなコード() {
        boolean hasSuzuya = false;
        for(Kan kan: kantaiCollection) {
            if(kan.name.equals("鈴谷")) {
                hasSuzuya = true;
                break;
            }
        }
        assertThat(hasSuzuya, is(true));
    }

    @Test
    public void 艦隊に鈴谷を含むか調べるコード改善版() {
        boolean hasSuzuya = kantaiCollection.contains(
                new Kan("鈴谷", "ブリドカットセーラ恵美")
        );
        assertThat(hasSuzuya, is(true));
    }

    @Test
    public void 艦隊に鈴谷を含むかテスト() {
        boolean hasSuzuya = kantaiCollection.stream().anyMatch(kan ->
                kan.name.equals("鈴谷")
        );
        assertThat(hasSuzuya, is(true));
    }

    @Test
    public void 艦隊に那珂ちゃんが含まれるとアイドルになる() {
        boolean isIdle = kantaiCollection.stream().anyMatch(Kan::isIdle);
        assertThat(isIdle, is(true));
    }

    @Test
    public void Iterate() {
        final List<String> shops =
                Arrays.asList("Rabbit House", "Fleur du lapin", "甘兎庵", "TULLY's COFFEE");

        for(int i = 0; i < shops.size(); i++) {
            System.out.println(shops.get(i));
        }

        for(String shop: shops) {
            System.out.println(shop);
        }

        shops.forEach(System.out::println);
    }

    @Test
    public void ikaretaMember() {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        boolean hasThree = false;
        for(int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i).equals(3)) {
                hasThree = true;
                break;
            }
        }
        assertThat(hasThree, is(true));
    }

    @Test
    public void ikaretaMemberTwo() {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);

        boolean hasThree = false;
        for(Integer number: numbers) {
            if(number.equals(3)) {
                hasThree = true;
                break;
            }
        }
        assertThat(hasThree, is(true));
    }

    @Test
    public void ikaretaMemberThree() {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        final boolean hasThree = numbers.contains(3);
        assertThat(hasThree, is(true));
    }

    @Test
    public void hasNumberGreaterThanEight() {
        final List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        boolean hasNumebrGreaterThanEight = false;
        for(Integer number: numbers) {
            if(number > 8) {
                hasNumebrGreaterThanEight = true;
                break;
            }
        }
        assertThat(hasNumebrGreaterThanEight, is(true));
    }

    @Test
    public void iterable() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean hasNumberGreaterThanEight =
                numbers.stream().filter(num -> num > 8).findAny().isPresent();
        assertThat(hasNumberGreaterThanEight, is(true));
    }

    @Test
    public void iterableTwo() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        boolean hasNumberGreaterThanEight =
                numbers.stream().filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer num) {
                        return num > 8;
                    }
                }).findAny().isPresent();
        assertThat(hasNumberGreaterThanEight, is(true));
    }

    @Test
    public void wa() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = 0;
        for(Integer num: numbers) {
            sum += num;
        }
        assertThat(sum, is(45));
    }

    @Test
    public void waTwo() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer sum = numbers.stream().reduce((n,m) -> n + m).orElse(0);
        assertThat(sum, is(45));

        Optional<Integer> valA = Optional.empty();
        assertThat(valA.orElse(0), is(0));

        Optional<Integer> valB = Optional.of(100);
        assertThat(valB.orElse(0), is(100));
    }

    @Test
    public void mapReduceTest() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final Integer value = numbers.stream()
                .filter(n -> n <= 5)
                .map(n -> n * 2)
                .reduce((n,m) -> n + m)
                .orElse(0);
        assertThat(value, is(30));
    }
    @Test
    public void mapReduceTestTwo() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        final Integer value = numbers.stream()
                .filter(n -> n <= 5)
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer n) {
                        return n * 2;
                    }
                })
                .reduce((n,m) -> n + m)
                .orElse(0);
        assertThat(value, is(30));
    }

    @Test
    public void hoge() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer value = 0;
        for(Integer n: numbers) {
            if(n <= 5) {
                value += n * 2;
            }
        }
        assertThat(value, is(30));
    }

    @Test
    public void foo() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for(Integer n: numbers) {
            System.out.println(n);
        }
    }

    @Test
    public void hage() {
        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        numbers.forEach(System.out::println);
    }
}
