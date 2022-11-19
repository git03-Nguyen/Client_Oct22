package team6.client.handler;

public class Applications{
    
    public Applications(){
    }
    
    public String initMessage(){
        return "<APP>$<>$<>";
    }
    
    public String getMessage(){
        return "<>$<GET>$<>";
    }
    
    public String killMessage(int pid){
        return ("<>$<KILL>$<" + String.valueOf(pid) + ">");
    }
    
    public String startNameMessage(String name){
        return ("<>$<START-NAME>$<" + name + ">");
    }
    
    public String startIDMessage(String name){
        return ("<>$<START-ID>$<" + name + ">");
    }
}
