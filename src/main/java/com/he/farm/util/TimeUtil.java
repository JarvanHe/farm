package com.he.farm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Auther: 贺谋昌
 * @Date: 2019/11/4 16:25
 * @Description:
 */
public class TimeUtil {
    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :HH:mm:ss");
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 获取今日0点时间戳
     * @return
     */
    public static String getTodayZero() {
        //获取明天0点时间
        Calendar cal=Calendar.getInstance();
        cal.add(Calendar.DATE,0);//这里改为1
        Date time=cal.getTime();
        return (new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(time));

}
}
