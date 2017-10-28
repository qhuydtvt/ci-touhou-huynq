package touhou.players;

import bases.GameObject;
import touhou.inputs.InputManager;

/**
 * Created by huynq on 10/25/17.
 */
public class PlayerCastSpell {
    boolean spellDisabled;
    int coolDownCount;
    final int COOL_DOWN_TIME = 10;

    public void run(Player owner) {
        if (spellDisabled) {
            coolDownCount++;
            if (coolDownCount >= COOL_DOWN_TIME) {
                spellDisabled = false;
                coolDownCount = 0;
            }
            return;
        }

        if (InputManager.instance.xPressed) {
            PlayerSpell newSpell = GameObject.recycle(PlayerSpell.class);
            newSpell.position.set(owner.position);

            spellDisabled = true;
        }
    }
}
