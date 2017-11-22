import java.util.UUID;

/**
 * Created by Ouyang on 2017/7/6.
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
    }
}
