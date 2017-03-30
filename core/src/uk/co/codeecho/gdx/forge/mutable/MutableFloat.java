package uk.co.codeecho.gdx.forge.mutable;

public class MutableFloat extends Mutable<Float>{

    public MutableFloat() {
        super(0f);
    }

    public MutableFloat(float value) {
        super(value);
    }
    
    public void add(float value){
        this.value = this.value + value;
    }
    
    public void subtract(float value){
        this.value = this.value - value;
    }
    
}
