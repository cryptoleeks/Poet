package observer;

/**
 * @Auther: Yonggang Shi
 * @Date: 2020/04/18 01:23
 * @Description:
 */
public class WeatherStation {

    public static void main(String[] args){
        WeatherData weatherData =new WeatherData();

        CurrentConditionDisplay currentConditionDisplay =new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(11,12,13);

    }
}
