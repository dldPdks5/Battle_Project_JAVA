package player;
import weapon.*;

public interface IHeal {

    public void 치료하기();

    public void 치료하기(마법사 target);
    
    public void 치료하기(마법사 target, 마법도구 medicine);

}
