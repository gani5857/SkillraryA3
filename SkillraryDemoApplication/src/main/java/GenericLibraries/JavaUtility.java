package GenericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * This class contains reusable methods to perform java related operations
 * @author TRACK QJSPIDERS
 */
public class JavaUtility {
	/**
	 * This method fetches current date and time
	 * @return
	 */
	public String getCurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		return sdf.format(date);
	}
	
	/**
	 * This method is used to wait for specified amount of time
	 * @param time
	 */
	public void pause(long time)
	{
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * This method generates random number within the specifiied limit
	 * @param limit
	 * @return 
	 */
	
	public int genarateRandomNum(int limit)
	{
		Random random = new Random();
		return random.nextInt(limit);
	}

}
