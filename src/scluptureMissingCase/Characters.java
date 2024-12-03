package scluptureMissingCase;

public abstract class Characters {

    private String name;
    private String gender;
    private String role;
    private int honestyMtr;
    private int trustMtr;
    private String mode;
    private int emotion;

    public String getName(){
        return name;
    };
    
    public void setName(String name) {
        if(name.length()>5) {
            this.name = name; //Must have at least 5 words
        } else {
            System.out.println("Name is too short!");
        }
    };

    public String getRole(){
        return role;
    };

    public void setRole(String role){
        this.role = role;
    };

    public int getHonesty(){
        return honestyMtr;
    } //Range out of 5
    public void setHonesty(int honesty){
        if(honesty>0 && honesty<=5) {
            this.honestyMtr = honesty;
        } else {
            System.out.println("Honesty Meter is invalid!");
        }
    }

    public int getTrust(){
        return trustMtr;
    } //Range out of 5
    public void setTrust(int trust){
        if(trust>0 && trust<=5) {
            this.trustMtr = trust;
        } else {
            System.out.println("Trust Meter is invalid!");
        }
    }

    public String getMode(){
        return mode;
    } //Out of 4, Tired, Sad; Neutral, Energetic
    public void setMode(String mode){
        if(mode.equals("Tired") || mode.equals("Sad") || mode.equals("Neutral") || mode.equals("Energetic")) {
            this.mode = mode;
        }
    }

    public String getEmotion(){
        if(emotion>0 && emotion<=3) {
            return "crying!";
        } else if(emotion>3 && emotion<=6) {
            return "loved!";
        } else if (emotion>6 && emotion<=9) {
            return "neutral!";
        } else if (emotion>9 && emotion<=12) {
            return "angry!";
        } else {
            return "can't assume!";
        }

    } //Out of 12, crying-loved-neutral-angry
    public void setEmotion(int emotion){
        if(emotion>0 && emotion<=12) {
            this.emotion = emotion;
        } else if (emotion>12) {
            this.emotion = 12;
        } else if(emotion<0) {
            this.emotion = 0;
        }
    }
}
