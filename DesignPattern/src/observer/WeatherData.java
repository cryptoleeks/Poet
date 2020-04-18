package observer;

import java.util.ArrayList;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/17 17:27
 * @Description: 主体实现发布通知对应观察者
 */
public class WeatherData implements  Subject {
    private ArrayList observers;
    private float temperature;
    private float humidtiy;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);

    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);

    }
    /**
     * 通过遍历当前已注册的观察者对象，实现数据通信，让观察者进行更新展示
     * @param
     * @return void
     * @author shiyonggang
     * @creed: Talk is cheap,show me the code
     * @date 2020/4/18/018 下午 3:27
     */
    @Override
    public void notifyObservers() {
        for (int i =0 ;i<observers.size();i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(temperature,humidtiy,pressure);
        }

    }

    public  void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature,float humidtiy,float pressure){
        this.temperature = temperature;
        this.humidtiy = humidtiy ;
        this.pressure = pressure;
        measurementsChanged();
    }
}
