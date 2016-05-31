public class WindInfo {
    //a string in the following format: "(Head|Tail)wind N knots. Crosswind N knots from your (left|right)."
    public static String message(String rwy, Integer windDirection, Integer windSpeed) {
        String rwyString = rwy.substring(rwy.length()-1,rwy.length());
        String rwyNum = rwy;
        if(rwyString.equals("L")||rwyString.equals("C")||rwyString.equals("R")){
            rwyNum = rwy.substring(0,rwy.length()-1);
            Integer rwyTen = Integer.parseInt(rwyNum);
            windDirection= Math.abs(rwyTen*10-windDirection);
        }else{
            Integer rwyTen = Integer.parseInt(rwyNum);
            windDirection= Math.abs(rwyTen*10-windDirection);
        }




        String htString ="Head";
        Integer htKnots;
        String lrString = "left";
        Integer lrKnots;
        Integer angle = windDirection%90;
        Integer recNum = windDirection/90;
        Integer rec=recNum%4;
        if(rec==1||rec==2){
            angle=90-angle;
        }else{
            lrString="right";
        }
        if(rec==2||rec==3){
            htString="Tail";
        }
        double v = Math.toRadians(angle);
        htKnots =  new Double(Math.cos(v)*windSpeed).intValue();
        lrKnots =  new Double(Math.sin(v)*windSpeed).intValue();
        return String.format("%swind %d knots. Crosswind %d knots from your %s.",htString,htKnots,lrKnots,lrString);
    }


    public static void main(String[] args){
        System.out.println(message("18L", 170, 15));
        System.out.println(message("22", 160, 20));


    }
}