public class Persona {
    private float pri_parcial;
    private float seg_parcial;
    private float ex_final;
    
    public Persona(float pri_parcial, float seg_parcial, float ex_final) {
        this.pri_parcial = pri_parcial;
        this.seg_parcial = seg_parcial;
        this.ex_final = ex_final;
    }

    public float getPri_parcial() {
        return pri_parcial;
    }

    public void setPri_parcial(float pri_parcial) {
        this.pri_parcial = pri_parcial;
    }

    public float getSeg_parcial() {
        return seg_parcial;
    }

    public void setSeg_parcial(float seg_parcial) {
        this.seg_parcial = seg_parcial;
    }

    public float getEx_final() {
        return ex_final;
    }

    public void setEx_final(float ex_final) {
        this.ex_final = ex_final;
    }

    public float media() {
        float media;
        
        media = (this.pri_parcial + this.seg_parcial + this.ex_final) / 3;

        return media;
    }
}
