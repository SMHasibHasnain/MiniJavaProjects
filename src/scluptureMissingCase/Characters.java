package scluptureMissingCase;

public abstract class Characters {

    public abstract String getName();
    public abstract void setName(String name);

    public abstract String getGender();
    public abstract void setGender(String gender);

    public abstract int getAge();
    public abstract void setAge(int age);

    public abstract String getRole();
    public abstract void setRole(String role);

    public abstract int getHonesty(); //Range out of 5
    public abstract void setHonesty(int honesty);

    public abstract int getTrust(); //Range out of 5
    public abstract void setTrust(int trust);

    public abstract String getMode(); //Out of 5, 0-2 Tired, Sad; 3-5 Happy, Energetic
    public abstract void setMode(int mode);

    public abstract String getEmotion(); //Out of 5, crying-loved-neutral-angry
    public abstract void setMode(String emotion);

}
