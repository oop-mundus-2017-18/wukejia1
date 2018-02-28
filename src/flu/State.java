package flu;
/**
 * util to represents the STATUS of a person.
 *
 * @author WU Kejia
 * @created 23/02/2018
 */

public enum State {
    
    HEALTHY("healthy"),
    INFECTED("infected"), 
    SICK("sick"),
    CONTAGIOUS("contagious"),
    RECOVERING("recovering"),
    DEAD("dead");
    //private String state = "healthy";//��γ�ʼ��stadeΪ����״̬������
    
    State(String state) {
        this.state = state;
    }
}