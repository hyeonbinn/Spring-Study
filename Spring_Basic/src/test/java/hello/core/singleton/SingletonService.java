package hello.core.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){
    } //외부에서 new SingleTonService() 하는 것을 막게 해줌.

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
