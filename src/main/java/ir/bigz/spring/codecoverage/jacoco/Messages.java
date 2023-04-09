package ir.bigz.spring.codecoverage.jacoco;

public class Messages {

    public String getMessage(String name){
        StringBuilder stringBuilder = new StringBuilder();

        if(name == null || name.trim().length() == 0){
            stringBuilder.append("Please provide Name!");
        }else{
            stringBuilder.append("Hello ").append(name).append("!");
        }

        return stringBuilder.toString();
    }
}
