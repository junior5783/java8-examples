package enumclass;


import java.util.EnumSet;

public class EnumClasses {
    public static void main (String... args){
        /**Enums*/
       System.out.printf("First -> Status NAME : %s, CODE : %s", Status.INITIAL.getName(), Status.INITIAL.getCode());
        for(Status status : EnumSet.range(Status.INITIAL, Status.COMPLETED))
            System.out.printf("%nSecond -> Status NAME : %s, CODE : %s", status.getName(), status.getCode());
    }
}
