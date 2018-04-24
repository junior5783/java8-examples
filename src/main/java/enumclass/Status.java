package enumclass;

public enum Status {

    INITIAL("Initial","0001"),
    IN_PROCESS("In Process","0002"),
    COMPLETED("Completed","0003");

    private final String name;
    private final String code;

    Status(String name, String code){
        this.name = name;
        this.code = code;
    }

    public String getName(){
        return this.name;
    }

    public String getCode(){
        return this.code;
    }
}