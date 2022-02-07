import java.math.BigDecimal;
import java.math.BigInteger;

public class PlanetsParade {
    public static final BigDecimal mercurySpeed = BigDecimal.valueOf(360 / (0.24d * 365.2564d));
    public static final BigDecimal venusSpeed = BigDecimal.valueOf(360 / (0.62d * 365.2564d));
    public static final BigDecimal earthSpeed = BigDecimal.valueOf(360 / (1d * 365.2564d));
    public static final BigDecimal marsSpeed = BigDecimal.valueOf(360 / (1.88d * 365.2564d));
    public static final BigDecimal jupiterSpeed = BigDecimal.valueOf(360 / (11.86d * 365.2564d));
    public static final BigDecimal saturnSpeed = BigDecimal.valueOf(360 / (29.46d * 365.2564d));
    public static final BigDecimal uranSpeed = BigDecimal.valueOf(360 / (84.07d * 365.2564d));
    public static final BigDecimal neptunSpeed = BigDecimal.valueOf(360 / (164.82d * 365.2564d));

    public static BigDecimal mercuryPosition = mercurySpeed;//180 - (22.6d * 2);
    public static BigDecimal venusPosition = venusSpeed;//180 - (35.4d * 2);
    public static BigDecimal earthPosition = earthSpeed;//180 - (0d * 2);
    public static BigDecimal marsPosition = marsSpeed;//180 - (38.0d * 2);
    public static BigDecimal jupiterPosition = jupiterSpeed;//180 - (21.1d * 2);
    public static BigDecimal saturnPosition = saturnSpeed;//180 - (1.3d * 2);
    public static BigDecimal uranPosition = uranSpeed;//180 - (83.7d * 2);
    public static BigDecimal neptunPosition = neptunSpeed;//180 - (34.6d * 2);

    public static BigDecimal bd = new BigDecimal(BigInteger.ZERO);

    public static void main(String[] args) throws InterruptedException {
        while (mercuryPosition != venusPosition && mercuryPosition != earthPosition && mercuryPosition != marsPosition && mercuryPosition != jupiterPosition
        && mercuryPosition != saturnPosition && mercuryPosition != uranPosition && mercuryPosition != neptunPosition) {
            bd = bd.add(BigDecimal.ONE);
            System.out.println(bd);
            mercuryPosition = mercuryPosition.add(mercurySpeed);
            venusPosition = venusPosition.add(venusSpeed);
            earthPosition = earthPosition.add(earthSpeed);
            marsPosition = marsPosition.add(marsSpeed);
            jupiterPosition = jupiterPosition.add(jupiterSpeed);
            saturnPosition = saturnPosition.add(saturnSpeed);
            uranPosition = uranPosition.add(uranSpeed);
            neptunPosition = neptunPosition.add(neptunSpeed);

            if (mercuryPosition.intValue() > 360) {
                mercuryPosition = mercuryPosition.subtract(BigDecimal.valueOf(360));
            }
            if (venusPosition.intValue() > 360) {
                venusPosition = venusPosition.subtract(BigDecimal.valueOf(360));
            }
            if (earthPosition.intValue() > 360) {
                earthPosition = earthPosition.subtract(BigDecimal.valueOf(360));
            }
            if (marsPosition.intValue() > 360) {
                marsPosition = marsPosition.subtract(BigDecimal.valueOf(360));
            }
            if (jupiterPosition.intValue() > 360) {
                jupiterPosition = jupiterPosition.subtract(BigDecimal.valueOf(360));
            }
            if (saturnPosition.intValue() > 360) {
                saturnPosition = saturnPosition.subtract(BigDecimal.valueOf(360));
            }
            if (uranPosition.intValue() > 360) {
                uranPosition = uranPosition.subtract(BigDecimal.valueOf(360));
            }
            if (neptunPosition.intValue() > 360) {
                neptunPosition = neptunPosition.subtract(BigDecimal.valueOf(360));
            }

//            Thread.sleep(1000);

//            System.out.println("" + mercuryPosition + " " + venusPosition + " " + earthPosition + " " + marsPosition + " " + jupiterPosition + " " + saturnPosition + " " + neptunPosition + " " + uranPosition);
        }
    }


}
