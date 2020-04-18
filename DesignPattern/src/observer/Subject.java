package observer;



/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/17 16:56
 * @Description: 观察者主题
 */
public interface Subject {
    void registerObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
