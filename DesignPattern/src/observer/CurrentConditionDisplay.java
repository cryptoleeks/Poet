package observer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/18 01:17
 * @Description: 观察者具体实现
 */
public class CurrentConditionDisplay implements Observer,DisplayElement {

    private float temperature;
    private float humidity;
    private Subject weatherData;
    /**
     * 通过构造函数的Subject对当前对象进行注册观察者操作
     * @param weatherData Subject 主题对象
     * @return 
     * @author shiyonggang
     * @creed: Talk is cheap,show me the code
     * @date 2020/4/18/018 下午 3:35
     */
    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData =  weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("当前温度:"+temperature+"，湿度："+humidity+"% ");
    }
    /**
     * 在数据更新之后进行展示操作
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure  压力
     * @return void
     * @author shiyonggang
     * @creed: Talk is cheap,show me the code
     * @date 2020/4/18/018 下午 3:37
     */
    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }
}
