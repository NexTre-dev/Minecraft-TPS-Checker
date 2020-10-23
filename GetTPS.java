
public class GetTPS {
	
    // Declare Variables
    private static long previousTotalWorldTime = -1L;
    private static double previousMeasureTime = -1.0D;
    public static double tps = -1.0D;
	
    // The string declared to render/print the TPS
    public static String tpsSTR = "";
	
    public static void updatePreviousTotalWorldTime(World worldIn) {
	    try {
	      if (worldIn.getWorldTime() == 0L) {
	        Thread.sleep(500L);
	        if (worldIn.getWorldTime() == 0L) {
	          Thread.sleep(1000L);
	          if (worldIn.getWorldTime() == 0L) {
	          } 
	        } 
	      } 
	      previousTotalWorldTime = worldIn.getTotalWorldTime();
	      previousMeasureTime = getTimeInSeconds();
	    } catch (Exception e) {
	      e.printStackTrace();
	    } 
    }
	
    public static void updateTPS(World worldIn) {
	    if (getTimeInSeconds() - previousMeasureTime < 3.0D)
	      return; 
	    tps = (worldIn.getTotalWorldTime() - previousTotalWorldTime) / (getTimeInSeconds() - previousMeasureTime);
	    updatePreviousTotalWorldTime(worldIn);
	    DecimalFormat df = new DecimalFormat("#.##");
	    df.setRoundingMode(RoundingMode.CEILING);
	    tpsSTR = df.format(tps);
    }
    
    public static double getTimeInSeconds() {
	    return System.nanoTime() / 1.0E9D;
    }
}
