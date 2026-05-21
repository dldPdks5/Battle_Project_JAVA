package player;

import weapon.마법도구;

public interface IAttack {

    public void 공격하기();

    public void 공격하기(마법사 target);

    public void 공격하기(마법사 target, 마법도구 weapon);

}
